package com.fastcampus.ch2;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 프로그램으로 등록
@Controller
public class HomeController {  //원격 프로그램
    //2. URL와 메서드를 연결
    @RequestMapping("/")
    public String main()  {
        return "index";  //templates/index.html
    }

    @GetMapping("/test")
    public String test(Model model)  {
  model.addAttribute("lastName","Ye");
  model.addAttribute("firstName","Ban");
        return "test";  //templates/index.html
    }

}
