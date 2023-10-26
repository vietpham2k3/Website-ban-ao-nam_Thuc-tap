package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class HoaDonChiTietRequest {
    private BigDecimal DonGia;
    private Integer IdColor ;
    private Integer IdSize;
    private UUID IdProductDetail;
    private Integer IdBill;
    private Integer SoLuong;
}
