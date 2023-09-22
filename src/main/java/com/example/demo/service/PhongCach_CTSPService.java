package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.PhongCach;
import com.example.demo.entity.PhongCach_CTSP;
import com.example.demo.repository.PhongCach_CTSPRepository;
import com.example.demo.request.PhongCach_CTSPRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhongCach_CTSPService {
    @Autowired
    private PhongCach_CTSPRepository repository;

    public PhongCach_CTSP add(PhongCach_CTSPRequest request){
        PhongCach_CTSP phongCach_ctsp = new PhongCach_CTSP();
        phongCach_ctsp.setPhongCach(PhongCach.builder().IdPhongCach(request.getIdPhongCach()).build());
        phongCach_ctsp.setChiTietSanPham(ChiTietSanPham.builder().IdCTSP(request.getIdCTSP()).build());
        return repository.save(phongCach_ctsp);
    }
    public void delete(UUID idCTSP){
        List<PhongCach_CTSP> list = repository.getbyCTSP(idCTSP);
        for(PhongCach_CTSP p : list){
             repository.delete(p);
        }

    }
}
