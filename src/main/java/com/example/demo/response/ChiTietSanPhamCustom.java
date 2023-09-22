package com.example.demo.response;

import com.example.demo.entity.SanPham;

import java.math.BigDecimal;
import java.util.UUID;

public interface ChiTietSanPhamCustom {
    UUID getIdCTSP();
    Integer getIdSanPham();
    String getMaSanPham();
    String getTenSanPham();
    BigDecimal getGiaBan();
    String getTenDanhMuc();
    String getTenThuongHieu();
    Integer getTrangThai();
}
