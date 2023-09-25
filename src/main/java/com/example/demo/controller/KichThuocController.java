package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/kich-thuoc")
public class KichThuocController {

    @GetMapping("/hien-thi")
    public String index(){
        return "/admin/kichthuoc/kich-thuoc.html";
    }
    @GetMapping("/add")
    public String add(){
        return "/admin/kichthuoc/add.html";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id){
        model.addAttribute("id",id);
        return "/admin/kichthuoc/update.html";
    }

}
