/* global SERVER, ACTIVE */

'use strict';

app.controller('usuarioController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', function ($scope, $rootScope, $http, $location, $routeParams) {

    $scope.headingTitle = "Configuración de Usuarios";

    $scope.usuarios = [];
    $scope.usuario = {};
    $scope.roles = {};
    $scope.idUsuario = $routeParams.id;

    $scope.initialize = function () {
        $scope.loadData();
        $scope.listRoles();
        if ($scope.idUsuario) {
            $scope.findUsuario();
            $scope.listRolesByUsuario();
        }
    };

    $scope.saveUsuario = function () {
        $http({
            url: SERVER + '/usuario/add',
            data: {
                usuario: $scope.usuario,
                roles: $scope.roles
            },
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $location.path("/usuario");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.loadData = function () {
        $http({
            url: SERVER + "/usuario/all",
            method: "GET"
        }).success(function (response) {
            $scope.usuarios = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.editUsuario = function () {
        $http({
            url: SERVER + '/usuario/edit',
            data: {
                usuario: $scope.usuario,
                roles: $scope.roles
            },
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $location.path("/usuario");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.confirmDeleteUsuario = function (id) {
        $('#deleteModal').modal();
        $("#deleteButton").click(function () {
            $scope.removeUsuario(id);
            $('#deleteModal').modal('hide');
        });
    };

    $scope.removeUsuario = function (id) {
        $http({
            url: SERVER + "/usuario/remove/" + id,
            method: "DELETE"
        }).success(function (response) {
            $scope.loadData();
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.findUsuario = function () {
        $http({
            url: SERVER + "/usuario/find/" + $scope.idUsuario,
            method: "GET",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (response) {
            $scope.usuario = response;
        }).error(function (err) {
            console.log(err);
        });
    };


    $scope.confirmDeleteModalUsuario = function (id) {
        $('#deleteModal').modal();
        $("#deleteButton").click(function () {
            $scope.removeUsuario(id);
            $('#deleteModal').modal('hide');
        });
    };


    $scope.listRoles = function () {
        $http({
            url: SERVER + "/usuario/role/all",
            method: "GET"
        }).success(function (response) {
            $scope.roles = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.listRolesByUsuario = function () {
        $http({
            url: SERVER + "/usuario/role/" + $scope.idUsuario,
            method: "GET"
        }).success(function (response) {
            $scope.roles = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.initialize();

}]);
