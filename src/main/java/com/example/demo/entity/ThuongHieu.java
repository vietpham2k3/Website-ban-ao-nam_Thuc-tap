package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ThuongHieu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThuongHieu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdThuongHieu")
    private Integer IdThuongHieu;
    @Column(name = "TenThuongHieu")
    private String TenThuongHieu;
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
    @OneToMany(mappedBy = "thuongHieu")
    private List<ChiTietSanPham> chiTietSanPhams;
}
