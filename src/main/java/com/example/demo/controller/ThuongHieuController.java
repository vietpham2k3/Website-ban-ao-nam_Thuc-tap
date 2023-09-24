package com.example.demo.controller;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.service.ThuongHieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

@Controller
@RequestMapping("/admin/thuong-hieu/")
public class ThuongHieuController {
    @Autowired public ThuongHieuService service;

    @GetMapping("hien-thi-page")
    public String pageTH(@RequestParam (defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("listTH", service.pageTH(pageable));

        model.addAttribute("th", new ThuongHieu());
        return "/admin/thuonghieu/thuong-hieu";
    }

    @PostMapping("add")
    public String add(@ModelAttribute("th") ThuongHieu thuongHieu,
                      Model model)
            throws IOException {

//        thuongHieu.setTrangThai(0);
        thuongHieu.setNgayTao(new Date());
        thuongHieu.setNgayCapNhat(new Date());
        thuongHieu.setNguoiCapNhat("Việt Create");

        model.addAttribute("th", thuongHieu);
        service.save(thuongHieu);
        return "redirect:/admin/thuong-hieu/hien-thi-page";
    }

    @GetMapping("view-thuong-hieu/{id}")
    public String viewDetails(@PathVariable Integer id, Model model) {
        ThuongHieu thuongHieu = service.detail(id);
        model.addAttribute("th", thuongHieu);

        // Thêm đường dẫn ảnh vào model
        model.addAttribute("anh", thuongHieu.getAnh());

        return "/admin/thuonghieu/updateTH";
    }


    @PostMapping("update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute("th") ThuongHieu thuongHieu, Model model) {
        // Cập nhật các thuộc tính của thương hiệu từ form
        ThuongHieu thuongHieu1 = service.detail(id);

        thuongHieu.setIdThuongHieu(id);
        thuongHieu.setNgayCapNhat(new Date());
        thuongHieu.setNguoiCapNhat("Việt FIX");
        thuongHieu.setNgayTao(thuongHieu1.getNgayTao());

        // Lưu thương hiệu đã cập nhật
        service.save(thuongHieu);

        return "redirect:/admin/thuong-hieu/hien-thi-page";
    }

    @PostMapping("delete/{id}")
    public String xoa(@PathVariable Integer id,Model model){
        ThuongHieu thuongHieu = service.detail(id);
//        thuongHieu.setIdThuongHieu(id);
        thuongHieu.setTrangThai(1);
        thuongHieu.setNgayCapNhat(new Date());
        thuongHieu.setNgayTao(thuongHieu.getNgayTao());
        thuongHieu.setNguoiCapNhat("Việt Delete");

        model.addAttribute("th",thuongHieu);

        service.save(thuongHieu);

        return "redirect:/admin/thuong-hieu/hien-thi-page";
    }
}
