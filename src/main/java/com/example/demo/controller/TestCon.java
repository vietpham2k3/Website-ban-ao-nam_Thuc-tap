package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestCon {

    @GetMapping("/index")
    public String index1(){
        return "/admin/pages/billing";
    }

    @GetMapping("/index2")
    public String index2(){
        return "/admin/pages/hoa-don";
    }
}
