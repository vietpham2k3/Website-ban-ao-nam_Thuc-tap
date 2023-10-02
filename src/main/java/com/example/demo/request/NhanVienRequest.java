package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class NhanVienRequest {
    private String MaNhanVien;
    private String TenNhanVien;
    private String Anh;
    private Boolean GioiTinh;
    private String Email;
    private String Sdt;
    private String DiaChi;
    private BigDecimal Luong;
    private String MatKhau;
    private Integer TrangThai;
}
