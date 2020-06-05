package com.ibm.test;

import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import net.sf.json.JSONObject;


@RestController
public class TestController {

    @GetMapping("/greet")
    public String helloWorld(Principal principal){
        Authentication authentication = (Authentication) principal;
        JSONObject object = JSONObject.fromObject(authentication);

        Authentication authenticationToken = SecurityContextHolder.getContext().getAuthentication();
        Object detailsToken = authenticationToken.getDetails();
        SimpleKeycloakAccount account = (SimpleKeycloakAccount) detailsToken;
        String token = account.getKeycloakSecurityContext().getTokenString();
        return "Hello World from Keycloak! Token : " + token;
    }

}
