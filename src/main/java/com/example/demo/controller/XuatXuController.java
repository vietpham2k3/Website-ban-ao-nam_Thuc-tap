package com.example.demo.controller;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.XuatXu;
import com.example.demo.service.ThuongHieuService;
import com.example.demo.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/admin/xuat-xu/")
public class XuatXuController {
    @Autowired
    public XuatXuService service;

    @GetMapping("hien-thi-page")
    public String pageXX(@RequestParam(defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("listXX", service.pageXX(pageable));

        model.addAttribute("xx", new XuatXu());
        return "/admin/xuatxu/xuat-xu";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("xx") XuatXu xuatXu,
                      Model model)
            throws IOException {

//        thuongHieu.setTrangThai(0);
        xuatXu.setNgayTao(new Date());
        xuatXu.setNgayCapNhat(new Date());
        xuatXu.setNguoiCapNhat("Việt Create");

        model.addAttribute("xx", xuatXu);
        service.save(xuatXu);
        return "redirect:/admin/xuat-xu/hien-thi-page";
    }

    @GetMapping("view-xuat-xu/{id}")
    public String viewDetails(@PathVariable Integer id, Model model) {
        XuatXu xuatXu = service.detail(id);
        model.addAttribute("xx", xuatXu);

        return "/admin/xuatxu/updateXX";
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable Integer id,
                         @ModelAttribute("xx") XuatXu xuatXu,
                         Model model) {
        // Cập nhật các thuộc tính của thương hiệu từ form
        XuatXu xuatXu1 = service.detail(id);

        xuatXu.setIdXuatXu(id);
        xuatXu.setNgayCapNhat(new Date());
        xuatXu.setNguoiCapNhat("Việt FIX");
        xuatXu.setNgayTao(xuatXu1.getNgayTao());

        // Lưu thương hiệu đã cập nhật
        service.save(xuatXu);

        return "redirect:/admin/xuat-xu/hien-thi-page";
    }

    @PostMapping("delete/{id}")
    public String xoa(@PathVariable Integer id,Model model){
        XuatXu xuatXu = service.detail(id);
//        thuongHieu.setIdThuongHieu(id);
        xuatXu.setTrangThai(1);
        xuatXu.setNgayCapNhat(new Date());
        xuatXu.setNgayTao(xuatXu.getNgayTao());
        xuatXu.setNguoiCapNhat("Việt Delete");

        model.addAttribute("xx",xuatXu);

        service.save(xuatXu);

        return "redirect:/admin/xuat-xu/hien-thi-page";
    }
}
