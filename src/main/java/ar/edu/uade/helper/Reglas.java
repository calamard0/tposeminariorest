package ar.edu.uade.helper;

import ar.edu.uade.model.Aspirante;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.DatosHermano;
import ar.edu.uade.model.DatosPadre;
import ar.edu.uade.model.Domicilio;
import ar.edu.uade.model.Responsable;

public class Reglas {

	public static int reglaUno(Colegio col, Domicilio auxDom) {
		if (dist(col.getDireccion(), auxDom) < 10) {
			return 20;
		} else {
			return 19;
		}
	}

	public static int reglaDos(DatosHermano auxHerm) {
		for (Curso cur : auxHerm.getColegio().getCursos()) {
			if (cur.getGrado() > 0) {
				return 18;
			}
		}
		return 17;
	}

	public static int reglaTres(DatosPadre auxPadr) {
		for (Curso cur : auxPadr.getColegio().getCursos()) {
			if (cur.getGrado() > 0) {
				return 16;
			}
		}
		return 15;
	}

	public static int reglaCuatro(DatosPadre auxPadr) {
		if (auxPadr.getFichaMunicipal() == "Carga horaria mayor a 16 horas, antiguedad de 2 años") {
			return 14;
		}
		if (auxPadr.getFichaMunicipal() == "Carga horaria mayor a 16 horas, antiguedad de 2 años, otro colegio") {
			return 13;
		}
		if (auxPadr.getFichaMunicipal() == "Carga horaria mayor a 16 horas siendo suplente, antiguedad de 3 años") {
			return 12;
		}
		return 11;
	}

	public static int reglaCinco(Responsable responsable, Aspirante aspirante) {
		if (aspirante.getDomicilio().getVilla() != null) {
			return 10;
		}
		if (responsable.getDatosLaborales().isSostenFamiliar()) {
			return 9;
		}
		return 8;
	}

	public static int reglaSeisYSiete(Aspirante aspirante) {
		if (aspirante.getNombre() == "Distrito") {
			return 7;
		}
		return 6;
	}

	public static int reglaOchoYNueve(Responsable responsable, String direccionCol) {
		if (dist(direccionCol,responsable.getDatosLaborales().getDomicilio()) < 10) {
			return 5;
		}
		return 4;
	}

	public static int reglaDiezYOnce(Responsable responsable, String direccion) {
		if (dist(direccion,responsable.getDatosLaborales().getDomicilio()) < 10) {
			return 3;
		}
		return 2;
	}
	
	public static int dist(String direccion, Domicilio auxDom) {
		// TODO Auto-generated method stub
		return 0;
	}

}
