package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.ChiTietSanPhamRepository;
import com.example.demo.repository.DanhMucRepository;
import com.example.demo.repository.PhanLoaiRepository;
import com.example.demo.repository.SanPhamRepository;
import com.example.demo.repository.ThuongHieuRepository;
import com.example.demo.repository.XuatXuRepository;
import com.example.demo.service.ChiTietSanPhamService;
import com.example.demo.service.KhuyenMaiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/client")
public class CtspController {
    @Autowired
    HttpSession session;
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private DanhMucRepository danhMucRepository;
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;
    @Autowired
    private PhanLoaiRepository phanLoaiRepository;
    @Autowired
    private XuatXuRepository xuatXuRepository;


//    @GetMapping("/getAll")
//    public String getAllCtsp(Model model){
//        model.addAttribute("listCtsp",chiTietSanPhamRepository.findAll());
//        return "client/home";
//    }

    @GetMapping("/{id}")
    public String getOneCtsp(@PathVariable UUID id, Model model) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(id).orElse(null);
        if (chiTietSanPham == null) {
            return "client/home";
        } else {
            KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
            model.addAttribute("idKhachHang",khachHang.getIdKhachHang());
            model.addAttribute("idGioHang",khachHang.getGioHangs().get(0).getIdGioHang());


            DanhMuc danhMuc = danhMucRepository.findById(chiTietSanPham.getDanhMuc().getIdDanhMuc()).orElse(null);
            SanPham sanPham = sanPhamRepository.findById(chiTietSanPham.getSanPham().getIdSanPham()).orElse(null);
            PhanLoai phanLoai = phanLoaiRepository.findById(chiTietSanPham.getPhanLoai().getIdPhanLoai()).orElse(null);
            XuatXu xuatXu = xuatXuRepository.findById(chiTietSanPham.getXuatXu().getIdXuatXu()).orElse(null);
            ThuongHieu thuongHieu = thuongHieuRepository.findById(chiTietSanPham.getThuongHieu().getIdThuongHieu()).orElse(null);

            model.addAttribute("chiTietSanPham",chiTietSanPham);
            model.addAttribute("sanPham",sanPham);
            model.addAttribute("danhMuc",danhMuc);
            model.addAttribute("phanLoai",phanLoai);
            model.addAttribute("thuongHieu",thuongHieu);
            model.addAttribute("xuatXu",xuatXu);

        }

        return "client/detaiLSP";
    }


}
