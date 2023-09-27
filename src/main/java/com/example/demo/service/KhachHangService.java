package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhachHang;
import com.example.demo.entity.KichThuoc;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.request.KhachHangReques;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class KhachHangService {
    @Autowired
    public KhachHangRepository res;

    public List<KhachHang> getAll(){
        return res.findAll();
    }

    public KhachHang add(KhachHangReques reques){
        KhachHang khachHang = new KhachHang();
        khachHang.setTaiKhoan(reques.getTaiKhoan());
        khachHang.setMatKhau(reques.getMatKhau());
        khachHang.setTenKhachHang(reques.getTenKhachHang());
        khachHang.setAnh(reques.getAnh());
        khachHang.setGioiTinh(reques.getGioiTinh());
        khachHang.setEmail(reques.getEmail());
        khachHang.setSdt(reques.getSdt());
        khachHang.setDiaChi(reques.getDiaChi());
        khachHang.setNgayTao(new Date());
        khachHang.setTrangThai(0);
        return res.save(khachHang);
    }
    public  KhachHang update(UUID id , KhachHangReques reques){
        KhachHang khachHang = res.getById(id);
        khachHang.setTenKhachHang(reques.getTenKhachHang());
        khachHang.setTaiKhoan(reques.getTaiKhoan());
        khachHang.setMatKhau(reques.getMatKhau());
        khachHang.setAnh(reques.getAnh());
        khachHang.setGioiTinh(reques.getGioiTinh());
        khachHang.setEmail(reques.getEmail());
        khachHang.setSdt(reques.getSdt());
        khachHang.setDiaChi(reques.getDiaChi());
        khachHang.setNgayTao(new Date());
        return res.save(khachHang);

    }
    public  KhachHang getById(UUID id ){
        return res.getById(id);
    }
    public KhachHang delete(UUID Id){
        KhachHang khachHang = res.getById(Id);
        khachHang.setTrangThai(1);
        return res.save(khachHang);
    }
}
