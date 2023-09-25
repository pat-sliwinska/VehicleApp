package com.mentoring.vehicleapp.shared.clients.json.placeholder.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long user;
    private Long id;
    private String title;
    private String body;
    private List<CommentDTO> comments;

}
