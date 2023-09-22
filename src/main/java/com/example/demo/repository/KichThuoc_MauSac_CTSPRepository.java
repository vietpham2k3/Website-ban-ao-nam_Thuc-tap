package com.example.demo.repository;

import com.example.demo.entity.MauSac_KichThuoc_CTSP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KichThuoc_MauSac_CTSPRepository extends JpaRepository<MauSac_KichThuoc_CTSP, UUID> {
}
