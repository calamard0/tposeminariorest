package ar.edu.uade.helper;

import ar.edu.uade.model.Aspirante;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.DatosHermano;
import ar.edu.uade.model.DatosPadre;
import ar.edu.uade.model.Domicilio;
import ar.edu.uade.model.Responsable;

public class Reglas {

	public static float reglaUno(Colegio col, Domicilio auxDom) {
		if (dist(col.getDireccion(), auxDom) < 10) {
			return 20;
		} else {
			return 19;
		}
	}

	public static float reglaDos(DatosHermano auxHerm) {
		for (Curso cur : auxHerm.getColegio().getCursos()) {
			if (cur.getGrado() > 0) {
				return 18;
			}
		}
		return 17;
	}

	public static float reglaTres(DatosPadre auxPadr) {
		for (Curso cur : auxPadr.getColegio().getCursos()) {
			if (cur.getGrado() > 0) {
				return 16;
			}
		}
		return 15;
	}

	public static float reglaCuatro(DatosPadre auxPadr) {
		return 11;
	}

	public static float reglaCinco(Responsable responsable, Aspirante aspirante) {
		if (aspirante.getDomicilio().getVilla() != null) {
			return 10;
		}
		if (responsable.getDatosLaborales().isSostenFamiliar()) {
			return 9;
		}
		return 8;
	}

	public static float reglaSeisYSiete(Aspirante aspirante) {
		if (aspirante.getNombre() == "Distrito") {
			return 7;
		}
		return 6;
	}

	public static float reglaOchoYNueve(Responsable responsable, String direccionCol) {
		if (dist(direccionCol,responsable.getDatosLaborales().getDomicilio()) < 10) {
			return 5;
		}
		return 4;
	}

	public static float reglaDiezYOnce(Responsable responsable, String direccion) {
		if (dist(direccion,responsable.getDatosLaborales().getDomicilio()) < 10) {
			return 3;
		}
		return 2;
	}
	
	public static float dist(String direccion, Domicilio auxDom) {
		// TODO Auto-generated method stub
		return 0;
	}

}
