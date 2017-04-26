'use strict';
var app = angular.module('app', [
    'ngResource',
    'ngRoute',
    'ngAnimate',
    'toastr',
    'angucomplete'
]);

//var SERVER = 'http://192.168.42.188:8083';
var SERVER = 'http://localhost:8083';

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

        .otherwise('/login');

    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}]);

