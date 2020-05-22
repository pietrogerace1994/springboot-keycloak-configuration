package com.ibm.test;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import net.sf.json.JSONObject;


@RestController
public class TestController {

    @GetMapping("/greet")
    public String helloWorld(Principal principal){
        Authentication authentication = (Authentication) principal;
        JSONObject object = JSONObject.fromObject(authentication);
        System.out.println(object);
        return "Hello World from Keycloak!";
    }

}
