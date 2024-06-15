package com.ecommerce.backendtwo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue
    private Integer userId;
    private String userName;
    private String email;
    private String password;
    @Transient
    private String token;
}
