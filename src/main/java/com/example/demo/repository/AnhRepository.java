package com.example.demo.repository;

import com.example.demo.entity.Anh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnhRepository extends JpaRepository<Anh, UUID> {

    @Query(value = "Select a from Anh a where a.sanPham.IdSanPham = :id")
    List<Anh> getAnhBySanPham(@Param("id") Integer id);
}
