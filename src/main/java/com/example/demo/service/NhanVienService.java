package com.example.demo.service;


import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRespository;
import com.example.demo.request.NhanVienRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NhanVienService {
    @Autowired
    public NhanVienRespository res;

    public List<NhanVien> getAll(){
        return res.getAll();
    }

    public NhanVien add(NhanVienRequest request){
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(request.getMaNhanVien());
        nhanVien.setTenNhanVien(request.getTenNhanVien());
        nhanVien.setAnh(request.getAnh());
        nhanVien.setGioiTinh(request.getGioiTinh());
        nhanVien.setEmail(request.getEmail());
        nhanVien.setSdt(request.getSdt());
        nhanVien.setDiaChi(request.getDiaChi());
        nhanVien.setLuong(request.getLuong());
        nhanVien.setMatKhau(request.getMatKhau());
        nhanVien.setTrangThai(0);
        nhanVien.setNgayTao(new Date(0));
        return res.save(nhanVien);
    }

    public NhanVien update(UUID id , NhanVienRequest request){
        NhanVien nhanVien = res.getById(id);
        nhanVien.setTenNhanVien(request.getTenNhanVien());
        nhanVien.setMaNhanVien(request.getMaNhanVien());
        nhanVien.setAnh(request.getAnh());
        nhanVien.setGioiTinh(request.getGioiTinh());
        nhanVien.setEmail(request.getEmail());
        nhanVien.setSdt(request.getSdt());
        nhanVien.setDiaChi(request.getDiaChi());
        nhanVien.setLuong(request.getLuong());
        nhanVien.setMatKhau(request.getMatKhau());
        nhanVien.setNgayCapNhat(new Date(0));
        return res.save(nhanVien);
    }

    public NhanVien getById(UUID id ){
        return res.getById(id);
    }
    public NhanVien delete(UUID Id){
        NhanVien nhanVien = res.getById(Id);
        nhanVien.setTrangThai(1);
        return res.save(nhanVien);
    }

}
