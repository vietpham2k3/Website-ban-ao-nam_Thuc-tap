Create database TTSavisTeam2
Use TTSavisTeam2

Create table Anh(
	IdImage UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	Link varchar(255),
	TenAnh nvarchar(255),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100)
)
Create table ChucVu(
	IdChucVu UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	TenChucVu nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table NhanVien(
	IdNhanVien UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	MaNhanVien varchar(20),
	TenNhanVien nvarchar(100),
	GioiTinh bit,
	Email varchar(100),
	Sdt varchar(15),
	DiaChi nvarchar(255),
	Luong Decimal,
	MatKhau varchar(30),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int,
	IdImage UNIQUEIDENTIFIER foreign key references Anh(IdImage)
)
Create table KhachHang(
	IdKhachHang UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	TaiKhoan varchar(15),
	MatKhau varchar(15),
	TenKhachHang nvarchar(100),
	GioiTinh bit,
	Email varchar(100),
	Sdt varchar(15),
	DiaChi nvarchar(255),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int,
	IdImage UNIQUEIDENTIFIER foreign key references Anh(IdImage)

)
Create table NhanVien_ChucVu(
	IdChucVu UNIQUEIDENTIFIER foreign key references ChucVu(IdChucVu),
	IdNhanVien UNIQUEIDENTIFIER foreign key references NhanVien(IdNhanVien)
)
Create table SanPham(
	IdSanPham int identity(1,1) primary key,
	MaSanPham varchar(15),
	TenSanPham nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int,
	IdImage UNIQUEIDENTIFIER foreign key references Anh(IdImage)
)
Create table DanhGia(
	IdDanhGia int identity(1,1) primary key,
	DiemDanhGia int,
	NoiDungDanhGia nvarchar(255),
	NgayDanhGia date,
	TrangThai int,
	IdSanPham int foreign key references SanPham(IdSanPham),
	IdKhachHang UNIQUEIDENTIFIER foreign key references KhachHang(IdKhachHang)
)
Create table KhuyenMai(
	IdKhuyenMai UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	MaKhuyenMai varchar(30),
	TenKhuyenMai nvarchar(100),
	ChietKhau int,
	NgayBatDau date,
	NgayKetThuc date,
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table PhanLoai(
	IdPhanLoai int identity(1,1) primary key,
	TenPhanLoai nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table ThuongHieu(
	IdThuongHieu int identity(1,1) primary key,
	TenThuongHieu nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table XuatXu(
	IdXuatXu int identity(1,1) primary key,
	TenXuatXu nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table DanhMuc(
	IdDanhMuc int identity(1,1) primary key,
	TenDanhMuc nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table ChatLieu(
	IdChatLieu int identity(1,1) primary key,
	TenChatLieu nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table MauSac(
	IdMauSac int identity(1,1) primary key,
	TenMauSac nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table KichThuoc(
	IdKichThuoc int identity(1,1) primary key,
	TenKichThuoc nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table PhongCach(
	IdPhongCach int identity(1,1) primary key,
	TenPhongCach nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table ChiTietSanPham(
	IdCTSP UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	GiaNhap Decimal,
	GiaBan Decimal,
	MoTa nvarchar(255),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int,
	IdSanPham int foreign key references SanPham(IdSanPham),
	IdPhanLoai int foreign key references PhanLoai(IdPhanLoai),
	IdThuongHieu int foreign key references ThuongHieu(IdThuongHieu),
	IdXuatXu int foreign key references XuatXu(IdXuatXu),
	IdKhuyenMai UNIQUEIDENTIFIER foreign key references KhuyenMai(IdKhuyenMai),
	IdDanhMuc int foreign key references DanhMuc(IdDanhMuc),
)
Create table MauSac_KichThuoc_CTSP(
	IdMauSac int foreign key references MauSac(IdMauSac),
	IdKichThuoc int foreign key references KichThuoc(IdKichThuoc),
	IdCTSP UNIQUEIDENTIFIER foreign key references ChiTietSanPham(IdCTSP),
	SoLuong int 
)
Create table ChatLieu_CTSP(
	IdChatLieu int foreign key references ChatLieu(IdChatLieu),
	IdCTSP UNIQUEIDENTIFIER foreign key references ChiTietSanPham(IdCTSP),
)
Create table PhongCach_CTSP(
	IdPhongCach int foreign key references PhongCach(IdPhongcach),
	IdCTSP UNIQUEIDENTIFIER foreign key references ChiTietSanPham(IdCTSP),
)
Create table HinhThucThanhToan(
	IdHTTT UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	TenHinhThuc nvarchar(100),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int
)
Create table HoaDon(
	IdHoaDon int identity(1,1) primary key,
	TongTien Decimal,
	TongTienKhiGiam Decimal,
	TenNguoiNhan nvarchar(100),
	SdtNhan varchar(15),
	DiaChiNhan nvarchar(255),
	PhiShip Decimal,
	GhiChu nvarchar(255),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int,
	IdHTTT UNIQUEIDENTIFIER foreign key references HinhThucThanhToan(IdHTTT),
	IdNhanVien UNIQUEIDENTIFIER foreign key references NhanVien(IdNhanVien),
	IdKhachHang UNIQUEIDENTIFIER foreign key references KhachHang(IdKhachHang),
)
Create table LichSuHoaDon(
	IdLichSuHoaDon  UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	Ten nvarchar(100),
	GhiChu nvarchar(255),
	NgayCapNhat Date,
	NguoiCapNhat nvarchar(100),
	TrangThai int,
	IdHoaDon int foreign key references HoaDon(IdHoaDon)
)
Create table HoaDonChiTiet(
	IdHoaDon int foreign key references HoaDon(IdHoaDon),
	IdCTSP UNIQUEIDENTIFIER foreign key references ChiTietSanPham(IdCTSP),
	DonGia Decimal,
	SoLuong Int,
	MauSac int ,
	KichThuoc int,
	ChietKhau int
)