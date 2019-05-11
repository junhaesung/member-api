package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Page<MemberEntity> getMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Transactional
    public MemberEntity createMember(MemberRequest memberRequest) {
        final MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname(memberEntity.getNickname());
        memberEntity.setToken(memberRequest.getToken());
        return memberRepository.save(memberEntity);
    }
}
