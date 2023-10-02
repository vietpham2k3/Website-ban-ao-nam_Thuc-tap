package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.PhanLoai;
import com.example.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhanLoaiRepository extends JpaRepository<PhanLoai,Integer> {
    @Query(value = "Select e from PhanLoai e where e.TrangThai = 0")
    public List<PhanLoai> getAll();
}
