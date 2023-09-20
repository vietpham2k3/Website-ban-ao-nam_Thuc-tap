package com.example.demo.service;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.XuatXu;
import com.example.demo.repository.ThuongHieuRepository;
import com.example.demo.repository.XuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XuatXuService {
    @Autowired
    private XuatXuRepository repository;
    public List<XuatXu> getAll(){
        return  repository.findAll();
    }
}
