package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Kiểm tra xem người dùng đã đăng nhập hay chưa bằng cách kiểm tra session hoặc cookie
        String loggedInUser = (String) request.getSession().getAttribute("loggedInUser");

        if (loggedInUser == null) {
            // Người dùng chưa đăng nhập, điều hướng họ đến trang đăng nhập
            response.sendRedirect("/login/sign-in");
            return false;
        }
        return true;
    }
}

