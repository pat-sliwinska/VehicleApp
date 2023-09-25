package com.mentoring.vehicleapp.shared.clients.json.placeholder.service;

import com.google.common.collect.Lists;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.JsonPlaceholderApiConnector;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.mapper.CommentMapper;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.CommentDTO;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final JsonPlaceholderApiConnector jsonPlaceholderApiConnector;
    private final CommentMapper commentMapper;

    public List<CommentDTO> getCommentsDTOList(Long id) {
        CommentResponse[] commentsByPost = jsonPlaceholderApiConnector.getCommentsByPost(id).orElse(new CommentResponse[]{});
        List<CommentResponse> commentResponseList = Lists.newArrayList(commentsByPost);
        return commentMapper.commentResponseToCommentDTOList(commentResponseList);
    }
}
