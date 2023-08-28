package com.example.hello.core_re.Order;

import com.example.hello.core_re.discount.DiscountPolicy;
import com.example.hello.core_re.member.Member;
import com.example.hello.core_re.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    //test
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //단일 책임에 대한 원칙이 잘 지켜짐

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
