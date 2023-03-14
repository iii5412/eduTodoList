package com.study.todolist.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "member_id")
    private String memberId;

    private String password;

    private String name;

    @Column(name = "REGIST_DT")
    private LocalDateTime registDt;

    @Column(name = "MODIFY_DT")
    private LocalDateTime modifyDt;

    @PrePersist
    private void prePersist() {
        this.modifyDt = LocalDateTime.now();
    }

    @Builder
    public Member(String memberId, String password, String name) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
        this.registDt = LocalDateTime.now();
    }
}
