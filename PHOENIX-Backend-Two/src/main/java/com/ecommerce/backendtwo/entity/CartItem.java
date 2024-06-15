package com.ecommerce.backendtwo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ecommerce.backendtwo.entity.embeddable.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cart_cart_id", "productId"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CartItem {
    @Id
    @GeneratedValue
    private Integer cartItemId;
    @Embedded
    private Product product;
    private Integer quantity;
    @ManyToOne
    @JsonBackReference
    private Cart cart;

    public int calculateAmount() {
        if (product == null || product.getSellingPrice() == null) return 0;
        return quantity * product.getSellingPrice();
    }
}
