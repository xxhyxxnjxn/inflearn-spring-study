package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderSerivce;
import hello.core.order.OrderServiceImpl;

/**
 * "책임과 관심사를 분리하자"
 * 애플리케이션 전체 동작 방식을 구성(config)하기 위해,
 * '구현 객체를 생성'하고 '연결'하는 책임을 가지는 별도의 설정 클래스를 만들자
 *
 * AppConfig는 생성한 객체 인스턴스의 참조(래퍼런스)를 생성자를 통해서 주입(연결)해준다. injection
 */
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
        //생성자 주입
        //MemberServiceImpl입장에서 보면 의존관계를 마치 외부에서 주입해주는 것 같다고 해서
        //DI(Dependency Injection) 의존관계 주입 또는 의존성 주입이라고 한다.

    }

    public OrderSerivce orderSerivce() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }


    private static MemberRepository getMemberRepository() {
        //나중에 수정하고 싶으면 이 코드만 바꾸면 됨
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
