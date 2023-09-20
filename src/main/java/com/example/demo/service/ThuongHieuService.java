package com.example.demo.service;

import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.DanhMucRepository;
import com.example.demo.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuongHieuService {
    @Autowired
    private ThuongHieuRepository repository;
    public List<ThuongHieu> getAll(){
        return  repository.findAll();
    }
}
