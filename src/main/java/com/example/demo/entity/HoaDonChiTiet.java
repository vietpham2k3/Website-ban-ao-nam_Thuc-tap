package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HoaDonChiTiet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdHoaDonChiTiet")
    private UUID IdHoaDonChiTiet;
    @ManyToOne
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;
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
