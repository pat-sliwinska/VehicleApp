package com.mentoring.vehicleapp.shared.clients.json.placeholder.api;

import com.mentoring.vehicleapp.shared.clients.json.placeholder.handler.GetAllPostsWithCommentsHandler;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final GetAllPostsWithCommentsHandler getAllPostsWithCommentsHandler;

    @GetMapping
    List<PostDTO> getAllPostsWithComments() {
        return getAllPostsWithCommentsHandler.getAllPostsWithComments();
    }

}
