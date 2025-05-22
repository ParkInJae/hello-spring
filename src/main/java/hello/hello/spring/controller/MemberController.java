package hello.hello.spring.controller;

import hello.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService; // new를 사용해서 객체를 생성하며 사용한다면

    @Autowired
    public MemberController(MemberService memberService){ // Autowired를 통해 의존성을 주입함
        /*
            MemberService가 순수한 자바 클래스이기 때문에 memberService를 찾을 수 없는 notFound 에러가 발생한다.
            원인 : Spring bean에 등록이 되어 있지 않아서 발생한 문제
            해결법 -> MemberService에 들어간 후 @Service를 작성해준다
        */
        this.memberService = memberService;

    }

}
