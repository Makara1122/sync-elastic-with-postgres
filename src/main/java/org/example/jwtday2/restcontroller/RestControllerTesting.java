package org.example.jwtday2.restcontroller;

import lombok.RequiredArgsConstructor;
import org.example.jwtday2.base.BaseResponse;
import org.example.jwtday2.domain.dto.AuthorResponse;
import org.example.jwtday2.security.CustomeUserDetail;
import org.example.jwtday2.service.AuthorService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
public class RestControllerTesting {
    private final AuthorService authorService;
    private final CustomeUserDetail customeUserDetail;
    @GetMapping("/user")
    public String hello() {

        return "Hello User";
    }
    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin";
    }
}
