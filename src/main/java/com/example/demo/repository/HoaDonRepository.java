package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import com.example.demo.response.HoaDonCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

    @Query(value = "SELECT HD.IdHoaDon, KH.TenKhachHang,HD.NgayCapNhat,HD.TongTienKhiGiam," +
            "KM.TenKhuyenMai, HTTT.TenHinhThuc, HD.TrangThai\n" +
            "FROM HoaDon HD JOIN KhachHang KH ON HD.IdKhachHang = KH.IdKhachHang\n" +
            "JOIN KhuyenMai KM ON HD.IdKhuyenMai = KM.IdKhuyenMai \n" +
            "JOIN HinhThucThanhToan HTTT ON HD.IdHTTT = HTTT.IdHTTT", nativeQuery = true)
    public List<HoaDonCustom> hienThi();


}
