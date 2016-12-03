(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('seleccionColegiosController', function ($scope, $http, inscripcionService) {
            
            var vm = this;
            var inscripcionModel = $scope.$parent.mainCtrl.inscripcion;
        
            vm.obtenerCurso = obtenerCurso;
            vm.eliminarColegioElegido = eliminarColegioElegido;
        
            function obtenerCurso(grado) {
                inscripcionService.getCurso(vm.colegioAAgregar.codigo, grado)
                    .then(function(data) {
                        inscripcionModel.cursos.push(data);
                })
            }
        
            function eliminarColegioElegido(curso) {
                var index = inscripcionModel.cursos.indexOf(curso);
                inscripcionModel.cursos.splice(index, 1); 
            }
        
            $http.get('json/colegios.json').then(function(data){
                vm.colegios = data.data.colegios;                
            });

        });
})();