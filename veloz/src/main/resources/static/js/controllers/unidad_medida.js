/* global SERVER, ACTIVE */

'use strict';

app.controller('unidadMedidaController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', 'toastr', function ($scope, $rootScope, $http, $location, $routeParams, toastr) {

    $scope.headingTitle = "Configuración de unidad de medida";
    $scope.medidas = [];
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

    $scope.initialize();

}]);