package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienRespository extends JpaRepository<NhanVien, UUID> {
    @Query(value = "select e from NhanVien e where e.IdNhanVien = :id ")
    public NhanVien getById(@Param("id")UUID id);

    @Query(value = "select e from NhanVien e where e.TrangThai = 0")
    public List<NhanVien> getAll();

    @Query(value = "SELECT * FROM NhanVien Where MaNhanVien= :MaNhanVien AND MatKhau= :MatKhau", nativeQuery = true)
    public NhanVien findByMaNhanVienAndMatKhau(@Param("MaNhanVien") String MaNhanVien,
                                               @Param("MatKhau") String MatKhau);

}
