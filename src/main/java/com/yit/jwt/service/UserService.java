package com.yit.jwt.service;

import com.yit.jwt.model.CustomUserDetailsDto;

import java.util.Optional;

public interface UserService {
    Optional<CustomUserDetailsDto> findByUsername(String username);
}
