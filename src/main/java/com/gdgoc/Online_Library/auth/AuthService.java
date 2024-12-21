package com.gdgoc.Online_Library.auth;

import static com.gdgoc.Online_Library.common.Role.USER;

import com.gdgoc.Online_Library.auth.dto.LoginRequest;
import com.gdgoc.Online_Library.auth.dto.SignUpRequest;
import com.gdgoc.Online_Library.auth.jwt.JwtUtils;
import com.gdgoc.Online_Library.user.User;
import com.gdgoc.Online_Library.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public void register(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }

        User user = User.builder()
                .name(signUpRequest.getName())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .email(signUpRequest.getEmail())
                .role(USER)
                .build();

        userRepository.save(user);
    }

    public String login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtUtils.generateToken(user.getEmail());
    }
}
