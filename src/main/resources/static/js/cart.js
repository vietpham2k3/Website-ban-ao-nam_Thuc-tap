let app = angular.module("myApp", []);
app.controller("ctrl", function ($scope, $http, $location) {
    $scope.loadCart = function () {
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
        //load cart by user
        $scope.listCart = [];
        $http.get("http://localhost:8080/api/cart/"+idKhachHang).then(function (cart) {
            $scope.listCart = cart.data;
            $scope.tongTien = 0;
            for (let i = 0; i < $scope.listCart.length; i++) {
                $scope.tongTien +=
                    $scope.listCart[i].donGia * $scope.listCart[i].soLuong;
            }
        });

        //delete product from cart
        $scope.deleteByCart = function (id) {
            Swal.fire({
                title: "Bạn có chắc muốn xóa sản phẩm này khỏi giỏ hàng ?",
                showCancelButton: true,
                confirmButtonText: "Xóa",
            }).then((result) => {
                /* Read more about isConfirmed, isDenied below */
                if (result.isConfirmed) {
                    $http.delete("http://localhost:8080/api/cart/" + id);
                    Swal.fire("Đã xóa khỏi giỏ hàng !", "", "success");
                    setTimeout(() => {
                        location.href = "#cart";
                    }, 100);
                }
            });
        };

        //giảm số lượng trong cart
        $scope.giam = function (idCartDetail, idProductDetail, idColor, idSize) {
            var getQuanity = parseInt(
                document.getElementById("qty" + idCartDetail).value
            );
            getQuanity = getQuanity - 1;
            //nếu product về số lượng là 0 thì check có thể xóa
            if (getQuanity <= 0) {
                $scope.deleteByCart(idCartDetail);
                getQuanity = 1;
                return;
            }
            //get đơn giá ở thời điểm hiện tại
            $http
                .get("http://localhost:8080/api/ctsp/" + idProductDetail)
                .then(function (response) {
                    var unitPrice = 0;
                    if (response.data.giamGia > 0) {
                        unitPrice =
                            response.data.giaBan -
                            response.data.giaBan * (response.data.giamGia * 0.01);
                    } else {
                        unitPrice = response.data.giaBan;
                    }

                    // nếu thỏa mãn thì giảm số lượng trong giỏ hàng
                    $http
                        .put("http://localhost:8080/api/cart/updateCart/" + idCartDetail, {
                            idCart : idGioHang,
                            idProductDetail: idProductDetail,
                            idColor: idColor,
                            idSize: idSize,
                            soLuong: getQuanity,
                            donGia: unitPrice,
                        })
                        .then(function (cart) {
                            if (cart.status === 200) {
                                //load lại sau khi giảm thành công !
                                $scope.loadCart();
                            }
                        });
                });
        };
        // tăng số lượng trong giỏ
        $scope.tang = function (idCartDetail, idProductDetail, idColor, idSize) {
            // check số lượng của sản phẩm đang còn
            var params = {
                IdProduct: idProductDetail,
                IdColor: idColor,
                IdSize: idSize,
            };
            $http({
                method: "GET",
                url: "http://localhost:8080/api/kichthuoc-mausac-ctsp/getQuantityProductAndColorAndSize",
                params: params,
            }).then(function (resp) {
                $scope.quantity = resp.data;

                if (
                    document.getElementById("qty" + idCartDetail).value >= $scope.quantity
                ) {
                    Swal.fire(
                        "Số lượng đã đến mức tối đa số lượng sản phẩm hiện có !",
                        "",
                        "error"
                    );
                    return;
                }
                document.getElementById("qty" + idCartDetail).value =
                    parseInt(document.getElementById("qty" + idCartDetail).value) + 1;

                //get đơn giá ở thời điểm hiện tại
                $http
                    .get("http://localhost:8080/api/ctsp/" + idProductDetail)
                    .then(function (response) {
                        var unitPrice = 0;
                        if (response.data.giamGia > 0) {
                            unitPrice =
                                response.data.giaBan -
                                response.data.giaBan * (response.data.giamGia * 0.01);
                        } else {
                            unitPrice = response.data.giaBan;
                        }

                        // nếu thỏa mãn thì tăng số lượng trong giỏ hàng
                        $http
                            .put(
                                "http://localhost:8080/api/cart/updateCart/" + idCartDetail,
                                {
                                    idCart : idGioHang,
                                    idProductDetail: idProductDetail,
                                    idColor: idColor,
                                    idSize: idSize,
                                    soLuong: parseInt(
                                        document.getElementById("qty" + idCartDetail).value
                                    ),
                                    donGia: unitPrice,
                                }
                            )
                            .then(function (cart) {
                                if (cart.status === 200) {
                                    //load lại sau khi tăng thành công !
                                    $scope.loadCart();
                                }
                            });
                    });
            });
        };

        $scope.EnterQuantity = function (
            idCartDetail,
            idProductDetail,
            idColor,
            idSize
        ) {
            var numberRegex = /^[0-9]+$/;
            if (
                !numberRegex.test(document.getElementById("qty" + idCartDetail).value)
            ) {
                Swal.fire("Số lượng phải là số nguyên dương !!", "", "error");
                $http
                    .get(
                        "http://localhost:8080/api/cart/getQuantityByCartDetail/" +
                        idCartDetail
                    )
                    .then(function (resp) {
                        document.getElementById("qty" + idCartDetail).value = resp.data;
                    });
                return;
            }
            var params = {
                IdProduct: idProductDetail,
                IdColor: idColor,
                IdSize: idSize,
            };
            $http({
                method: "GET",
                url: "http://localhost:8080/api/kichthuoc-mausac-ctsp/getQuantityProductAndColorAndSize",
                params: params,
            }).then(function (resp) {
                $scope.quantity = resp.data;

                if (
                    document.getElementById("qty" + idCartDetail).value > $scope.quantity
                ) {
                    Swal.fire(
                        "Số lượng đã đến mức tối đa số lượng sản phẩm hiện có !",
                        "",
                        "error"
                    );
                    $http
                        .get(
                            "http://localhost:8080/api/cart/getQuantityByCartDetail/" +
                            idCartDetail
                        )
                        .then(function (resp) {
                            document.getElementById("qty" + idCartDetail).value = resp.data;
                        });
                } else {
                    //get đơn giá ở thời điểm hiện tại
                    $http
                        .get("http://localhost:8080/api/ctsp/" + idProductDetail)
                        .then(function (response) {
                            var unitPrice = 0;
                            if (response.data.giamGia > 0) {
                                unitPrice =
                                    response.data.giaBan -
                                    response.data.giaBan * (response.data.giamGia * 0.01);
                            } else {
                                unitPrice = response.data.giaBan;
                            }

                            // nếu thỏa mãn thì tăng số lượng trong giỏ hàng
                            $http
                                .put(
                                    "http://localhost:8080/api/cart/updateCart/" + idCartDetail,
                                    {
                                        idCart : idGioHang,
                                        idProductDetail: idProductDetail,
                                        idColor: idColor,
                                        idSize: idSize,
                                        soLuong: parseInt(
                                            document.getElementById("qty" + idCartDetail).value
                                        ),
                                        donGia: unitPrice,
                                    }
                                )
                                .then(function (cart) {
                                    if (cart.status === 200) {
                                        //load lại sau khi tăng thành công !
                                        $scope.loadCart();
                                    }
                                });
                        });
                }
            });
        };
        $scope.checkCheckOut = function(){
            //load cart by user
            $scope.listCartCheck = [];
            $http.get("http://localhost:8080/api/cart/"+idKhachHang).then(function (cart) {
                $scope.listCartCheck = cart.data;
                if($scope.listCartCheck.length === 0){
                    Swal.fire('Giỏ hàng của bạn đang rỗng !','','error');
                    return

                }
                else{
                    location.href = "/client/thanh-toan"
                }


            });
        }
    };
    $scope.loadCart();


})