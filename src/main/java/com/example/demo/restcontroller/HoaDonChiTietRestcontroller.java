package com.example.demo.restcontroller;

import com.example.demo.entity.HoaDonChiTiet;
import com.example.demo.request.HoaDonChiTietRequest;
import com.example.demo.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/hdct")
public class HoaDonChiTietRestcontroller {
    @Autowired
    HoaDonChiTietService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody HoaDonChiTietRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
