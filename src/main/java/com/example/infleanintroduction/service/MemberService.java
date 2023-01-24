package com.example.infleanintroduction.service;

import com.example.infleanintroduction.domain.Member;
import com.example.infleanintroduction.repository.MemberRepository;
import com.example.infleanintroduction.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

  private final MemberRepository memberRepository;
  /*
  * 자동으로 Autowired 어노테이션으로 빈 등록하는 방법
  * */
//  @Autowired
//  public MemberService(MemberRepository memberRepository) {
//    this.memberRepository = memberRepository;
//  }

  /*
  * 수동으로 빈 등록하는 방벙
  * */
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
  /***
   * 회원가입
   */
  public Long join(Member member) {
    validateDuplicateMember(member);
    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
              .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
              });
  }

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }
}
