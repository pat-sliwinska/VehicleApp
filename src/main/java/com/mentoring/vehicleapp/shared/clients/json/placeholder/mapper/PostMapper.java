package com.mentoring.vehicleapp.shared.clients.json.placeholder.mapper;

import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.PostDTO;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.PostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "userId", target = "user")
    PostDTO postResponseToPostDTO(PostResponse postResponse);

    List<PostDTO> postResponseToPostDTOList(List<PostResponse> postResponseList);
}
