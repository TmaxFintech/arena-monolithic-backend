package com.arena.arena.model.repository;

import com.arena.arena.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {

    CommentEntity findByNickname(String nickname);
}
