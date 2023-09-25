package com.mentoring.vehicleapp.shared.clients.json.placeholder.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
