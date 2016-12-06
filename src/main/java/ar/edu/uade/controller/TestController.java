package ar.edu.uade.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.uade.dao.AspiranteRepository;
import ar.edu.uade.dao.ColegioRepository;
import ar.edu.uade.dao.CursoRepository;
import ar.edu.uade.dao.DatosExtraRepository;
import ar.edu.uade.dao.DatosLaboralesRepository;
import ar.edu.uade.dao.PreInscripcionRepository;
import ar.edu.uade.dao.ResponsableRepository;
import ar.edu.uade.dao.UsuarioRepository;
import ar.edu.uade.dao.VacanteRepository;
import ar.edu.uade.dto.ColegioDTO;
import ar.edu.uade.helper.CsvReader;
import ar.edu.uade.model.Aspirante;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.DatosColegioAnt;
import ar.edu.uade.model.DatosHermano;
import ar.edu.uade.model.DatosLaborales;
import ar.edu.uade.model.DatosPadre;
import ar.edu.uade.model.Domicilio;
import ar.edu.uade.model.PreInscripcion;
import ar.edu.uade.model.ProblemaSalud;
import ar.edu.uade.model.Responsable;
import ar.edu.uade.model.Usuario;
import ar.edu.uade.model.Vacante;

@RestController
@RequestMapping("test")
public class TestController {

	@Autowired
	ColegioRepository colegioRepository;
	
	@Autowired
	CursoRepository cursoRepo;
	
	@Autowired
	DatosLaboralesRepository datosLaboralesRepository;
	
	@Autowired
	DatosExtraRepository daExRepo;
	
	@Autowired
	AspiranteRepository aspRepo;
	
	@Autowired
	ResponsableRepository respRepo;
	
	@Autowired
	UsuarioRepository usuRepo;
	
	@Autowired
	PreInscripcionRepository preRepo;
	
	@Autowired
	VacanteRepository vacRepo;
	
	@RequestMapping(value = "/insertColegio")
	public void crearColegio() {
		
//		Colegio col = new Colegio("Colegio2", "Calle NuevaAAA", null);
//		
//		Curso cu = new Curso("CursoA", 1, 30, col);
//		//Curso cu2 = new Curso("CursoB", 2, 40, col);
//		//Curso cu3 = new Curso("CursoC", 3, 50, col);
//		
//		col.setId(446);
//		
//		Set<Curso> cursos = new HashSet<Curso>();
//		cursos.add(cu);
//		
//		col.setCursos(cursos);
//		
//		colegioRepository.save(col);
		colegioRepository.delete(446);
	}
	
	@RequestMapping(value = "/getColegios")
	public List<ColegioDTO> getColegios() {
		List<ColegioDTO> dtos = new ArrayList<ColegioDTO>();
		Iterable<Colegio> colegios = colegioRepository.findAll();
		for (Colegio colegio : colegios) {
			dtos.add(colegio.toDTO());
		}
		return dtos;
	}
	
	@RequestMapping(value = "/getColegio/{id_colegio}")
	public ColegioDTO getColegio(@PathVariable Integer id_colegio) {
		Colegio col = colegioRepository.findOne(id_colegio);
		return col.toDTO();
	}
	
	@RequestMapping(value = "/getDatosLaborales")
	public Iterable<DatosLaborales> getDatosLaborales() {
		return datosLaboralesRepository.findAll();
	}
	
	@RequestMapping(value = "/deleteDatosLaborales/{id}/{respId}")
	public void deleteDatosLaborales(@PathVariable Integer id, @PathVariable Integer respId) {
		
		Responsable resp = respRepo.findOne(respId);
		resp.setDatosLaborales(null);
		respRepo.save(resp);
		
		datosLaboralesRepository.delete(id);
	}

	@RequestMapping(value = "/getResponsables")
	public Iterable<Responsable> getResponsables() {
		return respRepo.findAll();
	}
	
	@RequestMapping(value = "/insertPreInscripcion")
	public void crearPreInscripcion() {
		
		int i = 0;
		List<String> nombresM = CsvReader.getInstancia().getNombresPorSexo("M");
		List<String> nombresF = CsvReader.getInstancia().getNombresPorSexo("F");
		List<String> apellidos = CsvReader.getInstancia().getApellidos();
		List<String> calles = CsvReader.getInstancia().getCalles();
		List<String> profesiones = CsvReader.getInstancia().getProfesiones();
		List<String> deptos = new ArrayList<String>() {{ add("A"); add("B"); add("C"); add("D"); }};
		List<Integer> pisos = new ArrayList<Integer>() {{ add(0); add(1); add(2); add(3); add(4); add(5); add(6);add(7);add(8);add(9);}};
		List<String> sexos = new ArrayList<String>() {{ add("M"); add("F"); }};
		List<String> datoExtra = new ArrayList<String>() {{ add("DP"); add("DH"); add("CA");  }};
		List<String> tipoResponsable = new ArrayList<String>() {{ add("Docente"); add("Persona"); }};
		int numeroDocumento = 44000000;
		int numeroDocumentoResp = 32000000;
		Date fechaNac = new GregorianCalendar(2010, Calendar.JANUARY, 1).getTime();
		Date fechaNacHermano = new GregorianCalendar(2012, Calendar.FEBRUARY, 1).getTime();
		
		Random rnd = new Random();
		int telefonoAlternativo = 24954444;
		int telefonoParticular = 45456677;
		int fichaMunicipal = 15433;
		int numeroJardin = 1;
		int grado = 1;
		
		// aca comienza a ciclar
		while ( i < 500 ) {
			// empieza vacantes
			List<Curso> cursos = cursoRepo.findByGrado(grado);
			int numero = rnd.nextInt(4500 - 1 + 1) + 1;
			String apellidoResponsable = apellidos.get(rnd.nextInt(apellidos.size()));
			
			// domicilio laboral
			Domicilio domic = this.crearDomicilio(calles, pisos, deptos, numero, rnd);
			DatosLaborales datLab = this.crearDatosLaborales(domic, profesiones, telefonoParticular, rnd);
			
			telefonoParticular += 157;
			numero = rnd.nextInt(4500 - 1 + 1) + 1;
			
			Domicilio domicAspirante = crearDomicilio(calles, pisos, deptos, numero, rnd);
			Aspirante asp = this.crearAspirante(domicAspirante, sexos, nombresM, nombresF, apellidoResponsable, numeroDocumento, rnd, fechaNac);
			Responsable resp = this.crearReponsable(datLab, sexos, nombresM, nombresF, apellidoResponsable, numeroDocumentoResp, rnd, telefonoAlternativo, telefonoParticular);
			
			PreInscripcion pre = new PreInscripcion();
			pre.setAspirante(asp);
			pre.setEstado("INI");
			pre.setResponsable(resp);
			pre.setValidada(true);
			
			String datEx = datoExtra.get(rnd.nextInt(datoExtra.size()));
			Curso cur = cursos.get(rnd.nextInt(cursos.size()));
			if ( datEx.equals("DP") )
				pre.setDatosExtra(this.crearDatosPadre(cur.getColegio(), fichaMunicipal, tipoResponsable, rnd));
			
			if ( datEx.equals("DH") ) {
				numeroDocumento += 359;
				pre.setDatosExtra(this.crearDatosHermano(cur.getColegio(), apellidoResponsable, nombresM, numeroDocumento, rnd, fechaNacHermano));
			}
			
			if ( datEx.equals("CA") ) {
				numeroJardin += 1;
				pre.setDatosExtra(this.crearDatosColegioAnt(calles, rnd, numeroJardin));
			}
			
			Set<Vacante> vacantes = this.crearVacantes(cur, cursos, rnd, pre);
			pre.setVacantes(vacantes);
			
			preRepo.save(pre);
			
			telefonoParticular += 107;
			telefonoAlternativo += 208;
			numeroDocumento += 359;
			numeroDocumentoResp += 148;
			fichaMunicipal += 567;
			i += 1;
			
			if ( grado == 7)
				grado = 1;
			else
				grado += 1;
			
			fechaNac = sumarRestarDiasFecha(fechaNac, grado);
			fechaNacHermano = sumarRestarDiasFecha(fechaNacHermano, grado);
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(fechaNac);
//			if ( calendar.get(Calendar.YEAR) == 2011) {
//				fechaNac = new GregorianCalendar(2010, Calendar.JANUARY, 1).getTime();
//			} 
//			else 
//			{
//				fechaNac = sumarRestarDiasFecha(fechaNac, grado);
//			}
//			
//			calendar = Calendar.getInstance();
//			calendar.setTime(fechaNacHermano);
//			if ( calendar.get(Calendar.YEAR) == 2013) {
//				fechaNacHermano = new GregorianCalendar(2012, Calendar.JANUARY, 1).getTime();
//			} 
//			else 
//			{
//				fechaNacHermano = sumarRestarDiasFecha(fechaNacHermano, grado);
//			}
			
			
		}
		// aca termina el ciclo
			
	}

	private Set<Vacante> crearVacantes(Curso cur, List<Curso> cursos, Random rnd, PreInscripcion pre) {
		Set<Vacante> vacantes = new HashSet<Vacante>();
		int peso = 8;
		while ( peso > 0 ) {
			Vacante vac = new Vacante();
			if ( peso == 8 )
				vac.setCurso(cur);
			else
				vac.setCurso(cursos.get(rnd.nextInt(cursos.size())));
			vac.setEstaAprobada(false);
			vac.setPeso(peso);
			vac.setPreinscripcion(pre);
			vac.setPrioridad(peso);
			vacantes.add(vac);
			peso -= 1;
		}
		return vacantes;
	}

	private DatosColegioAnt crearDatosColegioAnt(List<String> calles, Random rnd, int numeroJardin) {
		DatosColegioAnt dca = new DatosColegioAnt();
		dca.setDireccionJardin(calles.get(rnd.nextInt(calles.size())) + " 1111");
		dca.setNombreJardin("Jardin " + String.valueOf(numeroJardin));
		return dca;
	}

	private DatosHermano crearDatosHermano(Colegio col, String apellidoResponsable, List<String> nombresM, int numeroDocumento, Random rnd, Date fechaNacHermano) {
		DatosHermano dh = new DatosHermano();
		dh.setColegio(col);
		dh.setApellido(apellidoResponsable);
		dh.setNombre(nombresM.get(rnd.nextInt(nombresM.size())));
		dh.setNumeroDocumento(String.valueOf(numeroDocumento));
		
		Calendar c = Calendar.getInstance();
		c.set(2010, 6, 29, 0, 0);  
		dh.setFechaNacimiento(c.getTime());
		dh.setTipoDocumento("DNI");
		return dh;
	}

	private DatosPadre crearDatosPadre(Colegio col, int fichaMunicipal, List<String> tipoResponsable, Random rnd) {
		DatosPadre dp = new DatosPadre();
		dp.setColegio(col);
		dp.setFichaMunicipal(String.valueOf(fichaMunicipal));
		dp.setTipoResponsable(tipoResponsable.get(rnd.nextInt(tipoResponsable.size())));
		return dp;
	}

	private Responsable crearReponsable(DatosLaborales datLab, List<String> sexos, List<String> nombresM, List<String> nombresF, String apellidoResponsable, int numeroDocumentoResp, Random rnd, int telefonoAlternativo, int telefonoParticular) {
		Responsable resp = new Responsable();
		resp.setApellido(apellidoResponsable);
		resp.setDatosLaborales(datLab);
		resp.setEmail(apellidoResponsable + "@mail.com");
		resp.setNumeroDocumento(String.valueOf(numeroDocumentoResp));
		resp.setPaisNacimiento("Argentina");
		resp.setTelefonoAlternativo(String.valueOf(telefonoAlternativo));
		resp.setTelefonoParticular(String.valueOf(telefonoParticular));
		resp.setTipoDocumento("DNI");
		resp.setTrabaja(true);
		
		String sexo = sexos.get(rnd.nextInt(sexos.size()));
		
		if ( sexo.equals("M") ) {
			resp.setNombre(nombresM.get(rnd.nextInt(nombresM.size())));
			resp.setVinculoAspirante("Padre");
		} else {
			resp.setNombre(nombresF.get(rnd.nextInt(nombresF.size())));
			resp.setVinculoAspirante("Madre");
		}
		
		return resp;
	}

	private Aspirante crearAspirante(Domicilio domicAspirante, List<String> sexos, List<String> nombresM, List<String> nombresF, String apellidoResponsable, int numeroDocumento, Random rnd, Date fechaNac) {
		Aspirante asp = new Aspirante();
		asp.setApellido(apellidoResponsable);
		asp.setCertificadoDisca(false);
		asp.setDomicilio(domicAspirante);
		asp.setFechaNacimiento(fechaNac);
		asp.setNumeroDocumento(String.valueOf(numeroDocumento));
		asp.setPaisNacimiento("Argentina");
		
		String sexo = sexos.get(rnd.nextInt(sexos.size()));
		
		if (sexo.equals("M")) {
			asp.setNombre(nombresM.get(rnd.nextInt(nombresM.size())));
			asp.setSexo("M");
		}
		else {
			asp.setNombre(nombresF.get(rnd.nextInt(nombresF.size())));
			asp.setSexo("F");
		}
		asp.setSistemaSalud("Sistema Salud");
		asp.setTipoDocumento("DNI");
		return asp;
	}

	@RequestMapping(value = "/getPreInscripciones")
	public Iterable<PreInscripcion> getPreInscripciones() {
		return preRepo.findAll();
	}
	
	@RequestMapping(value = "/insertUsuario")
	public void crearUsuario() {
		
		Usuario usu = new Usuario();
		usu.setNombreUsuario("calamar");
		usu.setPassword("pass");
		usu.setRol("Rol1");
		
		usuRepo.save(usu);
		
	}
	
	private Domicilio crearDomicilio(List<String> calles, List<Integer> pisos, List<String> deptos, int numero, Random rnd) {

		Domicilio domic = new Domicilio();
		domic.setCalle(calles.get(rnd.nextInt(calles.size())));
		domic.setCodigoPostal(String.valueOf(numero));
		int piso = pisos.get(rnd.nextInt(pisos.size()));
		domic.setNumero(numero);
		domic.setPiso(piso);
		if ( piso > 0) {
			domic.setDepartamento(deptos.get(rnd.nextInt(deptos.size())));
			domic.setTipo("Depto");
		} 
		else {
			domic.setDepartamento("");
			domic.setTipo("Casa");
		}
		domic.setProvincia("CABA");
		domic.setVilla("");
		return domic;
		
	}

	private DatosLaborales crearDatosLaborales(Domicilio domic, List<String> profesiones, int telefonoParticular, Random rnd) {
		DatosLaborales datLab = new DatosLaborales();
		datLab.setDatosReferencia("SinRef");
		datLab.setDomicilio(domic);
		datLab.setProfesion(profesiones.get(rnd.nextInt(profesiones.size())));
		datLab.setSostenFamiliar(true);
		datLab.setTelefono(String.valueOf(telefonoParticular));
		return datLab;
	}
	
	private Date sumarRestarDiasFecha(Date fecha, int grado){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		if (grado != 1)
			calendar.add(calendar.YEAR, -1);
		else
			calendar.add(calendar.YEAR, 6);
		return calendar.getTime();
	 }
	
	@RequestMapping(value = "/getPreInscripciones/{preinscripcionId}")
	public List<Vacante> getPreInscripciones(@PathVariable Integer preinscripcionId) {
		PreInscripcion preIns = preRepo.findOne(preinscripcionId);
		List<Vacante> vacantes = vacRepo.findByPreinscripcionOrderByPrioridadDesc(preIns);

		return vacantes;
	}
}
