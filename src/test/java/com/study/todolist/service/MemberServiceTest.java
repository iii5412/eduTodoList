package com.study.todolist.service;

import com.study.todolist.domain.Member;
import com.study.todolist.repository.MemberRepository;
import com.study.todolist.request.MemberCreate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;


    @Test
    @DisplayName("DB정보가 정확한지 테스트 한다.")
    @Order(0)
    void DBConnectionTest() {
        final List<Member> all = memberRepository.findAll();
        assertEquals(0, all.size());
    }

    @Test
    void test() {
        log.info("asd");
    }

    @Test
    @DisplayName("사용자를 저장한다.")
    @Order(1)
    void save() {
        final MemberCreate requestMember = MemberCreate.builder()
                .memberId("test1")
                .password("1234")
                .name("테스트1")
                .build();

        final Member newMember = memberService.create(requestMember);

        final Member findMember = memberRepository.findById(newMember.getId()).orElseThrow(IllegalArgumentException::new);

        log.info("newMember.getId() => {}", newMember.getId());
        log.info("findMember.getId() => {}", findMember.getId());

        assertEquals(newMember.getId(), findMember.getId());
    }

}
