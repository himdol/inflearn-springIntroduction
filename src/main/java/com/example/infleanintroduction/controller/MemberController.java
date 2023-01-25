package com.example.infleanintroduction.controller;

import com.example.infleanintroduction.domain.Member;
import com.example.infleanintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
  /*
    컨트롤러는 어노테이션으로 스프링 컨테이너가 관리를 한다.
    @가 어노테이션이다.
    스프링 컴포넌트 등록 방법에는 두가지 방법이 있다.
    @Component 어노테이션 이용방
    @Controller  어노테이션 이용방법
   */

  private final MemberService memberservice;

  @Autowired
  public MemberController(MemberService memberservice) {
    this.memberservice = memberservice;
  }

  @GetMapping("/members/new")
  public String createForm() {
    return "members/createMemberForm";
  }

  @PostMapping("/members/new")
  public String create(MemberForm memberForm) {
    Member member = new Member();
    member.setName(memberForm.getName());

    System.out.println(member.getName());

    memberservice.join(member);

    return "redirect:/";
  }

  @GetMapping("/members")
  public String list(Model model) {
    List<Member> members = memberservice.findMembers();
    model.addAttribute("members", members);
    return "members/memberList";
  }
}
