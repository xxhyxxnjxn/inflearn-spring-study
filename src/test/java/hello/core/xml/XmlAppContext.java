package hello.core.xml;

import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        //GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext("appConfig.xml");
        //위 처럼 할 수 있지만 ApplicationContext가 부모이기 때문에 ApplicationContext로 받아도 된다.

        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
