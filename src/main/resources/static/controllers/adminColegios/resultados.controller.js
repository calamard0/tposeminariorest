(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('resultadosController', function ($scope, colegioService) {
            
            var vm = this;
             
            getAsignaciones();

            function getAsignaciones() {
                 colegioService.getAsignaciones().then(function(data) {
                     vm.asignacionesTotales = data
                 })
            }

        });
})();