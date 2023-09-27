package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class KhachHangReques {
    private String TaiKhoan;
    private  String MatKhau;
    private String TenKhachHang;
    private  String Anh;
    private Boolean GioiTinh;
    private String Email;
    private String Sdt;
    private String DiaChi;
    private BigDecimal NgayTao;
    private BigDecimal NgayCapNhat;
    private String NguoiCapNhat;
    private Integer TrangThai;

}
