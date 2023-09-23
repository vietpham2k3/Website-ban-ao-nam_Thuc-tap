package com.example.demo.restcontroller;

import com.example.demo.entity.MauSac_KichThuoc_CTSP;
import com.example.demo.entity.PhongCach_CTSP;
import com.example.demo.repository.KichThuoc_MauSac_CTSPRepository;
import com.example.demo.request.KichThuoc_MauSac_CTSPRequest;
import com.example.demo.service.KichThuoc_MauSac_CTSPService;
import com.example.demo.service.PhongCach_CTSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/kichthuoc-mausac-ctsp")
public class KichThuoc_MauSac_CTSPRestController {
    @Autowired
    KichThuoc_MauSac_CTSPService service;
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody KichThuoc_MauSac_CTSPRequest request){
        return ResponseEntity.ok(service.add(request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        service.delete(id);
        return ResponseEntity.ok("delete");

    }
}
