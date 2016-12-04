(function () {
    'use strict';

    angular.module('inscripciones')
        .service('inscripcionService', function ($q, $http) {
            
            var service = {
                saveInscripcion: saveInscripcion,
                getCurso: getCurso,
                getColegiosSugeridos: getColegiosSugeridos
            };
        
            function saveInscripcion(inscripcion) {
                var deferred = $q.defer();

                $http.post('/preinscripcion/crear', inscripcion)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }
        
            function getCurso(idColegio, grado) {
                var deferred = $q.defer();

                $http.get('/cursos/getCursoPorColegio/'+idColegio+'/'+grado)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }
        
            function getColegiosSugeridos(direccion, grado) {
                var deferred = $q.defer();

                $http.get('/preinscripcion/sugerirColegios/'+direccion+'/'+grado)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }

        
            return service;
        });
})();