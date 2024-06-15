package com.ecommerce.backendtwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backendtwo.entity.ContactUs;
import com.ecommerce.backendtwo.service.ContactUsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/contactUs")
public class ContactUsController {
    @Autowired
    private ContactUsService contactUsService;
    
    @PostMapping("/")
    public ResponseEntity<?> SendMessage(@RequestBody ContactUs contact)
    {
        ContactUs temp = this.contactUsService.SendMessage(contact);
        return ResponseEntity.ok(temp);
    }

    @GetMapping("/")
    public ResponseEntity<?> DeleteMessage(@RequestBody ContactUs contact){
        this.contactUsService.DeleteMessage(contact);
        return ResponseEntity.ok(null);
    }
}
