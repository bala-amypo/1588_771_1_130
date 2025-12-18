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

    @PostMapping
    public WarrantyClaimRecord submit(@RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    @PutMapping("/{id}/status")
    public WarrantyClaimRecord updateStatus(@PathVariable Long id,
                                            @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<WarrantyClaimRecord> getBySerial(@PathVariable String serialNumber) {
        return service.getBySerial(serialNumber);
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAll() {
        return service.getAll();
    }
}
