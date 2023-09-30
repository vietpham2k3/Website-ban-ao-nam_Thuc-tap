package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.DanhMuc;
import com.example.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu,Integer> {
    @Query(value = "Select e from ThuongHieu e where e.TrangThai = 0")
    public List<ThuongHieu> getAll();

}
