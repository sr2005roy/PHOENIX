package com.ecommerce.backendone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@JsonFilter(Product.FILTER)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {
    public static final String FILTER = "product-filter";
    @Id
    @SequenceGenerator(name = "productSequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSequence")
    private Integer productId;
    private String productName;
    private String imageUrl;
    @Column(length = 1000)
    private String description;
    private Integer markedPrice;
    private Integer sellingPrice;
    private Integer reviewCount;
    private Integer totalRating;
    @ManyToOne
    @JsonBackReference
    private Category category;
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Review> reviews;
}
