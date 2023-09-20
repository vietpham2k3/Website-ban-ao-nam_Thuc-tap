package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "GioHangChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GioHangChiTiet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdGioHangChiTiet")
    private UUID IdGioHangChiTiet;
    @ManyToOne
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;
    @ManyToOne
    @JoinColumn(name = "IdCTSP")
    private ChiTietSanPham chiTietSanPham;
    @Column(name = "DonGia")
    private BigDecimal DonGia;
    @Column(name = "SoLuong")
    private Integer SoLuong;
    @Column(name = "MauSac")
    private Integer MauSac;
    @Column(name = "KichThuoc")
    private Integer KichThuoc;
}
