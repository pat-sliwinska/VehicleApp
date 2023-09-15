package com.mentoring.vehicleapp.shared.clients.json.placeholder.model;

import lombok.Builder;

@Builder
public record PostResponse(
        Long userId,
        Long id,
        String title,
        String body
) {
}
