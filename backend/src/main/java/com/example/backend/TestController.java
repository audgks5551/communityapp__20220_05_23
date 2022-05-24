package com.example.backend;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/test")
    public TestEntity test(KeycloakPrincipal user) {
        AccessToken userInfo = user.getKeycloakSecurityContext().getToken();

        TestEntity testEntity = new TestEntity();
        testEntity.setUsername(userInfo.getPreferredUsername());
        testEntity.setToken(user.toString());
        return testEntity;
    }
}
