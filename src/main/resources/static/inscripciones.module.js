(function () {
    'use strict';

    var app = angular.module('inscripciones', ['ui.bootstrap', 'ui.sortable']);

    app.controller('mainController', function ($scope) {

        $scope.model = {
            nivel: {
                nivel: null,
                modalidad: null,
                grado: null
            },
            aspirante: {
                fechaNac: null,
                nombre: null,
                apellido: null,
                sexo: null,
                documento: {
                    tipo: null,
                    numero: null
                },
                nacionalidad: null,
                sistSalud: null,
                telefono: null,
                problemasSalud: [],
                certDiscapacidad: false,
                domicilio: {
                    provincia: null,
                    calleNro: null,
                    piso: null,
                    depto: null,
                    cp: null,
                    villa: null,
                    espacioConvicen: null
                }


            },
            responsable: {
                vinculo: null,
                nombre: null,
                apellido: null,
                sexo: null,
                documento: {
                    tipo: null,
                    numero: null
                },
                nacionalidad: null,
                email: null,
                telefono1: null,
                telefono2: null,
                domicilioLaboral: {
                    situacion: null,
                    profesion: null,
                    telefono: null,
                    provincia: null,
                    calleNro: null,
                    piso: null,
                    depto: null,
                    cp: null,
                    villa: null,
                    referencia: null
                }


            },
            adicionales: {
                concurrio: {
                    nivel: null,
                    escuela: null
                },
                hermano: {
                    nombre: null,
                    apellido: null,
                    fechaNac: null,
                    documento: {
                        tipo: null,
                        numero: null
                    },
                    nivel: null,
                    grado: null,
                    escuela: null
                },
                responsableTrabaja: {
                    ficha: null,
                    nivel: null,
                    escuela: null
                },
                preinscripcionesVinculadas: [{
                    numero: null,
                    parentesco: null
                }]
            },
            colegios: [
                {
                    id: 1,
                    value: 'Esc. Primaria Nº 04 DE 18 Casimiro Aureliano Maciel ( MARCOS PAZ 1732 )'
                },
                {
                    id: 2,
                    value: 'Esc. Primaria Nº 13 DE 19 Presbítero Alberti ( ITAQUI 2050 )'
                },
                {
                    id: 3,
                    value: 'Esc. Primaria Nº 19 DE 19 Jose Martí ( PJE. L ENTRE LACARRA Y LAGUNA 0000 )'
                },
                {
                    id: 4,
                    value: 'Esc. Primaria Nº 09 DE 13 Homero Manzi ( MIRALLA 2666 )'
                },
                {
                    id: 5,
                    value: 'Esc. Primaria Nº 03 DE 20 República Francesa - Plurilingüe ( MONTIEL 153 )'
                }
            ]
        };

        // ====================== DATEPICKER ======================
        $scope.today = function () {
            $scope.fechaNac = new Date();
        };
        $scope.today();

        $scope.clear = function () {
            $scope.fechaNac = null;
        };

        $scope.inlineOptions = {
            minDate: new Date(1920, 1, 1),
            maxDate: new Date(),
            showWeeks: true
        };

        $scope.dateOptions = {
            formatYear: 'yy',
            minDate: new Date(1920, 1, 1),
            maxDate: new Date(),
            startingDay: 1,
            showWeeks: false
        };

        $scope.toggleMin = function () {
            $scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
            $scope.dateOptions.minDate = $scope.inlineOptions.minDate;
        };

        $scope.toggleMin();

        $scope.open2 = function () {
            $scope.popup2.opened = true;
        };

        $scope.setDate = function (year, month, day) {
            $scope.fechaNac = new Date(year, month, day);
        };

        $scope.popup2 = {
            opened: false
        };
        // ====================== END - DATEPICKER ======================
    });
})();
