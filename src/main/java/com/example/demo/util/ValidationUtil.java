package com.example.demo.util;

import com.example.demo.exception.ResourceNotFoundException;

import java.time.LocalDate;

public final class ValidationUtil {

    private ValidationUtil() {
        // Prevent instantiation
    }

    /**
     * Validates duplicate condition
     */
    public static void checkDuplicate(boolean exists, String message) {
        if (exists) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Validates resource existence
     */
    public static void checkFound(Object obj, String message) {
        if (obj == null) {
            throw new ResourceNotFoundException(message);
        }
    }

    /**
     * Validates boolean condition
     */
    public static void checkCondition(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Validates warranty expiry
     */
    public static void validateWarranty(LocalDate expiryDate) {
        if (expiryDate == null || expiryDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Warranty expired");
        }
    }

    /**
     * Validates active device status
     */
    public static void validateActive(Boolean active) {
        if (active == null || !active) {
            throw new IllegalArgumentException("Device is inactive");
        }
    }
}
