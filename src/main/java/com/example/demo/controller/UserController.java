package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping
    public User create(@RequestBody User user) {
        return service.createUser(user);
    }

 
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<User> getByEmail(@PathVariable String email) {
        return service.getUserByEmail(email);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}
