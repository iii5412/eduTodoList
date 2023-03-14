package com.study.todolist.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class MemberCreate {
    @NotBlank(message = "아이디를 입력해주세요.")
    private String memberId;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @Builder
    public MemberCreate(String memberId, String password, String name) {
        this.memberId = memberId;
        this.password = password;
        this.name = name;
    }
}
