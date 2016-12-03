(function () {
    'use strict';

    angular.module('inscripciones')
        .service('inscripcionModelService', function () {
            
            var service = {
                getModel: function() {return model}
            };
        
            var model = {
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
                cursos: []
            };
        
            return service;
        });
})();