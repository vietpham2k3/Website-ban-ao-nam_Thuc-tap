package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DanhMuc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DanhMuc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdDanhMuc")
    private Integer IdDanhMuc;
    @Column(name = "TenDanhMuc")
    private String TenDanhMuc;
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
}
