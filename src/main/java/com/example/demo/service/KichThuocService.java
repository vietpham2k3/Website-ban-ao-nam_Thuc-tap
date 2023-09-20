package com.example.demo.service;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.XuatXu;
import com.example.demo.repository.KichThuocRepository;
import com.example.demo.repository.XuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichThuocService {
    @Autowired
    private KichThuocRepository repository;
    public List<KichThuoc> getAll(){
        return  repository.findAll();
    }
}
