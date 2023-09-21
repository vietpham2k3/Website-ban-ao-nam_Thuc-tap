package com.example.demo.repository;

import com.example.demo.entity.HoaDon;
import com.example.demo.response.HoaDonCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

    @Query(value = "SELECT HD.MaHoaDon, KH.TenKhachHang,HD.NgayCapNhat,HD.TongTienKhiGiam," +
            "KM.TenKhuyenMai, HTTT.TenHinhThuc, HD.TrangThai\n" +
            "FROM HoaDon HD JOIN KhachHang KH ON HD.IdKhachHang = KH.IdKhachHang\n" +
            "JOIN KhuyenMai KM ON HD.IdKhuyenMai = KM.IdKhuyenMai \n" +
            "JOIN HinhThucThanhToan HTTT ON HD.IdHTTT = HTTT.IdHTTT", nativeQuery = true)
    public List<HoaDonCustom> hienThi();


    @Query("SELECT HD FROM HoaDon HD " +
            "JOIN HD.khachHang KH " +
            "JOIN HD.khuyenMai KM " +
            "JOIN HD.hinhThucThanhToan HTTT " +
            "WHERE HD.MaHoaDon LIKE CONCAT('%', ?1, '%') " +
            "AND (KH.TenKhachHang IS NULL OR KH.TenKhachHang LIKE CONCAT('%', ?2, '%')) " +
            "AND (HD.TongTienKhiGiam IS NULL OR HD.TongTienKhiGiam = ?3) " +
            "AND (HD.TrangThai IS NULL OR HD.TrangThai = ?4) "+
            "AND (?5 IS NULL OR HD.NgayCapNhat >= ?5) " +
            "AND (?6 IS NULL OR HD.NgayCapNhat <= ?6) " +
            "AND (HTTT.TenHinhThuc IS NULL OR HTTT.TenHinhThuc = ?7)"
    )
    Page<HoaDon> searchHD(@Param("MaHoaDon") String MaHoaDon, @Param("TenKhachHang") String TenKhachHang,
                          @Param("TongTienKhiGiam") BigDecimal TongTienKhiGiam,
                          @Param("TrangThai") Integer TrangThai, @Param("tuNgay") Date tuNgay,
                          @Param("denNgay") Date denNgay, @Param("TenHinhThuc") String TenHinhThuc,
                          Pageable pageable);



}
