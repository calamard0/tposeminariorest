

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
        
            $http.get('/json/jardines.json').then(function(data){
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
            
            $scope.$on('existeJardinAnterior', function() {
            	vm.jardinAnterior = true;
            });
        
            $scope.$on('existeHermanoEnColegio', function() {
            	vm.hermanoEnColegio = true;
            });
            
            $scope.$on('existeResponsableEnColegio', function() {
            	vm.responsableEnColegio = true;
            });
            
            vm.inlineOptions = {
                minDate: new Date(1920, 1, 1),
                maxDate: new Date(),
                showWeeks: true
            };

            vm.dateOptions = {
                formatYear: 'yy',
                minDate: new Date(1920, 1, 1),
                maxDate: new Date(),
                startingDay: 1,
                showWeeks: false
            };
        
            vm.toggleMin = function () {
                vm.inlineOptions.minDate = vm.inlineOptions.minDate ? null : new Date();
                vm.dateOptions.minDate = vm.inlineOptions.minDate;
            };

            vm.openDatePicker = function () {
                vm.datePicker.opened = true;
            };

            vm.datePicker = {
                opened: false
            };
        
            $http.get('/json/colegios.json').then(function(data){
                vm.colegios = data.data.colegios;                
            });

        });
})();