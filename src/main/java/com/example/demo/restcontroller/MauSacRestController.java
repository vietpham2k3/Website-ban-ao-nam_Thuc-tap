package com.example.demo.restcontroller;

import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.service.MauSacService;
import com.example.demo.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/mausac")
public class MauSacRestController {
    @Autowired
    MauSacService service;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody MauSac mauSac){
        return ResponseEntity.ok(service.add(mauSac));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody MauSac mauSac){
        return ResponseEntity.ok(service.update(id,mauSac));
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getColorById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.getColorByProduct(id));
    }
}
