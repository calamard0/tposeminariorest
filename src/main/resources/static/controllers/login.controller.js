(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('loginController', function ($scope, $location, toastr, toastrConfig, $http) {
           
            toastrConfig.maxOpened = 1;
            toastrConfig.autoDismiss = true;
            toastrConfig.timeOut = 3000;
            toastrConfig.positionClass = 'toast-top-center';
        
            function init() {
               	$scope.error = $location.search().error;
                $scope.logout = $location.search().logout;
                
                 $http.post('/currentuser')
                    .success(function (data) {
                        if(data.id > 0) {
                        	$scope.username = data.nombreUsuario;
                        }
                    })
                    .error(function (data) {
                        console.log(data);
                    });
                
                
            }
        
            init();

        });
})();