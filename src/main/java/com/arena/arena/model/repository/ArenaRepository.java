package com.arena.arena.model.repository;

import com.arena.arena.model.entity.ArenaEntity;
import com.arena.arena.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArenaRepository extends JpaRepository<ArenaEntity, UUID> {

    ArenaEntity findByTitle(String title);

}
