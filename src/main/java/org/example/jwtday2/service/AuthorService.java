package org.example.jwtday2.service;

import org.example.jwtday2.domain.dto.AuthorRequest;
import org.example.jwtday2.domain.dto.AuthorResponse;

public interface AuthorService {
    AuthorResponse createAuthor(AuthorRequest authorRequest);
    AuthorResponse getAuthorById(String id);
    AuthorResponse updateAuthor(String id, AuthorRequest authorRequest);

}
