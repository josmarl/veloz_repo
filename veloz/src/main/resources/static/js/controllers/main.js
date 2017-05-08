'use strict';

app.controller('mainController', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {
    $(function () {
        $("body").tooltip({
            selector: '[data-toggle="tooltip"]',
            container: 'table'
        });
    });

}]);