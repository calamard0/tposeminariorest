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

                $http.post('/cursos/getCursos/'+idColegio)
                    .success(function (data) {
                        deferred.resolve(data);
                    })
                    .error(function (data) {
                        deferred.reject(data);
                    });

                return deferred.promise;
            }
        
            function guardarCursos(cursos) {
                var deferred = $q.defer();

                $http.post('/cursos/update/', cursos)
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