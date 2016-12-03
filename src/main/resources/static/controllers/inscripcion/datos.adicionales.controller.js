

(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('datosAdicionalesController', function ($scope, $http) {
            
            var vm = this;
            var inscripcionModel = $scope.$parent.mainCtrl.inscripcion;
        
            vm.jardinAnterior = false;
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
                switch(datoAdicionalName) {
                    case 'jardinAnterior':
                        vm.hermanoEnColegio = false;
                        inscripcionModel.datosExtra.hermanoEnColegio = null;
                        vm.responsableEnColegio = false;
                        inscripcionModel.datosExtra.responsableEnColegio = null;
                        break;
                    case 'hermanoEnColegio':
                        vm.jardinAnterior = false;
                        inscripcionModel.datosExtra.jardinAnterior = null;
                        vm.responsableEnColegio = false;
                        inscripcionModel.datosExtra.responsableEnColegio = null;
                        break;
                    case 'responsableEnColegio':
                        vm.hermanoEnColegio = false;
                        inscripcionModel.datosExtra.hermanoEnColegio = null;
                        vm.jardinAnterior = false;
                        inscripcionModel.datosExtra.jardinAnterior = null;
                        break;
                }
                inscripcionModel.datosExtra[datoAdicionalName] = null;
            }

        });
})();