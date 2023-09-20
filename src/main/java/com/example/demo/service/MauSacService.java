package com.example.demo.service;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.XuatXu;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.repository.XuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacService {
    @Autowired
    private MauSacRepository repository;
    public List<MauSac> getAll(){
        return  repository.findAll();
    }
}
