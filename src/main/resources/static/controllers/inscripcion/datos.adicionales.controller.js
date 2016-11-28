

(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('datosAdicionalesController', function ($scope, $http) {
            
            var vm = this;
        
            vm.jardinEstatal = null;
        
            $http.get('json/jardines.json').then(function(data){
                vm.jardines = data.data.jardin;                
            });

        });
})();