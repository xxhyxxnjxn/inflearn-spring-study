package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderSerivce{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //할인 정책을 변경하려면 코드를 변경해야함
    //DIP 위반 : 구체화에 의존하지말고 추상화에 의존하라를 위반한다 추상(인터페이스)뿐만 아니라 구체(구현)클래스에도 의존하고 있다.
    //추상 (인터페이스)의존 : DiscountPolicy / 구체(구현)클래스 : FixDiscountPolicy, RateDiscountPolicy
    //OCP위반 : fixDiscountpolicy를 ratediscountpolicy로 변경하는 순간 orderservieimpl의 소스도 함께 변경해야함

    //해결 : DIP를 위반하지 않도록 인터페이스에만 의존하도록 의존관계를 변경하면 된다.

//    private MemberRepository  memberRepository;
//    private DiscountPolicy discountPolicy; //인터페이스에만 의존하도록 변경
    // 이 대로만 호출하면 NPE 발생

    //해결 : 누군가가 클라이언트인 orderServiceImpl에 DiscoutnPolicy의 구현 객체를 대신 생성하고 주입해주어야한다.

    private final MemberRepository  memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //DIP 지키고 있다. -> 추상화에만 의존하고 있다. 구체화 클래스는 모름
    //생성자를 통해 RateDiscount가 들어올지 FixDiscount가 들어올지 모름
    //어떤 구현 객체를 주입할 지는 오직 외부(AppConfig)에서 결정한다.
    //실행에만 집중하면 된다. -> 책임 분리

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
