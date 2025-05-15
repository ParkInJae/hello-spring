package hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
        public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello"; // GET메핑으로 인해서, 뷰리졸버가 hello.html을 전송함

    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(name = "name", required = false) String name, Model model){
        // 윈도우의 경우 ctrl + P를 통해서 함수나, 메서드의 파라미터 정보를 확인할 수 있다.
        // required = false -> 해당하는 파라미터가 없어도 오류가 발생하지 않는다.
        // required = true -> 해당하는 파라미터가 반드시 포함되어야 하며, 파라미터가 포함되지 않고 전달될 경우에, 404 Bad Request가 나온다.
        model.addAttribute("name",name);
        
        return "hello_template"; // viewResolver가 templates의 hello-template.html을 찾아서 반환을 해줌
    }

    @GetMapping("hello-string")
    @ResponseBody // http의 head부와 body부 중에서 body부에 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        // ResponseBody로 인해서 viewResolver를 거치지 않고 간다.
        return "hello " + name; // hello + 파라미터
    }

    @GetMapping("hello-api")
    @ResponseBody // JSON으로 반환하는게 훨씬 편하며, ViewResorver가 아닌 HttpMessageConverter가 작동한다.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // 정적클래스 Hello 생성
    static class Hello {
        private  String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

    }


}
