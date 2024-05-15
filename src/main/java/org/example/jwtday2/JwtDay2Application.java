package org.example.jwtday2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(
        basePackages = "org.example.jwtday2.repo",
        excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.example.jwtday2.repo.elastic.*")
)
@EnableElasticsearchRepositories(
        basePackages = "org.example.jwtday2.repo.elastic"
)
@OpenAPIDefinition(
        info = @Info(
                title = "JWT Day 1",
                version = "1.0",
                description = "JWT Day" ),
        security = @SecurityRequirement(name = "bearerAuth")
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class JwtDay2Application {

    public static void main(String[] args) {
        SpringApplication.run(JwtDay2Application.class, args);
    }

}
