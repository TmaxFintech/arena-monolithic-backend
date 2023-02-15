package com.arena.arena.model.entity;

import com.sun.istack.NotNull;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class RecentReadArenaEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "RECENT_READ_ARENA_ID")
    private UUID recentReadArenaId;

    private LocalDateTime readTime;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARENA_ID")
    private ArenaEntity arena;

    public RecentReadArenaEntity(UserEntity user, ArenaEntity arena) {
        this.user = user;
        this.arena = arena;
        this.readTime = LocalDateTime.now();
    }
}
