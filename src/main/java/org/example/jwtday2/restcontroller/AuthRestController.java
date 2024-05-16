package org.example.jwtday2.restcontroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jwtday2.base.BaseResponse;
import org.example.jwtday2.domain.RefreshTokenRequest;
import org.example.jwtday2.domain.dto.*;
import org.example.jwtday2.service.AuthServiceImpl;
import org.example.jwtday2.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Service
@RequestMapping("/api/v1/auth")
@RestController

public class AuthRestController {

    private final AuthServiceImpl authService;
    private final AuthorService authorService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request){
        return authService.login(request);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register new user"
            , requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(schema = @Schema(implementation = AuthorRequest.class),
                    examples = @ExampleObject(value = """
                            {
                                "email": "string@gmail.com",
                                "password": "string",
                                "name": "string",
                                "roles": [
                                  "ADMIN"
                                ],
                                "isAccountExpired": "false",
                                "isAccountLocked": "false",
                                "isCredentialsExpired": "false",
                                "isDisabled": "false"
                              }
                                                        
                                                        
                            """)

            )
    )
    )

    public BaseResponse<AuthorResponse> register(@Valid  @RequestBody AuthorRequest request){
        return  BaseResponse.<AuthorResponse>createSuccess().setPayload(authorService.createAuthor(request));
    }

    @PostMapping("/refresh")
    public AuthResponse refreshToken(@RequestBody RefreshTokenRequest request){
        return authService.refreshToken(request);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<AuthorResponse> updateAuthor(@PathVariable String id, @RequestBody AuthorRequest request){
        return BaseResponse.<AuthorResponse>upDateSuccess().setPayload(authorService.updateAuthor(id,request));
    }

}
