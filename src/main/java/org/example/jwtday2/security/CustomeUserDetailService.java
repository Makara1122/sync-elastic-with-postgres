package org.example.jwtday2.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.jwtday2.domain.Author;
import org.example.jwtday2.repo.AuthorReposity;
import org.example.jwtday2.repo.AuthorityReposity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@Component

public class CustomeUserDetailService implements UserDetailsService {
    private final AuthorReposity authorReposity;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Author author = authorReposity.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
        CustomeUserDetail userDetails = new CustomeUserDetail();
        userDetails.setAuthor(author);
        return userDetails;
    }

}
