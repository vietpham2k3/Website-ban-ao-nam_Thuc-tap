package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSanPham")
    private Integer IdSanPham;
    @Column(name = "MaSanPham")
    private String MaSanPham;
    @Column(name = "TenSanPham")
    private String TenSanPham;
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
    @JsonIgnore
    @OneToMany(mappedBy = "sanPham")
    private Set<DanhGia> danhGias;
    @OneToMany(mappedBy = "sanPham")
    private Set<Anh> anhs = new HashSet<Anh>();
    @JsonIgnore
    @OneToMany(mappedBy = "sanPham")
    private Set<ChiTietSanPham> chiTietSanPhams;
}
