package com.example.demo.service;

import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.entity.GioHang;
import com.example.demo.entity.GioHangChiTiet;
import com.example.demo.repository.GioHangChiTietRepository;
import com.example.demo.request.GioHangChiTietRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class GioHangService {
    @Autowired
    GioHangChiTietRepository repository;

    public List<GioHangChiTiet> getCartByCustomer(UUID Id){
        return repository.getCartByCustomer(Id);
    }
    public void deleteAllCart(UUID Id){
        List<GioHangChiTiet> cartDetails = repository.getCartByCustomer(Id);
        for (GioHangChiTiet cartDetail: cartDetails) {
            repository.delete(cartDetail);
        }
    }
    public GioHangChiTiet addToCart(GioHangChiTietRequest request){
        GioHangChiTiet cartDetail = new GioHangChiTiet();
        cartDetail.setGioHang(GioHang.builder().IdGioHang(request.getIdCart()).build());
        cartDetail.setChiTietSanPham(ChiTietSanPham.builder().IdCTSP(request.getIdProductDetail()).build());
        cartDetail.setMauSac(request.getIdColor());
        cartDetail.setKichThuoc(request.getIdSize());
        cartDetail.setSoLuong(request.getSoLuong());
        cartDetail.setDonGia(request.getDonGia());
        return repository.save(cartDetail);
    }
    public void deleteToCart(UUID Id){
        GioHangChiTiet cartDetail = repository.getById(Id);
        repository.delete(cartDetail);
    }
    public GioHangChiTiet updateToCart(GioHangChiTietRequest request , UUID id){
        GioHangChiTiet cartDetail = repository.getById(id);
        cartDetail.setGioHang(GioHang.builder().IdGioHang(request.getIdCart()).build());
        cartDetail.setChiTietSanPham(ChiTietSanPham.builder().IdCTSP(request.getIdProductDetail()).build());
        cartDetail.setMauSac(request.getIdColor());
        cartDetail.setKichThuoc(request.getIdSize());
        cartDetail.setSoLuong(request.getSoLuong());
        cartDetail.setDonGia(request.getDonGia());
        return repository.save(cartDetail);
    }
    public Integer getQuantityByCartDetail(UUID id){
        return repository.getQuantityByCartDetail(id);
    }



}
