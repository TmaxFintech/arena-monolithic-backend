package com.arena.arena.service;

import com.arena.arena.model.entity.*;
import com.arena.arena.model.repository.ArenaRepository;
import com.arena.arena.model.repository.LikeRepository;
import com.arena.arena.model.repository.RecentReadArenaRepository;
import com.arena.arena.model.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class TestServiceTest {

    @Autowired
    private TestService testService;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private ArenaRepository arenaRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecentReadArenaRepository recentReadArenaRepository;


    @Test
    void testRelation() {
        String s = testService.saveUser();
        System.out.println(s);
        for (LikeEntity likeEntity : likeRepository.findAll()) {
            System.out.println("-------------------------------------------");
            System.out.println("likeEntity = " + likeEntity.getLikeId());
            System.out.println("-------------------------------------------");
            System.out.println("commentEntity = " + likeEntity.getComment().getCommentId());
            System.out.println("-------------------------------------------");
            System.out.println("userEntity = " + likeEntity.getUser().getUserId());
            System.out.println("-------------------------------------------");
        }
    }

    @Test
    void testArena() {
        ArenaEntity ae = new ArenaEntity("test", LocalDateTime.now());
        arenaRepository.save(ae);
        UserEntity userEntity = new UserEntity("account","1234","myNickName", AuthorityEnum.ADMIN);
        userRepository.save(userEntity);

        RecentReadArenaEntity rrae = new RecentReadArenaEntity(userRepository.findByNickname("myNickName") ,arenaRepository.findByTitle("test"));
        recentReadArenaRepository.save(rrae);
    }
}