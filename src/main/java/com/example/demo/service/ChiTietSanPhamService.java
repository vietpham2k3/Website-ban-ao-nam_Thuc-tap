package com.example.demo.service;

import com.example.demo.entity.DanhMuc;
import com.example.demo.response.ChiTietSanPhamCustom;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.repository.ChiTietSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSanPhamService {
    @Autowired
    private ChiTietSanPhamRepository repository;

    public List<ChiTietSanPhamCustom> getAll(){
        return repository.getAll();
    }
    public Page<ChiTietSanPhamCustom> phanTrang(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return repository.phanTrang(pageable);
    }


}
