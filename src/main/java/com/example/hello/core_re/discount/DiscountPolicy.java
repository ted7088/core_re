package com.example.hello.core_re.discount;

import com.example.hello.core_re.member.Member;

public interface DiscountPolicy {
    /*
    *@return 할인 대상 금액
    */
    int discount(Member member, int price);

}
