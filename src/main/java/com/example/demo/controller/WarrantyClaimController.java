package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public WarrantyClaimRecord submitClaim(@RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    @PatchMapping("/{id}/status")
    public WarrantyClaimRecord updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateClaimStatus(id, status);
    }

    @GetMapping("/{id}")
    public Optional<WarrantyClaimRecord> getClaim(@PathVariable Long id) {
        return service.getClaimById(id);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAllClaims() {
        return service.getAllClaims();
    }

    @GetMapping("/serial/{serial}")
    public List<WarrantyClaimRecord> getClaimsBySerial(@PathVariable String serial) {
        return service.getClaimsBySerial(serial);
    }
}
