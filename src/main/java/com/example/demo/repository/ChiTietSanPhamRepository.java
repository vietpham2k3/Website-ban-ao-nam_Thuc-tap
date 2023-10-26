package com.example.demo.repository;

import com.example.demo.response.ChiTietSanPhamCustom;
import com.example.demo.entity.ChiTietSanPham;
import com.example.demo.response.SanPhamBanChayReponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {

    @Query(value = "Select ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai from ChiTietSanPham ctsp\n" +
            "            join SanPham sp on sp.IdSanPham = ctsp.IdSanPham\n" +
            "            join Anh a on a.IdSanPham = sp.IdSanPham\n" +
            "            join DanhMuc dm on dm.IdDanhMuc = ctsp.IdDanhMuc\n" +
            "            join ThuongHieu th on th.IdThuongHieu = ctsp.IdThuongHieu where sp.TrangThai = 0\n" +
            "\t\t\tGroup by ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai", nativeQuery = true)
    public List<ChiTietSanPhamCustom> getAll();
    @Query(value = "Select ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai from ChiTietSanPham ctsp\n" +
            "            join SanPham sp on sp.IdSanPham = ctsp.IdSanPham\n" +
            "            join Anh a on a.IdSanPham = sp.IdSanPham\n" +
            "            join DanhMuc dm on dm.IdDanhMuc = ctsp.IdDanhMuc\n" +
            "            join ThuongHieu th on th.IdThuongHieu = ctsp.IdThuongHieu where sp.TrangThai = 0\n" +
            "\t\t\tGroup by ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai", nativeQuery = true)
    public Page<ChiTietSanPhamCustom> phanTrang(Pageable pageable);
    @Query(value = "Select ctsp.IdCTSP,sp.IdSanPham , sp.MaSanPham, sp.TenSanPham, ctsp.GiaBan,dm.TenDanhMuc, th.TenThuongHieu,sp.TrangThai from ChiTietSanPham ctsp\n" +
            "join SanPham sp on sp.IdSanPham = ctsp.IdSanPham\n" +
            "join Anh a on a.IdSanPham = sp.IdSanPham\n" +
            "join DanhMuc dm on dm.IdDanhMuc = ctsp.IdDanhMuc\n" +
            "join ThuongHieu th on th.IdThuongHieu = ctsp.IdThuongHieu where sp.TrangThai = 0 and ctsp.IdCTSP = :id", nativeQuery = true)
    public ChiTietSanPhamCustom getByid(@Param("id") Integer id);

    @Query(value = "Select e from ChiTietSanPham e where  e.IdCTSP = :id")
    public ChiTietSanPham getCTSP(@Param("id") UUID id);
    @Query(value = "Select e from ChiTietSanPham e where e.TrangThai = 0")
    public List<ChiTietSanPham> getAllCTSP();
    @Query(value = "Select e from ChiTietSanPham e where e.sanPham.TenSanPham like :name")
    public List<ChiTietSanPham> getByName(@Param("name") String name);
    @Query(value = "Select e from ChiTietSanPham e join ChatLieu_CTSP m on m.chiTietSanPham.IdCTSP = e.IdCTSP\n" +
            "join ChatLieu ma on ma.IdChatLieu = m.chatLieu.IdChatLieu join MauSac_KichThuoc_CTSP p on p.chiTietSanPham.IdCTSP = e.IdCTSP\n" +
            "join MauSac c on c.IdMauSac = p.mauSac.IdMauSac\n" +
            "join KichThuoc s on s.IdKichThuoc = p.kichThuoc.IdKichThuoc join PhongCach_CTSP pctsp on pctsp.chiTietSanPham.IdCTSP = e.IdCTSP join PhongCach pc on pc.IdPhongCach = pctsp.phongCach.IdPhongCach where (ma.IdChatLieu = :idmaterial or :idmaterial is null) and (c.IdMauSac = :idcolor or :idcolor is null) and (s.IdKichThuoc = :idsize or :idsize is null) and (e.danhMuc.IdDanhMuc = :idcategory or :idcategory is null) and (e.thuongHieu.IdThuongHieu = :idbrand or :idbrand is null) and (e.phanLoai.IdPhanLoai = :idphanloai or :idphanloai is null)" +
            "and (e.xuatXu.IdXuatXu = :idxuatxu or :idxuatxu is null) and (pc.IdPhongCach = :idphongcach or :idphongcach is null) and e.GiaBan >= :min and e.GiaBan <= :max and e.TrangThai = 0 Order by e.NgayTao desc")
    public List<ChiTietSanPham> getAllByFilter(@Param("idcolor") Integer IdColor , @Param("idsize") Integer IdSize,@Param("idmaterial") Integer IdMaterial,@Param("idcategory") Integer IdCategory , @Param("idbrand") Integer IdBrand ,@Param("idphanloai") Integer IdPhanLoai,@Param("idxuatxu") Integer IdXuatXu,@Param("idphongcach") Integer IdPhongCach,@Param("min") Double min ,@Param("max") Double max);

    @Query(value = "Select e from ChiTietSanPham e where e.TrangThai = 0 order by e.NgayTao desc ")
    List<ChiTietSanPham> getSanPhamMoi();
    @Query(value = "SELECT ctsp.IdCTSP , sp.TenSanPham , ctsp.GiaBan , a.Link  from \n" +
            " ChiTietSanPham ctsp\n" +
            "join HoaDonChiTiet hdct on hdct.IdCTSP = ctsp.IdCTSP\n" +
            "join SanPham sp on sp.IdSanPham = ctsp.IdSanPham\n" +
            "join Anh a on a.IdSanPham = ctsp.IdSanPham\n" +
            "group by ctsp.IdCTSP , sp.TenSanPham , ctsp.GiaBan , a.Link\n" +
            "order by count(hdct.IdCTSP) desc " , nativeQuery = true)
    public List<SanPhamBanChayReponse> getSanPhamBanChay();

}
