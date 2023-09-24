package com.example.demo.controller;

import com.example.demo.entity.PhongCach;
import com.example.demo.entity.XuatXu;
import com.example.demo.service.PhongCachService;
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
@RequestMapping("/admin/phong-cach/")
public class PhongCachController {
    @Autowired
    public PhongCachService service;

    @GetMapping("hien-thi-page")
    public String pagePC(@RequestParam(defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("listPC", service.pagePC(pageable));

        model.addAttribute("pc", new PhongCach());
        return "/admin/phongcach/phong-cach";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("pc") PhongCach phongCach,
                      Model model)
            throws IOException {

//        thuongHieu.setTrangThai(0);
        phongCach.setNgayTao(new Date());
        phongCach.setNgayCapNhat(new Date());
        phongCach.setNguoiCapNhat("Việt Create");

        model.addAttribute("pc", phongCach);
        service.save(phongCach);
        return "redirect:/admin/phong-cach/hien-thi-page";
    }

    @GetMapping("view-phong-cach/{id}")
    public String viewDetails(@PathVariable Integer id, Model model) {
        PhongCach phongCach = service.detail(id);
        model.addAttribute("pc", phongCach);

        return "/admin/phongcach/updatePC";
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable Integer id,
                         @ModelAttribute("pc") PhongCach phongCach,
                         Model model) {
        // Cập nhật các thuộc tính của thương hiệu từ form
        PhongCach phongCach1 = service.detail(id);

        phongCach.setIdPhongCach(id);
        phongCach.setNgayCapNhat(new Date());
        phongCach.setNguoiCapNhat("Việt FIX");
        phongCach.setNgayTao(phongCach1.getNgayTao());

        // Lưu thương hiệu đã cập nhật
        service.save(phongCach);

        return "redirect:/admin/phong-cach/hien-thi-page";
    }

    @PostMapping("delete/{id}")
    public String xoa(@PathVariable Integer id,Model model){
        PhongCach phongCach = service.detail(id);
//        thuongHieu.setIdThuongHieu(id);
        phongCach.setTrangThai(1);
        phongCach.setNgayCapNhat(new Date());
        phongCach.setNgayTao(phongCach.getNgayTao());
        phongCach.setNguoiCapNhat("Việt Delete");

        model.addAttribute("pc",phongCach);

        service.save(phongCach);

        return "redirect:/admin/phong-cach/hien-thi-page";
    }
}
