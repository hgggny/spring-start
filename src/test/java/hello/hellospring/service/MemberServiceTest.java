package hello.hellospring.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
    /*
    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    위 같이 사용할 경우 새로운 객체를 생성하기 때문에 올바른 사용법이 아니다.
    같은 instance 를 사용하도록 해야 한다.
    */
    MemoryMemberRepository memberRepository;
    MemberService memberService;

    /*
    @BeforeEach :
    각 테스트 실행 전에 호출된다.
    테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고,
    의존관계도 새로 맺어준다.
    */

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        // memberRepository 객체를 memberService (외부)에서 넣어준다. --> DI(dependency injection)
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() throws Exception {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void checkDuplicateMember() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}