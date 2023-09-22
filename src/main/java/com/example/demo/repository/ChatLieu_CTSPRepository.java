package com.example.demo.repository;

import com.example.demo.entity.ChatLieu_CTSP;
import com.example.demo.entity.PhongCach_CTSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatLieu_CTSPRepository extends JpaRepository<ChatLieu_CTSP, UUID> {
}
