(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('loginController', function ($scope, $location, toastr, toastrConfig) {
           
            toastrConfig.maxOpened = 1;
            toastrConfig.autoDismiss = true;
            toastrConfig.timeOut = 3000;
            toastrConfig.positionClass = 'toast-top-center';
        
            function init() {
               	$scope.error = $location.search().error;
                $scope.logout = $location.search().logout;
            }
        
            init();

        });
})();