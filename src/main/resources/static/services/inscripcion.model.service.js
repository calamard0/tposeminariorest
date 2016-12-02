(function () {
    'use strict';

    angular.module('inscripciones')
        .service('inscripcionModelService', function () {
            
            var service = {
                getModel: function() {return model}
            };
        
            var model = {
                curso: {
                    grado: null,
                    descripcion: '',
                    vacantesDisponibles: 0
                },
                aspirante: {
                    fechaNacimiento: null,
                    nombre: null,
                    apellido: null,
                    sexo: null,
                    tipoDocumento: null,
                    numeroDocumento: null,
                    paisNacimiento: null,
                    sistemaSalud: null,
                    telefono: null,
                    problemasSalud: {
                        fisicos: false,
                        alergias: false,
                        sensorial: false,
                        epileptico: false,
                        otros: false,
                        otrosDescripcion: ''
                    },
                    certificadoDisca: false,
                    domicilio: {
                        provincia: null,
                        calle: null,
                        numero: null,
                        piso: null,
                        departamento: null,
                        codigoPostal: null,
                        villa: null,
                        tipo: null
                    }


                },
                responsable: {
                    vinculoAspirante: null,
                    nombre: null,
                    apellido: null,
                    tipoDocumento: null,
                    numeroDocumento: null,
                    paisNacimiento: null,
                    email: null,
                    telefonoParticular: null,
                    telefonoAlternativo: null,
                    trabaja: false,
                    datosLaborales: {
                        profesion: null,
                        telefono: null,
                        datosReferencia: null,
                        domicilio: {
                            provincia: null,
                            calle: null,
                            numero: null,
                            piso: null,
                            departamento: null,
                            codigoPostal: null,
                            villa: null,
                            tipo: null
                        }
                    }
                },
                adicionales: {
                    jardinEstatal: {
                        codigo: null,
                        nombre: null,
                        direccion: null
                    },
                    hermanoEnColegio: {
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
                    responsableEnColegio: {
                        ficha: null,
                        nivel: null,
                        escuela: null
                    }
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