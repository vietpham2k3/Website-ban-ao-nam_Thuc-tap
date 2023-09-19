package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DanhGia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DanhGia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDanhGia")
    private Integer IdDanhGia;
    @Column(name = "DiemDanhGia")
    private Integer DiemDanhGia;
    @Column(name = "NoiDungDanhGia")
    private String NoiDungDanhGia;
    @Column(name = "Anh")
    private String Anh;
    @Column(name = "NgayDanhGia")
    private Date NgayDanhGia;
    @Column(name = "TrangThai")
    private Integer TrangThai;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdSanPham")
    private SanPham sanPham;

}
