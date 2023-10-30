package com.example.demo.controller;

import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/client/ctsp")
public class CtspController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping()
    public String index() {
        return "/Client/detailSp";
    }

    @GetMapping("/{id}")
    public String getOneCtsp(@PathVariable UUID id, Model model) {
        model.addAttribute("ctsp", chiTietSanPhamService.getCTSP(id));
        ;
        return "client/detaiLSP";
    }


}
