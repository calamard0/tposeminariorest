package ar.edu.uade.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uade.dao.ColegioRepository;
import ar.edu.uade.dao.CursoRepository;
import ar.edu.uade.dao.DatosExtraRepository;
import ar.edu.uade.dao.DatosLaboralesRepository;
import ar.edu.uade.dao.PreInscripcionRepository;
import ar.edu.uade.dao.ProblemaSaludRepository;
import ar.edu.uade.dto.CursoDTO;
import ar.edu.uade.dto.PreInscripcionDTO;
import ar.edu.uade.helper.CalcularPesosHelper;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.PreInscripcion;
import ar.edu.uade.model.ProblemaSalud;
import ar.edu.uade.model.Vacante;

@Controller
@RequestMapping("preinscripcion")
public class PreinscripcionController {
	
	class ColegioDistancia{
		int id;
		int distancia;
		public ColegioDistancia(int id, int distancia) {
			this.id = id;
			this.distancia = distancia; 
		}
	}
	
	class ColegioPromedio{
		int id;
		float promedio;
		public ColegioPromedio(int id, float promedio) {
			this.id = id;
			this.promedio = promedio; 
		}
	}
	
	 @Autowired
	 PreInscripcionRepository preRepo;
	 
	 @Autowired
	 ColegioRepository colRepo;
	 
	 @Autowired
	 DatosLaboralesRepository datLabRepo;
	 
	 @Autowired
	 CursoRepository cursoRepo;
	 
	 @Autowired
	 ProblemaSaludRepository probSaludRepo;
	 
	 @Autowired
	 DatosExtraRepository datExtRepo;
	 
	 @RequestMapping(value= "/crear", method = RequestMethod.POST)
	 @ResponseBody
	 public int crearPreinscripcion(@RequestBody PreInscripcionDTO dto) {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 PreInscripcion preInscripcion = preRepo.save(new PreInscripcion(dto));
		 
		 return preInscripcion.getId();
	 }
	 
	 @RequestMapping(value= "/modificar", method = RequestMethod.POST)
	 @ResponseBody
	 public int modificarPreinscripcion(@RequestBody PreInscripcionDTO dto) {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 PreInscripcion preInsActual = preRepo.findOne(dto.getId());
		 PreInscripcion preInsModificada = new PreInscripcion(dto);
		 realizarModificaciones(preInsActual, preInsModificada, false);
		 
		 return dto.getId();
	 }
	 
	 @RequestMapping(value= "/validar", method = RequestMethod.POST)
	 @ResponseBody
	 public int validarPreinscripcion(@RequestBody PreInscripcionDTO dto) {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 PreInscripcion preInsActual = preRepo.findOne(dto.getId());
		 PreInscripcion preInsModificada = new PreInscripcion(dto);
		 realizarModificaciones(preInsActual, preInsModificada, true);
		 
		 return dto.getId();
	 }
	 
	 private void realizarModificaciones(PreInscripcion preInsActual, PreInscripcion preInsModificada, boolean calcularPesos) {
		 
		 // se eliminan los problemas de salud actuales, para insertar los nuevos.
		 if ( preInsActual.getAspirante().getProblemasSalud() != null && preInsActual.getAspirante().getProblemasSalud().size() > 0 ) {
			 for (ProblemaSalud ps : preInsActual.getAspirante().getProblemasSalud()) {
				 probSaludRepo.delete(ps);
			}
		 }
		 
		 // verificar las vacantes contra las actuales.
		 for (Vacante vac : preInsModificada.getVacantes()) {
			 for (Vacante vacActual : preInsActual.getVacantes()) {
				if ( vacActual.getPrioridad() == vac.getPrioridad() ) {
					vac.setId(vacActual.getId());
					break;
				}
			 }
		 }
		 
		 if ( preInsActual.getDatosExtra() != null && preInsModificada.getDatosExtra() != null )
			 preInsModificada.getDatosExtra().setId(preInsActual.getDatosExtra().getId());
		 
		 if ( calcularPesos ) {
			 for(Vacante vac : preInsModificada.getVacantes()){
				Curso cur = cursoRepo.findOne(vac.getCurso().getId()) ;
				float peso = CalcularPesosHelper.calcularPesopeso(cur.getColegio(), vac, preInsModificada.getDatosExtra(),preInsModificada.getAspirante(), preInsModificada.getResponsable());
				vac.setPeso(peso);
			 }
//			 preInsModificada.calcularPesoVacantes();
		 } 
		 
		 boolean actualTieneDatosExtra = (preInsActual.getDatosExtra() != null);
		 int actualDatosExtraId = 0;
		 if ( actualTieneDatosExtra )
			 actualDatosExtraId = preInsActual.getDatosExtra().getId();
		 boolean actualTrabaja = (preInsActual.getResponsable().isTrabaja());
		 int actualDatosLaboralesId = 0;
		 if ( preInsActual.getResponsable().getDatosLaborales() != null )
			 actualDatosLaboralesId = preInsActual.getResponsable().getDatosLaborales().getId();
		 
		 preRepo.save(preInsModificada);
		 
		 if ( actualTieneDatosExtra && preInsModificada.getDatosExtra() == null )
			datExtRepo.delete(actualDatosExtraId);
		 
		 // si trabajaba, y ahora no lo hace, hay que eliminar datos laborales.
		 if ( actualTrabaja && ! preInsModificada.getResponsable().isTrabaja() )
			 datLabRepo.delete(actualDatosLaboralesId);
	 }

	 
	@RequestMapping("/control")
    public String view(Model model) {
        return "/views/validarPreinscripcion.html";
    }
	
	@RequestMapping(value= "/getPreInscripcion/{preinscripcionId}", method = RequestMethod.GET)
	 @ResponseBody
	 public PreInscripcionDTO getPreInscripcion(@PathVariable Integer preinscripcionId) {	
		 PreInscripcion preIns = preRepo.findOne(preinscripcionId);
		 return preIns.toDTO();
	 }
	 
	@RequestMapping(value = "/sugerirColegios/{direccion}/{grado}", method = RequestMethod.GET)
	@ResponseBody
	public List<CursoDTO> sugerirColegios(@PathVariable String direccion, @PathVariable int grado) {
		direccion += ", Buenos Aires, Ciudad Autónoma de Buenos Aires";
		List<Colegio> colegios = colRepo.findAll();
		ArrayList<ColegioDistancia> colegiosOrdenadosPorDistancia = getColegiosOrdenadosPorDistancia(direccion, colegios);

		List<Colegio> colegiosMasAptos = new ArrayList<Colegio>();
		for (ColegioDistancia colDis : colegiosOrdenadosPorDistancia) {
			colegiosMasAptos.add(colRepo.findById(colDis.id));
		}

		colegiosMasAptos = getColegiosMasAptosPorPromedioTotalLibre(colegiosMasAptos, grado, 5);

		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
		for (Colegio col : colegiosMasAptos) {
			Set<Curso> setCursos = col.getCursos();
			for (Curso cur : setCursos)
				if (cur.getGrado() == grado) {
					cursos.add(cur.toDTO());
				}
		}
		System.out.println("OK");
		return cursos;
	}
	 
	 public List<Colegio> getColegiosMasAptosPorPromedioTotalLibre(List<Colegio> colegios, int curso, int cantidadASugerir){
		 //Colegios con mejor promedio de vacantes totales/vacantes libres
		 List<Colegio> colegiosMasAptos = new ArrayList<Colegio>();
		 ArrayList<ColegioPromedio> colegiosPromedio = new ArrayList<ColegioPromedio>();
		 ArrayList<Colegio> colegiosAux = new ArrayList<Colegio>();
		 
		 for(Colegio col: colegios){
			 Set<Curso> cursos = col.getCursos();
			 Curso currentCurso = null;
			 for(Curso cur: cursos){
				 if(cur.getGrado()==curso)
					 currentCurso = cur;
			 }
			 int vacantesDisponibles;
			 int vacantes;
			 try {
				 vacantesDisponibles = currentCurso.getVacantesDisponibles();
			 } catch (Exception e){
				 vacantesDisponibles = 10;
			 }
			 try {
				 vacantes = currentCurso.getVacantes().size();
			 } catch (Exception e){
				 vacantes = 10;
			 }
			 float promedio = vacantes/vacantesDisponibles;
			 colegiosPromedio.add(new ColegioPromedio(col.getId(),promedio));
		 }
		 
		 System.out.println("Promedios: ");
		 //Crear lista de colegios
		 for(ColegioPromedio colPro : colegiosPromedio){
			 colegiosAux.add(colRepo.findById(colPro.id));
			 System.out.println(colPro.id + " - " + colPro.promedio);
		 }
		 
		 System.out.println("IDs colegios con mejor promedio: ");
		 int cantidad = colegiosPromedio.size();
		 for(int i=0; i<cantidadASugerir; i++){
			 float min = colegiosPromedio.get(0).promedio;
			 int curKey = colegiosPromedio.get(0).id;
			 //Random randomGenerator = new Random();
		     //int index = randomGenerator.nextInt(cantidad);
		     cantidad--;
		     int index = 0;
		     int curIndex = 0;
			 for(ColegioPromedio colPro : colegiosPromedio){
				 if(colPro.promedio < min){
					 min = colPro.promedio;
				 	 curKey = colPro.id;
				 	 curIndex = index; 
				 }
				 index++;
			 }
			 Colegio col = colRepo.findById(curKey);
			 System.out.println(col.getId());
			 colegiosMasAptos.add(col);
			 try{
				 colegiosPromedio.remove(curIndex);
			 } catch (Exception e){
				 System.out.println(e.toString());
			 }
		 }
		 return colegiosMasAptos;
	 }
	 
	 public ArrayList<ColegioDistancia> getColegiosOrdenadosPorDistancia(String direccion, List<Colegio> colegios){
		 direccion = direccion.replaceAll(" ", "+");
		 Hashtable<Integer,Integer> colegiosIds = apiCall(colegios,direccion);
		 ArrayList<ColegioDistancia> colegioDistanciaOrdenados = ordenarColegiosPorDistancia(colegiosIds);
		 return colegioDistanciaOrdenados;
	 }
	 
	 public ArrayList<ColegioDistancia> ordenarColegiosPorDistancia(Hashtable<Integer,Integer> colegiosIds) {

		ArrayList<ColegioDistancia> colegioDistancia = new ArrayList<ColegioDistancia>();
		for(Integer curKey : colegiosIds.keySet()){
			colegioDistancia.add(new ColegioDistancia(curKey,colegiosIds.get(curKey)));
		}

		Collections.sort(colegioDistancia,new Comparator<ColegioDistancia>() {
	        @Override
	        public int compare(ColegioDistancia s1, ColegioDistancia s2) {
	            if (s1.distancia > s2.distancia)
	                return 1;
	            if (s1.distancia < s2.distancia)
	                return -1;
	            else
	            	return 0;
	        }
	    });
    	System.out.println("Ordenar colegios por distancia: ");
	    for(ColegioDistancia colDis : colegioDistancia){
	    	System.out.println(colDis.id + " - " + colDis.distancia);
	    }
		return colegioDistancia;
	}

	public Hashtable<Integer,Integer> apiCall(List<Colegio> colegios,String direccion){
		 int maxCall = 25; //Cantidad de colegios en el envio a API
		 int maximoColegiosAUsar = colegios.size();
		 Hashtable<Integer,Integer> colegiosConDistancias = new Hashtable<Integer,Integer>();
		 //String apiKey = "AIzaSyBXuoucteWIPZ5I68RhZe-x-We2xktuGWs";
		 String apiKey = "AIzaSyDDCuxOg63WU4nGq9Vdxi59WNv3pwui62g";
		 for(int i=0; i<(Math.ceil((maximoColegiosAUsar/maxCall))); i++){
			 String destination = "";
			 for(int j=(0+(maxCall*i));j<maxCall+(maxCall*i);j++){
			 	destination+= colRepo.findById(j+1).getDireccion();
			 	destination+= ", Buenos Aires, Ciudad Autónoma de Buenos Aires";
			 	destination+= "|";
			 }
			 destination = destination.replaceAll(" ", "+");
			 destination.substring(0,destination.length()-1);
			 
			 URL apiCall;
			 String response = "";

			 try {
				apiCall = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + direccion + "&destinations=" + destination + "&language=es&key=" + apiKey);
				response = apiGet(apiCall);
			 } catch (MalformedURLException e) {
				e.printStackTrace();
			 }
			 String value = "";
		     JSONObject jsonObj = new JSONObject(response.toString());
		     JSONArray array = jsonObj.getJSONArray("rows");
		     JSONObject jsonObj2 = array.getJSONObject(0);
		     JSONArray array2 = jsonObj2.getJSONArray("elements");
		     int k = 0+(maxCall*i);
		     for (Object o : array2) {
		    	 try{
			    	 JSONObject distance = (JSONObject) ((JSONObject) o).get("distance");
			    	 value = ((JSONObject) distance).get("value").toString();
		    	 } catch (Exception e){
		    		 value = "999999";
		    	 }
		    	 Colegio col = colRepo.findById(k+1);
		    	 int idColegio = col.getId();
		    	 int distancia = Integer.valueOf(value);
		    	 System.out.println(idColegio + " - " + col.getNombre() + " - " + distancia);
		    	 colegiosConDistancias.put(idColegio, distancia);
		    	 k++;
		     } 
		     
		 }
		 
		 Hashtable<Integer,Integer> idsColegiosConDistanciaMinima = getIdsColegiosConDistanciasMinimas(colegiosConDistancias);
		 return idsColegiosConDistanciaMinima;
		 
	 }
	
     private Hashtable<Integer,Integer> getIdsColegiosConDistanciasMinimas(Hashtable<Integer,Integer> colegiosConDistancias) {
    	int maxColegiosASugerir = 25;
    	Hashtable<Integer,Integer> colegiosConDistanciasMinimas = new Hashtable<Integer,Integer>();
    	for(int i=0; i<maxColegiosASugerir; i++){
    		Random generator = new Random();
    		Object[] values = colegiosConDistancias.keySet().toArray();
    		Integer randomValue = (Integer) values[generator.nextInt(values.length)];
    		int min = colegiosConDistancias.get(randomValue);
    		int key = randomValue;
    		for(Integer curKey : colegiosConDistancias.keySet()){
    			int curValue = colegiosConDistancias.get(curKey);
    			if(curValue < min){
    				min = colegiosConDistancias.get(curKey);
    				key = curKey;
    			}
    		}
    		colegiosConDistanciasMinimas.put(key,min);
    		colegiosConDistancias.remove(key);
    	}
		return colegiosConDistanciasMinimas;
	}

	public String apiGet(URL url){
			HttpURLConnection con;
			try {
				con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");

				int responseCode = con.getResponseCode();
				System.out.println("Sending get request : " + url);
				System.out.println("Response code : " + responseCode);

				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String output;
				StringBuffer response = new StringBuffer();

				while ((output = in.readLine()) != null) {
					response.append(output);
				}
				in.close();

				System.out.println(response.toString());
				return response.toString();
			} catch (IOException e) {
				return "";
			}
		}
	 
}
