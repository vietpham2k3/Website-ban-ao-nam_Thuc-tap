package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "IdKhuyenMai")
    private String IdKhuyenMai;

//    @NotEmpty(message = "Không để trống thông tin")
    @Column(name = "MaKhuyenMai")
    private String MaKhuyenMai;

//    @NotEmpty(message = "Không để trống thông tin")
    @Column(name = "TenKhuyenMai")
    private String TenKhuyenMai;

//    @NotNull(message = "Không để trống thông tin")
    @Column(name = "ChietKhau")
    private Integer ChietKhau;

    @Column(name = "NgayBatDau")
    private String NgayBatDau;

    @Column(name = "NgayKetThuc")
    private String NgayKetThuc;

    @Column(name = "NgayTao")
    private String NgayTao;

    @Column(name = "NgayCapNhat")
    private String NgayCapNhat;

//    @NotEmpty(message = "Không để trống thông tin")
    @Column(name = "NguoiCapNhat")
    private String NguoiCapNhat;

    @Column(name = "TrangThai")
    private Integer TrangThai;

    @JsonIgnore
    @OneToMany(mappedBy = "khuyenMai")
    private List<HoaDon> hoaDons;
}
