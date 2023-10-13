package com.example.demo.controller;

import com.example.demo.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class TrangChuController {

    @GetMapping("/home")
    public String clientHome() {
        return "Client/home";
    }

    @GetMapping("/detail")
    public String detail(){
        return "/Client/detailSP";
    }

    @GetMapping("/cart")
    public String cart(){
        return "/Client/cart";
    }

    @GetMapping("/thanh-toan")
    public String checkout(){
        return "/Client/checkout";
    }

    @GetMapping("/product")
    public String product(){
        return"/Client/product";
    }
}
