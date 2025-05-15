package hello.hello.spring.domain;

public class Member {

    private Long id; // 시스템이 정해주는 아이디
    private String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
