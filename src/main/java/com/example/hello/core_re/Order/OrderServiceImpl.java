package com.example.hello.core_re.Order;

import com.example.hello.core_re.discount.DiscountPolicy;
import com.example.hello.core_re.discount.FixDiscountPolicy;
import com.example.hello.core_re.member.Member;
import com.example.hello.core_re.member.MemberRepository;
import com.example.hello.core_re.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); //단일 책임에 대한 원칙이 잘 지켜짐

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
