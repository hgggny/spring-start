# 👩🏻‍💻 김영한의 스프링 입문 [Spring start]
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

## 스프링 빈과 의존 관계
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

### 개방-폐쇄 원칙(OCP, Open-Closed Principle)
* 확장에는 열려있고, 수정, 변경에는 닫혀있다.
* 스프링의 DI (Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있다.

### 스프링 통합 테스트
* `@SpringBootTest`
  * 스프링 컨테이너와 테스트를 함께 실행한다.
* `@Transactional`
  * 테스트 케이스에 이 에노테이션이 완료 후에 항상 롤백한다. 
  * 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않는다.

## 스프링 JdbcTemplate
* 순수 Jdbc와 동일한 환경설정을 하면 된다.
* 스프링 JdbcTemplate과 MyBatis 같은 라이브러리는 JDBC API에서 본 반복 코드를 대부분 제거해준다. 
* 하지만 SQL은 직접 작성해야 한다.

## 스프링 데이터 JPA
* interface 를 생성하여 JpaRepository 를 extends 하여 사용한다. 
* 스프링 데이터 JPA 가 JpaRepository 를 extends 한 interface를 `SpringDataJapMemberRepository` 를 스프링 빈으로 자동 등록해 준다.
  ![img.png](img.png)
* 스프링 데이터 JPA 제공 기능
  * 인터페이스를 통한 기본적인 CRUD 
  * `findByName()`, `findByEmail()`처럼 메서드 이름 만으로 조회 기능 제공
  * 페이징 기능 자동 제공
* 실무에서는 JPA 와 스프링 데이터 JPA 를 기본으로 사용.
* 복잡한 동적 쿼리를 QueryDsl 이라는 라이브러리를 사용.

##  AOP (Aspect Oriented Programming)
* 모든 메서드의 호출 시간을 측정하고 싶은 경우 사용.
* 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)
![img_1.png](img_1.png)
* 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern) 분리
* 회원가입, 회원 조회에 시간을 측정 하는 기능은 핵심 관심 사항이 아니다.
* 시간을 측정하는 로직은 공통 관심 사항이다.
![img_2.png](img_2.png)
* `TimeTraceAop` class 를 생성해 핵심 관심사항과 공통 관심 사항을 분리 
### AOP 적용 전 의존 관계
![img_3.png](img_3.png)
![img_5.png](img_5.png)
### AOP 적용 후 의존 관계
![img_4.png](img_4.png)
![img_6.png](img_6.png)
