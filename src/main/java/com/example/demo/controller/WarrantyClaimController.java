package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Claim", description = "Warranty claims management")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WarrantyClaimRecord> submitClaim(@RequestBody WarrantyClaimRecord claim) {
        return ResponseEntity.ok(service.submitClaim(claim));
    }

    @GetMapping
    public ResponseEntity<List<WarrantyClaimRecord>> getAllClaims() {
        return ResponseEntity.ok(service.getAllClaims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarrantyClaimRecord> getClaim(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClaimById(id).orElseThrow());
    }

    @GetMapping("/serial/{serialNumber}")
    public ResponseEntity<List<WarrantyClaimRecord>> getBySerial(@PathVariable String serialNumber) {
        return ResponseEntity.ok(service.getClaimsBySerial(serialNumber));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<WarrantyClaimRecord> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateClaimStatus(id, status));
    }
}
