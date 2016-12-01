(function () {
    'use strict';

    angular.module('inscripciones')
        .service('inscripcionService', function ($q, $http) {
            
            var service = {
                saveInscripcion: saveInscripcion
            };
        
            function saveInscripcion(inscripcion) {
                var deferred = $q.defer();

                $http.post('/preinscripcion/crear', inscripcion)
                    .success(function (data) {
                        deferred.resolve(data.body);
                    })
                    .error(function (data) {
                        deferred.reject(data.body);
                    });

                return deferred.promise;
            }

        
            return service;
        });
})();