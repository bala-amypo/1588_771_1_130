package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranty")
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    public WarrantyClaimController(WarrantyClaimService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public WarrantyClaimRecord submit(@RequestBody WarrantyClaimRecord claim) {
        return service.submit(claim);
    }

    @GetMapping("/all")
    public List<WarrantyClaimRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @GetMapping("/serial/{serial}")
    public WarrantyClaimRecord getBySerial(@PathVariable String serial) {
        return service.getBySerialNumber(serial).orElse(null);
    }

    @PutMapping("/{id}/status")
    public WarrantyClaimRecord updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
