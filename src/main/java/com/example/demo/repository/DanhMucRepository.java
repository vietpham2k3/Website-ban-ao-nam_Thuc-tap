package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {
    @Query(value = "Select e from DanhMuc e where e.TrangThai = 0")
    public List<DanhMuc> getAll();

}
