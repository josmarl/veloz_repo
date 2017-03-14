/* global SERVER, ACTIVE */

'use strict';

app.controller('productoController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', function($scope, $rootScope, $http, $location, $routeParams) {

    $scope.headingTitle = "Configuración de Productos";
    $scope.productos = [];
    $scope.producto = {};
    $scope.idProducto = $routeParams.id;

    $scope.initialize = function() {
        $scope.loadData();
        if ($scope.idProducto) {
            $scope.findProducto();
            //$scope.listRolesByUsuario();
        }
    };
    /*
        $scope.saveUsuario = function() {
            console.log($scope.roles);
            console.log($scope.usuario);
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
            }).success(function(data) {
                $location.path("/usuario");
            }).error(function(err) {
                console.log(err);
            });
        };
    */
    $scope.loadData = function() {
        $http({
            url: SERVER + "/producto/all",
            method: "GET"
        }).success(function(response) {
            $scope.productos = response;
        }).error(function(err) {
            console.log(err);
        });
    };

    /*  $scope.editUsuario = function() {
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
          }).success(function(data) {
              $location.path("/usuario");
          }).error(function(err) {
              console.log(err);
          });*/

    $scope.removeProducto = function(id) {
        $http({
            url: SERVER + "/producto/remove/" + id,
            method: "DELETE"
        }).success(function(response) {
            $scope.loadData();
        }).error(function(err) {
            console.log(err);
        });
    };

    $scope.findProducto = function() {
        $http({
            url: SERVER + "/producto/find/" + $scope.idProducto,
            method: "GET",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function(response) {
            $scope.producto = response;
        }).error(function(err) {
            console.log(err);
        });
    };


    $scope.confirmDeleteModalProducto = function(id) {
        $('#deleteModal').modal();
        $("#deleteButton").click(function() {
            $scope.removeProducto(id);
            $('#deleteModal').modal('hide');
        });
    };

    /*
        $scope.listRoles = function() {
            $http({
                url: SERVER + "/usuario/role/all",
                method: "GET"
            }).success(function(response) {
                $scope.roles = response;
                console.log($scope.roles);
            }).error(function(err) {
                console.log(err);
            });
        };

        $scope.listRolesByUsuario = function() {
            $http({
                url: SERVER + "/usuario/role/" + $scope.idUsuario,
                method: "GET"
            }).success(function(response) {
                $scope.roles = response;
                console.log($scope.roles);
            }).error(function(err) {
                console.log(err);
            });
        };
    */

    $scope.initialize();

}]);
