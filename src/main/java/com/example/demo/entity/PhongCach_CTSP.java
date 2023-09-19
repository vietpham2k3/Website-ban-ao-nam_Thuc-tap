package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "PhongCach_CTSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhongCach_CTSP implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID Id;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdPhongCach")
    private PhongCach phongCach;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "IdCTSP")
    private ChiTietSanPham chiTietSanPham;
}
