package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.PhongCach;
import com.example.demo.entity.XuatXu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhongCachRepository extends JpaRepository<PhongCach,Integer> {
    @Query(value = "Select e from PhongCach e where e.TrangThai = 0")
    public List<PhongCach> getAll();

}
