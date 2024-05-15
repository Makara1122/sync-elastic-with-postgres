package org.example.jwtday2.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.jwtday2.repo.AuthorReposity;
import org.example.jwtday2.repo.AuthorityReposity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
@Component
@RequiredArgsConstructor
@Getter
@Setter

public class JwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {
    private final AuthorReposity authorReposity;
    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt source) {
        var user = authorReposity.findByEmail(source.getSubject()).orElseThrow(()->new RuntimeException("Author not found"));
        CustomeUserDetail customeUserDetail = new CustomeUserDetail();
        customeUserDetail.setAuthor(user);
        System.out.println(customeUserDetail.getAuthorities());
        return new UsernamePasswordAuthenticationToken(
                customeUserDetail,
                "",
                customeUserDetail.getAuthorities()
        );
    }
}
