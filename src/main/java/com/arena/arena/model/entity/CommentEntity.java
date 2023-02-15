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
public class CommentEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "COMMENT_ID")
    private UUID commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VOTE_ID")
    private VoteEntity vote;

    @NotNull
    private String content;
    @NotNull
    private String nickname;
    @NotNull
    private String account;
    private boolean isDeleted;

    public CommentEntity(String content, String nickname, String account, VoteEntity vote) {
        this.content = content;
        this.nickname = nickname;
        this.account = account;
        this.vote = vote;
        this.isDeleted = false;
    }
}
