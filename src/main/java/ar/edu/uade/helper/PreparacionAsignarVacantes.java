package ar.edu.uade.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.Vacante;

public class PreparacionAsignarVacantes {

	private static Integer disp;
	private static List<Curso> cursos = new ArrayList<Curso>();

	public static Integer vacantesDisp(List<Colegio> auxCantVacantes) {
		for(Colegio auxColegio : auxCantVacantes){
			for(Curso auxCurso : auxColegio.getCursos()){
				disp = disp + auxCurso.getVacantesDisponibles();
			}
		}
		return disp;
	}

	public static List<Curso> getCursosYVacantes(List<Colegio> auxCantVacantes) {
		for(Colegio auxColegio : auxCantVacantes){
			for(Curso auxCurso : auxColegio.getCursos()){
				cursos.add(auxCurso);
			}
		}
		return cursos;
	}

}
