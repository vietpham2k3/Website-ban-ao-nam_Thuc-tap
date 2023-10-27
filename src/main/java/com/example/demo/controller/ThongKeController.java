package com.example.demo.controller;

import com.example.demo.entity.HoaDon;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/thong-ke/")
public class ThongKeController {

    @GetMapping("hien-thi")
    public String hienThi(Model model){


        return "/admin/thongke/thong-ke";
    }
}
