package Dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;

public class LoginDao {

	public int buscarLogin(String user, String pass) {
		
		
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
	
	public String buscarTipoUsuario(String user, String pass) {
		
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		String selectUserPass = "select (select Tipo from tiposusuario where ID = (select IdTipo from usuarios where "
				+ "usuario = '" + user + "' and pass = '" + pass + "')) AS tipo";
		
		String tipoUser = "";
		try
		{
			st = conexion.prepareStatement(selectUserPass);
			rs = st.executeQuery();
			
			while(rs.next())
			{
				tipoUser = (rs.getString("tipo"));
			}
			
		}catch (SQLException e) 
		{
			tipoUser = "-1";
		}
		return tipoUser;
	}
	
}
