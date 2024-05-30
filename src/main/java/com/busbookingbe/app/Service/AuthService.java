package com.busbookingbe.app.Service;

import com.busbookingbe.app.Dto.JwtAuthResponse;
import com.busbookingbe.app.Dto.LoginRequestDTO;
import com.busbookingbe.app.Dto.RegisterDTO;
import com.busbookingbe.app.Dto.UserProfileDTO;

public interface AuthService {
    String register(RegisterDTO registerDto);
    JwtAuthResponse login(LoginRequestDTO loginRequestDto);
    UserProfileDTO getUser(String userName);
}
