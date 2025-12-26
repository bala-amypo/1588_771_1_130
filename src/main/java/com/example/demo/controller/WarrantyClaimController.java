package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public WarrantyClaimRecord submitClaim(@RequestBody WarrantyClaimRecord record) {
        return service.submitClaim(record);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAllClaims() {
        return service.getAllClaims();
    }
}
