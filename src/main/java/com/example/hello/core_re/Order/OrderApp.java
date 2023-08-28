package com.example.hello.core_re.Order;

import com.example.hello.core_re.AppConfig;
import com.example.hello.core_re.member.Grade;
import com.example.hello.core_re.member.Member;
import com.example.hello.core_re.member.MemberService;
import com.example.hello.core_re.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        OrderService orderService = appConfig.orderService();

        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);


        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice : "+order.calculatePrice());

    }
}
