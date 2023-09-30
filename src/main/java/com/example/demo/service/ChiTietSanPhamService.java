package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.DanhMucRepository;
import com.example.demo.request.ChiTietSanPhamRequest;
import com.example.demo.response.ChiTietSanPhamCustom;
import com.example.demo.repository.ChiTietSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamService {
    @Autowired
    private ChiTietSanPhamRepository repository;
    @Autowired
    private DanhMucRepository danhMucRepository;


    public List<ChiTietSanPham> getAll(){
        return repository.getAllCTSP();
    }public List<ChiTietSanPham> getAll1(){
        return repository.findAll();
    }


    public Page<ChiTietSanPham> phanTrang(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return repository.findAll(pageable);
    }
    public ChiTietSanPham add(ChiTietSanPhamRequest request){
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        chiTietSanPham.setGiaBan(request.getGiaBan());
        chiTietSanPham.setGiaNhap(request.getGiaNhap());
        chiTietSanPham.setPhanLoai(PhanLoai.builder().IdPhanLoai(request.getIdPhanLoai()).build());
        chiTietSanPham.setThuongHieu(ThuongHieu.builder().IdThuongHieu(request.getIdThuongHieu()).build());
        DanhMuc danhMuc = danhMucRepository.findById(request.getIdDanhMuc()).get();
        chiTietSanPham.setDanhMuc(danhMuc);
        chiTietSanPham.setXuatXu(XuatXu.builder().IdXuatXu(request.getIdXuatXu()).build());
        chiTietSanPham.setMoTa(request.getMoTa());
        chiTietSanPham.setGiamGia(request.getGiamGia());
        chiTietSanPham.setSanPham(SanPham.builder().IdSanPham(request.getIdSanPham()).build());
        chiTietSanPham.setTrangThai(0);
        return repository.save(chiTietSanPham);
    }
    public ChiTietSanPhamCustom getById(Integer id){
        return repository.getByid(id);
    }
    public ChiTietSanPham getCTSP(UUID id){
        return repository.getCTSP(id);
    }
    public ChiTietSanPham delete(UUID id){
        ChiTietSanPham chiTietSanPham = repository.getById(id);
        chiTietSanPham.setTrangThai(1);
        return repository.save(chiTietSanPham);
    }
    public ChiTietSanPham update(ChiTietSanPhamRequest request, UUID id){
        ChiTietSanPham chiTietSanPham = repository.getReferenceById(id);
        chiTietSanPham.setGiaBan(request.getGiaBan());
        chiTietSanPham.setGiaNhap(request.getGiaNhap());

        chiTietSanPham.setDanhMuc(DanhMuc.builder().IdDanhMuc(request.getIdDanhMuc()).build());
        chiTietSanPham.setPhanLoai(PhanLoai.builder().IdPhanLoai(request.getIdPhanLoai()).build());
        chiTietSanPham.setThuongHieu(ThuongHieu.builder().IdThuongHieu(request.getIdThuongHieu()).build());
        chiTietSanPham.setXuatXu(XuatXu.builder().IdXuatXu(request.getIdXuatXu()).build());
        chiTietSanPham.setMoTa(request.getMoTa());
        chiTietSanPham.setGiamGia(request.getGiamGia());
        return repository.saveAndFlush(chiTietSanPham);
    }
    public List<ChiTietSanPham> getAllbyProductName(String name){
        return repository.getByName('%'+name+'%');
    }
    public List<ChiTietSanPham> getAllbyFilter(Integer IdColor,Integer IdSize,Integer IdMaterial,Integer IdCategory, Integer IdBrand , Integer IdPhanLoai, Integer IdXuatXu,Integer IdPhongCach,Double min , Double max){
        return repository.getAllByFilter(IdColor,IdSize,IdMaterial,IdCategory,IdBrand,IdPhanLoai,IdXuatXu,IdPhongCach,min,max);
    }


}
