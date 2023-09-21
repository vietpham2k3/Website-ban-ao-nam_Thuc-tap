package com.example.demo.controller;

import com.example.demo.entity.HoaDon;
import com.example.demo.service.*;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/hoa-don/")
public class HoaDonController {

    @Autowired public HoaDonService serHD;
    @Autowired public KhachHangService serKH;
    @Autowired public KhuyenMaiService serKM;
    @Autowired public NhanVienService serNV;
    @Autowired public HinhThucThanhToanService serHTTT;
    @Autowired public DiaChiService serDC;

    @GetMapping("hien-thi")
    public String hienThi(@RequestParam(defaultValue = "0") int page, Model model){
        Pageable pageable = PageRequest.of(page,5);
        model.addAttribute("listHD", serHD.pageHD(pageable));
        model.addAttribute("searchHD", new HoaDon());
        model.addAttribute("listNV", serNV.getAll());
        model.addAttribute("listKM", serKM.getAll());
        model.addAttribute("listKH", serKH.getAll());
        model.addAttribute("listHTTT", serHTTT.getAll());
        return "/admin/hoadon/hoa-don";
    }

    @GetMapping("hien-thi-page-search")
    public String search(Model model, @ModelAttribute("searchHD") HoaDon hoaDon,
                         @RequestParam(name = "page", defaultValue = "0") Integer page,
                         @RequestParam(name = "TenKhachHang", defaultValue = "") String TenKhachHang,
                         @RequestParam(name = "TenHinhThuc", defaultValue = "") String TenHinhThuc,
                         @RequestParam(value = "xapXep", defaultValue = "0") Integer xapXep,
                         @RequestParam(value = "size", defaultValue = "5") Integer size,
                         @RequestParam(value = "tuNgay", defaultValue = "", required = false) LocalDateTime tuNgay,
                         @RequestParam(value = "denNgay", defaultValue = "", required = false) LocalDateTime denNgay) {
        Map<Integer, Sort> sortMapping = new HashMap<>();
        sortMapping.put(1, Sort.by("NgayCapNhat").descending());
        sortMapping.put(2, Sort.by("NgayCapNhat").ascending());
        sortMapping.put(3, Sort.by("TongTienKhiGiam").descending());
        sortMapping.put(4, Sort.by("TongTienKhiGiam").ascending());
        sortMapping.put(5, Sort.by("TenKhachHang").descending());
        sortMapping.put(6, Sort.by("TenKhachHang").ascending());
        sortMapping.put(null, Sort.by("NgayCapNhat").descending());

        Sort sort = sortMapping.getOrDefault(xapXep, Sort.by("NgayCapNhat").descending());

        if (page < 0 || page == null) {
            page = 0; // Đặt giá trị mặc định là 0 nếu số trang nhỏ hơn 0
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<HoaDon> listHD = serHD.searchHD(hoaDon.getMaHoaDon(), TenKhachHang, hoaDon.getTongTienKhiGiam(),
                hoaDon.getTrangThai(), tuNgay != null ? Date.from(tuNgay.atZone(ZoneId.systemDefault()).toInstant()) : null,
                denNgay != null ? Date.from(denNgay.atZone(ZoneId.systemDefault()).toInstant()) : null,
               TenHinhThuc, pageable);

//        model.addAttribute("listNV", serNV.getAll());
//        model.addAttribute("listKM", serKM.getAll());
//        model.addAttribute("listKH", serKH.getAll());
//        model.addAttribute("listHTTT", serHTTT.getAll());

        model.addAttribute("tuNgay", tuNgay);
        model.addAttribute("denNgay", denNgay);

        model.addAttribute("listHD", listHD);
        return "/admin/hoadon/hoa-don";
    }


    @PostMapping("export-excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();


        XSSFSheet sheet = workbook.createSheet("Danh sách hóa đơn");
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã Hóa Đơn");
        headerRow.createCell(1).setCellValue("Ngày Đặt Hàng");
        headerRow.createCell(2).setCellValue("Tổng Tiền Sau Khi Giảm");
        headerRow.createCell(3).setCellValue("Loại Đơn");
        headerRow.createCell(4).setCellValue("Khách Hàng");
        headerRow.createCell(5).setCellValue("Khuyến Mãi");
        headerRow.createCell(6).setCellValue("Trạng Thái");


        // Tạo CellStyle cho định dạng ngày
        CellStyle dateCellStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            sheet.autoSizeColumn(i);
        }

        List<HoaDon> hoaDons = serHD.getExcel();
        int rowNum = 1;
        for (HoaDon hoaDon : hoaDons) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(hoaDon.getMaHoaDon());
            Cell ngayThanhToanCell = row.createCell(1);
            ngayThanhToanCell.setCellValue(hoaDon.getNgayCapNhat());
            ngayThanhToanCell.setCellStyle(dateCellStyle);
            row.createCell(2).setCellValue(hoaDon.getTongTienKhiGiam() + " VND");
            row.createCell(3).setCellValue(hoaDon.getHinhThucThanhToan().getTenHinhThuc());
            row.createCell(4).setCellValue(hoaDon.getKhachHang().getTenKhachHang());
            row.createCell(5).setCellValue(hoaDon.getKhuyenMai().getTenKhuyenMai());
            row.createCell(6).setCellValue(hoaDon.getTrangThai() == 0 ? "Đang chờ xác nhận"
                    : (hoaDon.getTrangThai() == 1 ? "Đã xác nhận"
                    : (hoaDon.getTrangThai() == 2 ? "Đã hủy đơn"
                    : (hoaDon.getTrangThai() == 3 ? "Chờ giao hàng"
                    : (hoaDon.getTrangThai() == 4 ? "Đang giao hàng"
                    : (hoaDon.getTrangThai() == 5 ? "Giao hàng thành công"
                    : (hoaDon.getTrangThai() == 6 ? "Giao hàng thất bại"
                    : "Thanh toán thành công")))))));
        }


        response.setHeader("Content-Disposition", "attachment; filename=danhsachhoadon.xlsx");
        response.setContentType("application/vnd.ms-excel");

        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
    }


}
