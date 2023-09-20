package com.example.demo.restcontroller;

import com.example.demo.entity.Anh;
import com.example.demo.service.AnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/anh")
public class AnhRestController {
    @Autowired
    AnhService service;
    @GetMapping
    public ResponseEntity<?> getAllBySanPham(@RequestParam("idsp") Integer id){
        return ResponseEntity.ok(service.getAllbySanPham(id));
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Anh anh){
        return ResponseEntity.ok(service.add(anh));
    }
}
