package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

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
    @GetMapping("/update/{id}")
    public String update(Model model , @PathVariable("id") UUID id){
        model.addAttribute("idctsp",id);
        return "/admin/sanpham/update.html";
    }
}
