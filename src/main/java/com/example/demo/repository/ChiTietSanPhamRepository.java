package com.example.demo.repository;

import com.example.demo.response.ChiTietSanPhamCustom;
import com.example.demo.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {

    @Query(value = "Select ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai from ChiTietSanPham ctsp\n" +
            "            join SanPham sp on sp.IdSanPham = ctsp.IdSanPham\n" +
            "            join Anh a on a.IdSanPham = sp.IdSanPham\n" +
            "            join DanhMuc dm on dm.IdDanhMuc = ctsp.IdDanhMuc\n" +
            "            join ThuongHieu th on th.IdThuongHieu = ctsp.IdThuongHieu where sp.TrangThai = 0\n" +
            "\t\t\tGroup by ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai", nativeQuery = true)
    public List<ChiTietSanPhamCustom> getAll();
    @Query(value = "Select ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai from ChiTietSanPham ctsp\n" +
            "            join SanPham sp on sp.IdSanPham = ctsp.IdSanPham\n" +
            "            join Anh a on a.IdSanPham = sp.IdSanPham\n" +
            "            join DanhMuc dm on dm.IdDanhMuc = ctsp.IdDanhMuc\n" +
            "            join ThuongHieu th on th.IdThuongHieu = ctsp.IdThuongHieu where sp.TrangThai = 0\n" +
            "\t\t\tGroup by ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai", nativeQuery = true)
    public Page<ChiTietSanPhamCustom> phanTrang(Pageable pageable);
    @Query(value = "Select ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai from ChiTietSanPham ctsp\n" +
            "join SanPham sp on sp.IdSanPham = ctsp.IdSanPham\n" +
            "join Anh a on a.IdSanPham = sp.IdSanPham\n" +
            "join DanhMuc dm on dm.IdDanhMuc = ctsp.IdDanhMuc\n" +
            "join ThuongHieu th on th.IdThuongHieu = ctsp.IdThuongHieu where sp.TrangThai = 0 and ctsp.IdCTSP = :id", nativeQuery = true)
    public ChiTietSanPhamCustom getByid(@Param("id") Integer id);

    @Query(value = "Select e from ChiTietSanPham e where  e.IdCTSP = :id")
    public ChiTietSanPham getCTSP(@Param("id") UUID id);
}
