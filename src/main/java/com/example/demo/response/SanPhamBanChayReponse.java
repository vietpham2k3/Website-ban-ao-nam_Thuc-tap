package com.example.demo.response;

import java.math.BigDecimal;
import java.util.UUID;

public interface SanPhamBanChayReponse {
    UUID getIdCTSP();
    String getTenSanPham();
    BigDecimal getGiaBan();
    String getLink();
}
