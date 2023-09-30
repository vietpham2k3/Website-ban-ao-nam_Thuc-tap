package com.example.demo.service;

import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.repository.DanhMucRepository;
import com.example.demo.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ThuongHieuService {
    @Autowired
    private ThuongHieuRepository repository;
    public List<ThuongHieu> getAll(){
        return  repository.getAll();
    }

    public Page<ThuongHieu> pageTH(Pageable pageable){
        return repository.findAll(pageable);
    }

    public ThuongHieu save(ThuongHieu thuongHieu){
        return repository.save(thuongHieu);
    }

    public ThuongHieu detail(Integer id){
        return repository.findById(id).orElse(null);
    }

}
