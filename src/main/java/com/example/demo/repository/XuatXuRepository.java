package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.XuatXu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XuatXuRepository extends JpaRepository<XuatXu,Integer> {
    @Query(value = "Select e from XuatXu e where e.TrangThai = 0")
    public List<XuatXu> getAll();
}
