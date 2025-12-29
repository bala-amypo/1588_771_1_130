package com.example.demo.controller;

import com.example.demo.dto.WarrantyClaimRequest;
import com.example.demo.dto.WarrantyClaimResponse;
import com.example.demo.service.impl.WarrantyClaimServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranty-claims")
public class WarrantyClaimController {

    private final WarrantyClaimServiceImpl service;

    public WarrantyClaimController(WarrantyClaimServiceImpl service) {
        this.service = service;
    }

    // Create a new warranty claim
    @PostMapping
    public ResponseEntity<WarrantyClaimResponse> createWarrantyClaim(
            @RequestBody WarrantyClaimRequest request) {
        WarrantyClaimResponse response = service.createWarrantyClaim(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get all warranty claims
    @GetMapping
    public ResponseEntity<List<WarrantyClaimResponse>> getAllWarrantyClaims() {
        List<WarrantyClaimResponse> claims = service.getAllWarrantyClaims();
        return ResponseEntity.ok(claims);
    }

    // Get a warranty claim by ID
    @GetMapping("/{id}")
    public ResponseEntity<WarrantyClaimResponse> getWarrantyClaimById(@PathVariable Long id) {
        WarrantyClaimResponse response = service.getWarrantyClaimById(id);
        return ResponseEntity.ok(response);
    }

    // Update a warranty claim
    @PutMapping("/{id}")
    public ResponseEntity<WarrantyClaimResponse> updateWarrantyClaim(
            @PathVariable Long id,
            @RequestBody WarrantyClaimRequest request) {
        WarrantyClaimResponse response = service.updateWarrantyClaim(id, request);
        return ResponseEntity.ok(response);
    }

    // Delete a warranty claim
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarrantyClaim(@PathVariable Long id) {
        service.deleteWarrantyClaim(id);
        return ResponseEntity.noContent().build();
    }
}
