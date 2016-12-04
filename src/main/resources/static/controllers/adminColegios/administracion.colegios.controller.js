(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('administracionColegioController', function ($scope, colegioService, toastr, toastrConfig) {
            
            var vm = this;
            vm.guardar = guardar;
        
            var idColegio = 10;
        
            toastrConfig.maxOpened = 1;
            toastrConfig.autoDismiss = true;
            toastrConfig.timeOut = 3000;
            toastrConfig.positionClass = 'toast-top-center';
        
            function init() {
                colegioService.getCursos(idColegio).then(function(data) {
                    vm.cursos = data;
                });             
            }
        
            function guardar() {
                colegioService.guardarCursos(vm.cursos).then(
                    function(data) {
                        toastr.success("Cambios guardados");
                    },
                    function(data) {
                        toastr.error("Hubo un error, intente nuevamente en unos minutos");
                    });
            }
            
            init();

        });
})();