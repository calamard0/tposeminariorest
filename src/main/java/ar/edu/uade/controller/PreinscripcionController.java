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
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONArray;
import org.json.JSONObject;

import ar.edu.uade.dao.ColegioRepository;
import ar.edu.uade.dao.PreInscripcionRepository;
import ar.edu.uade.dto.ColegioDTO;
import ar.edu.uade.dto.CursoDTO;
import ar.edu.uade.dto.PreInscripcionDTO;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.Curso;
import ar.edu.uade.model.PreInscripcion;

@RestController
//@Controller
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
		int promedio;
		public ColegioPromedio(int id, int promedio) {
			this.id = id;
			this.promedio = promedio; 
		}
	}
	
	 @Autowired
	 PreInscripcionRepository preRepo;
	 
	 @Autowired
	 ColegioRepository colRepo;
	
	 @RequestMapping(value= "/nueva", method = RequestMethod.GET)
	 public ModelAndView initPreinscripcion() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 mav.addObject("colegio", null);  
		 
		 return mav;
	 }
	 
	 @RequestMapping(value= "/crear", method = RequestMethod.POST)
	 public ModelAndView crearPreinscripcion(@RequestBody PreInscripcionDTO dto) {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 // para pasar del string a un Date se puede usar el siguiente codigo
		 // java.util.Date date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(dto.getAspirante().getFechaNacimiento().replace('T', ' ').replace('Z', ' '));
		 
		 PreInscripcion preInscripcion = new PreInscripcion(dto);
		 preRepo.save(new PreInscripcion(dto));
		 
		 mav.addObject("preInscripcion", preInscripcion);  
		 return mav;
	 }
	 
	 @RequestMapping(value= "/modificar", method = RequestMethod.POST)
	 public ModelAndView modificarPreinscripcion() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 mav.addObject("colegio", null);  
		 
		 return mav;
	 }
	 
	 
	 @RequestMapping(value= "/validar", method = RequestMethod.GET)
	 public ModelAndView validarPreinscripcion() {	
		 ModelAndView mav = new ModelAndView();
		 mav.setViewName("preinscripcion");
		 
		 mav.addObject("colegio", null);  
		 
		 return mav;
	 }
	 
	@RequestMapping(value = "/sugerirColegios/{direccion}/{grado}", method = RequestMethod.GET)
	public List<CursoDTO> sugerirColegios(@PathVariable String direccion, @PathVariable int grado) {
		List<Colegio> colegios = colRepo.findAll();
		List<Colegio> colegiosMasAptos = getColegiosMasAptosPorPromedioTotalLibre(colegios, grado, colegios.size() / 2);
		ArrayList<ColegioDistancia> colegiosConDistancias = getColegiosPorDistancia(direccion, colegiosMasAptos);

		List<Colegio> colegiosMasAptos2 = new ArrayList<Colegio>();
		for (ColegioDistancia colDis : colegiosConDistancias) {
			colegiosMasAptos2.add(colRepo.findById(colDis.id));
		}

		colegiosMasAptos2 = getColegiosMasAptosPorPromedioTotalLibre(colegiosMasAptos2, grado, 5);
		Collections.reverse(colegiosMasAptos2);
		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
		for (Colegio col : colegiosMasAptos2) {
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
			 colegiosPromedio.add(new ColegioPromedio(col.getId(),(vacantes/vacantesDisponibles)));
		 }
		 
		 //Crear lista de colegios
		 for(ColegioPromedio colPro : colegiosPromedio){
			 colegiosAux.add(colRepo.findById(colPro.id));
		 }
		 
		 int cantidad = colegiosPromedio.size();
		 for(int i=0; i<cantidadASugerir; i++){
			 int min = colegiosPromedio.get(0).promedio;
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
			 colegiosMasAptos.add(colRepo.findById(curKey));
			 try{
				 colegiosPromedio.remove(curIndex);
			 } catch (Exception e){
				 System.out.println(e.toString());
			 }
		 }
		 return colegiosMasAptos;
	 }
	 
	 public ArrayList<ColegioDistancia> getColegiosPorDistancia(String direccion, List<Colegio> colegiosMasAptos){
		 direccion = direccion.replaceAll(" ", "+");
		 Hashtable<Integer,Integer> colegiosIds = apiCall(colegiosMasAptos,direccion);
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
	    
		return colegioDistancia;
	}

	public Hashtable<Integer,Integer> apiCall(List<Colegio> colegios,String direccion){
		 int maxCall = 25; //Cantidad de colegios en el envio a API
		 int maximoColegiosAUsar = colegios.size();
		 Hashtable<Integer,Integer> colegiosConDistancias = new Hashtable<Integer,Integer>();
		 //String apiKey = "AIzaSyBXuoucteWIPZ5I68RhZe-x-We2xktuGWs";
		 String apiKey = "AIzaSyDDCuxOg63WU4nGq9Vdxi59WNv3pwui62g";
		 for(int i=0; i<=(maximoColegiosAUsar/maxCall); i++){
			 String destination = "";
			 for(int j=(0+(maxCall*i));j<maxCall+(maxCall*i);j++){
			 	destination+= colRepo.findById(j+1).getDireccion();
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
			 System.out.println(response.toString());
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
		    	 colegiosConDistancias.put(colRepo.findById(k+1).getId(), Integer.valueOf(value));
		    	 k++;
		     } 
		     
		 }
		 
		 Hashtable<Integer,Integer> idsColegiosConDistanciaMinima = getIdsColegiosConDistanciasMinimas(colegiosConDistancias);
		 return idsColegiosConDistanciaMinima;
		 
	 }
	
     private Hashtable<Integer,Integer> getIdsColegiosConDistanciasMinimas(Hashtable<Integer,Integer> colegiosConDistancias) {
    	int maxColegiosASugerir = 45;
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
