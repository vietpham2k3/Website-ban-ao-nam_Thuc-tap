package com.example.demo.repository;

import com.example.demo.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {
    @Query(value = "Select e from GioHangChiTiet e where e.gioHang.khachHang.IdKhachHang = :id")
    public List<GioHangChiTiet> getCartByCustomer(@Param("id") UUID id);
    @Query(value = "Select e from GioHangChiTiet  e where e.IdGioHangChiTiet = :id")
    public GioHangChiTiet getById(@Param("id") UUID id);
    @Query(value = "Select e.SoLuong from GioHangChiTiet e where e.IdGioHangChiTiet = :id")
    public Integer getQuantityByCartDetail(@Param("id") UUID id);
}
