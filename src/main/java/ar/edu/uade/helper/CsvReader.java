package ar.edu.uade.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.jandex.Main;

public class CsvReader {
	
	public static CsvReader instancia;
	
	private CsvReader() {
		
	}
	
	public static CsvReader getInstancia() {
		if ( instancia == null )
			instancia = new CsvReader();
		return instancia;
	}

	public List<String> getNombresPorSexo(String sexo) {
		
		String csvFile = "C:/Users/Broker/Desktop/Seminario/nombres-permitidos.csv";
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ";";
	    List<String> nombres = new ArrayList<String>();

	    try {

	        br = new BufferedReader(new FileReader(csvFile));
	        while ((line = br.readLine()) != null) {
	            String[] nombre = line.split(cvsSplitBy);
	            if ( nombre[1].equals(sexo) )
	            	nombres.add(nombre[0]);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return nombres;
		
	}
	
	public List<String> getCalles() {
		
		String csvFile = "C:/Users/Broker/Desktop/Seminario/callejero.csv";
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ";";
	    List<String> calles = new ArrayList<String>();

	    try {

	        br = new BufferedReader(new FileReader(csvFile));
	        while ((line = br.readLine()) != null) {
	            String[] nombre = line.split(cvsSplitBy);
	            calles.add(nombre[9]);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return calles;
		
	}
	
	public List<String> getProfesiones() {
		
		String csvFile = "C:/Users/Broker/Desktop/Seminario/profesiones.csv";
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ";";
	    List<String> profesiones = new ArrayList<String>();

	    try {

	        br = new BufferedReader(new FileReader(csvFile));
	        while ((line = br.readLine()) != null) {
	            String[] nombre = line.split(cvsSplitBy);
	            profesiones.add(nombre[0]);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return profesiones;
		
	}
	
	public List<String> getApellidos() {
		
		String csvFile = "C:/Users/Broker/Desktop/Seminario/apellidos.csv";
	    BufferedReader br = null;
	    String line = "";
	    String cvsSplitBy = ",";
	    List<String> apellidos = new ArrayList<String>();

	    try {

	        br = new BufferedReader(new FileReader(csvFile));
	        while ((line = br.readLine()) != null) {
	            String[] nombre = line.split(cvsSplitBy);
	            apellidos.add(nombre[0]);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return apellidos;
		
	}
	
	//C:\Users\Broker\Desktop\Seminario\callejero.csv
	
}
