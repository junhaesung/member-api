package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 회원정보를 조회합니다.
     *
     * @param page 조회하려는 페이지. 0부터 시작
     * @param size 한 페이지에 보여줄 개수
     * @return
     */
    @GetMapping("/members")
    public Page<MemberEntity> getMembers(@RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "20") Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return memberService.getMembers(pageable);
    }

    /**
     * 회원을 생성합니다.
     *
     * @param memberRequest 생성하려는 회원의 정보
     * @return 생성된 회원
     */
    @PostMapping("/members")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberEntity createMember(@RequestBody MemberRequest memberRequest) {
        return memberService.createMember(memberRequest);
    }
}
