package hello.hellospring.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import hello.hellospring.domain.Member;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /*
    * 테스트는 서로 그 순서와 의존관계 상관없이 설계 돼야 한다.
    *
    * 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다.
    * 이렇게 되면 다음 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있다.
    *
    * 아래의 경우,
    * 같은 spring1 을 String 으로 저장 했더라도 다른 객체이기 때문에
    * 테스트에 실패한다.
    *
    * 그러므로 테스트가 끝날 때마다 clear 해야 한다.
    * */

    /*
    * @AfterEach 를 사용하면 각 테스트가 종료될 때마다 이 기능을 실행한다.
    * 여기서는 메모리 DB에 저장된 데이터를 삭제한다.
    * */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        repository.save(member);
        // then
        Member result = repository.findById(member.getId()).get();
        // import org.junit.jupiter.api.Assertions;
//        Assertions.assertEquals(member, result);

        // import org.assertj.core.api.Assertions;
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
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
    void findAll() {
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
