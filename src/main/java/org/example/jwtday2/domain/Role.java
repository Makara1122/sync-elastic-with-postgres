package org.example.jwtday2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "role_tbl")
@Getter
@Setter

public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
            (
                    name = "role_authority_tbl",
                    joinColumns = @JoinColumn(name = "role_id"),
                    inverseJoinColumns = @JoinColumn(name = "authorities_id")

            )
    private Set<Authority> authorities;

    @Override
    public String getAuthority() {
        return "ROLE_"+name;
    }
}
