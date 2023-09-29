package com.example.demo.service;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY); // Giờ hiện tại (24 giờ)
        int minute = cal.get(Calendar.MINUTE);

        KhuyenMai km1 = KhuyenMai.builder()
                .MaKhuyenMai(km.getMaKhuyenMai())
                .TenKhuyenMai(km.getTenKhuyenMai())
                .ChietKhau(km.getChietKhau())
                .NgayBatDau(km.getNgayBatDau())
                .NgayKetThuc(km.getNgayKetThuc())
                .NgayTao(cal.getTime())
                .NguoiCapNhat(km.getNguoiCapNhat())
                .TrangThai(km.getTrangThai())
                .build();
        return res.save(km1);


    }

    public KhuyenMai getOne(String id){
        Optional<KhuyenMai> optionalKhuyenMai = res.findById(id);
        return optionalKhuyenMai.get();

    }
    public KhuyenMai update(KhuyenMai km) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY); // Giờ hiện tại (24 giờ)
        int minute = cal.get(Calendar.MINUTE);

        KhuyenMai khuyenMai = res.getOne(km.getIdKhuyenMai());
        khuyenMai.setMaKhuyenMai(km.getMaKhuyenMai());
        khuyenMai.setTenKhuyenMai(km.getTenKhuyenMai());
        khuyenMai.setChietKhau(km.getChietKhau());
        khuyenMai.setNgayBatDau(km.getNgayBatDau());
        khuyenMai.setNgayKetThuc(km.getNgayKetThuc());
        khuyenMai.setNgayTao(cal.getTime());
        khuyenMai.setNguoiCapNhat(km.getNguoiCapNhat());
        khuyenMai.setTrangThai(km.getTrangThai());

        return res.save(khuyenMai);
    }

    public void delete(KhuyenMai khuyenMai){
       res.delete(khuyenMai);
    }
}
