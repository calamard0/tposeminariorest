package ar.edu.uade.helper;

import ar.edu.uade.controller.SistemaInscripciones;
import ar.edu.uade.model.Aspirante;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.DatosColegioAnt;
import ar.edu.uade.model.DatosExtra;
import ar.edu.uade.model.DatosHermano;
import ar.edu.uade.model.Domicilio;
import ar.edu.uade.model.Vacante;

public class CalcularPesosHelper {

	public static float calcularPesopeso(Vacante vac, DatosExtra datosExtra, Aspirante aspirante) {
		Curso auxCurso = vac.getCurso();
		Colegio auxCol = SistemaInscripciones.getInstance().buscarColegioPorCodigoDeCurso(auxCurso.getCodigo());
		Domicilio auxDom = aspirante.getDomicilio();

		if (auxCol != null) {
			if (datosExtra instanceof DatosColegioAnt) {
				DatosColegioAnt auxColAnt = (DatosColegioAnt) datosExtra;
				if (auxColAnt.getColegio().getCodigo() == auxCol.getCodigo()) {
					return (Reglas.reglaUno(auxCol, auxDom) / 23) * vac.getPrioridad();
				}
			}
			if (datosExtra instanceof DatosHermano) {
				DatosHermano auxHerm = (DatosHermano) datosExtra;
				if (auxHerm.getColegio().getCodigo() == auxCol.getCodigo()) {
					return (Reglas.reglaDos(auxCol, auxHerm) / 23) * vac.getPrioridad();
				}
			}
		}
		return 0;
	}
}
