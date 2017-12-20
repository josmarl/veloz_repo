/**
 * Created by josmarl on 02/05/2017.
 */
/* global SERVER, ACTIVE */

'use strict';

app.controller('almacenController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', 'toastr', function ($scope, $rootScope, $http, $location, $routeParams, toastr) {

    $scope.headingTitle = "Configuración de Almacén";
    $scope.almacenes = [];
    $scope.detalles = [];
    $scope.almacen = {};
    $scope.cliente = {};
    $scope.cliente.originalObject = {};
    $scope.idAlmacen = $routeParams.id;
    $scope.total = 0;

    $scope.initialize = function () {
        $scope.loadData();
        $scope.getProductos();
        $scope.getClientes();
        if ($scope.idAlmacen) {
            $scope.findAlmacen();
        }
    };

    $scope.loadData = function () {
        $http({
            url: SERVER + "/almacen/all",
            method: "GET"
        }).success(function (response) {
            $scope.almacenes = response;
        }).error(function (err) {
            console.log(err);
        });
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

    $scope.getClientes = function () {
        $http({
            url: SERVER + "/cliente/all",
            method: "GET"
        }).success(function (response) {
            $scope.clientes = response;
        }).error(function (err) {
            console.log(err);
        });
    };


    $scope.agregar = function () {

        var detalle = {};

        detalle.producto = $scope.prod.originalObject;
        detalle.cantidad = $scope.cantidad;
        detalle.importe = $scope.importe;

        var existe = 0;
        var nExiste = 0;

        if ($scope.detalles.length == 0) {
            $scope.detalles.push(detalle);
        } else {
            for (var i = 0; i < $scope.detalles.length; i++) {
                if ($scope.detalles[i].producto == detalle.producto) {
                    $scope.detalles[i].cantidad = parseInt($scope.detalles[i].cantidad) + parseInt(detalle.cantidad);
                    $scope.detalles[i].importe = parseFloat($scope.detalles[i].importe) + parseFloat(detalle.importe);
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

        $scope.total = parseFloat($scope.total) + parseFloat(detalle.importe);

    };

    $scope.deleteDetalle = function (detalle) {
        var index = $scope.detalles.indexOf(detalle);
        $scope.total = parseFloat($scope.total) - parseFloat($scope.detalles[index].importe);
        $scope.detalles.splice(index, 1);
    }

    $scope.validarDetalleAlmacen = function () {
        if ($scope.detalles.length > 0) {
            return false;
        } else {
            return true;
        }
    }

    $scope.guardarAlmacen = function () {

        var cli = {};

        if ($scope.cliente == null) {
            cli.id = undefined;
            cli.razonSocial = $("#ex4_value").val();
        } else {
            cli = $scope.cliente.originalObject;
        }


        $http({
            url: SERVER + '/almacen/save',
            data: {
                cliente: cli,
                nroDoc: $scope.nroDoc,
                detalles: $scope.detalles
            },
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            toastr.success('Documento procesado correctamente!', 'Mensaje!');
            $scope.detalles = [];
            $scope.cliente.originalObject = '';
            $scope.cantidad = 0;
            $scope.prod.originalObject = '';
            $location.path("/almacen");
        }).error(function (err) {
            console.log(err);
        });


    }

    $scope.findAlmacen = function () {
        $http({
            url: SERVER + "/almacen/find/" + $scope.idAlmacen,
            method: "GET",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (response) {
            $scope.almacen = response;
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.editAlmacen = function () {

        $http({
            url: SERVER + '/almacen/edit',
            data: $scope.almacen,
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $location.path("/almacen");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.removeAlmacen = function (id) {
        $http({
            url: SERVER + "/almacen/remove/" + id,
            method: "DELETE"
        }).success(function (response) {
            $scope.loadData();
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.seleccionarNroDoc = function () {
        $('#seleccionarNroDocModal').modal();
        $("#guardarButton").click(function () {
            $('#seleccionarNroDocModal').modal('hide');
        });
    };

    $scope.validarAlmacen = function () {
        if ($("#ex4_value").val() != undefined) {
            return false;
        } else {
            return true;
        }
    }

    $scope.confirmDeleteModalAlmacen = function (id) {
        $('#deleteModal').modal();
        $("#deleteButton").click(function () {
            $scope.removeAlmacen(id);
            $('#deleteModal').modal('hide');
        });
    };


    $scope.initialize();

}]);