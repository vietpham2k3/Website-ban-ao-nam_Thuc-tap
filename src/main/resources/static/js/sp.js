
    let url = "http://localhost:8080/api/sanpham";
    let urldanhmuc = "http://localhost:8080/api/danhmuc";
    let urlthuonghieu = "http://localhost:8080/api/thuonghieu";
    let urlphanloai = "http://localhost:8080/api/phanloai";
    let urlxuatxu = "http://localhost:8080/api/xuatxu";
    let urlphongcach = "http://localhost:8080/api/phongcach";
    let urlchatlieu = "http://localhost:8080/api/chatlieu";
    let urlmausac = "http://localhost:8080/api/mausac";
    let urlkichthuoc = "http://localhost:8080/api/kichthuoc";
    let app = angular.module("myApp", []);
    app.controller("ctrl", function ($scope, $http){
        $scope.list = [];
        $http.get(url).then(function (response) {
            $scope.list = response.data;
        });
        $scope.listDM = [];
        $http.get(urldanhmuc).then(function (response) {
            $scope.listDM = response.data;
        });
        $scope.listTH = [];
        $http.get(urlthuonghieu).then(function (response) {
            $scope.listTH = response.data;
        });
        $scope.listPL = [];
        $http.get(urlphanloai).then(function (response) {
            $scope.listPL = response.data;
        });
        $scope.listXX = [];
        $http.get(urlxuatxu).then(function (response) {
            $scope.listXX = response.data;
        });
        $scope.listPC = [];
        $http.get(urlphongcach).then(function (response) {
            $scope.listPC = response.data;
        });
        $scope.listCL = [];
        $http.get(urlchatlieu).then(function (response) {
            $scope.listCL = response.data;
        });
        $scope.listMS = [];
        $http.get(urlmausac).then(function (response) {
            $scope.listMS = response.data;
        });
        $scope.listKT = [];
        $http.get(urlkichthuoc).then(function (response) {
            $scope.listKT = response.data;
        });



        $scope.checkbox = function(mausac) {
            let listMS1 =  $scope.listMS;
            let listKT1 =  $scope.listKT;
                // Get the checkbox
            var checkBox = document.getElementById(mausac);
            // Get the output text
            var text = document.getElementById("text" + mausac);
                // If the checkbox is checked, display the output text
               for(let i = 0 ; i < listMS1.length; i++){
                   if (listMS1[i].idMauSac === mausac){
                       if (checkBox.checked == true){
                           text.innerHTML += '<div><label>Số lượng '+ listMS1[i].tenMauSac +'</label>';
                           for(let j = 0 ; j < listKT1.length; j++){
                               text.innerHTML += '<span style="padding-left: 10px; padding-bottom: 10px">Size</span> '+listKT1[j].tenKichThuoc+' <input id="'+listKT1[j].idKichThuoc+'" type="number" value="0" style="width: 50px">';
                           }
                           text.innerHTML += '</div>';
                       } else {
                           text.innerHTML = '';
                       }
                   }
               }

        };

    });


