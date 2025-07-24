package com.yit.jwt.controller;

import com.yit.jwt.model.*;
import com.yit.jwt.service.AuthenticationService;
import com.yit.jwt.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody RegisterDto registerUserDto) {
        UserDto registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginDto loginUserDto) {
        UserDto authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(new CustomUserDetailsDto(authenticatedUser));

        LoginResponseDto loginResponse = new LoginResponseDto();
        loginResponse.setAccessToken(jwtToken);
        loginResponse.setExpiration(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
