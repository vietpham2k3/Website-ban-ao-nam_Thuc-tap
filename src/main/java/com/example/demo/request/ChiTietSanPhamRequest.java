package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ChiTietSanPhamRequest {
    private BigDecimal GiaNhap;
    private BigDecimal GiaBan;
    private Integer GiamGia;
    private String MoTa;
    private Integer IdDanhMuc;
    private Integer IdPhanLoai;
    private Integer IdThuongHieu;
    private Integer IdXuatXu;
    private Integer IdSanPham;

}
