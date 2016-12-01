package ar.edu.uade.helper;

import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.DatosHermano;
import ar.edu.uade.model.Domicilio;

public class Reglas {

	public static int reglaUno(Colegio col, Domicilio auxDom) {
		if (dist(col.getDireccion(), auxDom) < 10) {
			return 23;
		} else {
			return 22;
		}
	}
	
	public static int reglaDos(Colegio auxCol, DatosHermano auxHerm) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int dist(String direccion, Domicilio auxDom) {
		// TODO Auto-generated method stub
		return 0;
	}
}
