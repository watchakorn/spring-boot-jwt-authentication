package com.yit.jwt.service;

import com.yit.jwt.entity.User;
import com.yit.jwt.model.LoginDto;
import com.yit.jwt.model.RegisterDto;
import com.yit.jwt.model.UserDto;

public interface AuthenticationService {
    UserDto signup(RegisterDto input);
    UserDto authenticate(LoginDto input);
}
