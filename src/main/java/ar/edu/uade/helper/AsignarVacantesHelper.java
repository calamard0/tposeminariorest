package ar.edu.uade.helper;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.model.Curso;
import ar.edu.uade.model.Vacante;

public class AsignarVacantesHelper {
	
	private static AsignarVacantesHelper instancia;
	
	public static AsignarVacantesHelper getInstance(){
		if(instancia == null){
			instancia = new AsignarVacantesHelper();
		}
		return instancia;
	}

	private List<Vacante> vacantesAsignadasExtra = new ArrayList<Vacante>();
	private List<Vacante> vacantesAsignadas = new ArrayList<Vacante>();
	private Integer vacantesDisponibles = 0;
	private List<Curso> cursosCompletos = new ArrayList<Curso>();
	List<Integer> vacantesAprobadas;
	
	public  List<Integer> asignarVacantes(List<Curso> cursos, int grado, List<Vacante> vacantes) {
		
		vacantesAprobadas = new ArrayList<Integer>();
		
		vacantesDisponibles = PreparacionAsignarVacantes.vacantesDisp(cursos);

		System.out.println("Se procesa el grado " + grado);

		if ((vacantes.size() / 8) >= vacantesDisponibles) {
			while (vacantesDisponibles != 0) {
				for (Curso disVsVac : cursos) {
					int auxCant = disVsVac.getVacantesDisponibles();
					if (disVsVac.getVacantes().size() > auxCant) {
						asignarVacantesAEsteCurso(disVsVac, cursos);
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
										buscarVacanteParaEsteCurso(vacante, disVsVac.getId(),
												cursos, auxCant - disVsVac.getVacantes().size());
									}
								}
							}

						}
						asignarVacantesAEsteCurso(disVsVac, cursos);
					}

				}
			}

		} else {
			for (Curso disVsVac : cursos) {
				int auxCant = disVsVac.getVacantesDisponibles();
				if (disVsVac.getVacantes().size() > auxCant) {
					asignarVacantesAEsteCurso(disVsVac, cursos);
				}
			}
		}
		return vacantesAprobadas;
	}

	private void asignarVacantesAEsteCurso(Curso disVsVac, List<Curso> cursos) {
//		int vacantesDisponiblesParaEsteCurso = disVsVac.getVacantesDisponibles();
		for (Vacante auxVac : disVsVac.getVacantes()) {
			// PODRIA VALIDAR SI ES LA DE MAYOR PRIORIDAD PARA EL ASPIRANTE
			auxVac.setEstaAprobada(true);
			vacantesAprobadas.add(auxVac.getId());
			System.out
					.println("Se le pre asigna la vacante " + auxVac.getId() + " del aspirante con numero de documento "
							+ auxVac.getPreinscripcion().getAspirante().getNumeroDocumento());
			vacantesAsignadas.add(auxVac);
			this.vacantesDisponibles = this.vacantesDisponibles - 1;
//			vacantesDisponiblesParaEsteCurso = disVsVac.getVacantesDisponibles() -1;
			borrasLasOtrasVacantes(auxVac, cursos, cursosCompletos);
//			if(disVsVac.getVacantesDisponibles() == 0){
//				break;
//			}
		}
		cursosCompletos.add(disVsVac);
	}

	private  void buscarVacanteParaEsteCurso(Vacante vacante, int id,
			List<Curso> cursos, int cantFaltantes) {
		List<Vacante> vacantesCambiantes = new ArrayList<Vacante>();
		for (int i = 0; i < vacantesAsignadasExtra.size() && cantFaltantes < 0; i++) {
			Vacante aux = vacantesAsignadasExtra.get(i);
			if (vacante.getPreinscripcion().getId() == aux.getPreinscripcion().getId()
					&& aux.getCurso().getId() == id) {
				vacante.setEstaAprobada(false);
				vacantesAprobadas.remove(vacante.getId());
				System.out.println("Se le remueve la asignacion de la vacante al curso " + vacante.getCurso().getId()
						+ " al aspirante con numero de documento "
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

	private  int cursosConVacantesDeSobra(Curso curso) {
		int cant = 0;
		for (Vacante vac : curso.getVacantes()) {
			if (!vac.isEstaAprobada()) {
				cant = cant + 1;
			}
		}
		return cant;
	}

	private  void borrasLasOtrasVacantes(Vacante first, List<Curso> cursos,
			List<Curso> cursosCompletos) {
		List<Curso> aux = new ArrayList<Curso>();
		aux.addAll(cursos);
		aux.removeAll(cursosCompletos);
//		buscarCursoById(first.getCurso().getId(), cursos).getVacantes().remove(first);
		List<Vacante> paraSacar = new ArrayList<Vacante>();
		for (Curso curso : aux) {
			paraSacar.clear();
			for (Vacante vac : curso.getVacantes()) {
				if (vac.getPreinscripcion().getId() == first.getPreinscripcion().getId() && !vac.isEstaAprobada()) {
					System.out
							.println("Descartos la vacante " + vac.getId() + " del aspirante con numero de documento "
									+ first.getPreinscripcion().getAspirante().getNumeroDocumento());
					vacantesAsignadasExtra.add(vac);
					paraSacar.add(vac);
				}
			}
			curso.getVacantes().removeAll(paraSacar);
		}
	}

	private  Curso buscarCursoById(int codigo, List<Curso> preInscripcionesSinAsignacion) {
		for (Curso cur : preInscripcionesSinAsignacion) {
			if (cur.getId() == codigo) {
				return cur;
			}
		}
		return null;
	}
}