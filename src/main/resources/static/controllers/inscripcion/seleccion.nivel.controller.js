(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('seleccionNivelController', function ($scope) {
            
            var vm = this;
        
            vm.gradoOptions = [
                {value: null, label: 'Seleccionar'},
                {value: 1, label: 'Primer Grado'},
                {value: 2, label: 'Segundo Grado'},
                {value: 3, label: 'Tercer Grado'},
                {value: 4, label: 'Cuarto Grado'},
                {value: 5, label: 'Quinto Grado'},
                {value: 6, label: 'Sexto Grado'},
                {value: 7, label: 'Septimo Grado'},
            ];
        
        });
})();