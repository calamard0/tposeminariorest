package ar.edu.uade.helper;

import ar.edu.uade.controller.SistemaInscripciones;
import ar.edu.uade.model.Aspirante;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.DatosColegioAnt;
import ar.edu.uade.model.DatosExtra;
import ar.edu.uade.model.DatosHermano;
import ar.edu.uade.model.DatosPadre;
import ar.edu.uade.model.Domicilio;
import ar.edu.uade.model.Responsable;
import ar.edu.uade.model.Vacante;

public class CalcularPesosHelper {

	public static float calcularPesopeso(Vacante vac, DatosExtra datosExtra, Aspirante aspirante, Responsable responsable) {
		Curso auxCurso = vac.getCurso();
		Colegio auxCol = SistemaInscripciones.getInstance().buscarColegioPorCodigoDeCurso(auxCurso.getCodigo());
		Domicilio auxDom = aspirante.getDomicilio();

		if (auxCol != null) {
			if (datosExtra instanceof DatosColegioAnt) {
				DatosColegioAnt auxColAnt = (DatosColegioAnt) datosExtra;
				if (auxColAnt.getColegio().getCodigo() == auxCol.getCodigo()) {
					return (Reglas.reglaUno(auxCol, auxDom) / 20) * vac.getPrioridad();
				}
			}
			if (datosExtra instanceof DatosHermano) {
				DatosHermano auxHerm = (DatosHermano) datosExtra;
				if (auxHerm.getColegio().getCodigo() == auxCol.getCodigo()) {
					return (Reglas.reglaDos(auxHerm) / 20) * vac.getPrioridad();
				}
			}
			if (datosExtra instanceof DatosPadre) {
				DatosPadre auxPadr = (DatosPadre) datosExtra;
				if (auxPadr.getColegio().getCodigo() == auxCol.getCodigo()) {
					if (auxPadr.getFichaMunicipal() == "Personal") {
						return (Reglas.reglaTres(auxPadr) / 20) * vac.getPrioridad();
					}
					if (auxPadr.getFichaMunicipal() == "Docente") {
						return (Reglas.reglaCuatro(auxPadr) / 20) * vac.getPrioridad();
					}
				}
			}
			if (Reglas.dist(auxCol.getDireccion(), auxDom) < 10) {
				return (Reglas.reglaCinco(responsable, aspirante) / 20) * vac.getPrioridad();
			}
			if (aspirante.getApellido() == "fue al jardin del ministerio de educacion") {
				return (Reglas.reglaSeisYSiete(aspirante) / 20) * vac.getPrioridad();
			}
			if (aspirante.getApellido() == "vive dentro de la ciudad autonoma de buenos aires"){
				return (Reglas.reglaOchoYNueve(responsable, auxCol.getDireccion()) / 20) * vac.getPrioridad();
			}else{
				return (Reglas.reglaDiezYOnce(responsable, auxCol.getDireccion()) / 20) * vac.getPrioridad();	
			}
			
		}
		return ((1/20)*vac.getPrioridad());
	}
}
