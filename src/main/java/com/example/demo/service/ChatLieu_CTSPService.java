package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.ChatLieu_CTSPRepository;
import com.example.demo.repository.PhongCach_CTSPRepository;
import com.example.demo.request.ChatLieu_CTSPRequest;
import com.example.demo.request.PhongCach_CTSPRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatLieu_CTSPService {
    @Autowired
    private ChatLieu_CTSPRepository repository;

    public ChatLieu_CTSP add(ChatLieu_CTSPRequest request){
        ChatLieu_CTSP chatLieu_ctsp = new ChatLieu_CTSP();
        chatLieu_ctsp.setChatLieu(ChatLieu.builder().IdChatLieu(request.getIdChatLieu()).build());
        chatLieu_ctsp.setChiTietSanPham(ChiTietSanPham.builder().IdCTSP(request.getIdCTSP()).build());
        return repository.save(chatLieu_ctsp);
    }
}
