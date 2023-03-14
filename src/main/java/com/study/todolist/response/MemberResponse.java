package com.study.todolist.response;

import com.study.todolist.domain.Member;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class MemberResponse {
    private final Long id;
    private final String memberId;
    private final String name;
    private final String registDt;
    private final String modifyDt;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.memberId = member.getMemberId();
        this.name = member.getName();
        this.registDt = LdtToString(member.getRegistDt());
        this.modifyDt = LdtToString(member.getModifyDt());
    }

    @Builder
    public MemberResponse(Long id, String memberId, String name, LocalDateTime registDt, LocalDateTime modifyDt) {
        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.registDt = LdtToString(registDt);
        this.modifyDt = LdtToString(modifyDt);
    }

    private String LdtToString(LocalDateTime ldt) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ldt.format(dateTimeFormatter);
    }
}
