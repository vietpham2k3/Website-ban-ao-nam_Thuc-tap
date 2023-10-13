package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private AuthService authService;

    @GetMapping("/login/sign-in")
    public String loginForm() {
        return "/admin/login/sign-in";
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
}
