
let url = "http://localhost:8080/api/hoa-don";
let app = angular.module("myApp", []);
app.controller("ctrl", function ($scope, $http){
    $scope.listHD = [];
    $http.get(url).then(function (response) {
        $scope.listHD = response.data;
    });
});


