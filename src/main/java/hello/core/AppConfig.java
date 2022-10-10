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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//애플리케이션 전체를 설정하고 구성함
//생성한 객체 인스턴스의 참조(래퍼런스)를 생성자를 통해서 주입(연결) 해준다.
@Configuration
public class AppConfig {
    // @Bean MemberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    //MemberServiceImpl는 MemoryMemberRepository 사용할거다!
    //수동으로 의존관계 주입
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
         public OrderService orderService() {
        //AppConfig를 통해 orderService를 조회하면 OrderServiceImpl 반환되는데 거기에 OrderServiceImpl,
        // FIxDisountPolicy 가 들어감
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //new FIxDisountPolicy
        return new RateDiscountPolicy();
    }
}
