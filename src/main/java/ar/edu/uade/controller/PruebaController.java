package ar.edu.uade.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.dto.Prueba;

@RestController
@RequestMapping(PruebaController.PRUEBA_BASE_URI)
public class PruebaController {

	public static final String PRUEBA_BASE_URI = "svc/v1/pruebas";
	
	@RequestMapping(value = "{pruebaNumero}")
	public Prueba getPrueba(@PathVariable final int pruebaNumero) {
		Prueba prueba = new Prueba();
		prueba.setValor("Valor1");
		prueba.setId(pruebaNumero);
		return prueba;
	}
	
}
