package com.example.demo.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class KichThuoc_MauSac_CTSPRequest {
    private Integer IdKichThuoc;
    private Integer IdMauSac;
    private UUID IdCTSP;
    private Integer SoLuong;
}
