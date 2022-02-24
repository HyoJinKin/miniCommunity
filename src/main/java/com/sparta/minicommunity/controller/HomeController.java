//package com.sparta.minicomunity.controller;
//
//import com.sparta.minicomunity.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//
//@RequiredArgsConstructor
//@Controller
//public class HomeController {
//
//    private final UserRepository userRepository;
//    private final LoginService loginService;
//    @GetMapping("/")
//    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        model.addAttribute("username", userDetails.getUsername());
//        return "index";
//    }



//}
