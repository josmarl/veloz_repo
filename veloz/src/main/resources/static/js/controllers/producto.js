/* global SERVER, ACTIVE */

'use strict';

app.controller('productoController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', function ($scope, $rootScope, $http, $location, $routeParams) {

    $scope.headingTitle = "Configuración de Productos";
    $scope.productos = [];
    $scope.producto = {};
    $scope.idProducto = $routeParams.id;

    $scope.initialize = function () {
        $scope.loadData();
        if ($scope.idProducto) {
            $scope.findProducto();
        }
    };

    $scope.loadData = function () {
        $http({
            url: SERVER + "/producto/all",
            method: "GET"
        }).success(function (response) {
            $scope.productos = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.saveProducto = function () {

        if ($scope.producto.estadoBoolean == true) {
            $scope.producto.estado = 1;
        } else {
            $scope.producto.estado = 0;
        }

        $http({
            url: SERVER + '/producto/add',
            data: $scope.producto,
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $location.path("/producto");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.editProducto = function () {

        if ($scope.producto.estadoBoolean == true) {
            $scope.producto.estado = 1;
        } else {
            $scope.producto.estado = 0;
        }

        $http({
            url: SERVER + '/producto/edit',
            data: $scope.producto,
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $location.path("/producto");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.removeProducto = function (id) {
        $http({
            url: SERVER + "/producto/remove/" + id,
            method: "DELETE"
        }).success(function (response) {
            $scope.loadData();
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.findProducto = function () {
        $http({
            url: SERVER + "/producto/find/" + $scope.idProducto,
            method: "GET",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (response) {
            $scope.producto = response;
            if ($scope.producto.estado == 1) {
                $scope.producto.estadoBoolean = true;
            } else {
                $scope.producto.estadoBoolean = false;
            }
        }).error(function (err) {
            console.log(err);
        });
    };


    $scope.confirmDeleteModalProducto = function (id) {
        $('#deleteModal').modal();
        $("#deleteButton").click(function () {
            $scope.removeProducto(id);
            $('#deleteModal').modal('hide');
        });
    };


    $scope.initialize();

}]);
