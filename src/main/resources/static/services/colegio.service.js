(function () {
    'use strict';

    angular.module('inscripciones')
        .service('colegioService', function ($q, $http) {
            
            var service = {
                getCursos: getCursos,
                guardarCursos: guardarCursos,
                getCurrentUser: getCurrentUser,
                getAlumnosInscriptos: getAlumnosInscriptos,
                getAsignaciones: getAsignaciones
            };
        
            function getCursos(idColegio) {
                var deferred = $q.defer();

                $http.get('/colegios/getById/'+idColegio)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }
        
            function guardarCursos(colegio) {
                var deferred = $q.defer();

                $http.post('/cursos/update/', colegio)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }
        
            function getCurrentUser() {
                var deferred = $q.defer();

                $http.post('/cursos/currentuser/')
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }
        
            function getAlumnosInscriptos(colegioID) {
                var deferred = $q.defer();

                $http.post('/cursos/getAlumnos/'+colegioID)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }
        
            function getAsignaciones() {
                var deferred = $q.defer();

                $http.post('/cursos/getAllAlumnos')
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