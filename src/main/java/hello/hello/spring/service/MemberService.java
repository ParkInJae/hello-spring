package hello.hello.spring.service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//윈도우 기준 ctrl + shift + t 를 눌러서 테스트 케이스를 자동적으로 생성할 수 있다.
@Service
public class MemberService {
    private final MemberRepository memberRepository; // 다른 MemoryMemberRepository를 참조할 수 있기 때문에 변경함

    @Autowired // Autowired를 통해서 스프링 컨터이너가 MemberRepository가 필요한 것을 알고 주입해준다.
    public MemberService(MemberRepository memberRepository) { //  외부에서 memberRepository를 넣어주기 때문에 의존성이 주입된다.
        this.memberRepository = memberRepository;
    }

    // 회원가입
    /*
     회원가입> 같은 이름이 안된다고 가정
    */
    public Long join(Member member ){
        validateDuplicateMember(member); // ctrl + alt + m을 눌러서 자신이 설정하는 이름으로 메서드를 만든다.

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result =  memberRepository.findByName(member.getName());
        // ifPresent 값이 null이 아닌 값이 존재한다면 아래의 로직이 작동
        // Optional이기 때문에 가능함
        result.ifPresent(m-> {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        });
    }

    public List<Member> findAll(){
        return  memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return memberRepository.findById( id);
    }
}
