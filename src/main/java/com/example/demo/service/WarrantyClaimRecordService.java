// package com.example.demo.service;

// import com.example.demo.model.WarrantyClaimRecord;
// import com.example.demo.repository.DeviceOwnershipRecordRepository;
// import com.example.demo.repository.WarrantyClaimRecordRepository;
// import org.springframework.stereotype.Service;

// import java.time.LocalDate;
// import java.util.List;

// @Service
// public class WarrantyClaimService {

//     private final WarrantyClaimRecordRepository claimRepo;
//     private final DeviceOwnershipRecordRepository deviceRepo;

//     public WarrantyClaimService(WarrantyClaimRecordRepository claimRepo,
//                                 DeviceOwnershipRecordRepository deviceRepo) {
//         this.claimRepo = claimRepo;
//         this.deviceRepo = deviceRepo;
//     }

//     public WarrantyClaimRecord submitClaim(WarrantyClaimRecord claim) {

//         var device = deviceRepo.findBySerialNumber(claim.getSerialNumber())
//                 .orElseThrow(() -> new RuntimeException("Device not found"));

//         if (!device.getActive())
//             throw new RuntimeException("Inactive device");

//         if (device.getWarrantyExpiration().isBefore(LocalDate.now()))
//             throw new RuntimeException("Warranty expired");

//         return claimRepo.save(claim);
//     }

//     public WarrantyClaimRecord updateStatus(Long id, String status) {
//         WarrantyClaimRecord claim = getById(id);
//         claim.setStatus(status);
//         return claimRepo.save(claim);
//     }

//     public WarrantyClaimRecord getById(Long id) {
//         return claimRepo.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Claim not found"));
//     }

//     public List<WarrantyClaimRecord> getBySerial(String serial) {
//         return claimRepo.findBySerialNumber(serial);
//     }

//     public List<WarrantyClaimRecord> getAll() {
//         return claimRepo.findAll();
//     }
// }
