/* global SERVER, ACTIVE */

'use strict';

app.controller('clienteController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', 'toastr', function ($scope, $rootScope, $http, $location, $routeParams, toastr) {

    $scope.headingTitle = "Configuración de Clientes";
    $scope.clientes = [];
    $scope.idCliente = $routeParams.id;

    $scope.initialize = function () {
        $scope.loadData();

        if ($scope.idCliente) {
            $scope.findCliente();
        }
    };


    $scope.loadData = function () {
        $http({
            url: SERVER + "/cliente/all",
            method: "GET"
        }).success(function (response) {
            $scope.clientes = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.saveCliente = function () {
        $http({
            url: SERVER + '/cliente/add',
            data: $scope.cliente,
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $location.path("/cliente");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.findCliente = function () {
        $http({
            url: SERVER + "/cliente/find/" + $scope.idCliente,
            method: "GET",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (response) {
            $scope.cliente = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.editCliente = function () {
        $http({
            url: SERVER + '/cliente/edit',
            data: $scope.cliente,
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $location.path("/cliente");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.removeCliente = function (id) {
        $http({
            url: SERVER + "/cliente/remove/" + id,
            method: "DELETE"
        }).success(function (response) {
            $scope.loadData();
        }).error(function (err) {
            console.log(err);
            toastr.error('No se pudo Eliminar porque el cliente está asociado a una venta anterior!', 'Error!');
        });
    };

    $scope.confirmDeleteModalCliente = function (id) {
        $('#deleteModal').modal();
        $("#deleteButton").click(function () {
            $scope.removeCliente(id);
            $('#deleteModal').modal('hide');
        });
    };


    $scope.initialize();

}]);