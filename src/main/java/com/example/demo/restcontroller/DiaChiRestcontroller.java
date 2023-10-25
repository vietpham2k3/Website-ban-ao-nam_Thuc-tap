package com.example.demo.restcontroller;

import com.example.demo.request.DiaChiRequest;
import com.example.demo.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/diachi")
public class DiaChiRestcontroller {
    @Autowired
    DiaChiService service;
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllByKhachHang(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.getAllbyKhachHang(id));
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody DiaChiRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
