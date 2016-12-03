package ar.edu.uade.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONArray;
import org.json.JSONObject;

import ar.edu.uade.dao.ColegioRepository;
import ar.edu.uade.dao.PreInscripcionRepository;
import ar.edu.uade.dto.PreInscripcionDTO;
import ar.edu.uade.model.Colegio;
import ar.edu.uade.model.PreInscripcion;

@Controller
@RequestMapping("preinscripcion")
public class PreinscripcionController {
	
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
	 
	 @RequestMapping(value= "/sugerirColegios", method = RequestMethod.GET)
	 public void sugerirColegios(String colegio){
		 getColegiosPorDistancia(colegio);
	 }
	 
	 public List<Integer> getColegiosPorDistancia(String direccion){
		 direccion = "Andres Lamas 2581" + ",Buenos+Aires,+Argentina";
		 direccion = direccion.replaceAll(" ", "+");
		 List<Integer> colegiosIds = new ArrayList<Integer>();
		 List<Colegio> colegios = colRepo.findAll();
		 colegiosIds = apiCall(colegios,direccion);
		 return colegiosIds;
	 }
	 
	 public List<Integer> apiCall(List<Colegio> colegios,String direccion){
		 Hashtable<Integer,Integer> colegiosConDistancias = new Hashtable<Integer,Integer>();
		 String apiKey = "AIzaSyBXuoucteWIPZ5I68RhZe-x-We2xktuGWs";
		 //String destinations = "";
		 /*
		 for (Colegio col : colegios) {
			 origins+= col.getNombre();
			 origins+=",";
		 }
		 origins.substring(0,origins.length()-1);
		 
		 String [] y = origins.split(",");
		 */
		 //destinations = colegios.get(0).getDireccion();
		 //destinations+= "|";
		 //destinations+= colegios.get(1).getDireccion();
		 //destinations = destinations.replaceAll(" ", "+");
		
		 int i=0;
		 for(Colegio col: colegios){
			 URL apiCall;
			 String response = "";
			 String destination = col.getDireccion().replaceAll(" ", "+");
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
		     for (Object o : array2) {
		    	 try{
		    	 JSONObject distance = (JSONObject) ((JSONObject) o).get("distance");
		    	 value = ((JSONObject) distance).get("value").toString();
		    	 } catch (Exception e){
		    		 value = "99999";
		    	 }
		     } 
		     colegiosConDistancias.put(col.getId(), Integer.valueOf(value));
			 i++;
		 }
		 
		 return null;
		 
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
