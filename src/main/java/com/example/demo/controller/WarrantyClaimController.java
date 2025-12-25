package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    /**
     * Submit a new warranty claim
     * POST /claims
     */
    @PostMapping
    public WarrantyClaimRecord submitClaim(
            @RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    /**
     * Update claim status
     * PUT /claims/{id}?status=APPROVED|REJECTED|FLAGGED
     */
    @PutMapping("/{id}")
    public WarrantyClaimRecord updateClaimStatus(
            @PathVariable Long id,
            @RequestParam("status") String status) {
        return service.updateClaimStatus(id, status);
    }
}
