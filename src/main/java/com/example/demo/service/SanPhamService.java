package com.example.demo.service;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.response.ChiTietSanPhamCustom;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.repository.ChiTietSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService {
    @Autowired
    private ChiTietSanPhamRepository repository;

    public List<ChiTietSanPhamCustom> getAll(){
        return repository.getAll();
    }
//    public Page<ChiTietSanPham> phanTrang(Pageable pageable){
//        return repository.findAll(pageable);
//    }
//    public SanPham add(SanPham sanPham){
//        return repository.save(sanPham);
//    }
//    public SanPham update(Integer id,SanPham sanPham){
//        SanPham sp = repository.getById(id);
//        sp.setTenSanPham(sanPham.getTenSanPham());
//        sp.setMoTa(sanPham.getMoTa());
//        sp.setTrangThai(0);
//        return repository.save(sanPham);
//    }
}
