(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('seleccionNivelController', function ($scope) {
            
            var vm = this;
        
            vm.gradoOptions = [
                {value: '', label: 'Seleccionar'},
                {value: 1, label: 'Primer Grado'},
                {value: 2, label: 'Segundo Grado', disabled: true},
                {value: 3, label: 'Tercer Grado', disabled: true},
                {value: 4, label: 'Cuarto Grado', disabled: true},
                {value: 5, label: 'Quinto Grado', disabled: true},
                {value: 6, label: 'Sexto Grado', disabled: true},
                {value: 7, label: 'Septimo Grado', disabled: true},
            ];
        
        });
})();