package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //ApplicationContext가 스프링의 모든 bean을 다 관리한다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //AppConfig에 있는 bean 어노테이션이 달린 모든 메서드가 스프링 컨테이너에 등록되어서 관리해준다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 메서드 이름 , 타입
        /**
         * 0807
         * 여기까지 작성해서 실행해보면 못보던 로그가 뜬다.
         * 21:22:23.345 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'appConfig'
         * 21:22:23.353 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'memberService'
         * 21:22:23.391 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'orderSerivce'
         * 21:22:23.395 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'discountPolicy'
         * 21:22:23.396 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'getMemberRepository'
         *
         * AppConfig에서 등록 해줬던 bean 리스트가 나온다.
         */


        Member member = new Member(1L, "memberA", Grade.BASIC);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member: " + member.getName());
        System.out.println("find Member: " + findMember.getName());
    }
}
