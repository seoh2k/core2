package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 기반으로 변경
@Configuration // 설정 구성
public class AppConfig {

    @Bean // 스프링 컨테이너에 스프링 빈(스프링컨테이너에 등록된 객체)으로 등록
    public MemberService memberService() {
        // 리팩터링
        // return new MemberServiceImpl(new MemoryMemberRepository());
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        // 리팩터링
        /** return new OrderServiceImpl(
                     new MemoryMemberRepository(),
                     new FixDiscountPolicy());
        ); */
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 할인 정책 변경
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
