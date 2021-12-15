package Dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Localidad;

public class LocalidadDao {

	public ArrayList<Localidad> listarLocalidades() {
		PreparedStatement st;
		ResultSet rs;
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		Connection conexion = Conexion.getConexion().getSQLConexion();		
		
		try {
			st = conexion.prepareStatement("SELECT * FROM Localidades order by Descripcion asc;");
			rs = st.executeQuery();
			while(rs.next()) {
				Localidad l = new Localidad();
				l.setID(rs.getInt("ID"));
				l.setDescripcion(rs.getString("Descripcion"));
				
				localidades.add(l);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return localidades;
	}
}
