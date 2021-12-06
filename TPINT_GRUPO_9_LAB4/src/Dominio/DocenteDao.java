package Dominio;

import java.sql.Connection;
import Entidades.Nacionalidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

import Conexion.Conexion;
import Entidades.Docente;

public class DocenteDao {

	public ArrayList<Docente> listarDocentes() {
		PreparedStatement st;
		ResultSet rs;
		ArrayList<Docente> docentes = new ArrayList<Docente>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Nacionalidad nac = new Nacionalidad();		
		
		try {
			st = conexion.prepareStatement("SELECT * FROM `vw-listar-docentes`;");
			rs = st.executeQuery();
			while(rs.next()) {
				Docente d = new Docente();
				d.setCodigo(rs.getInt("CodProfesor"));
				d.setLegajo(rs.getString("LegajoProfesor"));
				d.setDni(rs.getInt("DniProfesor"));
				d.setNombre(rs.getString("NombreProfesor"));
				d.setApellido(rs.getString("ApellidoProfesor"));
				SimpleDateFormat format = new SimpleDateFormat("dd-LL-yyyy");
				d.setFechaNac(format.format(rs.getDate("FechaNacProfesor")));
				d.setFechaNac(rs.getString("FechaNacProfesor"));
				d.setDireccion(rs.getString("DireccionProfesor"));
				d.setLocalidad(rs.getString("LocalidadProfesor"));
				nac.setDescripcion(rs.getString("NacionalidadProfesor"));
				d.setNacionalidad(nac);
				d.setEmail(rs.getString("EmailProfesor"));
				d.setTelefono(rs.getString("TelefonoProfesor"));
				docentes.add(d);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return docentes;
	}
	
}
