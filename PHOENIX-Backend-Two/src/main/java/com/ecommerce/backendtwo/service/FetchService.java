package com.ecommerce.backendtwo.service;

import com.ecommerce.backendtwo.entity.embeddable.Product;
import com.ecommerce.backendtwo.exception.FailedRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FetchService {
    @Value("${backend-one.api.url}")
    private String url;
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Product> getProductsById(List<Integer> ids) {
        if (ids == null || ids.size() == 0) return new ArrayList<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<List<Integer>> httpEntity = new HttpEntity<>(ids, httpHeaders);
        Product[] products = restTemplate.postForObject(url + "/products", httpEntity, Product[].class);
        if (products == null) throw new FailedRequestException("Failed to fetch products");
        return Arrays.asList(products);
    }
}
