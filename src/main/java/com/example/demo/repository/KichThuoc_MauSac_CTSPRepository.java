package com.example.demo.repository;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.MauSac_KichThuoc_CTSP;
import com.example.demo.entity.PhongCach_CTSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface KichThuoc_MauSac_CTSPRepository extends JpaRepository<MauSac_KichThuoc_CTSP, UUID> {
    @Query("Select e from MauSac_KichThuoc_CTSP  e  where e.chiTietSanPham.IdCTSP = :id")
    public List<MauSac_KichThuoc_CTSP> getbyCTSP(@Param("id") UUID id);
    @Query(value = "Select SUM(p.SoLuong) from MauSac_KichThuoc_CTSP p\n" +
            "where p.chiTietSanPham.IdCTSP = :id and p.mauSac.IdMauSac = :idcolor and p.kichThuoc.IdKichThuoc = :idsize")
    Integer getQuantityByProductAndColorAndSize(@Param("id") UUID id,@Param("idcolor") Integer idcolor,@Param("idsize") Integer idsize);
    @Query(value = "Select p from MauSac_KichThuoc_CTSP p\n" +
            "where p.chiTietSanPham.IdCTSP = :id and p.mauSac.IdMauSac = :idcolor and p.kichThuoc.IdKichThuoc = :idsize")
    public MauSac_KichThuoc_CTSP getByProductAndColorAndSize(@Param("id") UUID id,@Param("idcolor") Integer idcolor,@Param("idsize") Integer idsize);
    @Query(value = "Select p from MauSac_KichThuoc_CTSP p \n" +
            "where p.chiTietSanPham.IdCTSP= :idProduct and p.mauSac.IdMauSac= :idColor")
    List<MauSac_KichThuoc_CTSP> getAllByIdProductAndIdColor(@Param("idProduct") UUID IdProduct, @Param(("idColor")) Integer IdColor);
    @Query(value = "Select SUM(p.SoLuong) from MauSac_KichThuoc_CTSP p\n" +
            "where p.chiTietSanPham.IdCTSP = :id")
    Integer getQuantityByProduct(@Param("id") UUID id);
    @Query(value = "Select SUM(p.SoLuong) from MauSac_KichThuoc_CTSP p\n" +
            "where p.chiTietSanPham.IdCTSP = :id and p.mauSac.IdMauSac = :idcolor")
    Integer getQuantityByProductAndColor(@Param("id") UUID id,@Param("idcolor") Integer idcolor);

}
