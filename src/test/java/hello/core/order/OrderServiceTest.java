package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderSerivce orderService = new OrderServiceImpl();
//
//    @Test
//    public void createOrder() {
//        //long memberId 로 하면 null이 안들어가서 일단 Long 타입을 사용
//        Long memberId = 1L;
//        Member member = new Member(memberId, "memberA", Grade.VIP);
//        memberService.join(member);
//
//        Order order = orderService.createOrder(memberId, "itemA", 10000);
//
//        Assertions.assertEquals(order.getDiscountPrice(), 1000);
//        Assertions.assertEquals(order.calculatePrice(), 9000);
//    }
}
