package com.ecommerce.backendtwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.backendtwo.entity.ContactUs;
import com.ecommerce.backendtwo.repository.ContactUsRepository;
@Service
public class ContactUsService {
    @Autowired
    private ContactUsRepository contactUsRepository;
    
    public ContactUs SendMessage (ContactUs Contact){
        System.out.println(Contact);
        return contactUsRepository.save(Contact);
    }
    public ResponseEntity<ContactUs> DeleteMessage (ContactUs contact){
        contactUsRepository.delete(contact);
        return ResponseEntity.ok(contact);
    }
}
