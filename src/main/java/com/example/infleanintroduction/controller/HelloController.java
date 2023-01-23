package com.example.infleanintroduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

  @RequestMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
  }

  /*
  * cd build cd libs ls-arlth
  java -jar name.jar
  spring 이 실행이 되는 것을 알 수가 있다.
  컨트롤 + c 를 이용하여 종료할 수 있다.
  * */

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
  }

  @GetMapping("hello-string")
  @ResponseBody
  public String helloString(@RequestParam("name") String name)   {
    return "hello " +name;
  }

  @GetMapping("hello-api")
  @ResponseBody
  /*
   * @ResponseBody 가 붙어 있을때 객체가 오면 기본으로 JSON방식으로 반환하겠다가 기본정책
   * 객체 일때는 httpMessageConverter 가 동작하며 기본 문자처리는 - StringConverter / 기본 객체 처리는  - JsonConverter
   * Spring은 기본으로 MappingJackson2HttpMessageConverter 의 Jackson2의 라이브러리를 탑제하고있다.
   * 바꿀수 있지만 실무에서도 그대로 사용을 합니다.
   *
   * 참고 : 클라이언트의 http accept 헤더가 있다.
   */
  public Hello helloApi(@RequestParam("name") String name) {
    Hello hello = new Hello();
    hello.setName(name);
    return hello;
  }

  static class Hello {
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
