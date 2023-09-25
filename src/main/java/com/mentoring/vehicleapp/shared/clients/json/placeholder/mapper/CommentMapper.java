package com.mentoring.vehicleapp.shared.clients.json.placeholder.mapper;

import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.CommentDTO;
import com.mentoring.vehicleapp.shared.clients.json.placeholder.model.CommentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDTO commentResponseToCommentDTO(CommentResponse commentResponse);

    List<CommentDTO> commentResponseToCommentDTOList(List<CommentResponse> commentResponseList);
}
