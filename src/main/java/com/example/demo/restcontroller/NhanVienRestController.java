package com.example.demo.restcontroller;
import com.example.demo.request.NhanVienRequest;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/NhanVien")
public class NhanVienRestController {
    @Autowired
    NhanVienService nhanVienService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(nhanVienService.getAll());
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody NhanVienRequest request ){
        return ResponseEntity.ok(nhanVienService.add(request));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id , @RequestBody NhanVienRequest request ){
        return  ResponseEntity.ok(nhanVienService.update( id ,request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id  ){
        return  ResponseEntity.ok(nhanVienService.getById(id));
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        return ResponseEntity.ok(nhanVienService.delete(id));
    }
}
