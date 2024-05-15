package org.example.jwtday2.domain.dto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String userId,
        String accessToken,
        String refreshToken
) {
}
