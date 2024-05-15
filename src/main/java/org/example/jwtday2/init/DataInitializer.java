package org.example.jwtday2.init;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.jwtday2.domain.Authority;
import org.example.jwtday2.domain.Role;
import org.example.jwtday2.repo.AuthorityReposity;
import org.example.jwtday2.repo.RoleReposity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DataInitializer {
    private final AuthorityReposity authorityReposity;
    private final RoleReposity roleReposity;

        @PostConstruct
        void initAuthority(){
            List<String> authorities = List.of("READ","WRITE","DELETE");
            if(authorityReposity.count()==0){
                authorities.forEach(auth -> {
                    var authority = new Authority();
                    authority.setName(auth);
                    authorityReposity.save(authority);
                });
            }
        }

    @PostConstruct
    void roleInit(){
        List<String> roles = List.of("ADMIN","USER");
        if(roleReposity.count()==0){
            var allAuthorities =  new HashSet<>(authorityReposity.findAll());
            for(var role : roles){
                var roleObj = new Role();
                if(role.equals("ADMIN")){
                    roleObj.setAuthorities(allAuthorities);
                }else if (role.equals("USER")){
                    roleObj.setAuthorities(
                            allAuthorities.stream()
                                    .filter(auth -> auth.getName().equals("READ"))
                                    .collect(Collectors.toSet())
                    );
                }
                roleObj.setName(role);
                roleReposity.save(roleObj);
            }
        }
    }
}
