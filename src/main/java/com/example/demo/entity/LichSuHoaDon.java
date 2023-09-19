package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "LichSuHoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LichSuHoaDon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdLichSuHoaDon")
    private UUID IdLichSuHoaDon;
    @Column(name = "Ten")
    private String Ten;
    @Column(name = "GhiChu")
    private String GhiChu;
    @Column(name = "NgayCapNhat")
    private Date NgayCapNhat;
    @Column(name = "NguoiCapNhat")
    private String NguoiCapNhat;
    @Column(name = "TrangThai")
    private Integer TrangThai;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;
}
