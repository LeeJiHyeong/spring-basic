package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

//    @AfterEach
//    public void clear() {
//        this.memberService.
//    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("느엉1");

        // when
        Long joinId = memberService.join(member);

        // then
        Member findMember = this.memberService.findOne(joinId).get();
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}