/* global SERVER, ACTIVE */

'use strict';

app.controller('ventaController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', function ($scope, $rootScope, $http, $location, $routeParams) {

    $scope.headingTitle = "Ventas";

    $scope.productos = [];
    $scope.producto = {};
    $scope.ventas = [];

    $scope.initialize = function () {
        $scope.getProductos();
    };

    $scope.getProductos = function () {
        $http({
            url: SERVER + "/producto/all",
            method: "GET"
        }).success(function (response) {
            $scope.productos = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.addCar = function () {

        for(){

        }

    };


    $scope.initialize();

}]);

