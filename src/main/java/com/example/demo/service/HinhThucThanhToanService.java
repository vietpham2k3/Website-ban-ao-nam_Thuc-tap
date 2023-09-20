package com.example.demo.service;

import com.example.demo.entity.HinhThucThanhToan;
import com.example.demo.entity.HoaDon;
import com.example.demo.repository.HinhThucThanhToanRepository;
import com.example.demo.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HinhThucThanhToanService {
    @Autowired
    public HinhThucThanhToanRepository res;

    public List<HinhThucThanhToan> getAll(){
        return res.findAll();
    }
}
