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
    $scope.total = 0;

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
        var detalleTemp = {};
        $scope.detallesTemp = [];

        detalle.producto = $scope.prod.originalObject;
        detalle.cantidad = $scope.cantidad;
        detalle.precioUnitario = 0;

        var existe = 0;
        var nExiste = 0;


        if ($scope.detalles.length == 0 || $scope.detalles.size == 0) {
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


        for (var j = 0; j < $scope.detalles.length; j++) {
            if ($scope.detalles[j].producto == detalle.producto) {

                detalleTemp.producto = $scope.prod.originalObject;
                detalleTemp.cantidad = $scope.detalles[j].cantidad;
                detalleTemp.precioUnitario = 0;
                detalleTemp.cantidadStock = detalle.cantidad;
                $scope.detallesTemp.push(detalleTemp);
            }
        }

        $http({
            url: SERVER + '/venta/stock',
            data: {
                detalles: $scope.detallesTemp,
            },
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {

            if (data.object == false) {
                for (var j = 0; j < $scope.detalles.length; j++) {
                    if ($scope.detalles[j].producto == detalle.producto) {

                        var newCantidad = parseInt($scope.detalles[j].cantidad) - parseInt(detalle.cantidad)
                        $scope.detalles[j].cantidad = parseInt(newCantidad);

                        if ($scope.detalles[j].cantidad == 0) {
                            var index = $scope.detalles.indexOf(detalle);
                            $scope.detalles.splice(index, 1);
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
                            $scope.detallesProducto = data.detalles;
                            $scope.total = data.total;
                            $scope.detallesTemp = [];
                            $location.path("/venta");
                        }).error(function (err) {
                            console.log(err);
                        });
                    }
                    break;
                }

                toastr.error(data.msg, 'Error!');

            } else {
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
                    $scope.detallesProducto = data.detalles;
                    $scope.total = data.total;
                    $scope.detallesTemp = [];
                    $location.path("/venta");
                }).error(function (err) {
                    console.log(err);
                });
            }

        }).error(function (err) {
            console.log(err);
        });

        $scope.cliente = {};
        $scope.cliente.originalObject = {};
    };

    $scope.deleteDetalle = function (detalle) {

        var index = $scope.detallesProducto.indexOf(detalle);
        $scope.total = $scope.total - $scope.detallesProducto[index].importe;
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

    $scope.imprimir = function () {
        $http({
            url: SERVER + "/app/print",
            data: {ip: SERVER_IP},
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (response) {
            $scope.response = response;
            $scope.clearVenta();
            toastr.success($scope.response.msg, 'Mensaje!');
            $location.path("/venta");
        }).error(function (err) {
            $scope.clearVenta();
            console.log(err);
            $location.path("/venta");
        });
        $scope.clearVenta();
    }

    $scope.guardarVenta = function () {

        var cli = {};

        if ($scope.cliente == null) {
            cli.id = undefined;
            cli.razonSocial = $("#ex2_value").val();
        } else {
            cli = $scope.cliente.originalObject;
        }

        $http({
            url: SERVER + '/venta/save',
            data: {
                baseImponible: $scope.datosTipoComprobante.baseImponible,
                igv: $scope.datosTipoComprobante.igv,
                total: $scope.datosTipoComprobante.total,
                detalles: $scope.detallesProducto,
                tipoComprobante: $scope.tipoComprobante,
                cliente: cli
            },
            method: "POST",
            headers: {
                'Content-Type': 'application/json; charset=UTF-8'
            }
        }).success(function (data) {
            toastr.success('Venta procesada correctamente!', 'Mensaje!');
        }).error(function (err) {
            console.log(err);
        });

        $scope.imprimir();

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

    $scope.clearVenta = function () {
        $scope.tipoComprobante = {};
        $scope.cliente = {};
        $scope.cliente.originalObject = {};
        $scope.prod.originalObject = '';
        $scope.detalles = [];
        $scope.detallesTemp = [];
        $scope.detallesProducto = [];
        $scope.cantidad = '';
        $("#ex1").val('');
        $("#ex2").val('');
        $scope.prod = {};
    }

    $scope.initialize();

}]);

