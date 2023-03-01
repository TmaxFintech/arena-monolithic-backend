package com.arena.arena.model.dto;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class UserDto {
    private String account;
    private String password;
    private String nickname;
}
