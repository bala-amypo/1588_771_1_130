package com.example.demo.repository;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
}
