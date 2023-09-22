package com.example.demo.service;

import com.example.demo.entity.Anh;
import com.example.demo.entity.SanPham;
import com.example.demo.repository.AnhRepository;
import com.example.demo.request.ImageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnhService {
    @Autowired
    private AnhRepository repository;

    public List<Anh> getAnhbySanPham(Integer idSP){
        return repository.getAnhBySanPham(idSP);
    }
    public Anh add(ImageRequest request){
        Anh anh = new Anh();
        anh.setLink(request.getLink());
        anh.setTenAnh(request.getTenAnh());
        anh.setSanPham(SanPham.builder().IdSanPham(request.getIdSanPham()).build());
        return repository.save(anh);
    }
    public void delete(UUID id){
        Optional<Anh> optional = repository.findById(id);
        optional.map(o -> {
             repository.delete(o);
            return o;
        }).orElse(null);
    }


}
