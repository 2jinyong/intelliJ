package com.jinyong.shop.controller;

import ch.qos.logback.core.model.Model;
import com.jinyong.shop.dto.MemberFormDto;
import com.jinyong.shop.repository.MemberRepository;
import com.jinyong.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

//    @GetMapping("/new")
//    public String memberForm(Model model) {
//        model.addAttribute("memberFormDto",new MemberFormDto());
//        return "member/memberForm";
//    }
}
