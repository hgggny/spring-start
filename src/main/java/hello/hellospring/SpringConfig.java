package hello.hellospring;


import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
자바 코드로 직접 spring 빈 등록
--> @Service, @Repository, @Autowired 애노테이션을 없을 경우
*/
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memoryMemberRepository());
    }
    @Bean
    public MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }
}
