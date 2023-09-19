package com.example.demo.service;

import com.example.demo.entity.HoaDon;
import com.example.demo.repository.HoaDonRepository;
import com.example.demo.response.HoaDonCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonService {
    @Autowired public HoaDonRepository res;

//    public List<HoaDonCustom> getAll(){
//        return res.hienThi();
//    }

    public Page<HoaDon> pageHD(Pageable pageable){
        return res.findAll(pageable);
    }

}
