package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "NhanVien_ChucVu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NhanVien_ChucVu implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID Id;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdNhanVien")
    private NhanVien nhanVien;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdChucVu")
    private ChucVu chucVu;
}
