package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username","jains!");
       return "greetings";
        //templates안에 greetings를 찾아서 브라우저로 전송
        //리턴 타입이 스트링이라 "";로 선언
    }


    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "parkjain");
        return "goodbye";
    }
}
