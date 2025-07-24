package com.yit.jwt.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class LoginResponseDto {
    private String accessToken;
    private long expiration;
}
