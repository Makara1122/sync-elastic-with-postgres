package org.example.jwtday2.repo.elastic;

import org.example.jwtday2.domain.Role;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElsRoleRepository extends ElasticsearchRepository<Role,String> {
}
