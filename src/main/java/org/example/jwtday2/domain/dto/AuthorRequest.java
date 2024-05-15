package org.example.jwtday2.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record AuthorRequest(
        @NotNull(message = "Email is required")
        String email,
        @NotNull(message = "Password is required")
        String password,
        @NotEmpty(message = "Name is required")
        @NotNull(message = "Name is required")
        String name,
        @NotNull(message = "Roles is required")
        Set<String> roles,
        boolean isAccountExpired,
        boolean isAccountLocked,
        boolean isCredentialsExpired,
        boolean isDisabled
) {
}
