package com.example.demo.service;

import com.example.demo.entity.DanhMuc;
import com.example.demo.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService {
    @Autowired
    private DanhMucRepository repository;
    public List<DanhMuc> getAll(){
        return  repository.findAll();
    }
}
