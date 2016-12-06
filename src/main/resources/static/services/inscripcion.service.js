(function () {
    'use strict';

    angular.module('inscripciones')
        .service('inscripcionService', function ($q, $http) {
            
            var service = {
                saveInscripcion: saveInscripcion,
                getCurso: getCurso,
                getColegiosSugeridos: getColegiosSugeridos,
                getPreinscripcion: getPreinscripcion,
                modificarPreinscripcion: modificarPreinscripcion,
                validarPreinscripcion: validarPreinscripcion                
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
        
            function getPreinscripcion(id) {
                var deferred = $q.defer();

                $http.get('/preinscripcion/getPreInscripcion/'+id)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }
        
            function validarPreinscripcion(inscripcion) {
                var deferred = $q.defer();

                $http.post('/preinscripcion/validar/', inscripcion)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }
        
            function modificarPreinscripcion(inscripcion) {
                var deferred = $q.defer();

                $http.post('/preinscripcion/modificar/', inscripcion)
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