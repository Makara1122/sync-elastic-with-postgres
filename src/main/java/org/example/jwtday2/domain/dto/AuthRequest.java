package org.example.jwtday2.domain.dto;

import lombok.Builder;

@Builder
public record AuthRequest(
        String email,
        String password
) {
}
