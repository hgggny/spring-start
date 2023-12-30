# 김영한의 스프링 입문 [Spring start]
###### 자세한 설명은 관련 코드에 주석으로 작성했습니다.
## 초기세팅
* version
  * spring-boot: 3.2.1
  * java: 17
    
* build
  ```
  ./gradlew build
  ./gradlew build
  . java -jar hello-spring-0.0.1-SNAPSHOT.jar
  ```

## 스프링 웹 개발 기초
### MVC와 템플릿 엔진
![image](https://github.com/hgggny/spring-start/assets/97075204/ea95f2dc-00a3-40fc-b44f-4eebdc9ddceb)
* viewResolver 를 통해서 템플릿에 맞게 출력된다. 

### API
![image](https://github.com/hgggny/spring-start/assets/97075204/848a3ab2-95c6-4de8-968d-042a30130a7f)
* @ResoponseBody 는 viewResolver 를 사용하지 않고, HttpMessageConverter 가 동작한다.
* HTTP의 body에 문자 내용을 직접 반환한다.
  
### 일반적인 웹 애플리케이션 계층 구조
![image](https://github.com/hgggny/spring-start/assets/97075204/c292b0ed-f32b-403a-a567-69ea7ff7ba8e)
* 컨트롤러: 웹 MVC의 컨트롤러 역할
* 서비스: 핵심 비즈니스 로직 구현
* 리포지토리: 데이터베이스에 접근, 도메인 객체를 DB 에 저장하고 관리
* 도메인: 비즈니스 도메인 객체

#### TEST 코드 작성
* `@AfterEach` 와 `@BeforeEach` 를 통해 테스트가 서로 영향이 없도록 할 수 있다.
* DI(Dependency Injection) 를 이용하여 instance 를 외부에서 생성하여 주입 할 수 있다. 

### 스프링 빈과 의존 관계
* DI: 객체 의존 관계를 외부에서 넣어주는 것을 의존성 주입이라고 한다. 
* 생성자에 `@Autowired` 가 있으면 스프링이 연관된 객체를 객체 생성 시점에 스프링 컨테이너에서 찾아서 넣어준다. 
* 스프링은 스프링 컨테이너에서 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다.
* 싱글톤: 유일하게 instance를 하나만 등록해서 공유하는 방식.
* 스프링 빈을 등록하는 2가지 방법
  * 컴포넌트 스캔과 자동 의존 관계를 설정한다.
    * `@Component` 어노테이션이 있으면 스프링 빈으로 자동 등록
    * `@Controller`, `@Service`, `@Repository`
  * 자바 코드로 직접 스프링 빈을 등록한다. 
    * `@Configuration` 이 등록 된 class 에 `@Bean` 으로 의존성을 주입. 
