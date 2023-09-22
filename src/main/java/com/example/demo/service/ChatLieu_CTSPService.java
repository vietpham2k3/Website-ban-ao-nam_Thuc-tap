package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.ChatLieu_CTSPRepository;
import com.example.demo.repository.PhongCach_CTSPRepository;
import com.example.demo.request.ChatLieu_CTSPRequest;
import com.example.demo.request.PhongCach_CTSPRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public void delete(UUID idCTSP){
        List<ChatLieu_CTSP> list = repository.getbyCTSP(idCTSP);
        for(ChatLieu_CTSP p : list){
            repository.delete(p);
        }

    }
}
