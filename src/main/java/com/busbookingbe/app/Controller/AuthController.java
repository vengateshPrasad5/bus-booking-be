package com.busbookingbe.app.Controller;

import com.busbookingbe.app.Dto.*;
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
        JwtAuthResponse jwtAuthResponse = authService.login(requestDto);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDto) {
        String response = authService.register(registerDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("userProfile")
    public ResponseEntity<UserProfileDTO> userProfile(@RequestParam String userName) {
        UserProfileDTO user = authService.getUser(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("changePassword")
    public  ResponseEntity<String> passwordChange(@RequestBody PwdChangeDTO pwdChangeDTO){
        String response = authService.changePassword(pwdChangeDTO);
        return ResponseEntity.ok(response);
    }
}
