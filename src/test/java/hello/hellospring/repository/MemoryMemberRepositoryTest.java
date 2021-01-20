package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        this.repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("느엉");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // Assertions.assertEquals(member, null);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("느엉2");
        this.repository.save(member);

        Member member2 = new Member();
        member2.setName("느엉3");
        this.repository.save(member2);

        Member result = repository.findByName("느엉2").get();
        Assertions.assertThat(result).isEqualTo(member);
    }

}
