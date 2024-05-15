package org.example.jwtday2.repo;

import org.example.jwtday2.domain.Author;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorReposity extends JpaRepository<Author,String>  {
    Optional<Author> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Author> findById(String id);
}
