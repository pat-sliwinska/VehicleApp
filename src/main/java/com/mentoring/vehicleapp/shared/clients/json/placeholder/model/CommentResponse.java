package com.mentoring.vehicleapp.shared.clients.json.placeholder.model;

import lombok.Builder;

@Builder
public record CommentResponse(
        Long postId,
        Long id,
        String name,
        String email,
        String body
) {
}