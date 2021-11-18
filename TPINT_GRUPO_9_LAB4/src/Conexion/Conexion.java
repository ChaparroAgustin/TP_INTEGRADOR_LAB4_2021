package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	public static Conexion instancia;
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "admin";
	private String dbName = "tpintegrador";
	private Connection conexion;
	
	private Conexion() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion = DriverManager.getConnection(host+dbName,user,pass);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}
	
	public Connection getSQLConexion() 
	{
		return this.conexion;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.conexion.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		instancia = null;
	}
	
}
