package com.ecommerce.backendone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@JsonFilter(Category.FILTER)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Category {
    public static final String FILTER = "category-filter";
    @Id
    @SequenceGenerator(name = "categorySequence", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequence")
    private Integer categoryId;
    private String categoryName;
    private String imageUrl;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;
    @ManyToOne
    @JsonBackReference
    private Section section;
}
