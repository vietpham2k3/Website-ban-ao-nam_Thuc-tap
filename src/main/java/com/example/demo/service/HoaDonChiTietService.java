package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.repository.HoaDonChiTietRepository;
import com.example.demo.request.HoaDonChiTietRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepository repository;

    public HoaDonChiTiet add(HoaDonChiTietRequest request){
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        hoaDonChiTiet.setHoaDon(HoaDon.builder().IdHoaDon(request.getIdBill()).build());
        hoaDonChiTiet.setChiTietSanPham(ChiTietSanPham.builder().IdCTSP(request.getIdProductDetail()).build());
        hoaDonChiTiet.setDonGia(request.getDonGia());
        hoaDonChiTiet.setSoLuong(request.getSoLuong());
        hoaDonChiTiet.setKichThuoc(request.getIdSize());
        hoaDonChiTiet.setMauSac(request.getIdColor());
        return repository.save(hoaDonChiTiet);
    }
}
