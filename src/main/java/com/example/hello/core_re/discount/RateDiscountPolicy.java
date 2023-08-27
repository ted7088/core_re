package com.example.hello.core_re.discount;

import com.example.hello.core_re.member.Grade;
import com.example.hello.core_re.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int disconutPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return price*disconutPercent /100;
        }else{
            return 0;
        }
    }
}
