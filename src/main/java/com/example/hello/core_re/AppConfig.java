package com.example.hello.core_re;

import com.example.hello.core_re.Order.OrderService;
import com.example.hello.core_re.Order.OrderServiceImpl;
import com.example.hello.core_re.discount.DiscountPolicy;
import com.example.hello.core_re.discount.RateDiscountPolicy;
import com.example.hello.core_re.member.MemberService;
import com.example.hello.core_re.member.MemberServiceImpl;
import com.example.hello.core_re.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//appconfig는 실제 동작에 필요한 구현 객체를 생성한다.
//생성자를 통해서 주입
//test

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
//        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
//        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
//        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
