(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('responsableController', function ($scope) {
            
            var vm = this;
        
            vm.trabajaOptions = [
                {value: false, label: 'No trabaja'},
                {value: true, label: 'Trabaja'},
            ];

        });
})();