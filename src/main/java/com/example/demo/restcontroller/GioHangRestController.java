package com.example.demo.restcontroller;

import com.example.demo.request.GioHangChiTietRequest;
import com.example.demo.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cart")
public class GioHangRestController {
    @Autowired
    GioHangService service;
    @GetMapping("/{id}")
    public ResponseEntity<?> getCartByCustomer(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.getCartByCustomer(id));
    }
    @GetMapping("/getQuantityByCartDetail/{id}")
    public ResponseEntity<?> getQuantityByCartDetail(@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.getQuantityByCartDetail(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteToCart(@PathVariable("id") UUID id){
        service.deleteToCart(id);
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/deleteAllCart/{id}")
    public ResponseEntity<?> deleteAllCart(@PathVariable("id") UUID id){
        service.deleteAllCart(id);
        return ResponseEntity.ok("ok");
    }
    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody GioHangChiTietRequest cartDetail){
        return ResponseEntity.ok(service.addToCart(cartDetail));
    }
    @PutMapping("/updateCart/{id}")
    public ResponseEntity<?> updateToCart(@RequestBody GioHangChiTietRequest cartDetail,@PathVariable("id") UUID id){
        return ResponseEntity.ok(service.updateToCart(cartDetail,id));
    }
}
