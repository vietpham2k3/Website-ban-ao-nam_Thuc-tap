package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DiaChiGiaoHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaChiGiaoHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdDiaChi")
    private UUID IdDiaChi;
    @Column(name = "TenNguoiNhan")
    private String TenNguoiNhan;
    @Column(name = "SdtNhan")
    private String SdtNhan;
    @Column(name = "TinhThanh")
    private String TinhThanh;
    @Column(name = "QuanHuyen")
    private String QuanHuyen;
    @Column(name = "PhuongXa")
    private String PhuongXa;
    @Column(name = "GhiChu")
    private String GhiChu;
    @Column(name = "TrangThai")
    private Integer TrangThai;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;
    @JsonBackReference
    @OneToMany(mappedBy = "diaChiGiaoHang")
    private List<HoaDon> hoaDons;


}
