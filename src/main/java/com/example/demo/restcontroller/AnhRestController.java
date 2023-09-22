package com.example.demo.restcontroller;

import com.example.demo.entity.Anh;
import com.example.demo.request.ImageRequest;
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
    @GetMapping("{id}")
    public ResponseEntity<?> getAnhBySanPham(@PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(service.getAnhbySanPham(id));
    }
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ImageRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
