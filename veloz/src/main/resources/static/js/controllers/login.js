/* global SERVER, ACTIVE */

'use strict';

app.controller('navigation', function ($scope, $rootScope, $http, $location, $route) {

    var self = this;

    self.tab = function (route) {
        return $route.current && route === $route.current.controller;
    };

    var authenticate = function (credentials, callback) {

        var headers = credentials ? {
            authorization: "Basic "
            + btoa(credentials.username + ":"
                + credentials.password)
        } : {};

        $http.get(SERVER + '/user', {
            headers: headers
        }).then(function (response) {
            if (response.data.name) {
                $rootScope.userName = response.data.name;
                $rootScope.authenticated = true;
                for (var i = 0; i < response.data.authorities.length; i++) {
                    if (response.data.authorities[i].name == "ROLE_ADMIN") {
                        $rootScope.authenticatedAdmin = true;
                        break;
                    }
                }
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback($rootScope.authenticated);
        }, function () {
            $rootScope.authenticated = false;
            callback && callback(false);
        });

    };

    authenticate();

    self.credentials = {};
    self.login = function () {
        authenticate(self.credentials, function (authenticated) {
            if (authenticated) {
                console.log("Login succeeded")
                $location.path("/home");
                self.error = false;
                $rootScope.authenticated = true;
            } else {
                console.log("Login failed")
                $location.path("/login");
                self.error = true;
                $rootScope.authenticated = false;
            }
        })
    };

    self.logout = function () {
        $http.post(SERVER + '/logout', {}).finally(function () {
            $rootScope.authenticated = false;
            $rootScope.authenticatedAdmin = false;
            $location.path("/login");
        });
    };

});
