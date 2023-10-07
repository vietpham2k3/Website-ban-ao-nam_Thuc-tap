package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/ban-hang-tai-quay/")
public class BanHangTaiQuayController {

    @GetMapping ("tao-don")
    public String taoDon(){
        return "/admin/BanHangTaiQuay/TaoDonHang2";
    }
}
