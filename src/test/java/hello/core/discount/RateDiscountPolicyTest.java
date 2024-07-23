package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        //option enter 치면 staticㅇ르로 바꾸는거 나오는데 static으로 하는게 좋다.
        assertEquals(1000, discount);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertEquals(0, discount);
    }
}