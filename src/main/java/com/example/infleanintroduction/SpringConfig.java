package com.example.infleanintroduction;

import com.example.infleanintroduction.repository.JdbcMemberRepository;
import com.example.infleanintroduction.repository.MemberRepository;
import com.example.infleanintroduction.repository.MemoryMemberRepository;
import com.example.infleanintroduction.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
  /*
  * 수동 Bean 생성이다. 참고
  * */
  private DataSource dataSource;

  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
    return new JdbcMemberRepository(dataSource);
  }
}
