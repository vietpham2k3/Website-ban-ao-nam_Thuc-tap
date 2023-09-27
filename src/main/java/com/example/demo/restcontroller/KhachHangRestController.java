package com.example.demo.restcontroller;

import com.example.demo.entity.KhachHang;
import com.example.demo.request.KhachHangReques;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/KhachHang")
public class KhachHangRestController {
    @Autowired
    KhachHangService khachHangService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(khachHangService.getAll());
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody KhachHangReques reques ){
        return ResponseEntity.ok(khachHangService.add(reques));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id , @RequestBody KhachHangReques reques ){
        return  ResponseEntity.ok(khachHangService.update( id ,reques));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id  ){
        return  ResponseEntity.ok(khachHangService.getById(id));
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        return ResponseEntity.ok(khachHangService.delete(id));
    }


}
