package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PhanLoai")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhanLoai implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPhanLoai")
    private Integer IdPhanLoai;
    @Column(name = "TenPhanLoai")
    private String TenPhanLoai;
    @Column(name = "MoTa")
    private String MoTa;
    @Column(name = "Anh")
    private String Anh;
    @Column(name = "NgayTao")
    private Date NgayTao;
    @Column(name = "NgayCapNhat")
    private Date NgayCapNhat;
    @Column(name = "NguoiCapNhat")
    private String NguoiCapNhat;
    @Column(name = "TrangThai")
    private Integer TrangThai;
    @JsonBackReference
    @OneToMany(mappedBy = "phanLoai")
    private List<ChiTietSanPham> chiTietSanPhams;
}
