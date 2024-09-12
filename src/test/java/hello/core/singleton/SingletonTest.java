package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService = appConfig.memberService();

        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService = "+memberService);
        System.out.println("memberService2 = "+memberService2);
        // 각자 서로 다른 객체가 생성이 된다.
        // 웹 어플리케이션의 특징은 고객이 많다 -> 계속 객체가 생성이 되면 효율성이 좋지 않다.

        //memberService != memberService2
        Assertions.assertThat(memberService).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        //jvm 뜰 때 생성해 놓았던 인스턴스를 그냥 가져와서 쓰는거임 따로 생성 x
        System.out.println("singletonService = "+singletonService);
        System.out.println("singletonService2 = "+singletonService2);

        Assertions.assertThat(singletonService).isSameAs(singletonService2);
        //same == 참조값까지 비교하는거
        //equal
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService = "+memberService);
        System.out.println("memberService2 = "+memberService2);
        // 각자 서로 다른 객체가 생성이 된다.
        // 웹 어플리케이션의 특징은 고객이 많다 -> 계속 객체가 생성이 되면 효율성이 좋지 않다.

        //memberService != memberService2
        Assertions.assertThat(memberService).isSameAs(memberService2);
    }
}
