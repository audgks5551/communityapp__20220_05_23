package com.example.backend.article.controller;

import com.example.backend.article.dto.ArticleDTO;
import com.example.backend.article.service.ArticleService;
import com.example.backend.article.vo.RequestCreateArticle;
import com.example.backend.article.vo.ResponseArticle;
import com.example.backend.article.vo.ResponseUser;
import com.toedter.spring.hateoas.jsonapi.JsonApiModelBuilder;
import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

import static com.toedter.spring.hateoas.jsonapi.MediaTypes.JSON_API_VALUE;

@RestController
@RequestMapping(value = "api/articles", headers = "version=v1", produces = JSON_API_VALUE)
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> createArticle(
            @RequestBody @Valid RequestCreateArticle articleForm, KeycloakPrincipal user) {

        ResponseArticle article = articleService.createArticle(
                Optional.of(articleForm)
                        .map(form -> {
                            ArticleDTO dto = mapper.map(form, ArticleDTO.class);
                            dto.setUserId(user.getName());
                            return dto;
                        }).get()
                )
                .map(dto -> mapper.map(dto, ResponseArticle.class)).get();

        URI currentURI = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();

        return ResponseEntity.created(currentURI).body(
                JsonApiModelBuilder.jsonApiModel()
                        .model(article)
                        .relationship("author", new ResponseUser(user.getName()))
                        .build()
        );
    }

    @GetMapping("/test")
    public ResponseEntity articleTest() {
        return ResponseEntity.ok("test");
    }
}
