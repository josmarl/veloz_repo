/* global SERVER, ACTIVE */

'use strict';

app.controller('productoController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', 'toastr',
    function ($scope, $rootScope, $http, $location, $routeParams, toastr) {

        $scope.headingTitle = "Configuración de Productos";
        $scope.productos = [];
        $scope.producto = {};
        $scope.idProducto = $routeParams.id;
        $scope.estadoForm = true;
        $scope.medidas = [];

        $scope.initialize = function () {
            $scope.loadData();
            $scope.listMedidas();
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
                toastr.success('Producto Registrado Correctamente!', 'Mensaje!');
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
                if ($scope.producto.estado === 1) {
                    $scope.producto.estadoBoolean = true;
                } else {
                    $scope.producto.estadoBoolean = false;
                }
            }).error(function (err) {
                console.log(err);
            });
        };

        $scope.validarExitsProductoNombreCode = function () {
            $http({
                url: SERVER + "/producto/find/name/" + $scope.producto.nombre + "/" + $scope.producto.marca,
                method: "GET",
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                }
            }).success(function (response) {
                if (response) {
                    toastr.error('El producto ya ha sido registrado!', 'Error!');
                    $scope.estadoForm = false;
                } else {
                    toastr.success('El producto está disponible!', 'Mensaje!');
                    $scope.estadoForm = true;
                }
            }).error(function (err) {

            });
        };

        $scope.validarExitsProductoCode = function () {
            $http({
                url: SERVER + "/producto/find/code/" + $scope.producto.code,
                method: "GET",
                headers: {
                    'Content-Type': 'application/json; charset=UTF-8'
                }
            }).success(function (response) {
                if (response) {
                    toastr.error('El producto ya ha sido registrado!', 'Error!');
                    $scope.estadoForm = false;
                } else {
                    toastr.success('El código está disponible!', 'Mensaje!');
                    $scope.estadoForm = true;
                }
            }).error(function (err) {

            });
        };

        $scope.confirmDeleteModalProducto = function (id) {
            $('#deleteModal').modal();
            $("#deleteButton").click(function () {
                $scope.removeProducto(id);
                $('#deleteModal').modal('hide');
            });
        };

        $scope.listMedidas = function () {
            $http({
                url: SERVER + "/producto/medida/find/active",
                method: "GET"
            }).success(function (response) {
                $scope.medidas = response;
                console.log(response);
            }).error(function (err) {
                console.log(err);
            });
        };

        $scope.initialize();

    }]);
