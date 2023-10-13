package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID>  {
    @Query(value = "select e from KhachHang e where e.IdKhachHang = :id ")
    public KhachHang getById(@Param("id")UUID id);

    @Query(value = "SELECT * FROM KhachHang Where TaiKhoan= :TaiKhoan AND MatKhau= :MatKhau", nativeQuery = true)
    public KhachHang findByTaiKhoanAndMatKhau(@Param("TaiKhoan") String taiKhoan,@Param("MatKhau") String matKhau);
}
