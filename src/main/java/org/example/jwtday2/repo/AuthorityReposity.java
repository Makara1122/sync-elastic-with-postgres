package org.example.jwtday2.repo;

import org.example.jwtday2.domain.Author;
import org.example.jwtday2.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityReposity extends JpaRepository<Authority,String> {

}
