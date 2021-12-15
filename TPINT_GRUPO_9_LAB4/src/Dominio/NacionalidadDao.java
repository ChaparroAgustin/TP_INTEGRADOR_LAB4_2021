package Dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidades.Nacionalidad;
import Conexion.Conexion;

public class NacionalidadDao {

	public ArrayList<Nacionalidad> listarNacionalidades() {
		PreparedStatement st;
		ResultSet rs;
		ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
		Connection conexion = Conexion.getConexion().getSQLConexion();		
		
		try {
			st = conexion.prepareStatement("SELECT * FROM Nacionalidades order by Descripcion asc;");
			rs = st.executeQuery();
			while(rs.next()) {
				Nacionalidad n = new Nacionalidad();
				n.setID(rs.getInt("ID"));
				n.setDescripcion(rs.getString("Descripcion"));
				
				nacionalidades.add(n);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nacionalidades;
	}
	
}
