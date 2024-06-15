package com.ecommerce.backendtwo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ContactUs {//first name alast name email phone message
    @NotNull
    private String firstName ;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @Id
    private Long phone ;
    @NotNull
    private String message;
}
