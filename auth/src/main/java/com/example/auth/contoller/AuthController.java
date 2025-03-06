package com.example.auth.contoller;

import com.example.auth.model.User;
import com.example.auth.repository.UserRepository;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    UserRepository userRepository;

    @PostMapping("/login")
    ResponseEntity<User> login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/register")
    public String register(String username, String password) {
        return "register";
    }

    @PostMapping("/profile/{id}")
    public String getProfile(@PathVariable Long id) {
        return "profile";
    }
}
