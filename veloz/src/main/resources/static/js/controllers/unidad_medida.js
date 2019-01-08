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
        if ($scope.medida.estadoBoolean) {
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
            $scope.medida = response;
            if ($scope.medida.estado === 1) {
                $scope.medida.estadoBoolean = true;
            } else {
                $scope.medida.estadoBoolean = false;
            }
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.editMedida = function () {
        if ($scope.medida.estadoBoolean) {
            $scope.medida.estado = 1;
        } else {
            $scope.medida.estado = 0;
        }

        $http({
            url: SERVER + '/medida/edit',
            data: $scope.medida,
            method: "PUT",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $location.path("/medida");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.removeMedida = function (id) {
        $http({
            url: SERVER + "/medida/remove/" + id,
            method: "DELETE"
        }).success(function (response) {
            $scope.loadData();
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.confirmDeleteModalMedida = function (id) {
        console.log('ssssssss');
        $('#deleteModal').modal();
        $("#deleteButton").click(function () {
            $scope.removeMedida(id);
            $('#deleteModal').modal('hide');
        });
    };

    $scope.initialize();

}]);