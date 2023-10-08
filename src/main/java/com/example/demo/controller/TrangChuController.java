package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/")
public class TrangChuController {

    @GetMapping("/home")
    public String home(){
        return "/Client/home";
    }

    @GetMapping("/detail")
    public String detail(){
        return "/Client/detailSP";
    }

    @GetMapping("/cart")
    public String cart(){
        return "/Client/cart";
    }
}
