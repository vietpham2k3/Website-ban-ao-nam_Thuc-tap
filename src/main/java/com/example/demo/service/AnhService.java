package com.example.demo.service;

import com.example.demo.entity.Anh;
import com.example.demo.repository.AnhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnhService {
    @Autowired
    private AnhRepository repository;

    public List<Anh> getAllbySanPham(Integer idSP){
        return repository.getAllBySanPham(idSP);
    }
    public Anh add(Anh anh){
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
