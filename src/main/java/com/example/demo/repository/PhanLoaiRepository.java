package com.example.demo.repository;

import com.example.demo.entity.PhanLoai;
import com.example.demo.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanLoaiRepository extends JpaRepository<PhanLoai,Integer> {

}
