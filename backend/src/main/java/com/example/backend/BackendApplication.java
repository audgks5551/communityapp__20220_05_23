package com.example.backend;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.toedter.spring.hateoas.jsonapi.JsonApiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public JsonApiConfiguration jsonApiConfiguration() {
		return new JsonApiConfiguration()
				.withJsonApiVersionRendered(true)
				.withEmptyAttributesObjectSerialized(false)
				.withObjectMapperCustomizer(objectMapper -> {
					// put your additional object mapper config here
					objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
				})
		// Experimental feature:
		 .withAffordancesRenderedAsLinkMeta(JsonApiConfiguration.AffordanceType.SPRING_HATEOAS);
	}

}
