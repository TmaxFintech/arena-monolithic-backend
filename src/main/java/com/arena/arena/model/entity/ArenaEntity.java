package com.arena.arena.model.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class ArenaEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "ARENA_ID")
    private UUID arenaId;

    @NotNull
    private String title;
    @CreationTimestamp
    private LocalDateTime createDate;
    @NotNull
    private LocalDateTime closeDate;
    private Long bullCount;
    private Long bearCount;

    public ArenaEntity(String title, LocalDateTime closeDate) {
        this.title = title;
        this.closeDate = closeDate;
        this.bullCount = 0L;
        this.bearCount = 0L;
    }
}
