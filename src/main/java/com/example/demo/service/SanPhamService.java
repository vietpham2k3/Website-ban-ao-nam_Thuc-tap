package com.example.demo.service;

import com.example.demo.entity.SanPham;
import com.example.demo.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepository repository;

    public SanPham add(SanPham sanPham){
       return repository.save(sanPham);
    }
}
