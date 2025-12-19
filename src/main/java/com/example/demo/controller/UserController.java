package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Register user
    @PostMapping
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return service.getById(id);
    }

    // Get all users
    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/status")
    public User updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active
    ) {
        return service.updateStatus(id, active);
    }

    @GetMapping("/serial/{serialNumber}")
    public User getBySerialNumber(@PathVariable String serialNumber) {
        return service.getBySerialNumber(serialNumber);
    }
}
