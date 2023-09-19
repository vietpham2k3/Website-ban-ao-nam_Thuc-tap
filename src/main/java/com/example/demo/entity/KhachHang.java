package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KhachHang implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdKhachHang")
    private UUID IdKhachHang;
    @Column(name = "TaiKhoan")
    private String TaiKhoan;
    @Column(name = "MatKhau")
    private String MatKhau;
    @Column(name = "TenKhachHang")
    private String TenKhachHang;
    @Column(name = "Anh")
    private String Anh;
    @Column(name = "GioiTinh")
    private Boolean GioiTinh;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Sdt")
    private String Sdt;
    @Column(name = "DiaChi")
    private String DiaChi;
    @Column(name = "NgayTao")
    private Date NgayTao;
    @Column(name = "NgayCapNhat")
    private Date NgayCapNhat;
    @Column(name = "NguoiCapNhat")
    private String NguoiCapNhat;
    @Column(name = "TrangThai")
    private Integer TrangThai;
    @JsonBackReference
    @OneToMany(mappedBy = "khachHang")
    private List<DanhGia> danhGias;
    @JsonBackReference
    @OneToMany(mappedBy = "khachHang")
    private List<DiaChiGiaoHang> diaChiGiaoHangs;
    @JsonBackReference
    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> hoaDons;
}
