package com.example.demo.service;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.XuatXu;
import com.example.demo.repository.ThuongHieuRepository;
import com.example.demo.repository.XuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XuatXuService {
    @Autowired
    private XuatXuRepository repository;
    public List<XuatXu> getAll(){
        return  repository.getAll();
    }

    public Page<XuatXu> pageXX(Pageable pageable){
        return repository.findAll(pageable);
    }

    public XuatXu save(XuatXu xuatXu){
        return repository.save(xuatXu);
    }

    public XuatXu detail(Integer id){
        return repository.findById(id).orElse(null);
    }
}
