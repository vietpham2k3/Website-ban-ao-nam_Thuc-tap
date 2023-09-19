package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "MauSac")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MauSac implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdMauSac")
    private Integer IdMauSac;
    @Column(name = "MaMauSac")
    private String MaMauSac;
    @Column(name = "TenMauSac")
    private String TenMauSac;
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
}
