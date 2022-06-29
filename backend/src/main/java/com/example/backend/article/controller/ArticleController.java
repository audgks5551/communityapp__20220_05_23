package com.example.backend.article.controller;

import com.example.backend.article.dto.ArticleDTO;
import com.example.backend.article.service.ArticleService;
import com.example.backend.article.form.CreateArticleForm;
import com.example.backend.article.response.ResponseArticle;
import com.example.backend.article.response.ResponseUser;
import com.toedter.spring.hateoas.jsonapi.JsonApiError;
import com.toedter.spring.hateoas.jsonapi.JsonApiErrors;
import com.toedter.spring.hateoas.jsonapi.JsonApiModelBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.toedter.spring.hateoas.jsonapi.MediaTypes.JSON_API_VALUE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(
        value = "/api/articles",
        headers = "version=v1",
        consumes = APPLICATION_JSON_VALUE,
        produces = JSON_API_VALUE)
@RequiredArgsConstructor
@Tag(name = "article", description = "게시글 API")
public class ArticleController {

    private final ArticleService articleService;
    private final ModelMapper mapper;

    @PostMapping
    @Operation(summary = "게시글 생성", description = "제목(title)과 내용(body)을 이용하여 게시물을 신규 등록합니다.")
    public ResponseEntity<?> createArticle(
            @RequestBody @Valid CreateArticleForm articleForm, KeycloakPrincipal user) {

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

    @GetMapping
    @Operation(summary = "게시글 전체조회", description = "사용자가 가지고 있는 게시글 모두 출력")
    public ResponseEntity<?> listArticle(KeycloakPrincipal user) {
        List<? extends RepresentationModel<?>> articles = articleService.listArticlesByUserId(user.getName()).stream()
                .map(articleDTO -> mapper.map(articleDTO, ResponseArticle.class))
                .map(responseArticle ->
                        JsonApiModelBuilder.jsonApiModel()
                                .model(responseArticle)
                                .relationship("author", new ResponseUser(user.getName()))
                                .build())
                .collect(Collectors.toList());

        CollectionModel<? extends RepresentationModel<?>> result = PagedModel.of(articles);

        return ResponseEntity.ok(
                JsonApiModelBuilder.jsonApiModel()
                        .model(result)
                        .build()
        );
    }

    /**
     * 게시글 단건 조회
     */
    @GetMapping("/{articleId}")
    @Operation(summary = "게시글 단건 조회", description = "사용자의 게시글 한 건을 articleId를 통해 조회")
    public ResponseEntity<?> detailArticle(@PathVariable String articleId, KeycloakPrincipal user) {
        if(articleService.verifyArticlePermission(user.getName(), articleId)) {
            return ResponseEntity.status(FORBIDDEN).body(
                    JsonApiErrors.create().withError(
                            JsonApiError.create()
                                    .withTitle("detailArticle")
                                    .withStatus(FORBIDDEN.toString())
                                    .withDetail("게시글 권한이 없습니다.")
                    )
            );
        }

        ResponseArticle result = articleService.detailArticleByArticleId(articleId)
                .map(articleDTO -> mapper.map(articleDTO, ResponseArticle.class)).get();

        return ResponseEntity.ok(
                JsonApiModelBuilder.jsonApiModel()
                        .model(result)
                        .relationship("author", new ResponseUser(user.getName()))
                        .build()
        );
    }
}
