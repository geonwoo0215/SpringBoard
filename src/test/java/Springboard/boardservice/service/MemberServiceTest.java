package Springboard.boardservice.service;

import Springboard.boardservice.domain.Member;
import Springboard.boardservice.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    MemberService boardService;
    @Autowired
    MemberRepository userRepository;

    @Test
    void 회원_가입(){

        Member member = Member.builder()
                .username("mins")
                .password("1234")
                .email("email")
                .build();

        Long joinId = boardService.joinUser(member);

        Assertions.assertEquals(member, userRepository.findAll(joinId));
    }
}
