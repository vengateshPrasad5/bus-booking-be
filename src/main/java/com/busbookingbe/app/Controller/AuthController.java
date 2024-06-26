package com.busbookingbe.app.Controller;

import com.busbookingbe.app.Dto.*;
import com.busbookingbe.app.Exception.CustomAPIException;
import com.busbookingbe.app.Exception.ResourceNotFoundException;
import com.busbookingbe.app.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
        try {
            JwtAuthResponse jwtAuthResponse = authService.login(requestDto);
            return ResponseEntity.ok(jwtAuthResponse);
        } catch (RuntimeException e) {
            throw new RuntimeException("User not found");
        }
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto) {
        try {
            String response = authService.register(registerDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("userProfile")
    public ResponseEntity<UserProfileDTO> userProfile(@RequestParam String userName) {
        try {
            UserProfileDTO user = authService.getUser(userName);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("User not found");
        }
    }

    @PostMapping("changePassword")
    public  ResponseEntity<String> passwordChange(@RequestBody PwdChangeDTO pwdChangeDTO){
        try {
            String response = authService.changePassword(pwdChangeDTO);
            return ResponseEntity.ok(response);
        } catch (CustomAPIException e) {
            throw new CustomAPIException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
    }
}
