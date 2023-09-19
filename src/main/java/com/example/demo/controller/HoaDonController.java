package com.example.demo.controller;

import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/hoa-don/")
public class HoaDonController {

    @Autowired public HoaDonService serHD;
    @Autowired public KhachHangService serKH;
    @Autowired public KhuyenMaiService serKM;
    @Autowired public NhanVienService serNV;
    @Autowired public HinhThucThanhToanService serHTTT;
    @Autowired public DiaChiService serDC;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("listHD", serHD.pageHD(pageable));
        model.addAttribute("listNV", serNV.getAll());
        model.addAttribute("listKM", serKM.getAll());
        model.addAttribute("listKH", serKH.getAll());
        model.addAttribute("listHTTT", serHTTT.getAll());
        return "/admin/hoadon/hoa-don";
    }



    @GetMapping("hien-thi-page-search")
    public String phanTrang(@RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page,5);
        return "/admin/hoadon/hoa-don";
    }

}
