package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ChatLieu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatLieu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdChatLieu")
    private Integer IdChatLieu;
    @Column(name = "TenChatLieu")
    private String TenChatLieu;
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
