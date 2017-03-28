/* global SERVER, ACTIVE */

'use strict';

app.controller('ventaController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', function ($scope, $rootScope, $http, $location, $routeParams) {

    $scope.headingTitle = "Ventas";
    $scope.productos = [];
    $scope.ventas = [];
    $scope.detalles = [];
    $scope.prod = {};

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

    $scope.agregar = function () {

        var detalle = {};

        detalle.producto = $scope.prod;
        detalle.cantidad = $scope.cantidad;

        console.log(detalle.producto.id)

        $scope.detalles.push(detalle);

    };


    $scope.initialize();

}]);

