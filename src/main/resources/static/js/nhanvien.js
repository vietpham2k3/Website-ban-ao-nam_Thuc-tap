let url = "/api/NhanVien";
let app = angular.module("myApp", []);
app.controller("ctrl", function ($scope, $http, $location){
    $scope.list = [];

    $http.get(url).then(function (response) {
        $scope.list = response.data;
    });

    //add Nhân viên
    $scope.add = function (){
        $http.post("/api/NhanVien",{
            taiKhoan : $scope.taikhoan,
            matKhau : $scope.matkhau,
            tenNhanVien : $scope.tennhanvien,
            anh : $scope.anh,
            luong : $scope.luong,
            gioiTinh : $scope.gioitinh,
            email : $scope.email,
            sdt : $scope.sdt,
            diaChi : $scope.diachi,

        }).then(function (nhanvien){
            if (nhanvien.status === 200){
                alert("Thêm thành công !");
                location.href="/admin/nhan-vien/hien-thi";
            }
        })
    }
    //sửa nhân viên
    $scope.update = function (){
        let id = document.getElementById("id").value;
        $http.put("/api/NhanVien/update/"+id,{
            taiKhoan : $scope.taikhoan,
            matKhau : $scope.matkhau,
            tenNhanVien : $scope.tennhanvien,
            anh : $scope.anh,
            luong : $scope.luong,
            gioiTinh : $scope.gioitinh,
            email : $scope.email,
            sdt : $scope.sdt,
            diaChi : $scope.diachi,
        }).then(function (res){
            if (res.status === 200){
                alert("Sửa thành công");
                location.href="/admin/nhan-vien/hien-thi";
            }
        })
    }

    //xóa nhân viên
    $scope.delete = function (id){
        var check = window.confirm("Bạn có chắc muốn xóa ?");
        if (check === true){
            $http.put("/api/NhanVien/delete/"+id).then(function (res){
                if (res.status === 200){
                    alert("Xóa thành công");
                    window.location.reload();
                }
            })
        }

    }
    //detail
    $scope.detail = function (){
        let id = document.getElementById("id").value;
        $http.get("/api/NhanVien/"+id).then(function (res){
            if (res.status === 200){
                $scope.taikhoan = res.data.taikhoan,
                    $scope.matkhau = res.data.matKhau,
                    $scope.tennhanvien = res.data.tenNhanVien,
                    $scope.anh = res.data.anh,
                    $scope.luong = res.data.luong,
                    $scope.gioitinh = res.data.gioiTinh,
                    $scope.email = res.data.email,
                    $scope.sdt = res.data.sdt,
                    $scope.diachi = res.data.diaChi


            }
        })
    }


});