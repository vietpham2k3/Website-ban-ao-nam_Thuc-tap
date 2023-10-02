package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.XuatXu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac,Integer> {
    @Query(value = "Select e from MauSac e where e.IdMauSac = :id")
    public MauSac getById(@Param(("id")) Integer id);
    @Query(value = "Select e from MauSac e where e.TrangThai = 0")
    public List<MauSac> getAll();
}
