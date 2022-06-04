package com.example.backend.article.vo;

import com.toedter.spring.hateoas.jsonapi.JsonApiId;
import com.toedter.spring.hateoas.jsonapi.JsonApiTypeForClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonApiTypeForClass("articles")
public class ResponseArticle {
    @JsonApiId
    private String articleId;

    private String title;
    private String body;
}
