package com.arena.arena.service;

import com.arena.arena.model.entity.*;
import com.arena.arena.model.repository.CommentRepository;
import com.arena.arena.model.repository.LikeRepository;
import com.arena.arena.model.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TestService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private CommentRepository commentRepository;

    public String saveUser() {
        UserEntity userEntity = new UserEntity("account","1234","myNickName", AuthorityEnum.ADMIN);
        userRepository.save(userEntity);

        return "OK!!!!!!!!!!!!!!!!";
    }



}
