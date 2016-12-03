(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('seleccionColegiosController', function ($scope, $http, inscripcionService) {
            
            var vm = this;
            $scope.coco = 'coco'
        
            vm.obtenerCurso = obtenerCurso;
        
            function obtenerCurso(grado) {
                inscripcionService.getCurso(vm.colegioAAgregar.codigo, grado)
                    .then(function(data) {
                        $scope.$parent.mainCtrl.inscripcion.cursos.push(data);
                })
            }
        
            $http.get('json/colegios.json').then(function(data){
                vm.colegios = data.data.colegios;                
            });

        });
})();