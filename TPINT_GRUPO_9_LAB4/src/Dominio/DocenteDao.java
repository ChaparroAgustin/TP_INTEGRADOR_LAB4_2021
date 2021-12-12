package Dominio;

import java.sql.CallableStatement;
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
				d.setId(rs.getInt("ID"));
				d.setLegajo(rs.getString("Legajo"));
				d.setDni(rs.getString("Dni"));
				d.setNombre(rs.getString("Nombre"));
				d.setApellido(rs.getString("Apellido"));
				SimpleDateFormat format = new SimpleDateFormat("dd-LL-yyyy");
				d.setFechaNac(format.format(rs.getDate("FechaNac")));
				d.setDireccion(rs.getString("Direccion"));
				loc.setDescripcion(rs.getString("Localidad"));
				d.setLocalidad(loc);
				nac.setDescripcion(rs.getString("Nacionalidad"));
				d.setNacionalidad(nac);
				d.setEmail(rs.getString("Email"));
				d.setTelefono(rs.getString("Telefono"));
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

		String ListaFiltrada = "SELECT * FROM `vw-listar-docentes` where concat_ws(Legajo, Dni, Nombre, Apellido, "
				+ "FechaNac, Direccion, Localidad, Nacionalidad, Email, Telefono) like '%"+text+"%'";
		
		try {
			st = conexion.prepareStatement(ListaFiltrada);
			rs = st.executeQuery();
			while (rs.next()) {
				Docente docente = new Docente();
				docente.setLegajo(rs.getString("Legajo"));
				docente.setDni(rs.getString("Dni"));
				docente.setNombre(rs.getString("Nombre"));
				docente.setApellido(rs.getString("Apellido"));
				SimpleDateFormat format = new SimpleDateFormat("dd-LL-yyyy");
				docente.setFechaNac(format.format(rs.getDate("FechaNac")));
				docente.setDireccion(rs.getString("Direccion"));
				loc.setDescripcion(rs.getString("Localidad"));
				docente.setLocalidad(loc);
				nac.setDescripcion(rs.getString("Nacionalidad"));
				docente.setNacionalidad(nac);
				docente.setEmail(rs.getString("Email"));
				docente.setTelefono(rs.getString("Telefono"));

				Lista.add(docente);

			}

			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Lista;

	}
	
	public int AgregarDocente(Docente d)
	{
		int estado = 0;
		
		CallableStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			statement = conexion.prepareCall("insert into tpintegrador.docentes (Legajo, Dni, Nombre, "
					+ "Apellido, FechaNac, Direccion, Localidad, Nacionalidad, Email, Telefono)"
					+ "values('"
					+ d.getLegajo() + "', '"
					+ d.getDni() + "', '"
					+ d.getNombre() + "', '"
					+ d.getApellido() + "', '"
					+ d.getFechaNac() + "', '"
					+ d.getDireccion() + "', '"
					+ d.getLocalidad().getID() + "', '"
					+ d.getNacionalidad().getID() + "', '"
					+ d.getEmail() + "', '"
					+ d.getTelefono()
					+ "')");
			
			
			statement.execute();
			
			estado = 1;
			
		}
		catch (SQLException e) 
		{											
			estado = -1;
		}
		return estado;
	}
	
}
