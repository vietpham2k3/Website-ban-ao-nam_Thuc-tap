package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KichThuoc;
import com.example.demo.entity.MauSac;
import com.example.demo.entity.XuatXu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac,Integer> {
    @Query(value = "Select e from MauSac e where e.IdMauSac = :id")
    public MauSac getById(@Param(("id")) Integer id);
    @Query(value = "Select e from MauSac e where e.TrangThai = 0")
    public List<MauSac> getAll();

    @Query(value = "Select c.IdMauSac from MauSac c\n" +
            "join MauSac_KichThuoc_CTSP p on p.mauSac.IdMauSac = c.IdMauSac \n" +
            "join ChiTietSanPham pd on pd.IdCTSP = p.chiTietSanPham.IdCTSP \n" +
            "where pd.IdCTSP = :id \n" +
            "Group by c.IdMauSac")
    public List<Integer> getColorByProduct(@Param("id") UUID id);
}
