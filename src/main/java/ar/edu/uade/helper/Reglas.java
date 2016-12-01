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
			return 23;
		} else {
			return 22;
		}
	}

	public static int reglaDos(DatosHermano auxHerm) {
		for (Curso cur : auxHerm.getColegio().getCursos()) {
			if (cur.getGrado() > 0) {
				return 21;
			}
		}
		return 20;
	}

	public static int reglaTres(DatosPadre auxPadr) {
		for (Curso cur : auxPadr.getColegio().getCursos()) {
			if (cur.getGrado() > 0) {
				return 19;
			}
		}
		return 18;
	}

	public static int reglaCuatro(DatosPadre auxPadr) {
		if(auxPadr.getFichaMunicipal() == "Carga horaria mayor a 16 horas, antiguedad de 2 años"){
			return 17;	
		}
		if(auxPadr.getFichaMunicipal() == "Carga horaria mayor a 16 horas, antiguedad de 2 años, otro colegio"){
			return 16;	
		}
		if(auxPadr.getFichaMunicipal() == "Carga horaria mayor a 16 horas siendo suplente, antiguedad de 3 años"){
			return 15;	
		}
		return 16;
	}

	public static int reglaCinco(Responsable responsable, Aspirante aspirante) {
		if(aspirante.getDomicilio().getVilla() != null){
			return 14;
		}
		if(responsable.getDatosLaborales().isSostenFamiliar()){
			return 13;
		}
		return 12;
	}
	
	public static int reglaSeisYSiete(Aspirante aspirante) {
		if(aspirante.getNomobre() == "Distrito"){
			return 11;
		}
		return 10;
	}
	
	public static int dist(String direccion, Domicilio auxDom) {
		// TODO Auto-generated method stub
		return 0;
	}
}
