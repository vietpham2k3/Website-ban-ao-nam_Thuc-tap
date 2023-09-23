package com.example.demo.controller;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.service.KhuyenMaiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/khuyen-mai")
public class VoucherController {

    @Autowired
    private KhuyenMaiService serKM;

    @GetMapping("/hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model) {
        List<KhuyenMai> khuyenMais = serKM.getAll();
        model.addAttribute("listKM", khuyenMais);

        return "/admin/khuyenmai/khuyen-mai";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") String id,
                          Model model) {
      model.addAttribute("km",serKM.getOne(id));
        return "/admin/khuyenmai/khuyen-mai";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("khuyenMai") KhuyenMai km,
                      BindingResult bindingResult) {
            serKM.add(km);
            return "redirect:/admin/khuyen-mai/hien-thi";

        }

    @PostMapping("/update/{id} ")
    public String update(@ModelAttribute("khuyenMai") KhuyenMai km,
                      BindingResult bindingResult,
                         @PathVariable("id") String id) {

        serKM.update(km,id);
        return "redirect:/admin/khuyen-mai/hien-thi";

    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") String id) {
        KhuyenMai km = serKM.getOne(id);
        serKM.delete(km);
        return "redirect:/admin/khuyen-mai/hien-thi";

    }



//    @GetMapping("/update/{id}")
//    public String update(Model model , @PathVariable("id") UUID id){
//        model.addAttribute("idctsp",id);
//        return "/admin/khuyenmai/update.html";

}
