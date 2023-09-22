package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.ChatLieu_CTSP;
import com.example.demo.entity.PhongCach_CTSP;
import com.example.demo.entity.XuatXu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu,Integer> {

}
