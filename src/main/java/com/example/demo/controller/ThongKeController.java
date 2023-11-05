package com.example.demo.controller;

import com.example.demo.entity.HoaDon;
import com.example.demo.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired public ThongKeService service;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("donCho", service.soDonCho());
        model.addAttribute("donHuy", service.soDonHuy());
        model.addAttribute("donDaBan", service.soDonDaBan());
        model.addAttribute("donDangGiao", service.soDonDangGiao());
        model.addAttribute("doanhThuNgay", service.doanhThuTongNgay());
        model.addAttribute("doanhThuNgayHqua", service.doanhThuNgayHomQua());
        model.addAttribute("doanhThuThang", service.doanhThuTongThang());
        model.addAttribute("doanhThuNam", service.doanhThuTongNam());

        return "/admin/thongke/thong-ke";
    }
}
