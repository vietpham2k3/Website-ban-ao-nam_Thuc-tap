package com.example.demo.controller;

import com.example.demo.entity.PhanLoai;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.service.PhanLoaiService;
import com.example.demo.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/admin/phan-loai/")
public class PhanLoaiController {
    @Autowired
    public PhanLoaiService service;

    @GetMapping("hien-thi-page")
    public String pagePL(@RequestParam(defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("listPL", service.pagePL(pageable));

        model.addAttribute("pl", new PhanLoai());
        return "/admin/phanloai/phan-loai";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("pl") PhanLoai phanLoai,
                      Model model)
            throws IOException {

//        thuongHieu.setTrangThai(0);
        phanLoai.setNgayTao(new Date());
        phanLoai.setNgayCapNhat(new Date());
        phanLoai.setNguoiCapNhat("Việt Create");

        model.addAttribute("pl", phanLoai);
        service.save(phanLoai);
        return "redirect:/admin/phan-loai/hien-thi-page";
    }

    @GetMapping("view-phan-loai/{id}")
    public String viewDetails(@PathVariable Integer id, Model model) {
        PhanLoai phanLoai = service.detail(id);
        model.addAttribute("pl", phanLoai);

        // Thêm đường dẫn ảnh vào model
        model.addAttribute("anh", phanLoai.getAnh());

        return "/admin/phanloai/updatePL";
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute("pl") PhanLoai phanLoai, Model model) {
        // Cập nhật các thuộc tính của thương hiệu từ form
        PhanLoai phanLoai1 = service.detail(id);

        phanLoai.setIdPhanLoai(id);
        phanLoai.setNgayCapNhat(new Date());
        phanLoai.setNguoiCapNhat("Việt FIX");
        phanLoai.setNgayTao(phanLoai1.getNgayTao());

        // Lưu thương hiệu đã cập nhật
        service.save(phanLoai);

        return "redirect:/admin/phan-loai/hien-thi-page";
    }

    @PostMapping("delete/{id}")
    public String xoa(@PathVariable Integer id,Model model){
        PhanLoai phanLoai = service.detail(id);
//        thuongHieu.setIdThuongHieu(id);
        phanLoai.setTrangThai(1);
        phanLoai.setNgayCapNhat(new Date());
        phanLoai.setNgayTao(phanLoai.getNgayTao());
        phanLoai.setNguoiCapNhat("Việt Delete");

        model.addAttribute("pl",phanLoai);

        service.save(phanLoai);

        return "redirect:/admin/phan-loai/hien-thi-page";
    }
}
