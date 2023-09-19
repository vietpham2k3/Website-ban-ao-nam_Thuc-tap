package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhuyenMai;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhuyenMaiService {
    @Autowired
    public KhuyenMaiRepository res;

    public List<KhuyenMai> getAll(){
        return res.findAll();
    }
}
