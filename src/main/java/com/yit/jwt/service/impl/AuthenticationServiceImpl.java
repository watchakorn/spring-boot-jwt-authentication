package com.yit.jwt.service.impl;

import com.yit.jwt.entity.User;
import com.yit.jwt.model.LoginDto;
import com.yit.jwt.model.RegisterDto;
import com.yit.jwt.model.UserDto;
import com.yit.jwt.repository.UserRepository;
import com.yit.jwt.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserDto signup(RegisterDto input) {
        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setUsername(input.getUsername());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        User save = userRepository.save(user);
        return new UserDto(save);
    }

    @Override
    public UserDto authenticate(LoginDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        User user = userRepository.findByUsername(input.getUsername()).orElseThrow();
        return new UserDto(user);
    }
}
