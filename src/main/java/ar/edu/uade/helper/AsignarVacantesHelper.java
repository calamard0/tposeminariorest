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

		System.out.println("Se procesa el grado " + grado);

		if (vacantes.size() >= vacantesDisponibles) {
			while (vacantesDisponibles != 0) {
				for (Curso disVsVac : cursos) {
					int auxCant = disVsVac.getVacantesDisponibles();
					if (disVsVac.getVacantes().size() > auxCant) {
						asignarVacantesAEsteCurso(disVsVac, cursos, vacantesAsignadasExtra, vacantesDisponibles,
								vacantesAsignadas, cursosCompletos);
					} else {
						for (int i = 0; i < cursosCompletos.size()
								&& (auxCant - disVsVac.getVacantes().size()) < 0; i++) {
							Curso curso = cursosCompletos.get(i);
							if (cursosConVacantesDeSobra(curso) > 0) {
								for (int j = 0; j < curso.getVacantes().size()
										&& (auxCant - disVsVac.getVacantes().size()) < 0; j++) {
									// verificar si funca esto
									Vacante vacante = ((List<Vacante>) curso.getVacantes()).get(j);
									if (vacante.isEstaAprobada()) {
										buscarVacanteParaEsteCurso(vacante, vacantesAsignadasExtra, disVsVac.getId(),
												cursos, auxCant - disVsVac.getVacantes().size());
									}
								}
							}

						}
						asignarVacantesAEsteCurso(disVsVac, cursos, vacantesAsignadasExtra, vacantesDisponibles,
								vacantesAsignadas, cursosCompletos);
					}

				}
			}

		} else {
			for (Curso disVsVac : cursos) {
				int auxCant = disVsVac.getVacantesDisponibles();
				if (disVsVac.getVacantes().size() > auxCant) {
					asignarVacantesAEsteCurso(disVsVac, cursos, vacantesAsignadasExtra, vacantesDisponibles,
							vacantesAsignadas, cursosCompletos);
				}
			}
		}
	}

	private static void asignarVacantesAEsteCurso(Curso disVsVac, List<Curso> cursos,
			List<Vacante> vacantesAsignadasExtra, Integer vacantesDisponibles, List<Vacante> vacantesAsignadas,
			List<Curso> cursosCompletos) {
		for (Vacante auxVac : disVsVac.getVacantes()) {
			// PODRIA VALIDAR SI ES LA DE MAYOR PRIORIDAD PARA EL ASPIRANTE
			auxVac.setEstaAprobada(true);
			System.out
					.println("Se le pre asigna la vacante " + auxVac.getId() + "del aspirante con numero de documento "
							+ auxVac.getPreinscripcion().getAspirante().getNumeroDocumento());
			vacantesAsignadas.add(auxVac);
			vacantesDisponibles = vacantesDisponibles - 1;
			borrasLasOtrasVacantes(auxVac, cursos, vacantesAsignadasExtra);
		}
		cursosCompletos.add(disVsVac);
	}

	private static void buscarVacanteParaEsteCurso(Vacante vacante, List<Vacante> vacantesAsignadasExtra, int id,
			List<Curso> cursos, int cantFaltantes) {
		List<Vacante> vacantesCambiantes = new ArrayList<Vacante>();
		for (int i = 0; i < vacantesAsignadasExtra.size() && cantFaltantes < 0; i++) {
			Vacante aux = vacantesAsignadasExtra.get(i);
			if (vacante.getPreinscripcion().getId() == aux.getPreinscripcion().getId()
					&& aux.getCurso().getId() == id) {
				vacante.setEstaAprobada(false);
				System.out.println("Se le remueve la asignacion de la vacante al curso " + vacante.getCurso().getId()
						+ "al aspirante con numero de documento "
						+ vacante.getPreinscripcion().getAspirante().getNumeroDocumento()
						+ ", para preasignarle una vacante al curso " + id);
				Curso cur = buscarCursoById(id, cursos);
				cur.getVacantes().add(aux);
				vacantesCambiantes.add(aux);
				cantFaltantes = cantFaltantes - 1;
			}
		}
		vacantesAsignadasExtra.removeAll(vacantesCambiantes);
	}

	private static int cursosConVacantesDeSobra(Curso curso) {
		int cant = 0;
		for (Vacante vac : curso.getVacantes()) {
			if (!vac.isEstaAprobada()) {
				cant = cant + 1;
			}
		}
		return cant;
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