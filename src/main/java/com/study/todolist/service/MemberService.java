package com.study.todolist.service;

import com.study.todolist.domain.Member;
import com.study.todolist.exception.NotFoundMemberException;
import com.study.todolist.repository.MemberRepository;
import com.study.todolist.request.MemberCreate;
import com.study.todolist.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member create(MemberCreate memberCreate) {
        final Member member = Member.builder()
                .memberId(memberCreate.getMemberId())
                .name(memberCreate.getName())
                .password(memberCreate.getPassword())
                .build();
        return memberRepository.save(member);
    }

    public MemberResponse get(Long id) {
        final Member member = memberRepository.findById(id).orElseThrow(NotFoundMemberException::new);
        return new MemberResponse(member);
    }
}
