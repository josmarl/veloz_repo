'use strict';
var app = angular.module('app', [
    'ngResource',
    'ngRoute',
    'ngAnimate',
    'toastr',
    'angucomplete'
]);

//var SERVER = 'http://138.68.255.126:8088';
//var SERVER_IP = '138.68.255.126';

var SERVER = 'http://localhost:8088';
var SERVER_IP = 'localhost';

var ACTIVE = '1';
var INACTIVE = '0';
app.config(['$routeProvider', '$locationProvider', '$httpProvider', function ($routeProvider, $locationProvider, $httpProvider) {
        $routeProvider
                .when('/login', {
                    templateUrl: 'login.html',
                    controller: 'navigation',
                    controllerAs: 'controller'
                })
                .when('/home', {
                    templateUrl: 'home.html'
                })
                .when('/usuario', {
                    templateUrl: 'views/usuario/usuario.html',
                    controller: 'usuarioController'
                })
                .when('/usuario/new', {
                    templateUrl: 'views/usuario/usuario_form.html',
                    controller: 'usuarioController'
                })
                .when('/usuario/edit/:id', {
                    templateUrl: 'views/usuario/usuario_edit.html',
                    controller: 'usuarioController'
                })
                .when('/producto', {
                    templateUrl: 'views/producto/producto.html',
                    controller: 'productoController'
                })
                .when('/producto/new', {
                    templateUrl: 'views/producto/producto_form.html',
                    controller: 'productoController'
                })
                .when('/producto/edit/:id', {
                    templateUrl: 'views/producto/producto_edit.html',
                    controller: 'productoController'
                })
                .when('/persona', {
                    templateUrl: 'views/persona/persona.html',
                    controller: 'personaController'
                })
                .when('/venta', {
                    templateUrl: 'views/venta/venta.html',
                    controller: 'ventaController'
                })
                .when('/almacen', {
                    templateUrl: 'views/almacen/almacen.html',
                    controller: 'almacenController'
                })
                .when('/almacen/new', {
                    templateUrl: 'views/almacen/almacen_form.html',
                    controller: 'almacenController'
                })
                .when('/almacen/edit/:id', {
                    templateUrl: 'views/almacen/almacen_edit.html',
                    controller: 'almacenController'
                })
                .when('/cliente', {
                    templateUrl: 'views/cliente/cliente.html',
                    controller: 'clienteController'
                })
                .when('/cliente/new', {
                    templateUrl: 'views/cliente/cliente_form.html',
                    controller: 'clienteController'
                })
                .when('/cliente/edit/:id', {
                    templateUrl: 'views/cliente/cliente_edit.html',
                    controller: 'clienteController'
                })
                .when('/reportes', {
                    templateUrl: 'views/reportes/reportes.html',
                    controller: 'reportesController'
                })

                .otherwise('/login');

        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    }]);

