package ar.edu.uade.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import ar.edu.uade.dto.ColegioDTO;
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
	
	@RequestMapping(value = "/insertColegio")
	public void crearColegio() {
		
		Colegio col = new Colegio("Colegio2", "Calle Nueva", null);
		
		Curso cu = new Curso("CursoA", 1, 30, col);
		Curso cu2 = new Curso("CursoB", 2, 40, col);
		Curso cu3 = new Curso("CursoC", 3, 50, col);
		
		col.setId(2);
		
		Set<Curso> cursos = new HashSet<Curso>();
		cursos.add(cu);
		cursos.add(cu2);
		cursos.add(cu3);
		
		col.setCursos(cursos);
		
		colegioRepository.save(col);
	}
	
	@RequestMapping(value = "/insertDatosLaborales")
	public void crearDatosLaborales() {
		
		Domicilio domic = new Domicilio();
		domic.setCalle("Calle1");
		domic.setCodigoPostal("1111");
		domic.setDepartamento("De");
		domic.setNumero(1234);
		domic.setPiso(1);
		domic.setProvincia("Provincia1");
		domic.setTipo("TIpo1");
		domic.setVilla("Villa1");
		
		DatosLaborales datLab = new DatosLaborales();
		datLab.setDatosReferencia("Referencia1");
		datLab.setDomicilio(domic);
		datLab.setProfesion("Profesion1");
		datLab.setSituacionLaboral("Situacion Laboral");
		datLab.setSostenFamiliar(true);
		datLab.setTelefono("2323232");
		
		datosLaboralesRepository.save(datLab);
			
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
	
	@RequestMapping(value = "/insertAspirante")
	public void crearAspirante() {
		
		Domicilio domic = new Domicilio();
		domic.setCalle("Calle1");
		domic.setCodigoPostal("1111");
		domic.setDepartamento("De");
		domic.setNumero(1234);
		domic.setPiso(1);
		domic.setProvincia("Provincia1");
		domic.setTipo("TIpo1");
		domic.setVilla("Villa1");
		
		Aspirante asp = new Aspirante();
		asp.setApellido("Apellido");
		asp.setCertificadoDisca(true);
		asp.setDomicilio(domic);
		asp.setFechaNacimiento(new java.util.Date());
		asp.setNombre("Nombre");
		asp.setNumeroDocumento("1111");
		asp.setPaisNacimiento("Arg");
		asp.setSexo("M");
		asp.setSistemaSalud("Sistema Salud");
		asp.setTipoDocumento("Dni");
		
		ProblemaSalud ps = new ProblemaSalud();
		ps.setDescripcion("Desc");
		ps.setAspirante(asp);
		
		ProblemaSalud ps1 = new ProblemaSalud();
		ps1.setDescripcion("Desc2222");
		ps1.setAspirante(asp);
		
		Set<ProblemaSalud> problemas = new HashSet<ProblemaSalud>();
		problemas.add(ps1);
		problemas.add(ps);
		asp.setProblemasSalud(problemas);
		
		aspRepo.save(asp);
			
	}
	
	@RequestMapping(value = "/insertDatosExtra")
	public void crearDatosExtra() {
		
		DatosPadre dp = new DatosPadre();
		List<Colegio> colegios = colegioRepository.findByNombre("Colegio2");
		dp.setColegio(colegios.get(0));
//		dp.setFichaMunicipal("Ficha Munic");
//		dp.setNombre("Nombre");
		
		daExRepo.save(dp);
		
		DatosHermano dh = new DatosHermano();
		dh.setColegio(colegios.get(0));
//		dh.setApellido("Apellido");
//		dh.setNombre("Nombre");
//		dh.setNumeroDocumento("323232");
		
		daExRepo.save(dh);
		
		DatosColegioAnt dca = new DatosColegioAnt();
		dca.setColegio(colegios.get(0));
		
		daExRepo.save(dca);
	}
	
	@RequestMapping(value = "/insertResponsable")
	public void crearResponsable() {
		
		Domicilio domic = new Domicilio();
		domic.setCalle("Calle1");
		domic.setCodigoPostal("1111");
		domic.setDepartamento("De");
		domic.setNumero(1234);
		domic.setPiso(1);
		domic.setProvincia("Provincia1");
		domic.setTipo("TIpo1");
		domic.setVilla("Villa1");
		
		DatosLaborales datLab = new DatosLaborales();
		datLab.setDatosReferencia("Referencia1");
		datLab.setDomicilio(domic);
		datLab.setProfesion("Profesion1");
		datLab.setSituacionLaboral("Situacion Laboral");
		datLab.setSostenFamiliar(true);
		datLab.setTelefono("2323232");
		
		Responsable resp = new Responsable();
		resp.setApellido("Apellido");
		resp.setDatosLaborales(datLab);
		resp.setDomicilio(domic);
		resp.setEmail("Email");
		resp.setNombre("Nombre");
		resp.setNumeroDocumento("23232");
		resp.setPaisNacimiento("PaisNac");
		resp.setTelefonoAlternativo("telefonoAlternativ");
		resp.setTelefonoParticular("telefonoParticular");
		resp.setTipoDocumento("tipoDo");
		resp.setVinculoAspirante("vinculoAspirante");
		
		respRepo.save(resp);
			
	}
	
	@RequestMapping(value = "/getResponsables")
	public Iterable<Responsable> getResponsables() {
		return respRepo.findAll();
	}
	
	@RequestMapping(value = "/insertPreInscripcion")
	public void crearPreInscripcion() {
		
		List<Colegio> colegios = colegioRepository.findByNombre("Colegio2");
		
		Domicilio domic = new Domicilio();
		domic.setCalle("Calle1");
		domic.setCodigoPostal("1111");
		domic.setDepartamento("De");
		domic.setNumero(1234);
		domic.setPiso(1);
		domic.setProvincia("Provincia1");
		domic.setTipo("TIpo1");
		domic.setVilla("Villa1");
		
		DatosLaborales datLab = new DatosLaborales();
		datLab.setDatosReferencia("Referencia1");
		datLab.setDomicilio(domic);
		datLab.setProfesion("Profesion1");
		datLab.setSituacionLaboral("Situacion Laboral");
		datLab.setSostenFamiliar(true);
		datLab.setTelefono("2323232");
		
		Aspirante asp = new Aspirante();
		asp.setApellido("Apellido");
		asp.setCertificadoDisca(true);
		asp.setDomicilio(domic);
		asp.setFechaNacimiento(new java.util.Date());
		asp.setNombre("Nombre");
		asp.setNumeroDocumento("1111");
		asp.setPaisNacimiento("Arg");
		asp.setSexo("M");
		asp.setSistemaSalud("Sistema Salud");
		asp.setTipoDocumento("Dni");
		
		DatosHermano dh = new DatosHermano();
		dh.setColegio(colegios.get(0));
//		dh.setApellido("Apellido");
//		dh.setNombre("Nombre");
//		dh.setNumeroDocumento("323232");
		
		Responsable resp = new Responsable();
		resp.setApellido("Apellido");
		resp.setDatosLaborales(datLab);
		resp.setDomicilio(domic);
		resp.setEmail("Email");
		resp.setNombre("Nombre");
		resp.setNumeroDocumento("23232");
		resp.setPaisNacimiento("PaisNac");
		resp.setTelefonoAlternativo("telefonoAlternativ");
		resp.setTelefonoParticular("telefonoParticular");
		resp.setTipoDocumento("tipoDo");
		resp.setVinculoAspirante("vinculoAspirante");
		
		Iterable<Curso> cursos = cursoRepo.findAll();
		
		PreInscripcion pre = new PreInscripcion();
		pre.setAspirante(asp);
		pre.setCurso(cursos.iterator().next());
		pre.setDatosExtra(dh);
		pre.setEstado("INI");
		pre.setResponsable(resp);
		pre.setValidada(true);
		
		Vacante vac = new Vacante();
		vac.setCurso(cursos.iterator().next());
		vac.setEstaAprobada(true);
		vac.setPeso(14);
		vac.setPreinscripcion(pre);
		vac.setPrioridad(1);
		
		Vacante vac1 = new Vacante();
		vac1.setCurso(cursos.iterator().next());
		vac1.setEstaAprobada(true);
		vac1.setPeso(10);
		vac1.setPreinscripcion(pre);
		vac1.setPrioridad(2);
		
		Set<Vacante> vacantes = new HashSet<Vacante>();
		vacantes.add(vac1);
		vacantes.add(vac);
		
		pre.setVacantes(vacantes);
		
		preRepo.save(pre);
			
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
	
}
