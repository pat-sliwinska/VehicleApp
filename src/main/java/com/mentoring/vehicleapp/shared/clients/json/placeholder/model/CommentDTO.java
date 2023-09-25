package com.mentoring.vehicleapp.shared.clients.json.placeholder.model;

public record CommentDTO(
        Long postId,
        Long id,
        String name,
        String email,
        String body
) {
}
