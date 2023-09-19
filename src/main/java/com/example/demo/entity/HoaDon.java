package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHoaDon")
    private Integer IdHoaDon;
    @Column(name = "TongTien")
    private BigDecimal TongTien;
    @Column(name = "TongTienKhiGiam")
    private BigDecimal TongTienKhiGiam;
    @Column(name = "PhiShip")
    private BigDecimal PhiShip;
    @Column(name = "GhiChu")
    private String GhiChu;
    @Column(name = "NgayCapNhat")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date NgayCapNhat;
    @Column(name = "NguoiCapNhat")
    private String NguoiCapNhat;
    @Column(name = "TrangThai")
    private Integer TrangThai;
    @ManyToOne
    @JoinColumn(name = "IdDiaChi")
    private DiaChiGiaoHang diaChiGiaoHang;
    @ManyToOne
    @JoinColumn(name = "IdHTTT")
    private  HinhThucThanhToan hinhThucThanhToan;
    @ManyToOne
    @JoinColumn(name = "IdNhanVien")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "IdKhachHang")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "IdKhuyenMai")
    private KhuyenMai khuyenMai;
    @JsonBackReference
    @OneToMany(mappedBy = "hoaDon")
    private List<LichSuHoaDon> lichSuHoaDonList;
    @JsonBackReference
    @OneToMany(mappedBy = "hoaDon")
    private List<HoaDonChiTiet> hoaDonChiTiets;

}
