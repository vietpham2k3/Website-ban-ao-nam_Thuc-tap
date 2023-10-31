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
    @GetMapping("/getQuantityProductAndColorAndSize")
    public ResponseEntity<?> getQuantityProductAndColorAndSize(@RequestParam("IdProduct") UUID IdProduct,@RequestParam("IdColor") Integer IdColor,@RequestParam("IdSize") Integer IdSize){
        return ResponseEntity.ok(service.getQuantityByProductAndColorAndSize(IdProduct,IdColor,IdSize));
    }
    @PutMapping("/updateQuantity")
    public ResponseEntity<?> updateQuantity(@RequestParam("IdProduct") UUID IdProduct, @RequestParam("IdColor") Integer IdColor, @RequestParam("IdSize") Integer IdSize, @RequestParam("Quantity") Integer Quanity){
        return ResponseEntity.ok(service.updateQuantity(IdProduct,IdColor,IdSize,Quanity));
    }
    @GetMapping("/getbycolor")
    public ResponseEntity<?> getByColor(@RequestParam("IdProduct") UUID IdProduct , @RequestParam("IdColor") Integer IdColor){
        return ResponseEntity.ok(service.getAllByIdProductAndIdColor(IdProduct,IdColor));
    }
    @GetMapping("/getQuantityProduct")
    public ResponseEntity<?> getQuantityProduct(@RequestParam("IdProduct") UUID IdProduct){
        return ResponseEntity.ok(service.getQuantityByProduct(IdProduct));
    }
    @GetMapping("/getQuantityProductAndColor")
    public ResponseEntity<?> getQuantityProductAndColor(@RequestParam("IdProduct") UUID IdProduct,@RequestParam("IdColor") Integer IdColor){
        return ResponseEntity.ok(service.getQuantityByProductAndColor(IdProduct,IdColor));
    }

}
