package com.example.demo.repository;

import com.example.demo.entity.ChatLieu_CTSP;
import com.example.demo.entity.PhongCach_CTSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatLieu_CTSPRepository extends JpaRepository<ChatLieu_CTSP, UUID> {
    @Query("Select e from ChatLieu_CTSP  e  where e.chiTietSanPham.IdCTSP = :id")
    public List<ChatLieu_CTSP> getbyCTSP(@Param("id") UUID id);
}
