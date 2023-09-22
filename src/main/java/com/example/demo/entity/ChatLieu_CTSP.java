package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "ChatLieu_CTSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatLieu_CTSP implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID Id;
    @ManyToOne
    @JoinColumn(name = "IdChatLieu")
    private ChatLieu chatLieu;
    @ManyToOne
    @JoinColumn(name = "IdCTSP")
    @JsonBackReference
    private ChiTietSanPham chiTietSanPham;
}
