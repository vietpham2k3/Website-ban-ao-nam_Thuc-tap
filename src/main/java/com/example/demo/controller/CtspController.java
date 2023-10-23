package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client/ctsp" )
public class CtspController {
    @GetMapping()
    public String index(){
        return "/Client/detailSp";
    }


}
