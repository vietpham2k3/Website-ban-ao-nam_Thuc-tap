package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.entity.PhongCach;
import com.example.demo.service.AuthService;
import com.example.demo.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private AuthService authService;
    @Autowired
    private KhachHangService khService;

    @GetMapping("/login/sign-in")
    public String loginForm() {
        return "/admin/login/sign-in";
    }

    @GetMapping("/login/sign-up")
    public String signUpForm(Model model) {
        KhachHang kh = new KhachHang();
        model.addAttribute("kh", kh);
        return "/admin/login/sign-up";
    }

    @GetMapping("/login/forget")
    public String forgetPass(Model model) {
        KhachHang kh = new KhachHang();
        model.addAttribute("kh", kh);
        return "/admin/login/forget-pass";
    }

    @PostMapping("/login")
    public String doLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model,
            HttpSession session
    ) {
        KhachHang khachHang = authService.loginKhachHang(username, password);
        NhanVien nhanVien = authService.loginNhanVien(username, password);

        if (khachHang != null) {
            // Đăng nhập thành công với vai trò Khách Hàng
            session.setAttribute("loggedInUser", username);
            session.setAttribute("khachHang",khachHang);
            return "redirect:/client/home";
        } else if (nhanVien != null) {
            // Đăng nhập thành công với vai trò Nhân Viên
            session.setAttribute("loggedInUser", username);
            return "redirect:/admin/hoa-don/hien-thi";
        } else {
            // Đăng nhập không thành công, hiển thị thông báo lỗi
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng !");
            return "redirect:/login/sign-in";
        }
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String taiKhoan,
                         @RequestParam String matKhau,
            Model model,
            HttpSession session
    ) {
        model.addAttribute("taiKhoan",taiKhoan);
        model.addAttribute("matKhau",matKhau);
        authService.dangKy(taiKhoan,matKhau);
        return "redirect:/login/sign-in";
    }

    @PostMapping("/forget")
    @ResponseBody
    public String processForgetPassword(@ModelAttribute("kh") KhachHang khachHang, Model model) {
        // Kiểm tra xem tài khoản tồn tại
        KhachHang existingKhachHang = authService.findByTaiKhoan(khachHang.getTaiKhoan());

        if (existingKhachHang != null) {
            return existingKhachHang.getMatKhau();
        } else {
            return "Tài khoản không tồn tại";
        }
    }


}
