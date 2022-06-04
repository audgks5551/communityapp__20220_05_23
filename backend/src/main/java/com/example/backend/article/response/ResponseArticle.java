package com.example.backend.article.response;

import com.toedter.spring.hateoas.jsonapi.JsonApiId;
import com.toedter.spring.hateoas.jsonapi.JsonApiTypeForClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonApiTypeForClass("articles")
public class ResponseArticle {
    @JsonApiId
    private String articleId;

    private String title;
    private String body;
    private LocalDateTime created;
    private LocalDateTime modified;
}
