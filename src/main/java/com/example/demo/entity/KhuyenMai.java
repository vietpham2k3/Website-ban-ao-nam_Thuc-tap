package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "KhuyenMai")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KhuyenMai implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "IdKhuyenMai")
    private UUID IdKhuyenMai;

    @Column(name = "MaKhuyenMai")
    private String MaKhuyenMai;

    @Column(name = "TenKhuyenMai")
    private String TenKhuyenMai;

    @Column(name = "ChietKhau")
    private Integer ChietKhau;

    @Column(name = "NgayBatDau")
    private Date NgayBatDau;

    @Column(name = "NgayKetThuc")
    private Date NgayKetThuc;

    @Column(name = "NgayTao")
    private Date NgayTao;

    @Column(name = "NgayCapNhat")
    private Date NgayCapNhat;

    @Column(name = "NguoiCapNhat")
    private String NguoiCapNhat;

    @Column(name = "TrangThai")
    private Integer TrangThai;

    @JsonBackReference
    @OneToMany(mappedBy = "khuyenMai")
    private List<HoaDon> hoaDons;
}
