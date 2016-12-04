(function () {
    'use strict';

    angular.module('inscripciones')
        .service('colegioService', function ($q, $http) {
            
            var service = {
                getCursos: getCursos,
                guardarCursos: guardarCursos
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
        
            return service;
        });
})();