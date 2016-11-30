

(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('datosAdicionalesController', function ($scope, $http) {
            
            var vm = this;
        
            vm.jardinEstatal = false;
            vm.hermanoEnColegio = false;
            vm.responsableEnColegio = false;
        
            vm.cambioDatoAdicional = cambioDatoAdicional;
        
            vm.datosAdicionalesOptions = [
                {value: false, label: 'No'},
                {value: true, label: 'Si'},
            ];
        
            $http.get('json/jardines.json').then(function(data){
                vm.jardines = data.data.jardin;                
            });
        
            function cambioDatoAdicional(datoAdicionalName) {
                vm.jardinEstatal = false;
                vm.hermanoEnColegio = false;
                vm.responsableEnColegio = false;
                vm[datoAdicionalName] = true;
            }

        });
})();