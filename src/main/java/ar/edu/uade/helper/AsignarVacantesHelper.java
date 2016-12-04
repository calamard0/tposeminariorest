package ar.edu.uade.helper;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.model.Curso;
import ar.edu.uade.model.Vacante;

public class AsignarVacantesHelper {

	public static void asignarVacantes(List<Curso> cursos, int grado, List<Vacante> vacantes) {

		List<Vacante> vacantesAsignadasExtra = new ArrayList<Vacante>();
		List<Vacante> vacantesAsignadas = new ArrayList<Vacante>();
		Integer vacantesDisponibles = PreparacionAsignarVacantes.vacantesDisp(cursos);
		List<Curso> cursosCompletos = new ArrayList<Curso>();
		List<Curso> cursosIncompletos = new ArrayList<Curso>();
		Integer iteracion = 0;

		System.out.println("Se procesa el grado " + grado);

		if (vacantes.size() > vacantesDisponibles) {
			while (vacantesDisponibles != 0) {
				for (Curso disVsVac : cursos) {
					int auxCant = disVsVac.getVacantesDisponibles();
					if (disVsVac.getVacantes().size() > auxCant) {
						for (Vacante auxVac : disVsVac.getVacantes()) {
							System.out.println("Se le pre asigna la vacante " + auxVac.getId()
									+ "del aspirante con numero de documento "
									+ auxVac.getPreinscripcion().getAspirante().getNumeroDocumento());
							vacantesAsignadas.add(auxVac);
							vacantesDisponibles = vacantesDisponibles - 1;
							borrasLasOtrasVacantes(auxVac, cursos, vacantesAsignadasExtra);
						}
						cursosCompletos.add(disVsVac);
					} else {
						System.out.println("Fin de la iteracion numero de iteracion " + iteracion);
						iteracion = iteracion + 1;
						for(Vacante vacante : vacantesAsignadas){
							buscarVacantesParaEsteCurso(disVsVac.getId(),cursosCompletos, auxCant - disVsVac.getVacantes().size());
						}
					}

				}
			}

		}
	}

	private static void buscarVacantesParaEsteCurso(int id, List<Curso> cursosCompletos, int faltanVacantes) {
		List<Vacante> aux = new ArrayList<Vacante>();
		for(Curso curso : cursosCompletos){
			if(curso.getVacantes().size() > 0){
				for(Vacante vacante : curso.getVacantes()){
					if(vacante.getCurso().getId() == id){
						aux.add(vacante);
					}
				}
			}
		}
	}

	private static void borrasLasOtrasVacantes(Vacante first, List<Curso> cursos,
			List<Vacante> vacantesAsignadasExtra) {
		buscarCursoById(first.getCurso().getId(), cursos).getVacantes().remove(first);
		for (Vacante vac : first.getPreinscripcion().getVacantes()) {
			Curso cur = buscarCursoById(vac.getCurso().getId(), cursos);
			for (Vacante vacASacar : cur.getVacantes()) {
				if (vacASacar.getId() == first.getId()) {
					System.out
							.println("Descartos la vacante " + first.getId() + "del aspirante con numero de documento "
									+ first.getPreinscripcion().getAspirante().getNumeroDocumento());
					vacantesAsignadasExtra.add(vacASacar);
					cur.getVacantes().remove(vacASacar);
				}
			}
		}
	}

	private static Curso buscarCursoById(int codigo, List<Curso> preInscripcionesSinAsignacion) {
		for (Curso cur : preInscripcionesSinAsignacion) {
			if (cur.getId() == codigo) {
				return cur;
			}
		}
		return null;
	}
}