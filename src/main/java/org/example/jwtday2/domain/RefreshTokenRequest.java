package org.example.jwtday2.domain;

import lombok.Builder;

@Builder
public record RefreshTokenRequest(
        String refreshToken
) {
}
