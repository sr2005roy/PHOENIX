package com.ecommerce.backendone.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer userId;
    private String userName;
    private String email;
}
