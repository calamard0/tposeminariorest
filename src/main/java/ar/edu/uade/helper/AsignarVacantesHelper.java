package ar.edu.uade.helper;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.controller.SistemaInscripciones;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.Vacante;

public class AsignarVacantesHelper {

	private List<Vacante> vacantesAsignadas = new ArrayList<Vacante>();
	private List<Vacante> vacantesAsignadasExtra = new ArrayList<Vacante>();
	private List<Colegio> auxCantVacantes = SistemaInscripciones.getInstance().getColegios();
	private List<Curso> preInscripcionesSinAsignacion = PreparacionAsignarVacantes.getCursosYVacantes(auxCantVacantes);
	private Integer vacantesDisponibles = PreparacionAsignarVacantes.vacantesDisp(auxCantVacantes);

	private void asignarVacantes() {

		while (this.preInscripcionesSinAsignacion.size() == 0 || this.vacantesDisponibles == 0) {
			for (Curso disVsVac : preInscripcionesSinAsignacion) {
				int auxCant = disVsVac.getVacantesDisponibles();
				while (auxCant == 0 || disVsVac.getVacantes().size() == 0) {
					Vacante auxVac = disVsVac.getVacantes().first();
					System.out.println("Se le asigna la vacante " + auxVac.getId() + "del aspirante con numero de documento " + auxVac.getPreInscripcion().getAspirante().getNroDocumento());
					this.vacantesAsignadas.add(auxVac);
					this.vacantesDisponibles = this.vacantesDisponibles - 1;
					disVsVac.getVacantes().remove(auxVac);
					borrasLasOtrasVacantes(auxVac);
				}
			}
			if(this.preInscripcionesSinAsignacion.size() != 0 && this.vacantesDisponibles != 0){
//				for(Curso cur : buscarCursosConDisponibiliad()){
					
//				}
			}
		}
	}

	private void borrasLasOtrasVacantes(Vacante first) {
		for(Vacante vac: first.getPreInscripcion().getVacantes()){
			Curso cur = buscarCursoById(vac.getCurso().getCodigo());
			for(Vacante vacASacar : cur.getVacantes()){
				if(vacASacar.getId() == first.getId()){
					System.out.println("Descartos la vacante " + first.getId() + "del aspirante con numero de documento " + first.getPreInscripcion().getAspirante().getNroDocumento());
					this.vacantesAsignadasExtra.add(vacASacar);
				    cur.getVacantes().remove(vacASacar);
				}
			}
		}
	}

	private Curso buscarCursoById(int codigo) {
		for(Curso cur : preInscripcionesSinAsignacion){
			if(cur.getCodigo() == codigo){
				return cur;
			}
		}
		return null;
	}
}
