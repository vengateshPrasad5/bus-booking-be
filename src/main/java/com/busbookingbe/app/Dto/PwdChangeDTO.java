package com.busbookingbe.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PwdChangeDTO {
    private String userName;
    private String currentPwd;
    private String newPwd;
}
