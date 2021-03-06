(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('administracionColegioController', function ($scope, colegioService, toastr, toastrConfig, $http) {
            
            var vm = this;
            vm.guardar = guardar;
        
            var idColegio = 10;
        
            toastrConfig.maxOpened = 1;
            toastrConfig.autoDismiss = true;
            toastrConfig.timeOut = 3000;
            toastrConfig.positionClass = 'toast-top-center';
        
            function init() {
                colegioService.getCurrentUser().then(function(data) {
                    if(data.id > 0) {
                        $scope.username = data.nombreUsuario;
                    }
                    colegioService.getAlumnosInscriptos(data.colegio.id).then(function(data) {
                        vm.alumnosInscriptos = data[0].alumnos;
                        vm.curso = data[0];
                        
                    });
                    colegioService.getCursos(data.colegio.id).then(function(data) {
                        vm.colegio = data;
                    });
                }); 
                
            }
        
            function guardar() {
                colegioService.guardarCursos(vm.colegio).then(
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