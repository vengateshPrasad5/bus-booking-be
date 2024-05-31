package com.busbookingbe.app.Service;

import com.busbookingbe.app.Dto.*;

public interface AuthService {
    String register(RegisterDTO registerDto);
    JwtAuthResponse login(LoginRequestDTO loginRequestDto);
    UserProfileDTO getUser(String userName);
    String changePassword(PwdChangeDTO pwdChangeDTO);
}
