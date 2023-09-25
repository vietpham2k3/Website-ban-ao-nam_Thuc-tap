package com.example.demo.restcontroller;

import com.example.demo.entity.KichThuoc;
import com.example.demo.service.KichThuocService;
import com.example.demo.service.XuatXuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/kichthuoc")
public class KichThuocRestController {
    @Autowired
    KichThuocService service;
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping()
    public ResponseEntity<?> add(@RequestBody KichThuoc kichThuoc){
        return ResponseEntity.ok(service.add(kichThuoc));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody KichThuoc kichThuoc){
        return ResponseEntity.ok(service.update(id,kichThuoc));
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}
