package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hoa-don/")
public class HoaDonController {

    @GetMapping("hien-thi")
    public String index(){
        return "hoadon/hoa-don";
    }
}
