(function () {
    'use strict';

    angular.module('inscripciones')
        .service('inscripcionModelService', function () {
            
            var service = {
                getModel: function() {return model}
            };
        
            var model = {
                nivel: {
                    nivel: '1',
                    modalidad: '1',
                    grado: '1'
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
                    problemasSalud: {
                        fisicos: false,
                        alergias: false,
                        sensorial: false,
                        epileptico: false,
                        otros: false,
                        otrosDescripcion: ''
                    },
                    certDiscapacidad: false,
                    domicilio: {
                        provincia: null,
                        calleNro: null,
                        piso: null,
                        depto: null,
                        cp: null,
                        villa: null,
                        espacioConviven: null
                    }


                },
                responsable: {
                    vinculo: null,
                    nombre: null,
                    apellido: null,
                    documento: {
                        tipo: null,
                        numero: null
                    },
                    nacionalidad: null,
                    email: null,
                    telefono1: null,
                    telefono2: null,
                    trabaja: false,
                    datosLaborales: {
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
        
            return service;
        });
})();