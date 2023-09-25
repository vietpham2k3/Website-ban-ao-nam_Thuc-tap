package com.example.demo.service;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.XuatXu;
import com.example.demo.repository.MauSacRepository;
import com.example.demo.repository.XuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MauSacService {
    @Autowired
    private MauSacRepository repository;
    public List<MauSac> getAll(){
        return  repository.findAll();
    }

    public MauSac add(MauSac mauSac){
        return repository.save(mauSac);
    }
    public MauSac delete(Integer Id){
        MauSac mauSac = repository.getById(Id);
        mauSac.setTrangThai(1);
        return repository.save(mauSac);
    }
    public MauSac update(Integer Id, MauSac mauSac){
        MauSac kt = repository.getById(Id);
        kt.setTenMauSac(mauSac.getTenMauSac());
        kt.setMoTa(mauSac.getMoTa());
        kt.setMaMauSac(mauSac.getMaMauSac());

        kt.setNgayCapNhat(new Date());
        return repository.save(kt);
    }
    public MauSac getById(Integer id){
        return repository.getById(id);
    }
}
