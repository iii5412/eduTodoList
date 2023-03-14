package com.study.todolist.controller;

import com.study.todolist.domain.Member;
import com.study.todolist.request.MemberCreate;
import com.study.todolist.response.MemberResponse;
import com.study.todolist.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/{id}")
    public MemberResponse getMember(@PathVariable Long id) {
        return memberService.get(id);
    }

    @PostMapping("/member")
    public MemberResponse registMember(@RequestBody @Valid MemberCreate request) {
        final Member member = memberService.create(request);
        return new MemberResponse(member);
    }


}
