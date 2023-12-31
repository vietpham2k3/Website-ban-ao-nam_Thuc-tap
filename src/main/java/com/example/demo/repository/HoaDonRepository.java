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
//            "JOIN HD.khuyenMai KM " +
            "JOIN HD.hinhThucThanhToan HTTT " +
            "WHERE (:MaHoaDon IS NULL OR HD.MaHoaDon LIKE CONCAT('%', :MaHoaDon , '%')) " +
            "AND (:TenKhachHang IS NULL OR KH.TenKhachHang LIKE CONCAT('%', :TenKhachHang , '%')) " +
            "AND (:TongTienKhiGiam IS NULL OR HD.TongTienKhiGiam = :TongTienKhiGiam ) " +
            "AND (:TrangThai IS NULL OR HD.TrangThai = :TrangThai ) "+
            "AND (:tuNgay IS NULL OR HD.NgayCapNhat >= :tuNgay ) " +
            "AND (:denNgay IS NULL OR HD.NgayCapNhat <= :denNgay ) " +
            "AND (:TenHinhThuc IS NULL OR HTTT.TenHinhThuc LIKE CONCAT('%', :TenHinhThuc , '%') )" )
    Page<HoaDon> searchHD(@Param("MaHoaDon") String MaHoaDon, @Param("TenKhachHang") String TenKhachHang,
                          @Param("TongTienKhiGiam") BigDecimal TongTienKhiGiam,
                          @Param("TrangThai") Integer TrangThai, @Param("tuNgay") Date tuNgay,
                          @Param("denNgay") Date denNgay, @Param("TenHinhThuc") String TenHinhThuc,
                          Pageable pageable);


    @Query(value = "SELECT HD.MaHoaDon, KH.TenKhachHang,HD.NgayCapNhat,HD.TongTienKhiGiam," +
            "KM.TenKhuyenMai, HTTT.TenHinhThuc, HD.TrangThai\n" +
            "FROM HoaDon HD JOIN KhachHang KH ON HD.IdKhachHang = KH.IdKhachHang\n" +
            "JOIN KhuyenMai KM ON HD.IdKhuyenMai = KM.IdKhuyenMai \n" +
            "JOIN HinhThucThanhToan HTTT ON HD.IdHTTT = HTTT.IdHTTT", nativeQuery = true)
    public List<HoaDon> hienThiDetail();

    @Query (value = "SELECT COUNT(*) AS HOADON" +
            " FROM HoaDon WHERE TrangThai = 0",nativeQuery = true)
    public Integer soDonChoXacNhan();

    @Query (value = "SELECT COUNT(*) AS HOADON" +
            " FROM HoaDon WHERE TrangThai = 2",nativeQuery = true)
    public Integer soDonDaHuy();

    @Query (value = "SELECT COUNT(*) AS HOADON" +
            " FROM HoaDon WHERE TrangThai = 4",nativeQuery = true)
    public Integer soDonDangGiao();

    @Query (value = "SELECT COUNT(*) AS HOADON" +
            " FROM HoaDon WHERE TrangThai = 7",nativeQuery = true)
    public Integer soDonDaBan();

    ///
    @Query (value = "SELECT SUM(TongTienKhiGiam) AS HOADON FROM HoaDon WHERE TrangThai = 7 \n" +
            "AND DAY(NgayCapNhat) = DAY(GETDATE())\n" +
            "AND MONTH(NgayCapNhat) = MONTH(GETDATE())\n" +
            "  AND YEAR(NgayCapNhat) = YEAR(GETDATE());",nativeQuery = true)
    public Double doanhThuTongNgay();

    @Query (value = "SELECT SUM(TongTienKhiGiam) AS HOADON FROM HoaDon WHERE TrangThai = 7 \n" +
            "AND MONTH(NgayCapNhat) = MONTH(GETDATE())\n" +
            "  AND YEAR(NgayCapNhat) = YEAR(GETDATE());",nativeQuery = true)
    public Double doanhThuTongThang();

    @Query (value = "SELECT SUM(TongTienKhiGiam) AS HOADON FROM HoaDon WHERE TrangThai = 7 \n" +
            "AND DAY(NgayCapNhat) = DAY(GETDATE()) - 1\n" +
            "AND MONTH(NgayCapNhat) = MONTH(GETDATE())\n" +
            "  AND YEAR(NgayCapNhat) = YEAR(GETDATE());",nativeQuery = true)
    public Double doanhThuHomQua();

    @Query (value = "SELECT SUM(TongTienKhiGiam) AS HOADON FROM HoaDon WHERE TrangThai = 7 \n" +
            "  AND YEAR(NgayCapNhat) = YEAR(GETDATE());",nativeQuery = true)
    public Double doanhThuTongNam();
}
