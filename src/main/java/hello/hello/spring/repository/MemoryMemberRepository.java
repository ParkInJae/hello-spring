// src/main/java/hello/hello/spring/repository/MemoryMemberRepository.java
package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;

import java.util.*;

// implements 할 때 자동 import가 안 된다면, 위 package 선언과 경로를 반드시 검사하세요.
// alt + enter를 통해서 메소드 구현을 자동으로 할 수 있다.
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long,Member> store = new HashMap<>(); // save를 통해 저장할 저장소 생성
    private static long sequence =0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 결과가 없을 경우는 null을 반환함  // null이 나올경우 null을 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {

        // 람다식으로 작성한 store에서 stream을 통해서 반복을 돌리되, .filter를 통한 조건을 기입하고, 가장 먼저 찾은 요소를 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // findAny() > stream을 처리할 때 가장 먼저 찾은 요소를 반환
        /*
        findFirst > 여러 요소가 조건에 부합하더라도 Stream의 순서를 고려해서 가장 앞에 있는 요소를 반환
        findAny > 가장 먼저 찾은 요소를 반환
        */

    }

    @Override
    public List<Member> findAll() {
        // 전체 요소를 가져오기 때문에, 리스트를 생성하고 리스트에 store의 값들을 담은 전체 값을 반환한다.
        return new ArrayList<>(store.values());
    }
}
