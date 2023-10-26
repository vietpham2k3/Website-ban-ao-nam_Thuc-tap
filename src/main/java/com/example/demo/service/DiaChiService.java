package com.example.demo.service;

import com.example.demo.entity.DiaChiGiaoHang;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.DiaChiRepository;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.request.DiaChiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiaChiService {
    @Autowired
    public DiaChiRepository res;

    public List<DiaChiGiaoHang> getAllbyKhachHang(UUID id){
        return res.getDiaChiByKhachHang(id);
    }

    public DiaChiGiaoHang add(DiaChiRequest request){
        DiaChiGiaoHang diaChiGiaoHang = new DiaChiGiaoHang();
        diaChiGiaoHang.setGhiChu(request.getGhiChu());
       if(request.getIdKhachHang() !=  null){
           diaChiGiaoHang.setKhachHang(KhachHang.builder().IdKhachHang(request.getIdKhachHang()).build());
       }
        diaChiGiaoHang.setPhuongXa(request.getPhuongXa());
        diaChiGiaoHang.setQuanHuyen(request.getQuanHuyen());
        diaChiGiaoHang.setTinhThanh(request.getTinhThanh());
        diaChiGiaoHang.setSdtNhan(request.getSdtNhan());
        diaChiGiaoHang.setTenNguoiNhan(request.getTenNguoiNhan());
        diaChiGiaoHang.setTrangThai(request.getTrangThai());
        return res.save(diaChiGiaoHang);
    }
}
