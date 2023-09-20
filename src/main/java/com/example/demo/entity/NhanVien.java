package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NhanVien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdNhanVien")
    private UUID IdNhanVien;
    @Column(name = "MaNhanVien")
    private String MaNhanVien;
    @Column(name = "TenNhanVien")
    private String TenNhanVien;
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
    @Column(name = "Luong")
    private BigDecimal Luong;
    @Column(name = "MatKhau")
    private String MatKhau;
    @Column(name = "NgayTao")
    private Date NgayTao;
    @Column(name = "NgayCapNhat")
    private Date NgayCapNhat;
    @Column(name = "NguoiCapNhat")
    private String NguoiCapNhat;
    @Column(name = "TrangThai")
    private Integer TrangThai;
    @JsonIgnore
    @OneToMany(mappedBy = "nhanVien")
    private List<NhanVien_ChucVu> nhanVien_chucVuList;
    @JsonIgnore
    @OneToMany(mappedBy = "nhanVien")
    private List<HoaDon> hoaDons;
}
