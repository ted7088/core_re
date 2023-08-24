package com.example.hello.core_re.member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);

}
