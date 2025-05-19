package hello.hello.spring.service;

import hello.hello.spring.domain.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//기존 클래스에서 윈도우 기준 ctrl + shift + t 를 눌러서 자동적으로 생성한 테스트 클래스
class MemberServiceTest {

    MemberService memberService = new MemberService();



    @Test
    void join() {
        // given ->  상황이 주어졌을 때
        Member member = new Member();
        member.setName("Hello");


        // when -> 어떤 상황이 닥쳤을 때 
        Long saveId = memberService.join(member);

        // then
    Member findMember =memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    
    @Test
    public  void 중복_회원_예외(){
        // given
        Member member1 = new Member();
        member1.setName("Spring");
        
        Member member2 = new Member();
        member2.setName("Spring");
        // when
        memberService.join(member1); // 회원 1을 회원가입 시켰다고 가정
        assertThrows(NullPointerException.class, () -> memberService.join(member2));


    /*
        try{
            memberService.join(member2); // 회원 2를 회원가입 시켰다고 가정
            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디입니다.");
        }
    */

        // then

    }
    
    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }
}