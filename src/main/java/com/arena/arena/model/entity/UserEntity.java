package com.arena.arena.model.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "USER_ID")
    private UUID userId;

    @NotNull
    private String account;
    @NotNull
    private String password;
    @NotNull
    private String nickname;

    @Enumerated(EnumType.STRING)        // String으로 받아야 추후 변동에 문제없음
    private AuthorityEnum authority;
    private LocalDateTime signUpDate;
    private boolean isDeleted;

    /**
     * << userentity 생성자 >>
     * 계정 id, pw, nickname은 사용자에게 받고
     * authority에 대한 정보는 service 단에서 따로 두어서 일반/admin 사용자 구분을 둔다.
     */

    public UserEntity(String account, String password, String nickname, AuthorityEnum authority) {
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.authority = authority;
        this.signUpDate = LocalDateTime.now();
        this.isDeleted = false;
    }
}
