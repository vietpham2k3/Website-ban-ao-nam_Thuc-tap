package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/san-pham")
public class SanPhamController {
    @GetMapping("/hien-thi")
    public String index(){
        return "/admin/sanpham/san-pham.html";
    }
    @GetMapping("/add")
    public String add(){
        return "/admin/sanpham/add.html";
    }
    @GetMapping("/update")
    public String update(){
        return "/admin/sanpham/update.html";
    }
}
