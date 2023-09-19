package com.example.demo.service;

import com.example.demo.entity.DiaChiGiaoHang;
import com.example.demo.entity.HoaDon;
import com.example.demo.repository.DiaChiRepository;
import com.example.demo.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaChiService {
    @Autowired
    public DiaChiRepository res;

    public List<DiaChiGiaoHang> getAll(){
        return res.findAll();
    }
}
