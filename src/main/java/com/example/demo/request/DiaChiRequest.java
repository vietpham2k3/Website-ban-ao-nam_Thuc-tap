package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DiaChiRequest {
    private String TenNguoiNhan;
    private String SdtNhan;
    private String TinhThanh;
    private String QuanHuyen;
    private String PhuongXa;
    private String GhiChu;
    private Integer TrangThai;
    private UUID IdKhachHang;
}
