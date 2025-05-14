package hello.hello.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // 해당 어노테이션을 통해서 내장된 톰캣이나, 웹 서버를 이용해서 띄워준다.
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args); // 어노테이션을 통해서 클래스를 실행함
	}

}
