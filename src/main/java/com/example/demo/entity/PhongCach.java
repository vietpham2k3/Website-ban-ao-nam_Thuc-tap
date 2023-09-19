package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "KichThuoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KichThuoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdKichThuoc")
    private Integer IdKichThuoc;
    @Column(name = "TenKichThuoc")
    private String TenKichThuoc;
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
