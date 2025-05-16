package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MemoryMemberRepositoryTest {
    // 테스트 케이스 실행
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() throws Exception {
    // 테스트 케이스 싈행
        Member member = new Member();
        member.setName("Spring"); // crtl +shift +enter 같이 누르면 바로 문자열 뒤의 문장 작성 없이 바로 다음 행으로 넘어갈 수 있다.

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member,result); // member와 result가 동등한지 테스트할 때 사용함






    }
}
