package com.ecommerce.backendtwo.entity.embeddable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Integer productId;
    @Transient
    private String productName;
    @Transient
    private String imageUrl;
    @Transient
    private Integer markedPrice;
    @Transient
    private Integer sellingPrice;
}
