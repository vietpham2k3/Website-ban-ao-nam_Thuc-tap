package com.example.demo.service;

import com.example.demo.entity.LichSuHoaDon;
import com.example.demo.repository.LichSuHoaDonRepository;
import com.example.demo.service.LichSuHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LichSuHoaDonService {
    @Autowired
    private LichSuHoaDonRepository lichSuHoaDonRepository;

    public List<LichSuHoaDon> getAll() {
        return lichSuHoaDonRepository.findAll();
    }

    public LichSuHoaDon detail(UUID id) {
        return lichSuHoaDonRepository.findById(id).orElse(null);
    }

    public List<LichSuHoaDon> findAllLichSuHoaDonById(Integer id) {
        return lichSuHoaDonRepository.findLichSuHoaDonByHoaDonId(id);
    }

    public void createLichSuDonHang(LichSuHoaDon lichSuHoaDon) {
        lichSuHoaDonRepository.save(lichSuHoaDon);
    }

}
