package org.example.jwtday2.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.jwtday2.domain.Author;
import org.example.jwtday2.domain.Role;
import org.example.jwtday2.repo.RoleReposity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Component
@Getter
@Setter
@NoArgsConstructor
@Transactional
public class CustomeUserDetail implements UserDetails {


    private Author author;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        author.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            role.getAuthorities().forEach(authority ->
                    authorities.add(new SimpleGrantedAuthority(authority.getName()))
            );
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return author.getPassword();
    }

    @Override
    public String getUsername() {
        return author.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !author.isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !author.isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !author.isCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return !author.isDisabled();
    }
}
