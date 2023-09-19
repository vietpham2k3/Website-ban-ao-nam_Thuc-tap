package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChiTietSanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdCTSP")
    private UUID IdCTSP;
    @Column(name = "GiaNhap")
    private BigDecimal GiaNhap;
    @Column(name = "GiaBan")
    private BigDecimal GiaBan;
    @Column(name = "GiamGia")
    private Integer GiamGia;
    @Column(name = "MoTa")
    private String MoTa;
    @Column(name = "NgayTao")
    private Date NgayTao;
    @Column(name = "NgayCapNhat")
    private Date NgayCapNhat;
    @Column(name = "NguoiCapNhat")
    private String NguoiCapNhat;
    @Column(name = "TrangThai")
    private Integer TrangThai;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham sanPham;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdPhanLoai")
    private PhanLoai phanLoai;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdThuongHieu")
    private ThuongHieu thuongHieu;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdXuatXu")
    private XuatXu xuatXu;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdDanhMuc")
    private DanhMuc danhMuc;
    @JsonBackReference
    @OneToMany(mappedBy = "chiTietSanPham")
    private List<MauSac_KichThuoc_CTSP> mauSac_kichThuoc_ctspList;
    @JsonBackReference
    @OneToMany(mappedBy = "chiTietSanPham")
    private List<ChatLieu_CTSP> chatLieu_ctspList;
    @JsonBackReference
    @OneToMany(mappedBy = "chiTietSanPham")
    private List<PhongCach_CTSP> phongCach_ctspList;
    @JsonBackReference
    @OneToMany(mappedBy = "chiTietSanPham")
    private List<GioHangChiTiet> gioHangChiTiets;
    @JsonBackReference
    @OneToMany(mappedBy = "chiTietSanPham")
    private List<HoaDonChiTiet> hoaDonChiTiets;

}
