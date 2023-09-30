package com.example.demo.service;

import com.example.demo.entity.PhanLoai;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.PhanLoaiRepository;
import com.example.demo.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhanLoaiService {
    @Autowired
    private PhanLoaiRepository repository;
    public List<PhanLoai> getAll(){
        return  repository.getAll();
    }

    public Page<PhanLoai> pagePL(Pageable pageable){
        return repository.findAll(pageable);
    }

    public PhanLoai save(PhanLoai phanLoai){
        return repository.save(phanLoai);
    }

    public PhanLoai detail(Integer id){
        return repository.findById(id).orElse(null);
    }
}
