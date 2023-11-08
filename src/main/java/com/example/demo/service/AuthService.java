package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.repository.NhanVienRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private NhanVienRespository nhanVienRepository;

    public KhachHang loginKhachHang(String taiKhoan, String matKhau) {
        return khachHangRepository.findByTaiKhoanAndMatKhau(taiKhoan, matKhau);
    }

    public NhanVien loginNhanVien(String maNhanVien, String matKhau) {
        return nhanVienRepository.findByMaNhanVienAndMatKhau(maNhanVien, matKhau);
    }

    public void dangKy(String taiKhoan, String matKhau) {
        khachHangRepository.signUp(taiKhoan, matKhau);
    }

    public KhachHang findByTaiKhoan(String taiKhoan) {
        return khachHangRepository.findByTaiKhoan(taiKhoan);
    }
}

