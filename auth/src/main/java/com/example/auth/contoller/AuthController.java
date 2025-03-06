package com.example.auth.contoller;

import com.example.auth.dto.RegisterRequest;
import com.example.auth.model.User;
import com.example.auth.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    UserRepository userRepository;

    @PostMapping("/login")
    ResponseEntity<User> login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(user);
    }

    //Todo: need to implement
    @PostMapping("/logout")
    ResponseEntity<?> logout() {
        return ResponseEntity.ok(null);
    }

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            Optional<User> user = userRepository.findByEmail(request.getEmail());
            if (user.isPresent()) return ResponseEntity.badRequest().build();

            userRepository.save(user.get());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //Todo: need to implement this
    @PostMapping("/profile/{id}")
    ResponseEntity<?> getProfile(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findById(id).orElseThrow());
    }
}
