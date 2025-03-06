package com.example.auth.service;

import com.example.auth.dto.RegisterRequest;
import com.example.auth.model.User;
import com.example.auth.repository.UserRepository;
import com.nimbusds.oauth2.sdk.TokenResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final OAuthClient oAuthClient;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    AuthService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, OAuthClient oAuthClient) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.oAuthClient = oAuthClient;
    }

    public User register(RegisterRequest request) {
        userRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            throw new RuntimeException("Email already exists");
        });
        String pass = this.bCryptPasswordEncoder.encode(request.getPassword());

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(pass);
        user.setUsername(request.getUsername());
        return userRepository.save(user);
    }

    public TokenResponse login(String token) throws Exception {
        return oAuthClient.validateToken(token);
    }

    public void getProfile(User item){
        userRepository.findByEmail(item.getEmail()).get();
    }

    public void logout() throws Exception {
        oAuthClient.revokeToken("token");
    }
}
