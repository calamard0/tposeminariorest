(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('seleccionNivelController', function ($scope, toastr, toastrConfig) {
            
            var vm = this;
        
            toastrConfig.maxOpened = 1;
            toastrConfig.autoDismiss = true;
            toastrConfig.timeOut = 3000;
            toastrConfig.positionClass = 'toast-top-center';
        
            vm.siguiente = siguiente;
        
            function siguiente(invalidForm) {
                toastr.clear();
                if(invalidForm) {
                    toastr.error('Por favor, complete los campos obligatorios');
                } else {
                    $scope.$parent.$parent.tabset.active = 1;
                }
            }
        });
})();