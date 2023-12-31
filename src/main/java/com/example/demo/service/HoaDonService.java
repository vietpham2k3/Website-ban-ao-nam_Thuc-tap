package com.example.demo.service;

import com.example.demo.entity.DiaChiGiaoHang;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.KhachHang;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.request.HoaDonRequest;
import com.example.demo.response.HoaDonCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class HoaDonService {
    @Autowired public HoaDonRepository res;

//    public List<HoaDonCustom> getAll(){
//        return res.hienThi();
//    }

    public HoaDon detail(Integer id){
        return res.findById(id).orElse(null);
    }

    public Page<HoaDon> pageHD(Pageable pageable){
        return res.findAll(pageable);
    }

    public List<HoaDon> getExcel() {
        return res.findAll();
    }

    public Page<HoaDon> searchHD(String MaHoaDon, String TenKhachHang, BigDecimal TongTienKhiGiam, Integer TrangThai,
                                 Date tuNgay, Date denNgay, String TenHinhThuc, Pageable pageable){
        Page<HoaDon> result = res.searchHD(MaHoaDon, TenKhachHang, TongTienKhiGiam, TrangThai, tuNgay,denNgay, TenHinhThuc, pageable);

        System.out.println(result);

        return result;
    }
    public String genCode(){
        // Tạo đối tượng Random
        String code = "HD";
        Random random = new Random();
        for (int i = 0 ; i < 9 ; i++){
            Integer so = random.nextInt(9);
            code  += String.valueOf(so);
        }
        return code;
    }
    public HoaDon add(HoaDonRequest request){
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMaHoaDon(genCode());
        hoaDon.setNgayCapNhat(new Date());
        hoaDon.setTongTien(request.getTongTien());
        hoaDon.setPhiShip(request.getPhiShip());
        hoaDon.setTongTienKhiGiam(request.getTongTienKhiGiam());
        hoaDon.setGhiChu(request.getGhiChu());
        hoaDon.setKhachHang(KhachHang.builder().IdKhachHang(request.getIdKhachHang()).build());
        hoaDon.setDiaChiGiaoHang(DiaChiGiaoHang.builder().IdDiaChi(request.getIdDiaChi()).build());
        hoaDon.setTrangThai(request.getTrangThai());
        return res.save(hoaDon);
    }

}
