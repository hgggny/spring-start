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
