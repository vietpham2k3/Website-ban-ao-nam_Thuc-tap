package com.example.demo.service;

import com.example.demo.entity.PhongCach;
import com.example.demo.entity.XuatXu;
import com.example.demo.repository.PhongCachRepository;
import com.example.demo.repository.XuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongCachService {
    @Autowired
    private PhongCachRepository repository;
    public List<PhongCach> getAll(){
        return  repository.findAll();
    }
}
