package ar.edu.uade.helper;

import java.util.ArrayList;
import java.util.List;

import ar.edu.uade.controller.SistemaInscripciones;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.PreInscripcion;

public class AsignarVacantesHelper {

	private List<PreInscripcion> preInscripcionesAsignadas = new ArrayList<PreInscripcion>();
	private List<PreInscripcion> preInscripcionesSinAsignacion = SistemaInscripciones.getInstance().getPreInscripciones();
	private List<Colegio> auxCantVacantes = SistemaInscripciones.getInstance().getColegios();
	private Integer vacantesDisponibles = PreparacionAsignarVacantes.vacantesDisp(auxCantVacantes);
	
	private void asignarVacantes(){ 
		
		while(this.preInscripcionesSinAsignacion.size() == 0 || this.vacantesDisponibles == 0){
			for(PreInscripcion auxPreIn : preInscripcionesSinAsignacion){
				
			}
		}
	}
}
