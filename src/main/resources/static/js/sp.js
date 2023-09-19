
    let url = "http://localhost:8080/api/sanpham";
    let app = angular.module("myApp", []);
    app.controller("ctrl", function ($scope, $http){
        $scope.list = [];
        $http.get(url).then(function (response) {
            $scope.list = response.data;
        });
    });


