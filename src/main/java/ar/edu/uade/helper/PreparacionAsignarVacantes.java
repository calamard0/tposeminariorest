package ar.edu.uade.helper;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.model.Curso;

public class PreparacionAsignarVacantes {

	private static Integer disp;
	private static List<Curso> cursos = new ArrayList<Curso>();

	public static Integer vacantesDisp(List<Curso> auxCantVacantes) {
		for (Curso auxCurso : auxCantVacantes) {
			disp = disp + auxCurso.getVacantesDisponibles();
		}
		return disp;
	}
}