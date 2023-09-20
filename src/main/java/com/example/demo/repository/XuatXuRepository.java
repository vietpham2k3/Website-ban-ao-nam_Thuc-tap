package com.example.demo.repository;

import com.example.demo.entity.ThuongHieu;
import com.example.demo.entity.XuatXu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XuatXuRepository extends JpaRepository<XuatXu,Integer> {

}
