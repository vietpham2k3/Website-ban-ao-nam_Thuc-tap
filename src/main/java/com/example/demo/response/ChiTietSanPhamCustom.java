package com.example.demo.response;

import java.math.BigDecimal;
import java.util.UUID;

public interface ChiTietSanPhamCustom {
    UUID getIdCTSP();
    String getLink();
    String getMaSanPham();
    String getTenSanPham();
    BigDecimal getGiaBan();
    String getTenDanhMuc();
    String getTenThuongHieu();
}
