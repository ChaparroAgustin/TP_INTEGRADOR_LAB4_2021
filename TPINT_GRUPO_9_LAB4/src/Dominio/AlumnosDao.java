package Dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;

import Conexion.Conexion;
import Entidades.Alumno;
import Entidades.Nacionalidad;
import Entidades.Provincia;

public class AlumnosDao {

	public ArrayList<Alumno> obtenerAlumnos(){
		
		ArrayList<Alumno> Lista = new ArrayList<Alumno>();
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Nacionalidad nac = new Nacionalidad();
		Provincia prov = new Provincia();
		
		String ListaAlumnos = "SELECT * FROM `vw-alumnos`;";
		
		try 
		{
			st = conexion.prepareStatement(ListaAlumnos);
			rs = st.executeQuery();
			while(rs.next())
			{
				Alumno alumno = new Alumno();
				alumno.setLegajo(rs.getString("Legajo"));
				alumno.setDNI(rs.getString("Dni"));
				alumno.setNombre(rs.getString("Nombre"));
				alumno.setApellido(rs.getString("Apellido"));
				SimpleDateFormat format = new SimpleDateFormat("dd-LL-yyyy");
				alumno.setFechaNac(format.format(rs.getDate("FechaNac")));
				alumno.setDireccion(rs.getString("Direccion"));
				prov.setDescripcion(rs.getString("Provincia"));
				alumno.setProvincia(prov);
				nac.setDescripcion(rs.getString("Nacionalidad"));
				alumno.setNacionalidad(nac);
				alumno.setEmail(rs.getString("Email"));
				alumno.setTelefono(rs.getString("Telefono"));
				
				Lista.add(alumno);
				
			}
			
			//conexion.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Lista;
	}
	
	public ArrayList<Alumno> filtrarAlumnos(String text) {
		
		ArrayList<Alumno> Lista = new ArrayList<Alumno>();

		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Nacionalidad nac = new Nacionalidad();
		Provincia prov = new Provincia();

		String ListaFiltrada = "SELECT * FROM alumnos where concat_ws(Legajo, Dni, Nombre, Apellido, FechaNac," 
				+ "Direccion, Provincia, Nacionalidad, Email, Telefono) like '%"+text+"%'";
		
		try {
			st = conexion.prepareStatement(ListaFiltrada);
			rs = st.executeQuery();
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setLegajo(rs.getString("Legajo"));
				alumno.setDNI(rs.getString("Dni"));
				alumno.setNombre(rs.getString("Nombre"));
				alumno.setApellido(rs.getString("Apellido"));
				SimpleDateFormat format = new SimpleDateFormat("dd-LL-yyyy");
				alumno.setFechaNac(format.format(rs.getDate("FechaNac")));
				alumno.setDireccion(rs.getString("Direccion"));
				prov.setDescripcion(rs.getString("Provincia"));
				alumno.setProvincia(prov);
				nac.setDescripcion(rs.getString("Nacionalidad"));
				alumno.setNacionalidad(nac);
				alumno.setEmail(rs.getString("Email"));
				alumno.setTelefono(rs.getString("Telefono"));

				Lista.add(alumno);

			}

			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Lista;
	}
	
	public int AgregarAlumno(Alumno a)
	{
		int estado = 0;
		
		CallableStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			statement = conexion.prepareCall("insert into alumnos (Legajo, Dni, Nombre, "
					+ "Apellido, FechaNac, Direccion, Provincia, Nacionalidad, "
					+ "Email, Telefono)"
					+ "values(?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, a.getLegajo());
			statement.setString(2, a.getDNI());
			statement.setString(3, a.getNombre());
			statement.setString(4, a.getApellido());
			statement.setString(5, a.getFechaNac());
			statement.setString(6, a.getDireccion());
			statement.setString(7, a.getProvincia().getDescripcion());
			statement.setString(8, a.getNacionalidad().getDescripcion());
			statement.setString(9, a.getEmail());
			statement.setString(10, a.getTelefono());
			
			statement.execute();
			
			estado = 1;
			
		}
		catch (SQLException e) 
		{											
			if(e.getErrorCode() == 1062) { //Duplicados
				estado = -1;
			} else {
				e.printStackTrace();
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				estado = -2;		
			}
		}
		
		return estado;
	}
	
}
