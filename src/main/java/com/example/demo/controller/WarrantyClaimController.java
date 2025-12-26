package com.example.demo.controller;

import com.example.demo.service.impl.WarrantyClaimServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@RestController
@SecurityRequirement(name="bearerAuth")
public class WarrantyClaimController {
    private final WarrantyClaimServiceImpl service;
    
    public WarrantyClaimController(WarrantyClaimServiceImpl service) {
        this.service = service;
    }
}
