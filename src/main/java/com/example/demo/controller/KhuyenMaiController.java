package com.example.demo.controller;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/admin/khuyen-mai")
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiService khuyenMaiService;

    @GetMapping("/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model) {
        List<KhuyenMai> khuyenMais = khuyenMaiService.getAll();
        model.addAttribute("listKM", khuyenMais);

        return "/admin/khuyenmai/khuyen-mai";
    }

//    @GetMapping("/{id}")
//    public String getOne(@PathVariable("id") String id,
//                          Model model) {
//      model.addAttribute("km",khuyenMaiService.getOne(id));
//        return "/admin/khuyenmai/khuyen-mai";
//    }

    @PostMapping("/add")
    public String add(@ModelAttribute("khuyenMai") KhuyenMai km,
                      BindingResult bindingResult) {
            khuyenMaiService.add(km);
            return "redirect:/admin/khuyen-mai/hien-thi";

        }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id,
                             Model model){
        KhuyenMai km = khuyenMaiService.getOne(id);
        model.addAttribute("details",km);
        return "/admin/khuyenmai/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("khuyenMai") KhuyenMai km,
                      BindingResult bindingResult) {
        khuyenMaiService.update(km);
        return "redirect:/admin/khuyen-mai/hien-thi";

    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") String id) {
        KhuyenMai km = khuyenMaiService.getOne(id);
        khuyenMaiService.delete(km);
        return "redirect:/admin/khuyen-mai/hien-thi";

    }



//    @GetMapping("/update/{id}")
//    public String update(Model model , @PathVariable("id") UUID id){
//        model.addAttribute("idctsp",id);
//        return "/admin/khuyenmai/update.html";

}
