package com.arena.arena.service;

import com.arena.arena.model.entity.UserEntity;
import com.arena.arena.model.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginIdPwValidator implements UserDetailsService {
    private final UserRepository userRepository;

    public LoginIdPwValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public UserDetails loadUserByUsername(String insertedId) throws UsernameNotFoundException {

        UserEntity u = userRepository.findByAccount(insertedId);

        if (u == null) { throw new UsernameNotFoundException("유저가 없습니다"); }

        return User.builder()
                .username(insertedId)
                .password(u.getPassword())
                .roles( u.getAuthority().toString())
                .build();
    }
}
