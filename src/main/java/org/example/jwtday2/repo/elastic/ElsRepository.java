package org.example.jwtday2.repo.elastic;

import org.example.jwtday2.domain.Author;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElsRepository extends ElasticsearchRepository<Author,String> {
}
