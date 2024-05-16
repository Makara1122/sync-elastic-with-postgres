package org.example.jwtday2.service;

import lombok.RequiredArgsConstructor;
import org.example.jwtday2.domain.Author;
import org.example.jwtday2.domain.Role;
import org.example.jwtday2.domain.dto.AuthorRequest;
import org.example.jwtday2.domain.dto.AuthorResponse;
import org.example.jwtday2.mapper.AuthorMapper;
import org.example.jwtday2.repo.AuthorReposity;
import org.example.jwtday2.repo.RoleReposity;
import org.example.jwtday2.repo.elastic.ElsRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
    private final ElsRepository elsRepository;
    private final AuthorReposity authorReposity;
    private final RoleReposity roleReposity;
    private final AuthorMapper authorMapper;



    @Override
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {

           if (authorReposity.existsByEmail(authorRequest.email())) {
               throw  new RuntimeException("Email already exists");
           }
           Set<Role> roles = new HashSet<>();
           for (var role : authorRequest.roles()) {
               Role role1 = roleReposity.findByName(role).orElseThrow(() -> new RuntimeException("Role not found"));
               roles.add(role1);
           }
            // If all roles are valid, continue with your logic
            Author author = authorMapper.toAuthor(authorRequest);
           author.setRoles(roles);
           author.setPassword(new BCryptPasswordEncoder().encode(authorRequest.password()));
//           elsRepository.save(author);
         return authorMapper.toAuthorResponse(  authorReposity.save(author));
    }

    @Override
    public AuthorResponse getAuthorById(String id) {
        return authorMapper.toAuthorResponse(authorReposity.findById(id).orElseThrow(()->new RuntimeException("Author not found")));
    }

    @Override
    public AuthorResponse updateAuthor(String id, AuthorRequest authorRequest) {
        Author author    = authorReposity.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        author.setPassword(new BCryptPasswordEncoder().encode(authorRequest.password()));
        author.setEmail(authorRequest.email());
        author.setName(authorRequest.name());
        Set<Role> roles = new HashSet<>();
        for (var role : authorRequest.roles()) {
            Role role1 = roleReposity.findByName(role).orElseThrow(() -> new RuntimeException("Role not found"));
            roles.add(role1);
        }
        author.setRoles(roles);
        return authorMapper.toAuthorResponse(authorReposity.save(author));
    }
}
