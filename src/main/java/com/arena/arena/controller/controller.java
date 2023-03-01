package com.arena.arena.controller;

import com.arena.arena.model.dto.UserDto;
import com.arena.arena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class controller {

    @Autowired
    private UserService userService;
    @GetMapping("/loginPage")
    public String viewLoginPage() {
        return "loginPage";
    }

    @GetMapping("/signupPage")
    public String signupPage(){
        return "signupPage";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserDto user) {
        userService.save(user);
        return "loginPage";
    }

    @GetMapping("loginSuccess")
    public String viewLoginSuccessPage(@AuthenticationPrincipal User user, Model model) {
            model.addAttribute("userId", user.getUsername());
            model.addAttribute("userRoles", user.getAuthorities());
            return "loginSuccess";
    }
}
