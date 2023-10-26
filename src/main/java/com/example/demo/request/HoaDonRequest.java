package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class HoaDonRequest {
    private BigDecimal TongTien;
    private BigDecimal PhiShip;
    private BigDecimal TongTienKhiGiam;
    private String GhiChu;
    private UUID IdKhachHang;
    private UUID IdDiaChi;
    private Integer TrangThai;
}
