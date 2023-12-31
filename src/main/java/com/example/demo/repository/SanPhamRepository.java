package com.example.demo.repository;

import com.example.demo.entity.Anh;
import com.example.demo.entity.SanPham;
import com.example.demo.response.SanPhamCustom;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    @Query("SELECT DISTINCT s FROM SanPham s JOIN FETCH s.chiTietSanPhams JOIN FETCH s.danhGias")
    List<SanPham> getAll();
    @Query(value = "Select e from SanPham e where e.TrangThai = 0 and e.TenSanPham like :name")
    List<SanPham> searchByName(@Param("name") String name);


}
