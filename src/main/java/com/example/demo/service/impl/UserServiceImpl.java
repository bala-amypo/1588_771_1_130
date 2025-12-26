package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, User> usersById = new HashMap<>();
    private final Map<String, User> usersByEmail = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    @Override
    public User createUser(User user) {
        if (usersByEmail.containsKey(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        user.setId(idGen.getAndIncrement());

        // ensure roles not null
        if (user.getRoles() == null) {
            user.setRoles(Set.of("USER"));
        }

        usersById.put(user.getId(), user);
        usersByEmail.put(user.getEmail(), user);
        return user;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(usersById.get(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(usersByEmail.get(email));
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(usersById.values());
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = usersById.get(id);
        if (existing == null) {
            throw new NoSuchElementException("User not found");
        }

        user.setId(id);
        usersById.put(id, user);
        usersByEmail.put(user.getEmail(), user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        User removed = usersById.remove(id);
        if (removed != null) {
            usersByEmail.remove(removed.getEmail());
        }
    }
}
