package org.example.jwtday2.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;


import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "author_tbl")
@Document(indexName = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String password;


    private String name;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author_role_tbl",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;



    private boolean isAccountExpired;
    private boolean isAccountLocked;
    private boolean isCredentialsExpired;
    private boolean isDisabled;

}
