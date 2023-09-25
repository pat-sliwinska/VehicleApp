package com.mentoring.vehicleapp.shared.clients.json.placeholder.service;

import com.google.common.collect.Lists;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.JsonPlaceholderApiConnector;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.mapper.PostMapper;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.PostDTO;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final JsonPlaceholderApiConnector jsonPlaceholderApiConnector;
    private final PostMapper postMapper;


    public List<PostDTO> getPostDTOList() {
        PostResponse[] posts = jsonPlaceholderApiConnector.getPosts().orElse(new PostResponse[]{});
        List<PostResponse> postResponseList = Lists.newArrayList(posts);
        return postMapper.postResponseToPostDTOList(postResponseList);
    }
}
