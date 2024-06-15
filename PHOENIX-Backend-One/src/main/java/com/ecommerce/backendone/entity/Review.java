package com.ecommerce.backendone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Review {
    @Id
    @SequenceGenerator(name = "reviewSequence", sequenceName = "review_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewSequence")
    private Integer reviewId;
    private Integer userId;
    private String userName;
    private Integer rating;
    private String text;
    @CreationTimestamp
    private Date createdAt;
    @ManyToOne
    @JsonBackReference
    private Product product;
}
