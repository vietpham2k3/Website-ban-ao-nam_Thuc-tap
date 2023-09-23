package com.example.demo.repository;

import com.example.demo.entity.MauSac_KichThuoc_CTSP;
import com.example.demo.entity.PhongCach_CTSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface KichThuoc_MauSac_CTSPRepository extends JpaRepository<MauSac_KichThuoc_CTSP, UUID> {
    @Query("Select e from MauSac_KichThuoc_CTSP  e  where e.chiTietSanPham.IdCTSP = :id")
    public List<MauSac_KichThuoc_CTSP> getbyCTSP(@Param("id") UUID id);
}
