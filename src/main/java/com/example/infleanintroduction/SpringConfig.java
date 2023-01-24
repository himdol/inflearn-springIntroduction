package com.example.infleanintroduction;

import com.example.infleanintroduction.repository.MemberRepository;
import com.example.infleanintroduction.repository.MemoryMemberRepository;
import com.example.infleanintroduction.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  /*
  * 수동 Bean 생성이다. 참고
  * */
  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
  }
}
