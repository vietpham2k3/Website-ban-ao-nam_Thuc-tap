package com.example.demo.restcontroller;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.SanPham;
import com.example.demo.request.ChiTietSanPhamRequest;
import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ctsp")
public class ChiTietSanPhamRestController {
    @Autowired
    ChiTietSanPhamService service;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ChiTietSanPhamRequest chiTietSanPham){
        return ResponseEntity.ok(service.add(chiTietSanPham));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id")UUID id){
        return ResponseEntity.ok(service.getCTSP(id));
    }
    @GetMapping("/get")
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(service.getAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")UUID id){
        return ResponseEntity.ok(service.delete(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody ChiTietSanPhamRequest chiTietSanPham,@PathVariable("id")UUID id){
        return ResponseEntity.ok(service.update(chiTietSanPham,id));
    }
}
