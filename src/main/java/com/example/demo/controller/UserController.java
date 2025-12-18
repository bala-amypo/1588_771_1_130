// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     private final UserService userService;

//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     /**
//      * Create a new user (ADMIN / FRAUD_ANALYST / SUPPORT_AGENT)
//      */
//     @PostMapping
//     public User registerUser(@RequestBody User user) {
//         return userService.register(user);
//     }

//     /**
//      * Get all users
//      */
//     @GetMapping
//     public List<User> getAllUsers() {
//         return userService.getAll();
//     }
// }
