package com.yit.jwt.service.impl;

import com.yit.jwt.entity.User;
import com.yit.jwt.model.CustomUserDetailsDto;
import com.yit.jwt.repository.UserRepository;
import com.yit.jwt.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<CustomUserDetailsDto> findByUsername(String username) {
        log.debug("findByUsername::{}", username);
        CustomUserDetailsDto customUserDetailsDto = new CustomUserDetailsDto();
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            return Optional.empty();
        }
        User user = userOptional.get();
        customUserDetailsDto.setUsername(user.getUsername());
        customUserDetailsDto.setPassword(user.getPassword());
        customUserDetailsDto.setId(user.getId());
        customUserDetailsDto.setEmail(user.getEmail());
        return Optional.of(customUserDetailsDto);
    }
}
