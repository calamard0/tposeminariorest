(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('mainController', function ($scope, toastr, toastrConfig, inscripcionModelService, inscripcionService, $http) {

            var vm = this;
        
            vm.grado = '';
            vm.inscripcion = inscripcionModelService.getModel();
            vm.siguiente = siguiente;
            vm.anterior = anterior;
            vm.activeTab = 0;
            vm.crearInscripcion = crearInscripcion;
        
            toastrConfig.maxOpened = 1;
            toastrConfig.autoDismiss = true;
            toastrConfig.timeOut = 3000;
            toastrConfig.positionClass = 'toast-top-center';
            function siguiente(currentTabIndex) {
                toastr.clear();
                var isCurrentFormInvalid = vm[formsNameArray[currentTabIndex]].$invalid;
                if (isCurrentFormInvalid) {
                    toastr.error('Por favor, complete los campos obligatorios (marcados en rojo)');
                } else {
                    vm.activeTab = currentTabIndex+1;
                }
                console.log(vm.inscripcion);
            }
        
            function anterior(currentTabIndex) {
                vm.activeTab = currentTabIndex-1;
            }
        
            function crearInscripcion(inscripcion) {
                inscripcionService.saveInscripcion(inscripcion)
                    .then(function(data) {
                        console.log(data);
                })
            }
        
            var formsNameArray = {
                0: 'nivelForm',
                1: 'aspiranteForm',
                2: 'responsableForm',
                3: 'adicionalesForm',
                4: 'escuelasForm',
                5: ''
            }
            
            $http.get('json/calles.json').then(function(data){
                vm.calles = data.data.calles;                
            });

        });
})();