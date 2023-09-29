package com.example.demo.controller;

import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.PhanLoai;
import com.example.demo.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/admin/danh-muc")
@Controller
public class DanhMucController {
    @Autowired
    private DanhMucService danhMucService;
    
    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        model.addAttribute("listDM",danhMucService.getAll());
        return "/admin/danhmuc/danh-muc";
    }

    @GetMapping("hien-thi-page")
    public String pagePL(@RequestParam(defaultValue = "0") int page, Model model){
        model.addAttribute("listDM", danhMucService.phanTrang(page,5));

        model.addAttribute("dm", new DanhMuc());
        return "/admin/danhmuc/danh-muc";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("dm") DanhMuc dm,
                      BindingResult bindingResult) {
        danhMucService.add(dm);
        return "redirect:/admin/danh-muc/hien-thi-page";

    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id,
                             Model model){
        DanhMuc dm = danhMucService.getOne(id);
        model.addAttribute("dm",dm);
        return "/admin/danhmuc/updateDm";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("dm") DanhMuc dm,
                         BindingResult bindingResult) {
        danhMucService.update(dm);
        return "redirect:/admin/danh-muc/hien-thi-page";

    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        DanhMuc dm = danhMucService.getOne(id);
        danhMucService.delete(dm);
        return "redirect:/admin/danh-muc/hien-thi-page";

    }
    
}
