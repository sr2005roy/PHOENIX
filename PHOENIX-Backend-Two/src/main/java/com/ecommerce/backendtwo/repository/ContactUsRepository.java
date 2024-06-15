package com.ecommerce.backendtwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.backendtwo.entity.ContactUs;

public interface ContactUsRepository extends JpaRepository<ContactUs,Long> {
    
}
