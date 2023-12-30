# 김영한의 스프링 입문 [Spring start]

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
  
