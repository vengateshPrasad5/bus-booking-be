package com.busbookingbe.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthResponse {
    private String accessToken;
    private String role;
    private String userName;
    private Long userId;
    private String tokenType = "Bearer";
}
