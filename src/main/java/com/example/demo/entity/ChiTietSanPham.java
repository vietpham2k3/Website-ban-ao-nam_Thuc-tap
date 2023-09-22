package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

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
    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "IdPhanLoai")
    private PhanLoai phanLoai;
    @ManyToOne
    @JoinColumn(name = "IdThuongHieu")
    private ThuongHieu thuongHieu;
    @ManyToOne
    @JoinColumn(name = "IdXuatXu")
    private XuatXu xuatXu;
    @ManyToOne
    @JoinColumn(name = "IdDanhMuc")
    private DanhMuc danhMuc;
    @OneToMany(mappedBy = "chiTietSanPham")
    private Set<MauSac_KichThuoc_CTSP> mauSac_kichThuoc_ctspList = new HashSet<MauSac_KichThuoc_CTSP>();
    @OneToMany(mappedBy = "chiTietSanPham")
    private Set<ChatLieu_CTSP> chatLieu_ctspList = new HashSet<ChatLieu_CTSP>();
    @OneToMany(mappedBy = "chiTietSanPham")
    private Set<PhongCach_CTSP> phongCach_ctspList = new HashSet<PhongCach_CTSP>();
    @JsonIgnore
    @OneToMany(mappedBy = "chiTietSanPham")
    private List<GioHangChiTiet> gioHangChiTiets;
    @JsonIgnore
    @OneToMany(mappedBy = "chiTietSanPham")
    private List<HoaDonChiTiet> hoaDonChiTiets;

}
