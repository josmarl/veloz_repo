/* global SERVER, ACTIVE */

'use strict';

app.controller('ventaController', ['$scope', '$rootScope', '$http', '$location', '$routeParams', 'toastr', function ($scope, $rootScope, $http, $location, $routeParams, toastr) {

    $scope.headingTitle = "Ventas";
    $scope.productos = [];
    $scope.tipoComprobantes = [];
    $scope.clientes = [];
    $scope.ventas = [];
    $scope.detalles = [];
    $scope.detallesProducto = [];
    $scope.prod = {};
    $scope.tipoComprobante = {};
    $scope.datosTipoComprobante = {};
    $scope.cliente = {};
    $scope.cliente.originalObject = {};

    $scope.initialize = function () {
        $scope.getClientes();
        $scope.getProductos();
        $scope.getTipoComprobantes();
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


    $scope.getTipoComprobantes = function () {
        $http({
            url: SERVER + "/tipoComprobante/all",
            method: "GET"
        }).success(function (response) {
            $scope.tipoComprobantes = response;
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
        detalle.precioUnitario = 0;

        var existe = 0;
        var nExiste = 0;

        if ($scope.detalles.length == 0) {
            $scope.detalles.push(detalle);
        } else {
            for (var i = 0; i < $scope.detalles.length; i++) {
                if ($scope.detalles[i].producto == detalle.producto) {
                    $scope.detalles[i].cantidad = parseInt($scope.detalles[i].cantidad) + parseInt(detalle.cantidad);
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

        $http({
            url: SERVER + '/venta/add',
            data: {
                detalles: $scope.detalles,
            },
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $scope.detallesProducto = data;
            $location.path("/venta");
        }).error(function (err) {
            console.log(err);
        });
    };

    $scope.deleteDetalle = function (detalle) {
        var index = $scope.detallesProducto.indexOf(detalle);
        $scope.detallesProducto.splice(index, 1);
        $scope.detalles.splice(index, 1);
    }

    $scope.validarDetalleVenta = function () {
        if ($scope.detallesProducto.length > 0) {
            return false;
        } else {
            return true;
        }
    }

    $scope.getDatosTipoComprobante = function () {

        $http({
            url: SERVER + '/venta/tipocomp/totales',
            data: {
                detalles: $scope.detallesProducto,
                tipoComprobante: $scope.tipoComprobante
            },
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            $scope.datosTipoComprobante = data;
            $location.path("/venta");
        }).error(function (err) {
            console.log(err);
        });
    }

    $scope.guardarVenta = function () {

        if ($scope.cliente.originalObject == undefined
            || $scope.cliente.originalObject.id == undefined
            || $scope.cliente.originalObject.razonSocial != $("#ex2_value").val()) {

            $scope.cliente.originalObject.id = undefined;
            $scope.cliente.originalObject.razonSocial = $("#ex2_value").val();
        }

        $http({
            url: SERVER + '/venta/save',
            data: {
                baseImponible: $scope.datosTipoComprobante.baseImponible,
                igv: $scope.datosTipoComprobante.igv,
                total: $scope.datosTipoComprobante.total,
                detalles: $scope.detallesProducto,
                tipoComprobante: $scope.tipoComprobante,
                cliente: $scope.cliente.originalObject
            },
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            toastr.success('Venta procesada correctamente!', 'Mensaje!');
            $scope.detallesProducto = [];
            $scope.tipoComprobante = {};
            $scope.cliente.originalObject = '';
            $scope.cantidad = 0;
            $scope.prod.originalObject = '';
            $location.path("/venta");
        }).error(function (err) {
            console.log(err);
        });

    }


    $scope.seleccionarTipoComp = function () {
        $('#seleccionarTipCompModal').modal();
        $("#guardarButton").click(function () {
            $('#seleccionarTipCompModal').modal('hide');
        });
    };

    $scope.validarVenta = function () {
        if ($scope.datosTipoComprobante.total > 0) {
            return false;
        } else {
            return true;
        }
    }

    $scope.initialize();

}]);

