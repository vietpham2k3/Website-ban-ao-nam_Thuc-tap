package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.AuthService;
import com.google.api.Http;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class TrangChuController {
    @Autowired
    HttpSession session;
    @GetMapping("/home")
    public String clientHome() {
        return "Client/home";
    }

    @GetMapping("/detail")
    public String detail(){
        return "/Client/detailSP";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        model.addAttribute("idKhachHang",khachHang.getIdKhachHang());
        model.addAttribute("idGioHang",khachHang.getGioHangs().get(0).getIdGioHang());
        return "/Client/cart";
    }

    @GetMapping("/thanh-toan")
    public String checkout(Model model){
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
        model.addAttribute("idKhachHang",khachHang.getIdKhachHang());
        model.addAttribute("idGioHang",khachHang.getGioHangs().get(0).getIdGioHang());
        return "/Client/checkout";
    }

    @GetMapping("/product")
    public String product(){
        return"/Client/product";
    }
}
