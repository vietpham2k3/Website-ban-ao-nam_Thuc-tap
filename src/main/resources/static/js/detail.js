let app = angular.module("myApp", []);
app.controller("ctrl", function ($scope, $http, $location){
    let idGioHang = document.getElementById("idGioHang").value;
    let idKhachHang = document.getElementById("idKhachHang").value;
    let urlcolor = "http://localhost:8080/api/mausac";
    let urlsize = "http://localhost:8080/api/kichthuoc";
    // load color
    $scope.listColor = [];
    $http.get(urlcolor).then(function (response) {
        $scope.listColor = response.data;
    });
    // load size
    $scope.listSize = [];
    $http.get(urlsize).then(function (response) {
        $scope.listSize = response.data;
    });


    var id = document.getElementById("idCTSP").value;
    var params = {
        IdProduct: id,
    };
    $http({
        method: "GET",
        url: "http://localhost:8080/api/kichthuoc-mausac-ctsp/getQuantityProduct",
        params: params,
    }).then(function (resp) {
        $scope.quantity = resp.data;
    });

    $http
        .get("http://localhost:8080/api/mausac/get/" + id)
        .then(function (color) {
            $scope.colorid = color.data;
        });


    var selectedVal = "";
    var selectedVal1 = "";

    $scope.check = function () {
        var selected = $("input[type='radio'][name='ColorRadioGroup']:checked");
        if (selected.length > 0) {
            selectedVal = selected.val();
            $scope.selectedVal = selected.val();
        }
        $scope.listKT = [];
        var params = {
            IdProduct: id,
            IdColor: selectedVal,
        };
        $http({
            method: "GET",
            url: "http://localhost:8080/api/kichthuoc-mausac-ctsp/getbycolor",
            params: params,
        }).then(function (resp) {
            $scope.listKT = resp.data;
        });

        $http({
            method: "GET",
            url: "http://localhost:8080/api/kichthuoc-mausac-ctsp/getQuantityProductAndColor",
            params: params,
        }).then(function (resp) {
            $scope.quantity = resp.data;
        });

        $scope.checkSize = function () {
            var selected1 = $("input[type='radio'][name='SizeRadioGroup']:checked");
            if (selected1.length > 0) {
                selectedVal1 = selected1.val();
                $scope.selectedVal1 = selected1.val();
            }
            var params = {
                IdProduct: id,
                IdColor: selectedVal,
                IdSize: selectedVal1,
            };
            $http({
                method: "GET",
                url: "http://localhost:8080/api/kichthuoc-mausac-ctsp/getQuantityProductAndColorAndSize",
                params: params,
            }).then(function (resp) {
                $scope.quantity = resp.data;
            });
        };
    };

    //thêm sản phẩm vào giỏ hàng
    $scope.addToCart = function () {
        if (selectedVal === "") {
            Swal.fire("Vui lòng chọn màu sắc !!", "", "error");
            return;
        }
        if (selectedVal1 === "") {
            Swal.fire("Vui lòng chọn kích thước !!", "", "error");
            return;
        }
        let soLuong = document.getElementById("Quantity").value;
        if (soLuong.length === 0) {
            Swal.fire("Số lượng không được bỏ trống !!", "", "error");
            document.getElementById("Quantity").value = 1;
            return;
        }

        if (soLuong <= 0) {
            Swal.fire("Số lượng phải lớn hơn 0 !!", "", "error");
            document.getElementById("Quantity").value = 1;
            return;
        }

        if ($scope.quantity < soLuong) {
            Swal.fire(
                "Số lượng bạn thêm đang vượt quá số lượng còn hàng !!",
                "",
                "error"
            );
            return;
        }

        var numberRegex = /^[0-9]+$/;
        if (!numberRegex.test(soLuong)) {
            Swal.fire("Số lượng phải là số !!", "", "error");
            document.getElementById("Quantity").value = 1;
            return;
        }

        $http
            .get("http://localhost:8080/api/ctsp/" + id)
            .then(function (response) {
                var unitPrice = 0;
                if (response.data.giamGia > 0) {
                    unitPrice =
                        response.data.giaBan -
                        response.data.giaBan * (response.data.giamGia * 0.01);
                    $scope.unitPrice = unitPrice;
                } else {
                    unitPrice = response.data.giaBan;
                    $scope.unitPrice = unitPrice;
                }
                //get cart by user
                $scope.listCart = [];
                $http.get("http://localhost:8080/api/cart/"+idKhachHang).then(function (cart) {
                    $scope.listCart = cart.data;
                    // add to cart
                    if ($scope.listCart.length === 0) {
                        $http
                            .post("http://localhost:8080/api/cart", {
                                idCart: idGioHang,
                                idProductDetail: id,
                                idColor: selectedVal,
                                idSize: selectedVal1,
                                soLuong: soLuong,
                                donGia: unitPrice,
                            })
                            .then(function (cart) {
                                if (cart.status === 200) {
                                    Swal.fire("Đã thêm vào giỏ !!", "", "success");
                                }
                            });
                    }
                    //check list cart by user
                    if ($scope.listCart.length > 0) {
                        for (let i = 0; i < $scope.listCart.length; i++) {
                            // if product in cart
                            if (
                                $scope.listCart[i].chiTietSanPham.idCTSP == id &&
                                $scope.listCart[i].mauSac == selectedVal &&
                                $scope.listCart[i].kichThuoc == selectedVal1
                            ) {
                                if ($scope.listCart[i].soLuong >= $scope.quantity) {
                                    Swal.fire(
                                        "Bạn đã thêm số lượng tối đa hiện có của sản phẩm vào giỏ hàng !!",
                                        "",
                                        "error"
                                    );
                                    return;
                                }

                                $http
                                    .put(
                                        "http://localhost:8080/api/cart/updateCart/" +
                                        $scope.listCart[i].idGioHangChiTiet,
                                        {
                                            idCart: idGioHang,
                                            idProductDetail: id,
                                            idColor: selectedVal,
                                            idSize: selectedVal1,
                                            soLuong:
                                                parseInt(soLuong) +
                                                parseInt($scope.listCart[i].soLuong),
                                            donGia: unitPrice,
                                        }
                                    )
                                    .then(function (cart) {
                                        if (cart.status === 200) {
                                            Swal.fire("Đã thêm vào giỏ !!", "", "success");
                                        }
                                    });
                                return;
                            }
                        }
                        // add to cart
                        $http
                            .post("http://localhost:8080/api/cart", {
                                idCart: idGioHang,
                                idProductDetail: id,
                                idColor: selectedVal,
                                idSize: selectedVal1,
                                soLuong: soLuong,
                                donGia: unitPrice,
                            })
                            .then(function (cart) {
                                if (cart.status === 200) {
                                    Swal.fire("Đã thêm vào giỏ !!", "", "success");
                                }
                            });
                    }
                });
            });
    };


});