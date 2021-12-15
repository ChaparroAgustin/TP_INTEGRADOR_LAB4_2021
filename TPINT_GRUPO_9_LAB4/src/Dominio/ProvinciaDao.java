package Dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Provincia;

public class ProvinciaDao {

	public ArrayList<Provincia> listarProvincias() {
		PreparedStatement st;
		ResultSet rs;
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();
		Connection conexion = Conexion.getConexion().getSQLConexion();		
		
		try {
			st = conexion.prepareStatement("SELECT * FROM Provincias order by Descripcion asc;");
			rs = st.executeQuery();
			while(rs.next()) {
				Provincia p = new Provincia();
				p.setID(rs.getInt("ID"));
				p.setDescripcion(rs.getString("Descripcion"));
				
				provincias.add(p);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return provincias;
	}
	
}
