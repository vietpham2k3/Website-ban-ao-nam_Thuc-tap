package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/mau-sac")
public class MauSacController {

    @GetMapping("/hien-thi")
    public String index(){
        return "/admin/mausac/mau-sac.html";
    }
    @GetMapping("/add")
    public String add(){
        return "/admin/mausac/add.html";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id){
        model.addAttribute("id",id);
        return "/admin/mausac/update.html";
    }

}
