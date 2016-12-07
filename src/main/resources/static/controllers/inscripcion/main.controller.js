(function () {
    'use strict';

    angular.module('inscripciones')
        .controller('mainController', function ($scope, $rootScope, toastr, toastrConfig, inscripcionModelService, inscripcionService, $http, $window, $timeout) {

            var vm = this;
        
            vm.grado = '';
            vm.inscripcion = inscripcionModelService.getModel();
            vm.siguiente = siguiente;
            vm.anterior = anterior;
            vm.activeTab = 0;
            vm.crearInscripcion = crearInscripcion;
            vm.cargaExitosa = false;
            vm.preinscripcionCargadaNro = '';
            vm.showForm = false;
            vm.obtenerPreinscripcion = obtenerPreinscripcion;
            vm.modificarPreinscripcion = modificarPreinscripcion;
            vm.validarPreinscripcion = validarPreinscripcion;
            vm.cargandoPreinscripcion = false;
        
            vm.getGrado = getGrado;
            vm.getTipoDoc = getTipoDoc;
            vm.getSexo = getSexo;
            vm.getSistSalud = getSistSalud;
            vm.getVilla = getVilla;
            vm.getTipoVivienda = getTipoVivienda;
            vm.getVinculo = getVinculo;
        
            vm.sugerirColegios = sugerirColegios;
            vm.loadginColegiosSugeridos = true;
            vm.direccionAspiranteSugeridos = '';
            
            $http.post('/currentuser')
                .success(function (data) {
                    if(data.id > 0) {
                    	$scope.username = data.nombreUsuario;
                    }
                })
                .error(function (data) {
                    console.log(data);
                });
        
            toastrConfig.maxOpened = 1;
            toastrConfig.autoDismiss = true;
            toastrConfig.timeOut = 3000;
            toastrConfig.positionClass = 'toast-top-center';
            function siguiente(currentTabIndex) {
                toastr.clear();
                var isCurrentFormInvalid = vm[formsNameArray[currentTabIndex]].$invalid;
                if (isCurrentFormInvalid) {
                    toastr.error('Por favor, complete los campos obligatorios (marcados en rojo)');
                } else {
                    vm.activeTab = currentTabIndex+1;
                    $window.scrollTo(0, 0);
                }
                console.log(vm.inscripcion);
            }
        
            function anterior(currentTabIndex) {
                vm.activeTab = currentTabIndex-1;
            }
         
            function crearInscripcion(inscripcion) {
                inscripcionService.saveInscripcion(inscripcion)
                    .then(function(data) {
                        toastr.success("Preinscripcion cargada existosamente!");
                        vm.cargaExitosa = true;
                        vm.preinscripcionCargadaNro = data;
                })
            }
        
            function obtenerPreinscripcion() {
                vm.cargandoPreinscripcion = true;
                var direccionAspiranteActual = '';
                vm.modeValidate = true;
                vm.showForm = false;
                $scope.nivel = "1";
                $scope.modalidad = "1";
                inscripcionService.getPreinscripcion(vm.nroPreInscATraer)
                    .then(function(data) {
                        vm.showForm = true;
                        vm.cargandoPreinscripcion = false;
                        vm.grado = data.cursos[0].grado;
                        vm.inscripcion = data;
                        $timeout(function() {
                            if(data.datosExtra) {
                                if (data.datosExtra.jardinAnterior) {
                                    $rootScope.$broadcast('existeJardinAnterior');
                                } else if (data.datosExtra.hermanoEnColegio) {
                                    $rootScope.$broadcast('existeHermanoEnColegio');
                                } else if (data.datosExtra.responsableEnColegio) {
                                    $rootScope.$broadcast('existeResponsableEnColegio');
                                }
                            }
                        }, 500);  
                }, function() {
                    vm.cargandoPreinscripcion = false;
                    toastr.error('No existe una presinscripcion con ese número, intente nuevamente');
                });
            }
        
            function modificarPreinscripcion() {
                inscripcionService.modificarPreinscripcion(vm.inscripcion)
                    .then(function(data) {
                        toastr.success("Preinscripción modificada exitosament!")
                        console.log(data);
                });
            }
        
            function validarPreinscripcion() {
                inscripcionService.validarPreinscripcion(vm.inscripcion)
                    .then(function(data) {
                        toastr.success("Preinscripción validada exitosament!")
                        console.log(data);
                });
            }
        
            var formsNameArray = {
                0: 'nivelForm',
                1: 'aspiranteForm',
                2: 'responsableForm',
                3: 'adicionalesForm',
                4: 'escuelasForm',
                5: ''
            }
            
            $http.get('/json/calles.json').then(function(data){
                vm.calles = data.data.calles;                
            });
        
            function getGrado(numero) {
                var gradoString = '';
                switch(numero) {
                    case 1:
                        gradoString = 'Primer Grado';
                        break;
                    case 2:
                        gradoString = 'Segundo Grado';
                        break;
                    case 3:
                        gradoString = 'Tercer Grado';
                        break;
                    case 4:
                        gradoString = 'Cuarto Grado';
                        break;
                    case 5:
                        gradoString = 'Quinto Grado';
                        break;
                    case 6:
                        gradoString = 'Sexto Grado';
                        break;
                    case 7:
                        gradoString = 'Septimo Grado';
                        break;
                }
                return gradoString
            }
        
            function getTipoDoc(tipo) {
                var tipoDoc = '';
                switch(tipo) {
                    case 'DNI':
                        tipoDoc = 'Documento Nacional de Identidad';
                        break;
                    case 'PN':
                        tipoDoc = 'Partida de nacimiento';
                        break;
                    case 'CRP':
                        tipoDoc = 'Credencial residencia precaria';
                        break;
                    case 'PE':
                        tipoDoc = 'Pasaporte extranjero';
                        break;
                    case 'CE':
                        tipoDoc = 'Cédula extranjera';
                        break;
                    case 'ODE':
                        tipoDoc = 'Otro documento extranjero';
                        break;
                    case 'DT':
                        tipoDoc = 'Documento en trámite';
                        break;
                    case 'SD':
                        tipoDoc = 'Sin documento';
                        break;
                }
                return tipoDoc
            }
        
            function getSexo(s) {
                if(s=='M') {
                    return 'Masculino';
                } else {
                    return 'Femenino';
                }
            }
        
            function getSistSalud(sistS) {
                var sisteSalud = '';
                switch(sistS) {
                    case 'HtalPublico':
                        sisteSalud = 'Hospital público';
                        break;
                    case 'ObraSocial':
                        sisteSalud = 'Obra social';
                        break;
                    case 'PrePaga':
                        sisteSalud = 'Pre-paga';
                        break;
                }
                return sisteSalud
            }
        
            function getVilla(id) {
                var villa = '';
                switch(id) {
                    case '65': villa = 'Asentamiento Barrio Obrero'; break;
                    case '68': villa = 'Asentamiento Bermejo'; break;
                    case '51': villa = 'Asentamiento Biarritz y Espino'; break;
                    case '80': villa = 'Asentamiento Bosch'; break;
                    case '85': villa = 'Asentamiento Calle B. Mitre'; break;
                    case '78': villa = 'Asentamiento Charlone'; break;
                    case '74': villa = 'Asentamiento El pueblito'; break;
                    case '86': villa = 'Asentamiento El Triángulo'; break;
                    case '58': villa = 'Asentamiento Fraga'; break;
                    case '59': villa = 'Asentamiento La Carbonilla'; break;
                    case '64': villa = 'Asentamiento Lamadrid'; break;
                    case '54': villa = 'Asentamiento Los Pinos'; break;
                    case '73': villa = 'Asentamiento Magaldi'; break;
                    case '75': villa = 'Asentamiento Mar Dulce'; break;
                    case '87': villa = 'Asentamiento María Auxiliadora'; break;
                    case '88': villa = 'Asentamiento Paredón Lacroze'; break;
                    case '57': villa = 'Asentamiento Portela'; break;
                    case '81': villa = 'Asentamiento Rodrigo Bueno'; break;
                    case '89': villa = 'Asentamiento Saldías'; break;
                    case '82': villa = 'Asentamiento Scapino'; break;
                    case '83': villa = 'Asentamiento Warnes y Newbery'; break;
                    case '71': villa = 'Asentamiento Yerbal'; break;
                    case '77': villa = 'NHT Del Trabajo'; break;
                    case '66': villa = 'NHT Zavaleta'; break;
                    case '79': villa = 'Villa 1-11-14'; break;
                    case '72': villa = 'Villa 13 bis'; break;
                    case '60': villa = 'Villa 15'; break;
                    case '55': villa = 'Villa 16'; break;
                    case '63': villa = 'Villa 17'; break;
                    case '69': villa = 'Villa 19'; break;
                    case '84': villa = 'Villa 20'; break;
                    case '76': villa = 'Villa 21-24'; break;
                    case '53': villa = 'Villa 26'; break;
                    case '70': villa = 'Villa 31'; break;
                    case '61': villa = 'Villa 31 BIS'; break;
                    case '52': villa = 'Villa 3- Bo. Fatima'; break;
                    case '56': villa = 'Villa 6'; break;
                    case '62': villa = 'Villa Calacita'; break;
                    case '67': villa = 'Villa Piletones'; break;
                }
                return villa;
            }
        
            function getTipoVivienda(id) {
                var vivienda = '';
                switch(id) {
                    case 'casa': vivienda = 'Vivienda propia'; break;
                    case 'viviendaalquilada': vivienda = 'Vivienda alquilada'; break;
                    case 'pension': vivienda = 'Pensión'; break;
                    case 'hotel': vivienda = 'Hotel familiar'; break;
                    case 'situacionCalle': vivienda = 'Situación de calle'; break;
                    case 'nhp': vivienda = 'Núcleo habitacional precario'; break;
                    case 'villa': vivienda = 'Villa'; break;
                    case 'ninguno': vivienda = 'Ninguno de los anteriores'; break;
                }
                return vivienda;
            }
        
            function getVinculo(v) {
                var vinculo = '';
                switch(v) {
                    case 'padre': vinculo = 'Padre'; break;
                    case 'madre': vinculo = 'Madre'; break;
                    case 'hermano': vinculo = 'Hermano/a'; break;
                    case 'tutor': vinculo = 'Tutor/a'; break;
                    case 'responsable': vinculo = 'Responsable a cargo'; break;
                    case 'tio': vinculo = 'Tío/a'; break;
                    case 'primo': vinculo = 'Primo/a'; break;
                    case 'padrastro': vinculo = 'Padrastro'; break;
                    case 'madrastra': vinculo = 'Madrastra'; break;
                    case 'abuelo': vinculo = 'Abuelo/a'; break;
                    case 'autorizado': vinculo = 'Autorizado/a'; break;
                    case 'NA': vinculo = 'No Aplica'; break;
                }
                return vinculo;
            }
        
            var cursosNuevos = [];
            function sugerirColegios() {
                var direccionAspiranteActual = vm.inscripcion.aspirante.domicilio.calle + ' ' + vm.inscripcion.aspirante.domicilio.numero;
                if(vm.direccionAspiranteSugeridos != direccionAspiranteActual) {
                    vm.loadginColegiosSugeridos = true;
                    vm.direccionAspiranteSugeridos = direccionAspiranteActual
                    
                    if(vm.modeValidate) {
                        
                        // al validar/modificar la inscripcion

                        for(var index in vm.inscripcion.cursos) {
                            vm.inscripcion.cursos[index].sugerido = true;
                        }
                        vm.loadginColegiosSugeridos = false;
                        
                    } else {
                        
                        // al crear la inscripcion
                        
                        cursosNuevos = [];
                        for(var index in vm.inscripcion.cursos) {
                            if(!vm.inscripcion.cursos[index].sugerido)
                                cursosNuevos.push(vm.inscripcion.cursos[index]);
                        }
                        inscripcionService.getColegiosSugeridos(vm.direccionAspiranteSugeridos, vm.grado).then(function(data) {
                            for(var index in data) {
                                var curso = data[index];
                                curso.sugerido = true;
                                cursosNuevos.push(curso);
                            }
                            vm.inscripcion.cursos = cursosNuevos;
                            vm.loadginColegiosSugeridos = false;
                        }); 
                    }

                }
            }
        
            function marcarSugeridos(sugeridos, existente) {
                 for(var index in sugeridos) {
                     if(sugeridos[index].id == existente.id) {
                         existente.sugerido = true;
                         break;
                     }
                 }
            }

        });
})();