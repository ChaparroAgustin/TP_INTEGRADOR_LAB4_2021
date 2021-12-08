package Dominio;

import java.sql.Connection;
import Entidades.Nacionalidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

import Conexion.Conexion;
import Entidades.Alumno;
import Entidades.Docente;
import Entidades.Localidad;

public class DocenteDao {

	public ArrayList<Docente> listarDocentes() {
		PreparedStatement st;
		ResultSet rs;
		ArrayList<Docente> Lista = new ArrayList<Docente>();
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Nacionalidad nac = new Nacionalidad();
		Localidad loc = new Localidad();
		
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
				loc.setDescripcion(rs.getString("LocalidadProfesor"));
				d.setLocalidad(loc);
				nac.setDescripcion(rs.getString("NacionalidadProfesor"));
				d.setNacionalidad(nac);
				d.setEmail(rs.getString("EmailProfesor"));
				d.setTelefono(rs.getString("TelefonoProfesor"));
				Lista.add(d);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Lista;
	}
	
	public ArrayList<Docente> listaFiltroDocentes(String text) {
		
		ArrayList<Docente> Lista = new ArrayList<Docente>();

		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Nacionalidad nac = new Nacionalidad();
		Localidad loc = new Localidad();

		String ListaFiltrada = "SELECT * FROM profesores where concat_ws(CodProfesor, LegajoProfesor, DniProfesor, NombreProfesor, "
				+ "ApellidoProfesor, FechaNacProfesor, DireccionProfesor, LocalidadProfesor, NacionalidadProfesor, EmailProfesor, "
				+ "TelefonoProfesor) like '%"+text+"%'";
		
		try {
			st = conexion.prepareStatement(ListaFiltrada);
			rs = st.executeQuery();
			while (rs.next()) {
				Docente docente = new Docente();
				docente.setCodigo(rs.getInt("CodProfesor"));
				docente.setLegajo(rs.getString("LegajoProfesor"));
				docente.setDni(rs.getInt("DniProfesor"));
				docente.setNombre(rs.getString("NombreProfesor"));
				docente.setApellido(rs.getString("ApellidoProfesor"));
				SimpleDateFormat format = new SimpleDateFormat("dd-LL-yyyy");
				docente.setFechaNac(format.format(rs.getDate("FechaNacProfesor")));
				docente.setDireccion(rs.getString("DireccionProfesor"));
				loc.setDescripcion(rs.getString("LocalidadProfesor"));
				docente.setLocalidad(loc);
				nac.setDescripcion(rs.getString("NacionalidadProfesor"));
				docente.setNacionalidad(nac);
				docente.setEmail(rs.getString("EmailProfesor"));
				docente.setTelefono(rs.getString("TelefonoProfesor"));

				Lista.add(docente);

			}

			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Lista;

	}
	
}
