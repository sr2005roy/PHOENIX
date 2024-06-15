package com.ecommerce.backendtwo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Cart {
    @Id
    @GeneratedValue
    private Integer cartId;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "cart")
    @JsonManagedReference
    private List<CartItem> cartItems;
    @Transient
    private Integer totalAmount;
}
