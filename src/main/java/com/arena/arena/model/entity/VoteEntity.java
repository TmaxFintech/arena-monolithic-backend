package com.arena.arena.model.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class VoteEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "VOTE_ID")
    private UUID voteId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ChoiceEnum choice;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARENA_ID")
    private ArenaEntity arena;

    public VoteEntity(ChoiceEnum choice, UserEntity user, ArenaEntity arena) {
        this.choice = choice;
        this.user = user;
        this.arena = arena;
    }

}
