package org.example.jwtday2.mapper;

import org.example.jwtday2.domain.Author;
import org.example.jwtday2.domain.Role;
import org.example.jwtday2.domain.dto.AuthorRequest;
import org.example.jwtday2.domain.dto.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")

public interface AuthorMapper {
    @Mapping(target = "roles",source = "author.roles",qualifiedByName = "roleToSet")
    AuthorResponse toAuthorResponse(Author author);
    @Named("roleToSet")
    default Set<String> roleToSet(Set<Role> roles) {
        Set<String> roleToSet2 = new HashSet<>();
        for (var role : roles) {
            roleToSet2.add(role.getName());
        }
        return roleToSet2;
    }
    @Mapping(target =  "id",ignore = true)
    @Mapping(target =  "roles", ignore = true)
    Author toAuthor(AuthorRequest authorRequest);
}
