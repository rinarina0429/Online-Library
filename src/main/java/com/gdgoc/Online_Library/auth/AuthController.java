package com.gdgoc.Online_Library.auth;

import com.gdgoc.Online_Library.auth.dto.LoginRequest;
import com.gdgoc.Online_Library.auth.dto.LoginResponse;
import com.gdgoc.Online_Library.auth.dto.SignUpRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody @Valid SignUpRequest signUpRequest) {
        authService.register(signUpRequest);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
