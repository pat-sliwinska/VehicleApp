package com.mentoring.vehicleapp.shared.clients.json.placeholder.handler;

import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.PostDTO;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.service.CommentService;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
