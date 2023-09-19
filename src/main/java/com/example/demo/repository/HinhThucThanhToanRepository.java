package com.example.demo.repository;

import com.example.demo.entity.HinhThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HinhThucThanhToanRepository extends JpaRepository<HinhThucThanhToan, UUID> {
}
