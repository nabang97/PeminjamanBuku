package com.nabang97.bookrent.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User         : Yolanda Parawita
 * Date & Time  : 20/06/2022 & 9:33
 */

public class AbstractManageBean {

    public Map<String, Object> isAuthenticated(String token){
        Map<String,String> map = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        map2.put("isAuthenticated", false);
        map2.put("username", "");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token.split(" ")[1].trim());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> requestEntity =
                new HttpEntity<Map<String, String>>(map, headers);
        ResponseEntity<Map> responseAll3 =
                restTemplate.postForEntity("http://localhost:8040/authenticationcheck", requestEntity
                        , Map.class);
        Map<String,Object> entry = responseAll3.getBody();
        if (responseAll3.getStatusCode() == HttpStatus.valueOf(200)){
            map2.put("isAuthenticated", entry.get("isAuthenticated"));
            map2.put("username", entry.get("username"));
        }
        return map2;
    }
}
