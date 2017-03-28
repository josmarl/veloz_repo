/* global SERVER, ACTIVE */

'use strict';

app.controller('ventaController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', function ($scope, $rootScope, $http, $location, $routeParams) {

    $scope.headingTitle = "Ventas";
    $scope.productos = [];
    $scope.ventas = [];
    $scope.detalles = [];
    $scope.detalle = {};

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


        $scope.detalles.push(
            {
                producto: $scope.prod,
                cantidad: $scope.cantidad
            }
        );

        for (var j = 0; j < $scope.detalles.length; j++) {
            console.log($scope.detalles[j].producto.nombre);
        }
    };


    $scope.initialize();

}]);

