package com.example.hello.core_re.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
