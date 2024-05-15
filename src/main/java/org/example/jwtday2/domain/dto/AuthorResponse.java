package org.example.jwtday2.domain.dto;

import java.util.Set;

public record AuthorResponse(
        String id,
        String email,
        String name,
        Set<String> roles,
        boolean isAccountExpired,
        boolean isAccountLocked,
        boolean isCredentialsExpired,
        boolean isDisabled
) {
}
