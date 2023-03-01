package com.arena.arena.service;

import com.arena.arena.model.dto.UserDto;
import com.arena.arena.model.entity.AuthorityEnum;
import com.arena.arena.model.entity.UserEntity;
import com.arena.arena.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(UserDto user){
        userRepository.save(new UserEntity(user.getAccount(), passwordEncoder.encode(user.getPassword()), user.getNickname(), AuthorityEnum.USER));
    }
}
