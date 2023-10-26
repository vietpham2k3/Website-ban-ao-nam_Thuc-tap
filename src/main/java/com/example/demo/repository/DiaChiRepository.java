package com.example.demo.repository;

import com.example.demo.entity.DiaChiGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiaChiRepository extends JpaRepository<DiaChiGiaoHang, UUID> {

    @Query(value = "select e from DiaChiGiaoHang e where e.khachHang.IdKhachHang = :id")
    public List<DiaChiGiaoHang> getDiaChiByKhachHang(@Param("id") UUID id);
}
