package com.busbookingbe.app.Controller;

import com.busbookingbe.app.Dto.JwtAuthResponse;
import com.busbookingbe.app.Dto.LoginRequestDTO;
import com.busbookingbe.app.Dto.RegisterDTO;
import com.busbookingbe.app.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginRequestDTO requestDto) {
        JwtAuthResponse jwtAuthResponse = authService.login(requestDto);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto) {
        String response = authService.register(registerDto);

        return ResponseEntity.ok(response);
    }
}
