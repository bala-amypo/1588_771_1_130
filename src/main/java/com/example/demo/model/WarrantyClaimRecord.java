// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// public class WarrantyClaimRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String serialNumber;
//     private String claimantName;
//     private String claimantEmail;
//     private String claimReason;

//     private String status = "PENDING";

//     private LocalDateTime submittedAt;

//     @PrePersist
//     public void onCreate() {
//         this.submittedAt = LocalDateTime.now();
//     }

//     // getters & setters
// }
