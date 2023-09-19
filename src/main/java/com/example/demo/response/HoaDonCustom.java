package com.example.demo.response;

import java.math.BigDecimal;
import java.util.Date;

public interface HoaDonCustom {
    Integer getIdHoaDon();
    String getTenKhachHang();
    Date getNgayCapNhat();
    BigDecimal getTongTienKhiGiam();
    String getTenKhuyenMai();
    String getTenHinhThuc();
    Integer getTrangThai();
}
