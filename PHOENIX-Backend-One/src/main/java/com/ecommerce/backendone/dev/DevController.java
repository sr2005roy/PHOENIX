package com.ecommerce.backendone.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {
    private DevService service;
    @Autowired
    public DevController(DevService service) {
        this.service = service;
    }

    @GetMapping("/dev/resetdb")
    public String resetDb() {
        if (service.resetDatabase())
            return "Database Reset Successful!";
        return "Database Reset Failed!";
    }
}
