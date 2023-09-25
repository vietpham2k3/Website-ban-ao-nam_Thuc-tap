let url = "/api/kichthuoc";
let app = angular.module("myApp", []);
app.controller("ctrl", function ($scope, $http, $location){
    $scope.list = [];

    $http.get(url).then(function (response) {
        $scope.list = response.data;
    });

    //add kích thước
    $scope.add = function (){
        $http.post("/api/kichthuoc",{
            tenKichThuoc : $scope.ten,
            moTa : $scope.mota,
            ngayTao : new Date(),
            trangThai : 0
        }).then(function (kichthuoc){
            if (kichthuoc.status === 200){
                alert("Thêm thành công !");
                location.href="/admin/kich-thuoc/hien-thi";
            }
        })
    }
    //sửa kích thước
    $scope.update = function (){
        let id = document.getElementById("id").value;
        $http.put("/api/kichthuoc/update/"+id,{
            tenKichThuoc : $scope.ten,
            moTa : $scope.mota
        }).then(function (res){
            if (res.status === 200){
                alert("Sửa thành công");
                location.href="/admin/kich-thuoc/hien-thi";
            }
        })
    }

    //xóa kích thước
    $scope.delete = function (id){
        var check = window.confirm("Bạn có chắc muốn xóa ?");
        if (check === true){
            $http.put("/api/kichthuoc/delete/"+id).then(function (res){
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
        $http.get("/api/kichthuoc/"+id).then(function (res){
            if (res.status === 200){
                $scope.ten = res.data.tenKichThuoc,
                    $scope.mota = res.data.moTa
            }
        })
    }


});


