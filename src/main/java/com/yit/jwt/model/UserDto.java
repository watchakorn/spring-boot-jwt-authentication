package com.yit.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yit.jwt.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String username;
    @JsonIgnore
    private String password;

    public UserDto(User user) {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
    }
}
