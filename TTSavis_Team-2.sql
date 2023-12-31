USE [TTSavisTeam2]
GO
/****** Object:  Table [dbo].[Anh]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Anh](
	[IdImage] [uniqueidentifier] NOT NULL,
	[Link] [varchar](255) NULL,
	[TenAnh] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[IdSanPham] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdImage] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[IdChatLieu] [int] IDENTITY(1,1) NOT NULL,
	[TenChatLieu] [nvarchar](100) NULL,
	[MoTa] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdChatLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChatLieu_CTSP]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu_CTSP](
	[Id] [uniqueidentifier] NOT NULL,
	[IdChatLieu] [int] NULL,
	[IdCTSP] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[IdCTSP] [uniqueidentifier] NOT NULL,
	[GiaNhap] [decimal](18, 0) NULL,
	[GiaBan] [decimal](18, 0) NULL,
	[GiamGia] [int] NULL,
	[MoTa] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
	[IdSanPham] [int] NULL,
	[IdPhanLoai] [int] NULL,
	[IdThuongHieu] [int] NULL,
	[IdXuatXu] [int] NULL,
	[IdDanhMuc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCTSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[IdChucVu] [uniqueidentifier] NOT NULL,
	[TenChucVu] [nvarchar](100) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhGia]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhGia](
	[IdDanhGia] [int] IDENTITY(1,1) NOT NULL,
	[DiemDanhGia] [int] NULL,
	[NoiDungDanhGia] [nvarchar](255) NULL,
	[Anh] [varchar](255) NULL,
	[NgayDanhGia] [date] NULL,
	[TrangThai] [int] NULL,
	[IdSanPham] [int] NULL,
	[IdKhachHang] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDanhGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[IdDanhMuc] [int] IDENTITY(1,1) NOT NULL,
	[TenDanhMuc] [nvarchar](100) NULL,
	[MoTa] [nvarchar](255) NULL,
	[Anh] [varchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DiaChiGiaoHang]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaChiGiaoHang](
	[IdDiaChi] [uniqueidentifier] NOT NULL,
	[TenNguoiNhan] [nvarchar](100) NULL,
	[SdtNhan] [varchar](15) NULL,
	[TinhThanh] [nvarchar](100) NULL,
	[QuanHuyen] [nvarchar](100) NULL,
	[PhuongXa] [nvarchar](100) NULL,
	[GhiChu] [nvarchar](255) NULL,
	[TrangThai] [int] NULL,
	[IdKhachHang] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDiaChi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHang]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHang](
	[IdGioHang] [uniqueidentifier] NOT NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
	[IdKhachHang] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdGioHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHangChiTiet]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHangChiTiet](
	[IdGioHangChiTiet] [uniqueidentifier] NOT NULL,
	[IdGioHang] [uniqueidentifier] NULL,
	[IdCTSP] [uniqueidentifier] NULL,
	[DonGia] [decimal](18, 0) NULL,
	[SoLuong] [int] NULL,
	[MauSac] [int] NULL,
	[KichThuoc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdGioHangChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HinhThucThanhToan]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HinhThucThanhToan](
	[IdHTTT] [uniqueidentifier] NOT NULL,
	[TenHinhThuc] [nvarchar](100) NULL,
	[MoTa] [nvarchar](255) NULL,
	[Anh] [varchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHTTT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[IdHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[MaHoaDon] [nvarchar](20) NULL,
	[TongTien] [decimal](18, 0) NULL,
	[TongTienKhiGiam] [decimal](18, 0) NULL,
	[PhiShip] [decimal](18, 0) NULL,
	[GhiChu] [nvarchar](255) NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
	[IdDiaChi] [uniqueidentifier] NULL,
	[IdHTTT] [uniqueidentifier] NULL,
	[IdNhanVien] [uniqueidentifier] NULL,
	[IdKhachHang] [uniqueidentifier] NULL,
	[IdKhuyenMai] [uniqueidentifier] NULL,
 CONSTRAINT [PK__HoaDon__4DD461C8702B43F1] PRIMARY KEY CLUSTERED 
(
	[IdHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[IdHoaDonChiTiet] [uniqueidentifier] NOT NULL,
	[IdHoaDon] [int] NULL,
	[IdCTSP] [uniqueidentifier] NULL,
	[DonGia] [decimal](18, 0) NULL,
	[SoLuong] [int] NULL,
	[MauSac] [int] NULL,
	[KichThuoc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdHoaDonChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[IdKhachHang] [uniqueidentifier] NOT NULL,
	[TaiKhoan] [varchar](15) NULL,
	[MatKhau] [varchar](15) NULL,
	[TenKhachHang] [nvarchar](100) NULL,
	[Anh] [varchar](255) NULL,
	[GioiTinh] [bit] NULL,
	[Email] [varchar](100) NULL,
	[Sdt] [varchar](15) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[IdKhuyenMai] [uniqueidentifier] NOT NULL,
	[MaKhuyenMai] [varchar](30) NULL,
	[TenKhuyenMai] [nvarchar](100) NULL,
	[ChietKhau] [int] NULL,
	[NgayBatDau] [date] NULL,
	[NgayKetThuc] [date] NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichThuoc]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichThuoc](
	[IdKichThuoc] [int] IDENTITY(1,1) NOT NULL,
	[TenKichThuoc] [nvarchar](100) NULL,
	[MoTa] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdKichThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichSuHoaDon]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichSuHoaDon](
	[IdLichSuHoaDon] [uniqueidentifier] NOT NULL,
	[Ten] [nvarchar](100) NULL,
	[GhiChu] [nvarchar](255) NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
	[IdHoaDon] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdLichSuHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[IdMauSac] [int] IDENTITY(1,1) NOT NULL,
	[MaMauSac] [varchar](20) NULL,
	[TenMauSac] [nvarchar](100) NULL,
	[MoTa] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMauSac] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac_KichThuoc_CTSP]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac_KichThuoc_CTSP](
	[Id] [uniqueidentifier] NOT NULL,
	[IdMauSac] [int] NULL,
	[IdKichThuoc] [int] NULL,
	[IdCTSP] [uniqueidentifier] NULL,
	[SoLuong] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[IdNhanVien] [uniqueidentifier] NOT NULL,
	[MaNhanVien] [varchar](20) NULL,
	[TenNhanVien] [nvarchar](100) NULL,
	[Anh] [varchar](255) NULL,
	[GioiTinh] [bit] NULL,
	[Email] [varchar](100) NULL,
	[Sdt] [varchar](15) NULL,
	[DiaChi] [nvarchar](255) NULL,
	[Luong] [decimal](18, 0) NULL,
	[MatKhau] [varchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien_ChucVu]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien_ChucVu](
	[Id] [uniqueidentifier] NOT NULL,
	[IdChucVu] [uniqueidentifier] NULL,
	[IdNhanVien] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanLoai]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanLoai](
	[IdPhanLoai] [int] IDENTITY(1,1) NOT NULL,
	[TenPhanLoai] [nvarchar](100) NULL,
	[MoTa] [nvarchar](255) NULL,
	[Anh] [varchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPhanLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongCach]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongCach](
	[IdPhongCach] [int] IDENTITY(1,1) NOT NULL,
	[TenPhongCach] [nvarchar](100) NULL,
	[MoTa] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPhongCach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhongCach_CTSP]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhongCach_CTSP](
	[Id] [uniqueidentifier] NOT NULL,
	[IdPhongCach] [int] NULL,
	[IdCTSP] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[IdSanPham] [int] IDENTITY(1,1) NOT NULL,
	[MaSanPham] [varchar](15) NULL,
	[TenSanPham] [nvarchar](100) NULL,
	[MoTa] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThuongHieu]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThuongHieu](
	[IdThuongHieu] [int] IDENTITY(1,1) NOT NULL,
	[TenThuongHieu] [nvarchar](100) NULL,
	[Anh] [varchar](255) NULL,
	[MoTa] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdThuongHieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XuatXu]    Script Date: 10/23/2023 9:04:17 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XuatXu](
	[IdXuatXu] [int] IDENTITY(1,1) NOT NULL,
	[TenXuatXu] [nvarchar](100) NULL,
	[MoTa] [nvarchar](255) NULL,
	[NgayTao] [date] NULL,
	[NgayCapNhat] [date] NULL,
	[NguoiCapNhat] [nvarchar](100) NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdXuatXu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Anh] ([IdImage], [Link], [TenAnh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [IdSanPham]) VALUES (N'e2f7f1d6-2b95-43a0-8ab3-1fc828fa3bdf', N'https://firebasestorage.googleapis.com/v0/b/tt-saviss.appspot.com/o/06b819dc-0d0d-433e-84d0-9965a67ace26?alt=media', N'Gai Xinh', NULL, NULL, NULL, 3)
INSERT [dbo].[Anh] ([IdImage], [Link], [TenAnh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [IdSanPham]) VALUES (N'84175c48-962f-49d9-bfa3-534c3cb71557', N'https://firebasestorage.googleapis.com/v0/b/tt-saviss.appspot.com/o/bce8b443-9899-40dc-bacd-4a29b5a6fc60?alt=media', NULL, NULL, NULL, NULL, 6)
INSERT [dbo].[Anh] ([IdImage], [Link], [TenAnh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [IdSanPham]) VALUES (N'5db4db82-0c60-4f13-89af-8673faeee771', N'https://firebasestorage.googleapis.com/v0/b/tt-saviss.appspot.com/o/05b5e44c-c1b0-412f-9c39-5a74fef67e5a?alt=media', N'kkk', NULL, NULL, NULL, 4)
INSERT [dbo].[Anh] ([IdImage], [Link], [TenAnh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [IdSanPham]) VALUES (N'4fe8ed59-3c4a-4694-a4d1-ccb6489234ff', N'https://firebasestorage.googleapis.com/v0/b/tt-saviss.appspot.com/o/bc7dce29-5af9-420e-a300-6384f4c4021c?alt=media', NULL, NULL, NULL, NULL, 5)
GO
SET IDENTITY_INSERT [dbo].[ChatLieu] ON 

INSERT [dbo].[ChatLieu] ([IdChatLieu], [TenChatLieu], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (1, N'Vải', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[ChatLieu] ([IdChatLieu], [TenChatLieu], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (2, N'Da', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[ChatLieu] ([IdChatLieu], [TenChatLieu], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (3, N'Lụa', NULL, NULL, NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[ChatLieu] OFF
GO
INSERT [dbo].[ChatLieu_CTSP] ([Id], [IdChatLieu], [IdCTSP]) VALUES (N'6dcbc3cf-368f-4cdd-9338-0b5e79c4007e', 3, N'30c32f16-3be7-4f6c-8705-789b019dec3c')
INSERT [dbo].[ChatLieu_CTSP] ([Id], [IdChatLieu], [IdCTSP]) VALUES (N'86b13a95-f9a8-4dd8-8130-740d4dfb372f', 2, N'ef295189-7560-4272-9523-f5f4a3512c72')
INSERT [dbo].[ChatLieu_CTSP] ([Id], [IdChatLieu], [IdCTSP]) VALUES (N'cfe9a0d6-b7ad-4e80-b227-eaf9ef2b03e3', 1, N'30c32f16-3be7-4f6c-8705-789b019dec3c')
GO
INSERT [dbo].[ChiTietSanPham] ([IdCTSP], [GiaNhap], [GiaBan], [GiamGia], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdSanPham], [IdPhanLoai], [IdThuongHieu], [IdXuatXu], [IdDanhMuc]) VALUES (N'30c32f16-3be7-4f6c-8705-789b019dec3c', CAST(34535 AS Decimal(18, 0)), CAST(88987 AS Decimal(18, 0)), 3234, NULL, NULL, NULL, NULL, 0, 4, 1, 28, 2, 1)
INSERT [dbo].[ChiTietSanPham] ([IdCTSP], [GiaNhap], [GiaBan], [GiamGia], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdSanPham], [IdPhanLoai], [IdThuongHieu], [IdXuatXu], [IdDanhMuc]) VALUES (N'b157d66a-ec9f-4950-af0f-d0dedd52774d', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 6, 5, 26, 3, 1)
INSERT [dbo].[ChiTietSanPham] ([IdCTSP], [GiaNhap], [GiaBan], [GiamGia], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdSanPham], [IdPhanLoai], [IdThuongHieu], [IdXuatXu], [IdDanhMuc]) VALUES (N'ef295189-7560-4272-9523-f5f4a3512c72', CAST(100000 AS Decimal(18, 0)), CAST(900000 AS Decimal(18, 0)), 10000, N'Ngon', NULL, NULL, NULL, 0, 3, 1, 27, 1, 1)
GO
SET IDENTITY_INSERT [dbo].[DanhMuc] ON 

INSERT [dbo].[DanhMuc] ([IdDanhMuc], [TenDanhMuc], [MoTa], [Anh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (1, N'Sports', NULL, NULL, NULL, NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[DanhMuc] OFF
GO
INSERT [dbo].[DiaChiGiaoHang] ([IdDiaChi], [TenNguoiNhan], [SdtNhan], [TinhThanh], [QuanHuyen], [PhuongXa], [GhiChu], [TrangThai], [IdKhachHang]) VALUES (N'55795a9c-3a69-43ba-a426-8b6a6c68428e', N'Viet', N'113', N'HN', N'DA', N'VN', N'kk', 0, N'bbe9cdcd-62a8-41b2-8b10-206259548198')
GO
INSERT [dbo].[HinhThucThanhToan] ([IdHTTT], [TenHinhThuc], [MoTa], [Anh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (N'20153b59-79b7-4c85-b553-4b067b15aea6', N'Đặt hàng online', NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[HinhThucThanhToan] ([IdHTTT], [TenHinhThuc], [MoTa], [Anh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (N'9fafe834-572d-426c-9b8d-65787f58cbb3', N'Tại Quầy', NULL, NULL, NULL, NULL, NULL, 1)
GO
SET IDENTITY_INSERT [dbo].[HoaDon] ON 

INSERT [dbo].[HoaDon] ([IdHoaDon], [MaHoaDon], [TongTien], [TongTienKhiGiam], [PhiShip], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdDiaChi], [IdHTTT], [IdNhanVien], [IdKhachHang], [IdKhuyenMai]) VALUES (1, N'HD01', CAST(90000 AS Decimal(18, 0)), CAST(80000 AS Decimal(18, 0)), CAST(30000 AS Decimal(18, 0)), NULL, CAST(N'2023-10-08' AS Date), NULL, 1, N'55795a9c-3a69-43ba-a426-8b6a6c68428e', N'20153b59-79b7-4c85-b553-4b067b15aea6', N'51b733f8-e358-4868-8ee4-825eb9ad5776', N'bbe9cdcd-62a8-41b2-8b10-206259548198', N'a3bfef69-4d1f-4bc4-91be-c8719b37ef9a')
INSERT [dbo].[HoaDon] ([IdHoaDon], [MaHoaDon], [TongTien], [TongTienKhiGiam], [PhiShip], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdDiaChi], [IdHTTT], [IdNhanVien], [IdKhachHang], [IdKhuyenMai]) VALUES (2, N'HD02', CAST(90000 AS Decimal(18, 0)), CAST(80000 AS Decimal(18, 0)), CAST(30000 AS Decimal(18, 0)), NULL, CAST(N'2023-10-07' AS Date), NULL, 0, N'55795a9c-3a69-43ba-a426-8b6a6c68428e', N'20153b59-79b7-4c85-b553-4b067b15aea6', N'51b733f8-e358-4868-8ee4-825eb9ad5776', N'6d44e540-fecb-4aa8-a16e-dd01a5af3eaa', N'a3bfef69-4d1f-4bc4-91be-c8719b37ef9a')
INSERT [dbo].[HoaDon] ([IdHoaDon], [MaHoaDon], [TongTien], [TongTienKhiGiam], [PhiShip], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdDiaChi], [IdHTTT], [IdNhanVien], [IdKhachHang], [IdKhuyenMai]) VALUES (3, N'HD03', CAST(90000 AS Decimal(18, 0)), CAST(99000 AS Decimal(18, 0)), CAST(30000 AS Decimal(18, 0)), NULL, CAST(N'2023-10-07' AS Date), NULL, 7, N'55795a9c-3a69-43ba-a426-8b6a6c68428e', N'20153b59-79b7-4c85-b553-4b067b15aea6', N'51b733f8-e358-4868-8ee4-825eb9ad5776', N'bbe9cdcd-62a8-41b2-8b10-206259548198', N'a3bfef69-4d1f-4bc4-91be-c8719b37ef9a')
INSERT [dbo].[HoaDon] ([IdHoaDon], [MaHoaDon], [TongTien], [TongTienKhiGiam], [PhiShip], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdDiaChi], [IdHTTT], [IdNhanVien], [IdKhachHang], [IdKhuyenMai]) VALUES (4, N'HD04', CAST(90000 AS Decimal(18, 0)), CAST(58979 AS Decimal(18, 0)), CAST(30000 AS Decimal(18, 0)), NULL, CAST(N'2023-10-07' AS Date), NULL, 7, N'55795a9c-3a69-43ba-a426-8b6a6c68428e', N'20153b59-79b7-4c85-b553-4b067b15aea6', N'51b733f8-e358-4868-8ee4-825eb9ad5776', N'6d44e540-fecb-4aa8-a16e-dd01a5af3eaa', N'a3bfef69-4d1f-4bc4-91be-c8719b37ef9a')
INSERT [dbo].[HoaDon] ([IdHoaDon], [MaHoaDon], [TongTien], [TongTienKhiGiam], [PhiShip], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdDiaChi], [IdHTTT], [IdNhanVien], [IdKhachHang], [IdKhuyenMai]) VALUES (5, N'HD05', CAST(90000 AS Decimal(18, 0)), CAST(80000 AS Decimal(18, 0)), CAST(30000 AS Decimal(18, 0)), NULL, CAST(N'2023-10-07' AS Date), NULL, 0, N'55795a9c-3a69-43ba-a426-8b6a6c68428e', N'20153b59-79b7-4c85-b553-4b067b15aea6', N'51b733f8-e358-4868-8ee4-825eb9ad5776', N'bbe9cdcd-62a8-41b2-8b10-206259548198', N'a3bfef69-4d1f-4bc4-91be-c8719b37ef9a')
INSERT [dbo].[HoaDon] ([IdHoaDon], [MaHoaDon], [TongTien], [TongTienKhiGiam], [PhiShip], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdDiaChi], [IdHTTT], [IdNhanVien], [IdKhachHang], [IdKhuyenMai]) VALUES (6, N'HD06', CAST(90000 AS Decimal(18, 0)), CAST(10000 AS Decimal(18, 0)), CAST(30000 AS Decimal(18, 0)), NULL, CAST(N'2023-10-10' AS Date), NULL, 0, N'55795a9c-3a69-43ba-a426-8b6a6c68428e', N'20153b59-79b7-4c85-b553-4b067b15aea6', N'51b733f8-e358-4868-8ee4-825eb9ad5776', N'6d44e540-fecb-4aa8-a16e-dd01a5af3eaa', N'a3bfef69-4d1f-4bc4-91be-c8719b37ef9a')
INSERT [dbo].[HoaDon] ([IdHoaDon], [MaHoaDon], [TongTien], [TongTienKhiGiam], [PhiShip], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdDiaChi], [IdHTTT], [IdNhanVien], [IdKhachHang], [IdKhuyenMai]) VALUES (7, N'HD07', CAST(90000 AS Decimal(18, 0)), CAST(80000 AS Decimal(18, 0)), CAST(30000 AS Decimal(18, 0)), NULL, CAST(N'2023-10-20' AS Date), NULL, 4, N'55795a9c-3a69-43ba-a426-8b6a6c68428e', N'20153b59-79b7-4c85-b553-4b067b15aea6', N'51b733f8-e358-4868-8ee4-825eb9ad5776', N'bbe9cdcd-62a8-41b2-8b10-206259548198', N'a3bfef69-4d1f-4bc4-91be-c8719b37ef9a')
INSERT [dbo].[HoaDon] ([IdHoaDon], [MaHoaDon], [TongTien], [TongTienKhiGiam], [PhiShip], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdDiaChi], [IdHTTT], [IdNhanVien], [IdKhachHang], [IdKhuyenMai]) VALUES (8, N'HD08', CAST(90000 AS Decimal(18, 0)), CAST(80000 AS Decimal(18, 0)), CAST(30000 AS Decimal(18, 0)), NULL, CAST(N'2023-10-10' AS Date), NULL, 0, N'55795a9c-3a69-43ba-a426-8b6a6c68428e', N'20153b59-79b7-4c85-b553-4b067b15aea6', N'51b733f8-e358-4868-8ee4-825eb9ad5776', N'bbe9cdcd-62a8-41b2-8b10-206259548198', N'a3bfef69-4d1f-4bc4-91be-c8719b37ef9a')
SET IDENTITY_INSERT [dbo].[HoaDon] OFF
GO
INSERT [dbo].[KhachHang] ([IdKhachHang], [TaiKhoan], [MatKhau], [TenKhachHang], [Anh], [GioiTinh], [Email], [Sdt], [DiaChi], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (N'bbe9cdcd-62a8-41b2-8b10-206259548198', NULL, NULL, N'Viet DZ', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KhachHang] ([IdKhachHang], [TaiKhoan], [MatKhau], [TenKhachHang], [Anh], [GioiTinh], [Email], [Sdt], [DiaChi], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (N'aa326154-d6ce-42ee-9127-65c69ceb240c', N'viet', N'123', NULL, NULL, NULL, NULL, NULL, NULL, CAST(N'2023-10-11' AS Date), NULL, NULL, 0)
INSERT [dbo].[KhachHang] ([IdKhachHang], [TaiKhoan], [MatKhau], [TenKhachHang], [Anh], [GioiTinh], [Email], [Sdt], [DiaChi], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (N'6d44e540-fecb-4aa8-a16e-dd01a5af3eaa', NULL, NULL, N'Haha', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
GO
INSERT [dbo].[KhuyenMai] ([IdKhuyenMai], [MaKhuyenMai], [TenKhuyenMai], [ChietKhau], [NgayBatDau], [NgayKetThuc], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (N'a3bfef69-4d1f-4bc4-91be-c8719b37ef9a', N'KM01', N'Giam 100k', 100000, CAST(N'2002-10-10' AS Date), CAST(N'2002-10-15' AS Date), CAST(N'2002-10-10' AS Date), NULL, NULL, 0)
GO
SET IDENTITY_INSERT [dbo].[KichThuoc] ON 

INSERT [dbo].[KichThuoc] ([IdKichThuoc], [TenKichThuoc], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (1, N'XL', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[KichThuoc] ([IdKichThuoc], [TenKichThuoc], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (2, N'L', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[KichThuoc] ([IdKichThuoc], [TenKichThuoc], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (3, N'M', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[KichThuoc] ([IdKichThuoc], [TenKichThuoc], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (4, N'XS', N'Null', CAST(N'2023-09-28' AS Date), NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[KichThuoc] OFF
GO
INSERT [dbo].[LichSuHoaDon] ([IdLichSuHoaDon], [Ten], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdHoaDon]) VALUES (N'805834c5-b0fb-47fe-bee8-051ca4b108a3', NULL, N'tt', CAST(N'2023-10-07' AS Date), NULL, 7, 3)
INSERT [dbo].[LichSuHoaDon] ([IdLichSuHoaDon], [Ten], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdHoaDon]) VALUES (N'4e338063-2436-470f-95fe-0a62a93e9070', NULL, N'giao', CAST(N'2023-10-07' AS Date), NULL, 4, 3)
INSERT [dbo].[LichSuHoaDon] ([IdLichSuHoaDon], [Ten], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdHoaDon]) VALUES (N'97c941fb-28ea-458c-a641-38624ac365be', NULL, N'tt', CAST(N'2023-10-07' AS Date), NULL, 7, 4)
INSERT [dbo].[LichSuHoaDon] ([IdLichSuHoaDon], [Ten], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdHoaDon]) VALUES (N'838fe9fc-e5b4-4dbd-bc78-387f33e52d7c', NULL, N'xac nhan', CAST(N'2023-10-07' AS Date), NULL, 1, 3)
INSERT [dbo].[LichSuHoaDon] ([IdLichSuHoaDon], [Ten], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdHoaDon]) VALUES (N'5828fd74-9dc2-43bc-ae27-3a95e1dc0e17', NULL, N'ok', CAST(N'2023-10-20' AS Date), NULL, 4, 7)
INSERT [dbo].[LichSuHoaDon] ([IdLichSuHoaDon], [Ten], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdHoaDon]) VALUES (N'fa574d27-3ca6-4d83-b513-819c5266c4a3', NULL, N'', CAST(N'2023-10-08' AS Date), NULL, 1, 1)
INSERT [dbo].[LichSuHoaDon] ([IdLichSuHoaDon], [Ten], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdHoaDon]) VALUES (N'00e92ed6-9361-4a21-9661-81c842c2bb59', NULL, N'ok', CAST(N'2023-10-07' AS Date), NULL, 1, 4)
INSERT [dbo].[LichSuHoaDon] ([IdLichSuHoaDon], [Ten], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdHoaDon]) VALUES (N'87c7a1af-8004-42c4-ae11-ba3b9a9a891a', NULL, N'ok', CAST(N'2023-10-20' AS Date), NULL, 1, 7)
INSERT [dbo].[LichSuHoaDon] ([IdLichSuHoaDon], [Ten], [GhiChu], [NgayCapNhat], [NguoiCapNhat], [TrangThai], [IdHoaDon]) VALUES (N'611d7ade-e480-4343-8a73-de6e998c044c', NULL, N'giao', CAST(N'2023-10-07' AS Date), NULL, 4, 4)
GO
SET IDENTITY_INSERT [dbo].[MauSac] ON 

INSERT [dbo].[MauSac] ([IdMauSac], [MaMauSac], [TenMauSac], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (1, NULL, N'Đỏ', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[MauSac] ([IdMauSac], [MaMauSac], [TenMauSac], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (2, NULL, N'Xanh', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[MauSac] ([IdMauSac], [MaMauSac], [TenMauSac], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (3, NULL, N'Tím', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[MauSac] ([IdMauSac], [MaMauSac], [TenMauSac], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (4, NULL, N'Đen', NULL, NULL, NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[MauSac] OFF
GO
INSERT [dbo].[MauSac_KichThuoc_CTSP] ([Id], [IdMauSac], [IdKichThuoc], [IdCTSP], [SoLuong]) VALUES (N'c6d0af8a-6b9a-4b64-8c2e-35855c4158db', 2, 1, N'ef295189-7560-4272-9523-f5f4a3512c72', 6)
INSERT [dbo].[MauSac_KichThuoc_CTSP] ([Id], [IdMauSac], [IdKichThuoc], [IdCTSP], [SoLuong]) VALUES (N'c74a2d5a-3ced-4915-959a-4638f7effef6', 4, 1, N'30c32f16-3be7-4f6c-8705-789b019dec3c', 3)
INSERT [dbo].[MauSac_KichThuoc_CTSP] ([Id], [IdMauSac], [IdKichThuoc], [IdCTSP], [SoLuong]) VALUES (N'ded6c38a-e85b-4267-94a1-617e2fba304c', 3, 2, N'ef295189-7560-4272-9523-f5f4a3512c72', 5)
INSERT [dbo].[MauSac_KichThuoc_CTSP] ([Id], [IdMauSac], [IdKichThuoc], [IdCTSP], [SoLuong]) VALUES (N'b05360b8-c23e-48b6-884a-7e3003ef1b15', 3, 2, N'30c32f16-3be7-4f6c-8705-789b019dec3c', 5)
INSERT [dbo].[MauSac_KichThuoc_CTSP] ([Id], [IdMauSac], [IdKichThuoc], [IdCTSP], [SoLuong]) VALUES (N'83b89dbe-5b0a-495a-899b-8b25579abf87', 4, 3, N'ef295189-7560-4272-9523-f5f4a3512c72', 5)
INSERT [dbo].[MauSac_KichThuoc_CTSP] ([Id], [IdMauSac], [IdKichThuoc], [IdCTSP], [SoLuong]) VALUES (N'2d98b474-fe70-4b11-b8e6-a9fca7965ee5', 4, 3, N'30c32f16-3be7-4f6c-8705-789b019dec3c', 5)
INSERT [dbo].[MauSac_KichThuoc_CTSP] ([Id], [IdMauSac], [IdKichThuoc], [IdCTSP], [SoLuong]) VALUES (N'c14c738c-63c4-4713-9d62-b96a99ecb4bd', 3, 1, N'ef295189-7560-4272-9523-f5f4a3512c72', 5)
INSERT [dbo].[MauSac_KichThuoc_CTSP] ([Id], [IdMauSac], [IdKichThuoc], [IdCTSP], [SoLuong]) VALUES (N'3c65a496-ff44-4aa9-98b1-d08aca0ee608', 4, 2, N'ef295189-7560-4272-9523-f5f4a3512c72', 5)
GO
INSERT [dbo].[NhanVien] ([IdNhanVien], [MaNhanVien], [TenNhanVien], [Anh], [GioiTinh], [Email], [Sdt], [DiaChi], [Luong], [MatKhau], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (N'142b28a1-85a6-40a6-9b4f-1bbef38c658b', N'NV00', N'than', NULL, NULL, NULL, NULL, NULL, NULL, N'123', CAST(N'1970-01-01' AS Date), NULL, NULL, 0)
INSERT [dbo].[NhanVien] ([IdNhanVien], [MaNhanVien], [TenNhanVien], [Anh], [GioiTinh], [Email], [Sdt], [DiaChi], [Luong], [MatKhau], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (N'51b733f8-e358-4868-8ee4-825eb9ad5776', N'NV01', N'Than Chi Long', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[NhanVien] ([IdNhanVien], [MaNhanVien], [TenNhanVien], [Anh], [GioiTinh], [Email], [Sdt], [DiaChi], [Luong], [MatKhau], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (N'ee697f0f-b23e-4c53-be61-a3956d0918f0', N'NV02', N'KKK', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
GO
SET IDENTITY_INSERT [dbo].[PhanLoai] ON 

INSERT [dbo].[PhanLoai] ([IdPhanLoai], [TenPhanLoai], [MoTa], [Anh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (1, N'The Thao', N'ngon vcl', N'https://kiemtientuweb.com/ckfinder/userfiles/images/anh-gai-xinh/anh-gai-xinh-18.jpg', NULL, CAST(N'2023-09-25' AS Date), N'Việt FIX', 0)
INSERT [dbo].[PhanLoai] ([IdPhanLoai], [TenPhanLoai], [MoTa], [Anh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (2, N'Đánh Nhau', N'HaHa', N'https://kiemtientuweb.com/ckfinder/userfiles/images/anh-gai-xinh/anh-gai-xinh-2.jpg', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt Delete', 1)
INSERT [dbo].[PhanLoai] ([IdPhanLoai], [TenPhanLoai], [MoTa], [Anh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (3, N'Đối Kháng', N'NGON VCL', N'https://kiemtientuweb.com/ckfinder/userfiles/images/anh-gai-xinh/anh-gai-xinh-27.jpg', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt Create', 0)
INSERT [dbo].[PhanLoai] ([IdPhanLoai], [TenPhanLoai], [MoTa], [Anh], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (5, N'Đánh Nhau', N'null', N'https://haycafe.vn/wp-content/uploads/2021/12/hinh-anh-gai-xinh-toc-ngan-dep.jpg', CAST(N'2023-09-27' AS Date), CAST(N'2023-09-27' AS Date), N'Việt Create', 0)
SET IDENTITY_INSERT [dbo].[PhanLoai] OFF
GO
SET IDENTITY_INSERT [dbo].[PhongCach] ON 

INSERT [dbo].[PhongCach] ([IdPhongCach], [TenPhongCach], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (1, N'Summer', N'NULL', NULL, CAST(N'2023-09-25' AS Date), N'Việt FIX', 0)
INSERT [dbo].[PhongCach] ([IdPhongCach], [TenPhongCach], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (2, N'Fall', N'NULL', NULL, CAST(N'2023-09-25' AS Date), N'Việt FIX', 0)
INSERT [dbo].[PhongCach] ([IdPhongCach], [TenPhongCach], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (3, N'Winter', N'ngon', NULL, CAST(N'2023-09-25' AS Date), N'Việt Delete', 1)
INSERT [dbo].[PhongCach] ([IdPhongCach], [TenPhongCach], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (4, N'VIP', N'HaHa', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt Create', 0)
INSERT [dbo].[PhongCach] ([IdPhongCach], [TenPhongCach], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (5, N'VIP2', N'ngon', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt Create', 0)
INSERT [dbo].[PhongCach] ([IdPhongCach], [TenPhongCach], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (6, N'VIP25', N'NGON VCL', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt Create', 0)
SET IDENTITY_INSERT [dbo].[PhongCach] OFF
GO
INSERT [dbo].[PhongCach_CTSP] ([Id], [IdPhongCach], [IdCTSP]) VALUES (N'f349b398-2f63-4408-b44f-388c123110e1', 2, N'ef295189-7560-4272-9523-f5f4a3512c72')
INSERT [dbo].[PhongCach_CTSP] ([Id], [IdPhongCach], [IdCTSP]) VALUES (N'76a6fdf3-3ce8-4297-a8e6-5299cf824573', 3, N'30c32f16-3be7-4f6c-8705-789b019dec3c')
INSERT [dbo].[PhongCach_CTSP] ([Id], [IdPhongCach], [IdCTSP]) VALUES (N'f551acc3-49ba-4a47-86a1-55094175748d', 3, N'ef295189-7560-4272-9523-f5f4a3512c72')
INSERT [dbo].[PhongCach_CTSP] ([Id], [IdPhongCach], [IdCTSP]) VALUES (N'c80748cb-d5d2-4ff7-b3bf-8e60861373cd', 2, N'30c32f16-3be7-4f6c-8705-789b019dec3c')
GO
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([IdSanPham], [MaSanPham], [TenSanPham], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (1, NULL, NULL, NULL, CAST(N'2023-09-23' AS Date), NULL, NULL, 0)
INSERT [dbo].[SanPham] ([IdSanPham], [MaSanPham], [TenSanPham], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (2, N'SP01', N'Haha', NULL, CAST(N'2023-09-23' AS Date), NULL, NULL, 0)
INSERT [dbo].[SanPham] ([IdSanPham], [MaSanPham], [TenSanPham], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (3, N'SP01', N'Gai Xinh', NULL, CAST(N'2023-09-23' AS Date), CAST(N'2023-09-25' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([IdSanPham], [MaSanPham], [TenSanPham], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (4, N'SP02', N'kkk', NULL, CAST(N'2023-09-23' AS Date), CAST(N'2023-09-25' AS Date), NULL, 0)
INSERT [dbo].[SanPham] ([IdSanPham], [MaSanPham], [TenSanPham], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (5, N'SP02', NULL, NULL, CAST(N'2023-09-24' AS Date), NULL, NULL, 0)
INSERT [dbo].[SanPham] ([IdSanPham], [MaSanPham], [TenSanPham], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (6, N'SP02', NULL, NULL, CAST(N'2023-09-28' AS Date), NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[ThuongHieu] ON 

INSERT [dbo].[ThuongHieu] ([IdThuongHieu], [TenThuongHieu], [Anh], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (26, N'LV', N'https://kiemtientuweb.com/ckfinder/userfiles/images/anh-gai-xinh/anh-gai-xinh-2.jpg', N'ngon vcl', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt FIX', 0)
INSERT [dbo].[ThuongHieu] ([IdThuongHieu], [TenThuongHieu], [Anh], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (27, N'lol', N'https://kenh14cdn.com/thumb_w/620/2020/5/28/0-1590653959375414280410.jpg', N'NULL', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt FIX', 0)
INSERT [dbo].[ThuongHieu] ([IdThuongHieu], [TenThuongHieu], [Anh], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (28, N'NIKEKK', N'https://kiemtientuweb.com/ckfinder/userfiles/images/anh-gai-xinh/anh-gai-xinh-18.jpg', N'NGON VCL', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt Create', 0)
SET IDENTITY_INSERT [dbo].[ThuongHieu] OFF
GO
SET IDENTITY_INSERT [dbo].[XuatXu] ON 

INSERT [dbo].[XuatXu] ([IdXuatXu], [TenXuatXu], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (1, N'USA', N'NULL', CAST(N'2029-10-10' AS Date), CAST(N'2023-09-25' AS Date), N'Việt FIX', 0)
INSERT [dbo].[XuatXu] ([IdXuatXu], [TenXuatXu], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (2, N'KING', N'ngon', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt Delete', 1)
INSERT [dbo].[XuatXu] ([IdXuatXu], [TenXuatXu], [MoTa], [NgayTao], [NgayCapNhat], [NguoiCapNhat], [TrangThai]) VALUES (3, N'KING 2', N'ngon', CAST(N'2023-09-25' AS Date), CAST(N'2023-09-25' AS Date), N'Việt Create', 0)
SET IDENTITY_INSERT [dbo].[XuatXu] OFF
GO
ALTER TABLE [dbo].[Anh] ADD  DEFAULT (newid()) FOR [IdImage]
GO
ALTER TABLE [dbo].[ChatLieu_CTSP] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT (newid()) FOR [IdCTSP]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (newid()) FOR [IdChucVu]
GO
ALTER TABLE [dbo].[DiaChiGiaoHang] ADD  DEFAULT (newid()) FOR [IdDiaChi]
GO
ALTER TABLE [dbo].[GioHang] ADD  DEFAULT (newid()) FOR [IdGioHang]
GO
ALTER TABLE [dbo].[GioHangChiTiet] ADD  DEFAULT (newid()) FOR [IdGioHangChiTiet]
GO
ALTER TABLE [dbo].[HinhThucThanhToan] ADD  DEFAULT (newid()) FOR [IdHTTT]
GO
ALTER TABLE [dbo].[HoaDonChiTiet] ADD  DEFAULT (newid()) FOR [IdHoaDonChiTiet]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (newid()) FOR [IdKhachHang]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (newid()) FOR [IdKhuyenMai]
GO
ALTER TABLE [dbo].[LichSuHoaDon] ADD  DEFAULT (newid()) FOR [IdLichSuHoaDon]
GO
ALTER TABLE [dbo].[MauSac_KichThuoc_CTSP] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (newid()) FOR [IdNhanVien]
GO
ALTER TABLE [dbo].[NhanVien_ChucVu] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[PhongCach_CTSP] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[Anh]  WITH CHECK ADD FOREIGN KEY([IdSanPham])
REFERENCES [dbo].[SanPham] ([IdSanPham])
GO
ALTER TABLE [dbo].[ChatLieu_CTSP]  WITH CHECK ADD FOREIGN KEY([IdChatLieu])
REFERENCES [dbo].[ChatLieu] ([IdChatLieu])
GO
ALTER TABLE [dbo].[ChatLieu_CTSP]  WITH CHECK ADD FOREIGN KEY([IdCTSP])
REFERENCES [dbo].[ChiTietSanPham] ([IdCTSP])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IdDanhMuc])
REFERENCES [dbo].[DanhMuc] ([IdDanhMuc])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IdPhanLoai])
REFERENCES [dbo].[PhanLoai] ([IdPhanLoai])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IdSanPham])
REFERENCES [dbo].[SanPham] ([IdSanPham])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IdThuongHieu])
REFERENCES [dbo].[ThuongHieu] ([IdThuongHieu])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([IdXuatXu])
REFERENCES [dbo].[XuatXu] ([IdXuatXu])
GO
ALTER TABLE [dbo].[DanhGia]  WITH CHECK ADD FOREIGN KEY([IdKhachHang])
REFERENCES [dbo].[KhachHang] ([IdKhachHang])
GO
ALTER TABLE [dbo].[DanhGia]  WITH CHECK ADD FOREIGN KEY([IdSanPham])
REFERENCES [dbo].[SanPham] ([IdSanPham])
GO
ALTER TABLE [dbo].[DiaChiGiaoHang]  WITH CHECK ADD FOREIGN KEY([IdKhachHang])
REFERENCES [dbo].[KhachHang] ([IdKhachHang])
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD FOREIGN KEY([IdKhachHang])
REFERENCES [dbo].[KhachHang] ([IdKhachHang])
GO
ALTER TABLE [dbo].[GioHangChiTiet]  WITH CHECK ADD FOREIGN KEY([IdCTSP])
REFERENCES [dbo].[ChiTietSanPham] ([IdCTSP])
GO
ALTER TABLE [dbo].[GioHangChiTiet]  WITH CHECK ADD FOREIGN KEY([IdGioHang])
REFERENCES [dbo].[GioHang] ([IdGioHang])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__IdDiaChi__05D8E0BE] FOREIGN KEY([IdDiaChi])
REFERENCES [dbo].[DiaChiGiaoHang] ([IdDiaChi])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__IdDiaChi__05D8E0BE]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__IdHTTT__06CD04F7] FOREIGN KEY([IdHTTT])
REFERENCES [dbo].[HinhThucThanhToan] ([IdHTTT])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__IdHTTT__06CD04F7]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__IdKhachH__08B54D69] FOREIGN KEY([IdKhachHang])
REFERENCES [dbo].[KhachHang] ([IdKhachHang])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__IdKhachH__08B54D69]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__IdKhuyen__09A971A2] FOREIGN KEY([IdKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([IdKhuyenMai])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__IdKhuyen__09A971A2]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK__HoaDon__IdNhanVi__07C12930] FOREIGN KEY([IdNhanVien])
REFERENCES [dbo].[NhanVien] ([IdNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK__HoaDon__IdNhanVi__07C12930]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([IdCTSP])
REFERENCES [dbo].[ChiTietSanPham] ([IdCTSP])
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK__HoaDonChi__IdHoa__114A936A] FOREIGN KEY([IdHoaDon])
REFERENCES [dbo].[HoaDon] ([IdHoaDon])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK__HoaDonChi__IdHoa__114A936A]
GO
ALTER TABLE [dbo].[LichSuHoaDon]  WITH CHECK ADD  CONSTRAINT [FK__LichSuHoa__IdHoa__0D7A0286] FOREIGN KEY([IdHoaDon])
REFERENCES [dbo].[HoaDon] ([IdHoaDon])
GO
ALTER TABLE [dbo].[LichSuHoaDon] CHECK CONSTRAINT [FK__LichSuHoa__IdHoa__0D7A0286]
GO
ALTER TABLE [dbo].[MauSac_KichThuoc_CTSP]  WITH CHECK ADD FOREIGN KEY([IdCTSP])
REFERENCES [dbo].[ChiTietSanPham] ([IdCTSP])
GO
ALTER TABLE [dbo].[MauSac_KichThuoc_CTSP]  WITH CHECK ADD FOREIGN KEY([IdKichThuoc])
REFERENCES [dbo].[KichThuoc] ([IdKichThuoc])
GO
ALTER TABLE [dbo].[MauSac_KichThuoc_CTSP]  WITH CHECK ADD FOREIGN KEY([IdMauSac])
REFERENCES [dbo].[MauSac] ([IdMauSac])
GO
ALTER TABLE [dbo].[NhanVien_ChucVu]  WITH CHECK ADD FOREIGN KEY([IdChucVu])
REFERENCES [dbo].[ChucVu] ([IdChucVu])
GO
ALTER TABLE [dbo].[NhanVien_ChucVu]  WITH CHECK ADD FOREIGN KEY([IdNhanVien])
REFERENCES [dbo].[NhanVien] ([IdNhanVien])
GO
ALTER TABLE [dbo].[PhongCach_CTSP]  WITH CHECK ADD FOREIGN KEY([IdCTSP])
REFERENCES [dbo].[ChiTietSanPham] ([IdCTSP])
GO
ALTER TABLE [dbo].[PhongCach_CTSP]  WITH CHECK ADD FOREIGN KEY([IdPhongCach])
REFERENCES [dbo].[PhongCach] ([IdPhongCach])
GO
