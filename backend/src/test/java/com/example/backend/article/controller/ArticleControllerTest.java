package com.example.backend.article.controller;

import com.example.backend.article.dto.ArticleDTO;
import com.example.backend.article.service.ArticleServiceImpl;
import com.example.backend.article.form.CreateArticleForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.keycloak.KeycloakPrincipal;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class ArticleControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ArticleServiceImpl articleService;

    @SpyBean
    ModelMapper mapper;

    @Test
    public void 게시글_생성_v1() throws Exception {

        String uuid = UUID.randomUUID().toString();
        KeycloakPrincipal mockPrincipal = Mockito.mock(KeycloakPrincipal.class);
        Mockito.when(mockPrincipal.getName()).thenReturn(uuid);

        CreateArticleForm request = new CreateArticleForm("title", "body");

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleId(UUID.randomUUID().toString());
        articleDTO.setTitle(request.getTitle());
        articleDTO.setBody(request.getBody());
        articleDTO.setUserId(uuid);

        given(articleService.createArticle(any())).willReturn(articleDTO);

        String content = objectMapper.writeValueAsString(request);
        mvc.perform(
                    post("/article")
                            .contentType("application/vnd.api+json")
                            .accept("application/vnd.api+json")
                            .principal(mockPrincipal)
                            .content(content)
                            .header("version", "v1")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
