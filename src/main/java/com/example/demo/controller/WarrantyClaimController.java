package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warranty")
@RequiredArgsConstructor
public class WarrantyClaimController {

    private final WarrantyClaimService service;

    @PostMapping("/submit")
    public WarrantyClaimRecord submit(@RequestBody WarrantyClaimRecord claim) {
        return service.submitClaim(claim);
    }

    @GetMapping("/serial/{serial}")
    public List<WarrantyClaimRecord> getBySerial(@PathVariable String serial) {
        return service.getClaimsBySerial(serial);
    }
}
