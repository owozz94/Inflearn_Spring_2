package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDisountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//애플리케이션 전체를 설정하고 구성함
//생성한 객체 인스턴스의 참조(래퍼런스)를 생성자를 통해서 주입(연결) 해준다.
public class AppConfig {
    //MemberServiceImpl는 MemoryMemberRepository 사용할거다!
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        //AppConfig를 통해 orderService를 조회하면 OrderServiceImpl 반환되는데 거기에 OrderServiceImpl,
        // FIxDisountPolicy 가 들어감
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    public DiscountPolicy discountPolicy(){
        //new FIxDisountPolicy
        return new RateDiscountPolicy();
    }
}
