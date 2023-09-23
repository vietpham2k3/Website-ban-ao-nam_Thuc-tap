package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhuyenMai;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhuyenMaiService {

    @Autowired
    public KhuyenMaiRepository res;

    public List<KhuyenMai> getAll() {
        return res.findAll();
    }

    public Page<KhuyenMai> getAll(Pageable pageable) {

        return res.findAll(pageable);
    }


    public KhuyenMai add(KhuyenMai km) {
        KhuyenMai km1 = KhuyenMai.builder()
                .MaKhuyenMai(km.getMaKhuyenMai())
                .TenKhuyenMai(km.getTenKhuyenMai())
                .ChietKhau(km.getChietKhau())
                .NgayBatDau(km.getNgayBatDau())
                .NgayKetThuc(km.getNgayKetThuc())
                .NgayTao(km.getNgayTao())
                .NguoiCapNhat(km.getNguoiCapNhat())
                .TrangThai(km.getTrangThai())
                .build();
        return res.save(km1);


    }

    public KhuyenMai getOne(String id){
        Optional<KhuyenMai> optionalKhuyenMai = res.findById(id);
        return optionalKhuyenMai.get();

    }
    public KhuyenMai update(KhuyenMai km, String id) {
        KhuyenMai getOne = res.findById(id).get();

        KhuyenMai km1 = getOne.builder()
                .MaKhuyenMai(km.getMaKhuyenMai())
                .TenKhuyenMai(km.getTenKhuyenMai())
                .ChietKhau(km.getChietKhau())
                .NgayBatDau(km.getNgayBatDau())
                .NgayKetThuc(km.getNgayKetThuc())
                .NgayTao(km.getNgayTao())
                .NguoiCapNhat(km.getNguoiCapNhat())
                .build();

        return km1;
    }

    public void delete(KhuyenMai khuyenMai){
       res.delete(khuyenMai);
    }
}
