package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
    테스트는 서로 의존 순서와 관계없이 설계가 되어야함
    그러기 위해서 하나의 테스트가 실행된 후 공용 데이터를 지워야한다.
*/
class MemoryMemberRepositoryTest {
    // 테스트 케이스 실행
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  // 메소드가 실행이 끝날때마다 실행하는 콜백 메소드
    public void afterEach(){

        repository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        repository.save(member);
        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        Member result = repository.findByName("spring1").get();
        //then
        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }



}


