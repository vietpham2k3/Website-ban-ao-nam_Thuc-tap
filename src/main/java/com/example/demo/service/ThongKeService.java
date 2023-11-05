package com.example.demo.service;

import com.example.demo.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThongKeService {
    @Autowired public HoaDonRepository res;

    public Integer soDonCho(){
        return res.soDonChoXacNhan();
    }

    public Integer soDonHuy(){
        return res.soDonDaHuy();
    }

    public Integer soDonDangGiao(){
        return res.soDonDangGiao();
    }

    public Integer soDonDaBan(){
        return res.soDonDaBan();
    }
    //
    public Double doanhThuTongNgay(){
        return res.doanhThuTongNgay();
    }

    public Double doanhThuNgayHomQua(){
        return res.doanhThuHomQua();
    }

    public Double doanhThuTongThang(){
        return res.doanhThuTongThang();
    }

    public Double doanhThuTongNam(){
        return res.doanhThuTongNam();
    }
}
