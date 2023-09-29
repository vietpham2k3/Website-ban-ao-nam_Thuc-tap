package com.example.demo.service;

import com.example.demo.entity.DanhMuc;
import com.example.demo.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class DanhMucService {
    @Autowired
    private DanhMucRepository repository;

    public List<DanhMuc> getAll(){
        return  repository.findAll();
    }

    public Page<DanhMuc> phanTrang(Integer page, Integer size){

        Pageable pageable = PageRequest.of(page,size);

        return repository.findAll(pageable);

    }


    public DanhMuc add(DanhMuc danhMuc){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY); // Giờ hiện tại (24 giờ)
        int minute = cal.get(Calendar.MINUTE);

        DanhMuc dm = DanhMuc.builder()
                .TenDanhMuc(danhMuc.getTenDanhMuc())
                .MoTa(danhMuc.getMoTa())
                .Anh(danhMuc.getAnh())
                .NgayTao(cal.getTime())
                .NgayCapNhat(cal.getTime())
                .NguoiCapNhat(danhMuc.getNguoiCapNhat())
                .TrangThai(danhMuc.getTrangThai())
                .build();
        return repository.save(dm);
    }

    public DanhMuc update(DanhMuc danhMuc){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY); // Giờ hiện tại (24 giờ)
        int minute = cal.get(Calendar.MINUTE);

        DanhMuc dm = repository.findById(danhMuc.getIdDanhMuc()).get();
        dm.setIdDanhMuc(danhMuc.getIdDanhMuc());
        dm.setTenDanhMuc(danhMuc.getTenDanhMuc());
        dm.setMoTa(danhMuc.getMoTa());
        dm.setAnh(danhMuc.getAnh());
        dm.setNgayCapNhat(cal.getTime());
        dm.setNguoiCapNhat("Huỳnh");
        dm.setTrangThai(danhMuc.getTrangThai());

        return repository.save(dm);

    }

    public DanhMuc getOne(Integer id){
        DanhMuc dm = repository.findById(id).get();

        return dm;
    }
    public void delete(DanhMuc dm){
        repository.delete(dm);
    }

}
