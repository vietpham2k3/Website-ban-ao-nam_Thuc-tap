package com.example.demo.restcontroller;

import com.example.demo.request.HoaDonRequest;
import com.example.demo.response.HoaDonCustom;
import com.example.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonResController {
    @Autowired public HoaDonService service;

//    @GetMapping("")
//    public ResponseEntity<?> hienThi(){
//        return ResponseEntity.ok(service.getAll());
//    }

    @PostMapping
        public ResponseEntity<?> add(@RequestBody HoaDonRequest request){
        return ResponseEntity.ok(service.add(request));
    }
}
