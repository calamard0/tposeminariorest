package ar.edu.uade.helper;

import java.util.List;

import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;

public class PreparacionAsignarVacantes {

	private static Integer disp;

	public static Integer vacantesDisp(List<Colegio> auxCantVacantes) {
		for(Colegio auxColegio : auxCantVacantes){
			for(Curso auxCurso : auxColegio.getCursos()){
				disp = disp + auxCurso.getVacantesDisponibles();
			}
		}
		return disp;
	}

}
