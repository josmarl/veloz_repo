/* global SERVER, ACTIVE */

'use strict';

app.controller('reportesController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', 'toastr', function ($scope, $rootScope, $http, $location, $routeParams, toastr) {

    $scope.headingTitle = "Reporte de : --- ";
    $scope.reporte = {};
    $scope.nreportes = [];
    $scope.almacenesConsolidado = [];
    $scope.ventas = [];
    $scope.viewReporteAlmacen = false;
    $scope.viewReporteVentas = false;
    $scope.idReporte = $routeParams.id;

    $scope.initialize = function () {
        $scope.getReportes();
    }

    $scope.getReportes = function () {
        $http({
            url: SERVER + "/reportes/nreportes",
            method: "GET"
        }).success(function (response) {
            $scope.nreportes = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.findReporteName = function () {
        if ($scope.nreporte == 1) {
            $scope.headingTitle = "Reporte de : Almacén Consolidado";
        } else {
            $scope.headingTitle = "Reporte de : Ventas";
        }
        $scope.viewReporteAlmacen = false;
        $scope.viewReporteVentas = false;
    }


    $scope.findReporte = function () {
        $http({
            url: SERVER + "/reportes/find/" + $scope.nreporte,
            method: "GET"
        }).success(function (response) {
            $scope.reporte = response.object;
            if ($scope.nreporte == 1) {
                $scope.viewReporteAlmacen = true;
                $scope.viewReporteVentas = false;
            } else {
                $scope.viewReporteAlmacen = false;
                $scope.viewReporteVentas = true;
            }
        }).error(function (err) {
            console.log(err);
        });
    }


    $scope.initialize();

}]);