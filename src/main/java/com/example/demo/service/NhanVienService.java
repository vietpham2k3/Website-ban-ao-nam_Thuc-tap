package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.repository.NhanVienRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    public NhanVienRespository res;

    public List<NhanVien> getAll(){
        return res.findAll();
    }

}
