package ar.edu.uade.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory instancia;
	   
    private ConnectionFactory(){
    	
    	try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}
    }
    
    public static ConnectionFactory getinstance()
    {
    	if(instancia == null)
    		instancia = new ConnectionFactory();
        return instancia;
    }
    
    public Connection getConexion()
    {  
        String userName = "AI_2974_20";
        String password = "AI_2974_20";
        String url = "jdbc:jtds:sqlserver://bd";
        Connection con = null;
		try {
			con = DriverManager.getConnection (url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return con;
    }
}
