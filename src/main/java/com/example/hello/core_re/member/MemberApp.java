package com.example.hello.core_re.member;

import com.example.hello.core_re.AppConfig;

public class MemberApp {
    public static void main(String[] args) {

        AppConfig appConfig =new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("find Member = " + member.getName());
        System.out.println("new member = " + findMember.getName());

    }
}
