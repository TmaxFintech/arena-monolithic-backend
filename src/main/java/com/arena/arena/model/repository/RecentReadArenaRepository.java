package com.arena.arena.model.repository;

import com.arena.arena.model.entity.RecentReadArenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecentReadArenaRepository extends JpaRepository<RecentReadArenaEntity, UUID> {

}
