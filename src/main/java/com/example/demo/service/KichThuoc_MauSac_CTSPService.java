package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.KichThuoc_MauSac_CTSPRepository;
import com.example.demo.repository.PhongCach_CTSPRepository;
import com.example.demo.request.KichThuoc_MauSac_CTSPRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KichThuoc_MauSac_CTSPService {
    @Autowired
    private KichThuoc_MauSac_CTSPRepository repository;

    public MauSac_KichThuoc_CTSP add(KichThuoc_MauSac_CTSPRequest request){
        MauSac_KichThuoc_CTSP mauSac_kichThuoc_ctsp = new MauSac_KichThuoc_CTSP();
        mauSac_kichThuoc_ctsp.setKichThuoc(KichThuoc.builder().IdKichThuoc(request.getIdKichThuoc()).build());
        mauSac_kichThuoc_ctsp.setMauSac(MauSac.builder().IdMauSac(request.getIdMauSac()).build());
        mauSac_kichThuoc_ctsp.setChiTietSanPham(ChiTietSanPham.builder().IdCTSP(request.getIdCTSP()).build());
        mauSac_kichThuoc_ctsp.setSoLuong(request.getSoLuong());
        return repository.save(mauSac_kichThuoc_ctsp);
    }
    public void delete(UUID idCTSP){
        List<MauSac_KichThuoc_CTSP> list = repository.getbyCTSP(idCTSP);
        for(MauSac_KichThuoc_CTSP p : list){
            repository.delete(p);
        }

    }
}
