let url = "/api/KhachHang";
let app = angular.module("myApp", []);
app.controller("ctrl", function ($scope, $http, $location){
    $scope.list = [];

    $http.get(url).then(function (response) {
        $scope.list = response.data;
    });

    //add khach hang
    $scope.add = function (){
        $http.post("/api/KhachHang",{
            taiKhoan : $scope.taikhoan,
            matKhau : $scope.matkhau,
            tenKhachHang : $scope.tenkhachhang,
            anh : $scope.anh,
            gioiTinh : $scope.gioitinh,
            email : $scope.email,
            sdt : $scope.sdt,
            diaChi : $scope.diachi,

        }).then(function (khachhang){
            if (khachhang.status === 200){
                alert("Thêm thành công !");
                location.href="/admin/khach-hang/hien-thi";
            }
        })
    }
    //sửa khach hang
    $scope.update = function (){
        let id = document.getElementById("id").value;
        $http.put("/api/KhachHang/update/"+id,{
            taiKhoan : $scope.taikhoan,
            matKhau : $scope.matkhau,
            tenKhachHang : $scope.tenkhachhang,
            anh : $scope.anh,
            gioiTinh : $scope.gioitinh,
            email : $scope.email,
            sdt : $scope.sdt,
            diaChi : $scope.diachi,
        }).then(function (res){
            if (res.status === 200){
                alert("Sửa thành công");
                location.href="/admin/khach-hang/hien-thi";
            }
        })
    }

    //xóa khach hang
    $scope.delete = function (id){
        var check = window.confirm("Bạn có chắc muốn xóa ?");
        if (check === true){
            $http.put("/api/KhachHang/delete/"+id).then(function (res){
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
        $http.get("/api/KhachHang/"+id).then(function (res){
            if (res.status === 200){
                $scope.taikhoan = res.data.taiKhoan,
                    $scope.matkhau = res.data.matKhau,
                    $scope.tenkhachhang = res.data.tenKhachHang,
                    $scope.anh = res.data.anh,
                    $scope.gioitinh = res.data.gioiTinh,
                    $scope.email = res.data.email,
                    $scope.sdt = res.data.sdt,
                    $scope.diachi = res.data.diaChi


            }
        })
    }


});