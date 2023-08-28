package com.example.hello.core_re;

import com.example.hello.core_re.Order.OrderService;
import com.example.hello.core_re.Order.OrderServiceImpl;
import com.example.hello.core_re.discount.FixDiscountPolicy;
import com.example.hello.core_re.member.MemberService;
import com.example.hello.core_re.member.MemberServiceImpl;
import com.example.hello.core_re.member.MemoryMemberRepository;

//appconfig는 실제 동작에 필요한 구현 객체를 생성한다.
//생성자를 통해서 주입
//test
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
