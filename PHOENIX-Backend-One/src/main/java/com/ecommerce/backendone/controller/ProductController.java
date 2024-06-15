package com.ecommerce.backendone.controller;

import com.ecommerce.backendone.entity.Product;
import com.ecommerce.backendone.service.ProductService;
import com.ecommerce.backendone.utility.MappingJacksonValueBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public MappingJacksonValue getProduct(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return MappingJacksonValueBuilder.init(product)
                .addFilter(Product.FILTER)
                .build();
    }

    @PostMapping("/products")
    public MappingJacksonValue getProducts(@RequestBody List<Integer> ids) {
        List<Product> products = new ArrayList<>();
        for (Integer id : ids) {
            Product product = productService.getProductById(id);
            if (product != null)
                products.add(product);
        }
        return MappingJacksonValueBuilder.init(products)
                .addFilter(Product.FILTER,
                        "description",
                        "reviwCount",
                        "totalRating",
                        "category",
                        "reviews")
                .build();
    }

    @GetMapping("/products/search")
    public MappingJacksonValue getProductsWithTextLike(@RequestParam String text) {
        Product[] products = productService.getProductsWithText(text);
        return MappingJacksonValueBuilder.init(products)
                .addFilter(Product.FILTER,
                        "description",
                        "category",
                        "reviews")
                .build();
    }
}