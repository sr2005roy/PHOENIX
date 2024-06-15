package com.ecommerce.backendtwo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderItem {
    @Id
    @GeneratedValue
    private Integer orderItemId;
    private Integer productId;
    private String productName;
    private Integer totalPrice;
    private Integer quantity;
    private String imageUrl;
    @CreationTimestamp
    private Date orderDate;
    @OneToOne
    private User user;
}
