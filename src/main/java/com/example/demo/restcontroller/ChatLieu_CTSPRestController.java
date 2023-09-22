package com.example.demo.restcontroller;

import com.example.demo.request.ChatLieu_CTSPRequest;
import com.example.demo.request.PhongCach_CTSPRequest;
import com.example.demo.service.ChatLieu_CTSPService;
import com.example.demo.service.PhongCach_CTSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/chatlieu-ctsp")
public class ChatLieu_CTSPRestController {
    @Autowired
    ChatLieu_CTSPService service;
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ChatLieu_CTSPRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
