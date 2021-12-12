package Dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import Entidades.Nacionalidad;
import Entidades.Provincia;

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
		
		try {
			st = conexion.prepareStatement("SELECT * FROM `vw-listar-docentes` where Estado = true;");
			rs = st.executeQuery();
			while(rs.next()) {
				Nacionalidad nac = new Nacionalidad();
				Localidad loc = new Localidad();
				Docente d = new Docente();
				d.setID(rs.getInt("ID"));
				d.setLegajo(rs.getString("Legajo"));
				d.setDni(rs.getString("Dni"));
				d.setNombre(rs.getString("Nombre"));
				d.setApellido(rs.getString("Apellido"));
				SimpleDateFormat format = new SimpleDateFormat("dd-LL-yyyy");
				d.setFechaNac(format.format(rs.getDate("FechaNac")));
				d.setDireccion(rs.getString("Direccion"));
				loc.setID(rs.getInt("IdLocalidad"));
				loc.setDescripcion(rs.getString("Localidad"));
				d.setLocalidad(loc);
				nac.setID(rs.getInt("IdNacionalidad"));
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
		
		String ListaFiltrada = "SELECT * FROM `vw-listar-docentes` where Estado = true and "
				+ "concat_ws(Legajo, Dni, Nombre, Apellido, "
				+ "FechaNac, Direccion, Localidad, Nacionalidad, Email, Telefono) like '%"+text+"%'";
		
		try {
			st = conexion.prepareStatement(ListaFiltrada);
			rs = st.executeQuery();
			while (rs.next()) {
				Nacionalidad nac = new Nacionalidad();
				Localidad loc = new Localidad();
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
	
public Docente Buscar(String text) {
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Nacionalidad nac = new Nacionalidad();
		Localidad loc = new Localidad();
		Docente docente = new Docente();
		
		String Consulta = "select ID, Legajo, Dni, Nombre, Apellido, Day(FechaNac) Dia, "
				+ "Month(FechaNac) Mes, Year(FechaNac) Anio, Direccion, Localidad as IdLocalidad, "
				+ "(select Localidades.Descripcion from Localidades where Localidades.ID = docentes.Localidad) AS Localidad, "
				+ "Nacionalidad as IdNacionalidad, "
				+ "(select Nacionalidades.Descripcion from Nacionalidades where Nacionalidades.ID = docentes.Nacionalidad) "
				+ "AS Nacionalidad, Email, Telefono, Estado "
				+ "from docentes where Estado = true and Legajo = '"+text+"' "
				+ "or "
				+ "Estado = true and Dni = '"+text+"'";
		
		try {
			st = conexion.prepareStatement(Consulta);
			rs = st.executeQuery();
			while (rs.next()) {
				docente.setID(rs.getInt("ID"));
				docente.setLegajo(rs.getString("Legajo"));
				docente.setDni(rs.getString("Dni"));
				docente.setNombre(rs.getString("Nombre"));
				docente.setApellido(rs.getString("Apellido"));
				docente.setDiaNac(rs.getInt("Dia"));
				docente.setMesNac(rs.getInt("Mes"));
				docente.setAnioNac(rs.getInt("Anio"));
				docente.setDireccion(rs.getString("Direccion"));
				loc.setID(rs.getInt("IdLocalidad"));
				loc.setDescripcion(rs.getString("Localidad"));
				docente.setLocalidad(loc);
				nac.setID(rs.getInt("IdNacionalidad"));
				nac.setDescripcion(rs.getString("Nacionalidad"));
				docente.setNacionalidad(nac);
				docente.setEmail(rs.getString("Email"));
				docente.setTelefono(rs.getString("Telefono"));
				
			}
			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return docente;
	}
	
	public int Contar(String text) {
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int coincidencia = 0;

		String Consulta = "select count(*) as Cantidad "
				+ "from docentes where Estado = true and Legajo = '" + text + "' "
				+ "or "
				+ "Estado = true and Dni = '" + text + "'";
		
		try {
			st = conexion.prepareStatement(Consulta);
			rs = st.executeQuery();
			while (rs.next()) {
				coincidencia = rs.getInt("Cantidad");
			}
			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coincidencia;
	}

	public int ContarModificar(String DniLegajo, int Id) {
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int coincidencia = 0;

		String Consulta = "select count(*) as Cantidad "
				+ "from docentes where Estado = true "
				+ "and "
				+ "Dni = '" + DniLegajo + "' "
				+ "and "
				+ "ID <> " + Id + " "
				+ "or "
				+ "Estado = true "
				+ "and "
				+ "Legajo = '" + DniLegajo + "' "
				+ "and "
				+ "ID <> " + Id + "";
		
		try {
			st = conexion.prepareStatement(Consulta);
			rs = st.executeQuery();
			while (rs.next()) {
				coincidencia = rs.getInt("Cantidad");
			}
			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coincidencia;
	}
	
	public int Modificar(Docente d)
	{
		int estado = 0;
		
		CallableStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			statement = conexion.prepareCall("update docentes set "
					+ "Legajo = '"+d.getLegajo()+"', "
					+ "Dni= '"+d.getDni()+"', "
					+ "Nombre= '"+d.getNombre()+"', "
					+ "Apellido= '"+d.getApellido()+"', "
					+ "FechaNac= '"+d.getFechaNac()+"', "
					+ "Direccion= '"+d.getDireccion()+"', "
					+ "Localidad= '"+d.getLocalidad().getID()+"', "
					+ "Nacionalidad= '"+d.getNacionalidad().getID()+"', "
					+ "Email= '"+d.getEmail()+"', "
					+ "Telefono= '"+d.getTelefono()+"' "
					+ "where ID = " + d.getID());
			
			statement.execute();
			
			estado = 1;
			
		}
		catch (SQLException e) 
		{											
			estado = -3;
		}
		return estado;
	}
	
}
