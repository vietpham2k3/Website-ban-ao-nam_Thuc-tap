package com.example.demo.service;

import com.example.demo.entity.Anh;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.AnhRepository;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.response.AnhCustom;
import com.example.demo.response.SanPhamCustom;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepository repository;

    public List<SanPham> getAll(){
        return repository.findAll();
    }
    public SanPham add(SanPham sanPham){
       return repository.save(sanPham);
    }
    public SanPham update(SanPham sanPham,Integer id){
        SanPham sp = repository.getById(id);
        sp.setMaSanPham(sanPham.getMaSanPham());
        sp.setTenSanPham(sanPham.getTenSanPham());
        sp.setNgayCapNhat(new Date());
        return repository.save(sp);
    }
    public SanPham getById(Integer id){
        SanPham sanPham = repository.getById(id);
        return sanPham;
    }
    public SanPham delete(Integer id){
        SanPham sanPham = repository.getById(id);
        sanPham.setTrangThai(1);
        return repository.save(sanPham);
    }

}
