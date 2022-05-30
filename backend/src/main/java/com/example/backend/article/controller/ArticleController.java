package com.example.backend.article.controller;

import com.example.backend.article.dto.ArticleDTO;
import com.example.backend.article.service.ArticleService;
import com.example.backend.article.vo.RequestCreateArticle;
import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static com.example.backend.base.http.MediaType.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        value = "/article",
        headers = "version=v1",
        consumes = { APPLICATION_JSON_VALUE, APPLICATION_VND_JSON_VALUE },
        produces = { APPLICATION_JSON_VALUE, APPLICATION_VND_JSON_VALUE }
)
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity createArticle(
            @Valid @RequestBody RequestCreateArticle requestCreateArticle, KeycloakPrincipal user) {

        ArticleDTO articleDTO = mapper.map(requestCreateArticle, ArticleDTO.class);
        articleDTO.setUserId(user.getName());

        ArticleDTO savedArticleDTO = articleService.createArticle(articleDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public ResponseEntity articleTest() {
        return ResponseEntity.ok("test");
    }
}
