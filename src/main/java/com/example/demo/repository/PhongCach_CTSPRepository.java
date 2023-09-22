package com.example.demo.repository;

import com.example.demo.entity.PhongCach_CTSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PhongCach_CTSPRepository extends JpaRepository<PhongCach_CTSP, UUID> {

    @Query("Select e from PhongCach_CTSP  e  where e.chiTietSanPham.IdCTSP = :id")
    public PhongCach_CTSP getbyCTSP(@Param("id") UUID id);
}
