package Dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;

public class LoginDao {

	public int buscarLogin(String user, String pass) {
		/*PreparedStatement st;
		ResultSet rs;
		int cantidad = 0;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			st = conexion.prepareStatement("SELECT count(*) Cantidad FROM usuarios where usuario = '" + user + "' and pass = '" + pass + "'");
			rs = st.executeQuery();
			while(rs.next()) {
				cantidad = (rs.getInt("Cantidad"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return cantidad;*/
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		String selectUserPass = "SELECT count(*) as CANTIDAD FROM usuarios where usuario = '" + user + "' and pass = '" + pass + "'";
		
		int cantidad = 0;
		try
		{
			st = conexion.prepareStatement(selectUserPass);
			rs = st.executeQuery();
			while(rs.next())
			{
				cantidad = (rs.getInt("CANTIDAD"));
			}
		}catch (SQLException e) 
		{
			cantidad = 0;
		}
		return cantidad;
	}
	
}
