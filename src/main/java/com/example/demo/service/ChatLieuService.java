package com.example.demo.service;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.XuatXu;
import com.example.demo.repository.ChatLieuRepository;
import com.example.demo.repository.XuatXuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuService {
    @Autowired
    private ChatLieuRepository repository;
    public List<ChatLieu> getAll(){
        return  repository.getAll();
    }
}
