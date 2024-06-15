package com.ecommerce.backendone.service;

import com.ecommerce.backendone.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FetchService {
    @Value("${backend-two.api.url}")
    private String url;

    public User validateToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> response = restTemplate.exchange(url + "/validate", HttpMethod.GET, requestEntity, User.class, 0);
        if (!response.getStatusCode().is2xxSuccessful())
            throw new RuntimeException("Invalid jwt");
        return response.getBody();
    }
}
