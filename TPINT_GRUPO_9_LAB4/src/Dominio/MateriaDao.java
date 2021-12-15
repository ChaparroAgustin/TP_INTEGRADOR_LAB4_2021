package Dominio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Materia;

public class MateriaDao {

	public ArrayList<Materia> listarMaterias() {
		PreparedStatement st;
		ResultSet rs;
		ArrayList<Materia> materias = new ArrayList<Materia>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			st = conexion.prepareStatement("SELECT ID, Descripcion FROM tpintegrador.Materias order by Descripcion asc;");
			rs = st.executeQuery();
			while(rs.next()) {
				Materia m = new Materia();
				m.setID(rs.getInt("ID"));
				m.setDescripcion(rs.getString("Descripcion"));
				materias.add(m);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return materias;
	}
	
}
