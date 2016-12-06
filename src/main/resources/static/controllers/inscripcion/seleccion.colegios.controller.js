(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('seleccionColegiosController', function ($scope, $http, inscripcionService, toastr, toastrConfig) {
            
            var vm = this;
            var inscripcionModel = $scope.$parent.mainCtrl.inscripcion;
        
            vm.obtenerCurso = obtenerCurso;
            vm.eliminarColegioElegido = eliminarColegioElegido;
        
            toastrConfig.maxOpened = 1;
            toastrConfig.autoDismiss = true;
            toastrConfig.timeOut = 3000;
            toastrConfig.positionClass = 'toast-top-center';
        
            function obtenerCurso(grado) {
                toastr.clear();
                inscripcionService.getCurso(vm.colegioAAgregar.id, grado)
                    .then(function(data) {
                        if(!colegioYaEstaAgregado(data.colegio.id)) {
                            inscripcionModel.cursos.push(data);
                            vm.colegioAAgregar = null;
                        } else {
                            toastr.info('Colegio ya agregado, elija otro por favor');
                        }
                       
                })
            }
        
            function colegioYaEstaAgregado(colegioID) {
                for(var i in inscripcionModel.cursos) {
                    if(inscripcionModel.cursos[i].colegio.id == colegioID)
                        return true;
                }
                return false;
            }
        
            function eliminarColegioElegido(curso) {
                var index = inscripcionModel.cursos.indexOf(curso);
                inscripcionModel.cursos.splice(index, 1); 
            }
        
            $http.get('/json/colegios.json').then(function(data){
                vm.colegios = data.data.colegios;                
            });

        });
})();