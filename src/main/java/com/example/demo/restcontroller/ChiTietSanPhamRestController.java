package com.example.demo.restcontroller;

import com.example.demo.request.ChiTietSanPhamRequest;
import com.example.demo.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ctsp")
public class ChiTietSanPhamRestController {
    @Autowired
    ChiTietSanPhamService service;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody ChiTietSanPhamRequest chiTietSanPham){
        return ResponseEntity.ok(service.add(chiTietSanPham));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id")UUID id){
        return ResponseEntity.ok(service.getCTSP(id));
    }
    @GetMapping("/get")
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(service.getAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")UUID id){
        return ResponseEntity.ok(service.delete(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody ChiTietSanPhamRequest chiTietSanPham, @PathVariable("id")UUID id){
        return ResponseEntity.ok(service.update(chiTietSanPham,id));
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<?> getAllByProductName(@PathVariable("name") String name){
        return ResponseEntity.ok(service.getAllbyProductName(name));
    }
    @GetMapping("/filter")
    public ResponseEntity<?> getAllByFilter(@RequestParam(name = "idcategory",required = false) Integer IdCategory,
                                            @RequestParam(name = "idmaterial",required = false) Integer IdMaterial,
                                            @RequestParam(name = "idcolor",required = false) Integer IdColor,
                                            @RequestParam(name = "idsize",required = false) Integer IdSize,
                                            @RequestParam(name = "idbrand",required = false) Integer IdBrand,
                                            @RequestParam(name = "idphanloai",required = false) Integer IdPhanLoai,
                                            @RequestParam(name = "idxuatxu",required = false) Integer IdXuatXu,
                                            @RequestParam(name = "idphongcach",required = false) Integer IdPhongCach,
                                            @RequestParam("min") Double min,
                                            @RequestParam("max") Double max){

        return ResponseEntity.ok(service.getAllbyFilter(IdColor,IdSize,IdMaterial,IdCategory,IdBrand,IdPhanLoai,IdXuatXu,IdPhongCach,min,max));
    }

}
