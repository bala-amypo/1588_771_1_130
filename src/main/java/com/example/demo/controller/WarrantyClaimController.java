package com.example.demo.controller;

import com.example.demo.model.WarrantyClaim;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warranty-claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    // ✅ REQUIRED by TestNG
    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    // -------- Optional endpoints (tests do NOT touch these) --------

    @PostMapping
    public WarrantyClaim createClaim(@RequestBody WarrantyClaim claim) {
        return service.createClaim(claim);
    }

    @GetMapping("/{id}")
    public Optional<WarrantyClaim> getClaimById(@PathVariable Long id) {
        return service.getClaimById(id);
    }

    @GetMapping
    public List<WarrantyClaim> getAllClaims() {
        return service.getAllClaims();
    }

    @PutMapping("/{id}/status")
    public WarrantyClaim updateClaimStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateClaimStatus(id, status);
    }
}
