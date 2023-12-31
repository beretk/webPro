package com.lec.ch04_friend.controller;
import com.lec.ch04_friend.domain.Friend;
import com.lec.ch04_friend.service.FriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    @Autowired
    private FriendService friendService;
    @GetMapping("/") // 우선순위 : 컨트롤러 -> static(정적리소스)
    public String home(Model model){
        model.addAttribute("greeting", "Welcome, 첫 화면");
        return "home";
    }
}
