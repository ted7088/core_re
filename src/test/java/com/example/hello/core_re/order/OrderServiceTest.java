package com.example.hello.core_re.order;

import com.example.hello.core_re.Order.Order;
import com.example.hello.core_re.Order.OrderService;
import com.example.hello.core_re.Order.OrderServiceImpl;
import com.example.hello.core_re.member.Grade;
import com.example.hello.core_re.member.Member;
import com.example.hello.core_re.member.MemberService;
import com.example.hello.core_re.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl(memberRepository);
    OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

    @Test
    void createOrder(){
        Long memberId= 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
