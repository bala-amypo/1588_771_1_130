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
        return service.submit(claim);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAll() {
        return service.getAll();
    }
}
