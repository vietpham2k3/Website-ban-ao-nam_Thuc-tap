
let myapp = angular.module("myApp", []);
myapp.controller ('CtspController', function ($scope , $http){

    $scope.loadAll = function (){
        // hien thi san pham
        $scope.list = [];
        $http.get("http://localhost:8080/api/ctsp/ProductNew").then(function (response){
            $scope.list = response.data;
        })
    }
    $scope.loadAll()
    // san pham ban chay
    $scope.loadSanPhamBanChay = function (){
        $scope.list1 = [];
        $http.get("http://localhost:8080/api/ctsp/ProductBanChay").then(function (response){
            $scope.list1 = response.data;
        })

    }

});