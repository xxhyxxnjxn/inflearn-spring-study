package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
