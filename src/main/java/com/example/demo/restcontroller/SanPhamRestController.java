package com.example.demo.restcontroller;

import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sanpham")
public class SanPhamRestController {
    @Autowired
    private ChiTietSanPhamService service;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/phantrang")
    public ResponseEntity<?> phantrang(@RequestParam(value = "page", defaultValue = "0") Integer page){
        return ResponseEntity.ok(service.phanTrang(page));
    }
}
