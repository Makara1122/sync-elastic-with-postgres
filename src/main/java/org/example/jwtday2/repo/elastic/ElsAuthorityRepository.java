package org.example.jwtday2.repo.elastic;

import org.example.jwtday2.domain.Authority;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElsAuthorityRepository extends ElasticsearchRepository<Authority,String> {
}
