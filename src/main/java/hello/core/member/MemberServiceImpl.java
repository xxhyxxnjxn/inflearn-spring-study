package hello.core.member;

public class MemberServiceImpl implements MemberService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //DIP 위반
    // memberservice가 직접 memberrepository를 설정하는 것은 연극배우가 직접 캐스팅을 하는 것과 똑같다.

    private final MemberRepository memberRepository;
    //이렇게 되면 memberserviceimpl에는 오로지 memberrepository라는 인터페이스만 존재하게 된다.
    //추상화에만 의존하게 된다
    //DIP 원칙을 지키게 됨
    //구체화는 전혀 모르게 된다. 구체화는 AppConfig에서 하게 됨
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //의존 관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
