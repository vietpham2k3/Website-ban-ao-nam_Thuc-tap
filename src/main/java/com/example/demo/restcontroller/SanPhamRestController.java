package com.example.demo.restcontroller;

import com.example.demo.entity.SanPham;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sanpham")
public class SanPhamRestController {
    @Autowired
    private ChiTietSanPhamService service;

    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/phantrang")
    public ResponseEntity<?> phantrang(@RequestParam(value = "page", defaultValue = "0") Integer page){
        return ResponseEntity.ok(service.phanTrang(page));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getbyid(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody SanPham sanPham){
        return ResponseEntity.ok(sanPhamService.add(sanPham));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody SanPham sanPham){
        return ResponseEntity.ok(sanPhamService.update(sanPham,id));
    }
}
