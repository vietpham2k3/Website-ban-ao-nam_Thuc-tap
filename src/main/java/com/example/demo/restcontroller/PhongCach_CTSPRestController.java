package com.example.demo.restcontroller;

import com.example.demo.entity.PhongCach_CTSP;
import com.example.demo.entity.SanPham;
import com.example.demo.request.PhongCach_CTSPRequest;
import com.example.demo.service.PhongCach_CTSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/phongcach-ctsp")
public class PhongCach_CTSPRestController {
    @Autowired
    PhongCach_CTSPService service;
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody PhongCach_CTSPRequest request){
        return ResponseEntity.ok(service.add(request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")UUID id){
        service.delete(id);
         return ResponseEntity.ok("delete");

    }
}
