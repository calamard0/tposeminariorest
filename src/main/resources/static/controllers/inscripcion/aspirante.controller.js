(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('aspiranteController', function ($scope) {
            
            var vm = this;
        
            vm.certDiscapacidadOptions = [
                {value: false, label: 'No'},
                {value: true, label: 'Si'},
            ];
        
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

        });
})();