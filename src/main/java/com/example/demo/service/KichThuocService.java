package com.example.demo.service;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.XuatXu;
import com.example.demo.repository.KichThuocRepository;
import com.example.demo.repository.XuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KichThuocService {
    @Autowired
    private KichThuocRepository repository;
    public List<KichThuoc> getAll(){
        return  repository.getAll();
    }
    public KichThuoc add(KichThuoc kichThuoc){
        return repository.save(kichThuoc);
    }
    public KichThuoc delete(Integer Id){
        KichThuoc kichThuoc = repository.getById(Id);
        kichThuoc.setTrangThai(1);
        return repository.save(kichThuoc);
    }
    public KichThuoc update(Integer Id, KichThuoc kichThuoc){
        KichThuoc kt = repository.getById(Id);
        kt.setTenKichThuoc(kichThuoc.getTenKichThuoc());
        kt.setMoTa(kichThuoc.getMoTa());
        kt.setNgayCapNhat(new Date());
        return repository.save(kt);
    }
    public KichThuoc getById(Integer id){
        return repository.getById(id);
    }
}
