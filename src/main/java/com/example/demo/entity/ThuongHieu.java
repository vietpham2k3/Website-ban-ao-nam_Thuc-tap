package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date NgayTao;
    @Column(name = "NgayCapNhat")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date NgayCapNhat;
    @Column(name = "NguoiCapNhat")
    private String NguoiCapNhat;
    @Column(name = "TrangThai")
    private Integer TrangThai;
    @JsonIgnore
    @OneToMany(mappedBy = "thuongHieu")
    private List<ChiTietSanPham> chiTietSanPhams;
}
