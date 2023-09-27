package com.mentoring.vehicleapp.shared.clients.json.placeholder.handler;

import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.PostDTO;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.service.CommentService;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetAllPostsWithCommentsHandler {

    private final PostService postService;
    private final CommentService commentService;

    public List<PostDTO> getAllPostsWithComments() {
        List<PostDTO> postDTOList = postService.getPostDTOList();
        postDTOList.forEach(postDTO -> postDTO.setComments(commentService.getCommentsDTOList(postDTO.getId())));
        return postDTOList;
    }

    public List<PostDTO> getAllPostsWithCommentsAsync() {
        List<PostDTO> postDTOList = postService.getPostDTOList();
        List<CompletableFuture<PostDTO>> postDtos = postDTOList.stream()
                .map(this::setComments)
                .toList();

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                postDtos.toArray(new CompletableFuture[postDtos.size()])
        );
        CompletableFuture<List<PostDTO>> allPostDtosFutures = allFutures.thenApply(v -> {
            return postDtos.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());
        });

        try {
            return allPostDtosFutures.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<PostDTO> setComments(PostDTO postDTO) {
        return CompletableFuture.supplyAsync(() ->
        {
            try {
                postDTO.setComments(commentService.getCommentsDTOListAsync(postDTO.getId()).get());
                return postDTO;
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
