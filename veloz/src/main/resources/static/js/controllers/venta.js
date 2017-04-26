/* global SERVER, ACTIVE */

'use strict';

app.controller('ventaController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', function ($scope, $rootScope, $http, $location, $routeParams) {

    $scope.headingTitle = "Ventas";
    $scope.productos = [];
    $scope.tipoComprobantes = [];
    $scope.ventas = [];
    $scope.detalles = [];
    $scope.detallesProducto = [];
    $scope.prod = {};

    $scope.initialize = function () {
        $scope.getProductos();
        $scope.getTipoComprobantes();
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


    $scope.getTipoComprobantes = function () {
        $http({
            url: SERVER + "/tipoComprobante/all",
            method: "GET"
        }).success(function (response) {
            $scope.tipoComprobantes = response;
            console.log($scope.tipoComprobantes)
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.agregar = function () {

        var detalle = {};

        detalle.producto = $scope.prod.originalObject;
        detalle.cantidad = $scope.cantidad;
        detalle.precioUnitario = 0;

        var existe = 0;
        var nExiste = 0;

        if ($scope.detalles.length == 0) {
            $scope.detalles.push(detalle);
        } else {
            for (var i = 0; i < $scope.detalles.length; i++) {
                if ($scope.detalles[i].producto == detalle.producto) {
                    $scope.detalles[i].cantidad = parseInt($scope.detalles[i].cantidad) + parseInt(detalle.cantidad);
                    existe = parseInt(existe) + 1;
                } else {
                    nExiste = parseInt(nExiste) + 1;
                }
            }
        }

        if (existe == 0) {
            if (nExiste >= 1) {
                $scope.detalles.push(detalle);
            }
        }

        $http({
            url: SERVER + '/venta/add',
            data: {
                detalles: $scope.detalles,
            },
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            console.log(data)
            $scope.detallesProducto = data;
            $location.path("/venta");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.deleteDetalle = function (detalle) {
        var index = $scope.detallesProducto.indexOf(detalle);
        $scope.detallesProducto.splice(index, 1);
        $scope.detalles.splice(index, 1);
    }


    $scope.initialize();

}]);

