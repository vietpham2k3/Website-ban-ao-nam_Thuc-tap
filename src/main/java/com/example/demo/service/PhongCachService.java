package com.example.demo.service;

import com.example.demo.entity.PhongCach;
import com.example.demo.entity.XuatXu;
import com.example.demo.repository.PhongCachRepository;
import com.example.demo.repository.XuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongCachService {
    @Autowired
    private PhongCachRepository repository;
    public List<PhongCach> getAll(){
        return  repository.findAll();
    }

    public Page<PhongCach> pagePC(Pageable pageable){
        return repository.findAll(pageable);
    }

    public PhongCach save(PhongCach phongCach){
        return repository.save(phongCach);
    }

    public PhongCach detail(Integer id){
        return repository.findById(id).orElse(null);
    }
}
