/* global SERVER, ACTIVE */

'use strict';

app.controller('unidadMedidaController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', 'toastr', function ($scope, $rootScope, $http, $location, $routeParams, toastr) {

    $scope.headingTitle = "Configuración de unidad de medida";
    $scope.medidas = [];
    $scope.medida = {};
    $scope.medidaId = $routeParams.id;

    $scope.initialize = function () {
        $scope.loadData();

        if ($scope.medidaId) {
            $scope.findUnidadMedida();
        }
    };

    $scope.loadData = function () {
        $http({
            url: SERVER + "/medida/all",
            method: "GET"
        }).success(function (response) {
            $scope.medidas = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.saveMedida = function () {
        if ($scope.medida.estadoBoolean == true) {
            $scope.medida.estado = 1;
        } else {
            $scope.medida.estado = 0;
        }
        $http({
            url: SERVER + "/medida/add",
            data: $scope.medida,
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (response) {
            $location.path("/medida");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.findUnidadMedida = function () {
        $http({
            url: SERVER + "/medida/find/" + $scope.medidaId,
            method: "GET",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (response) {
            $scope.unidadMedida = response;
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

    $scope.initialize();

}]);