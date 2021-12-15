package Dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.AlumnoPorCurso;
import Entidades.Curso;

public class CursoDao {

	public int Contar(Curso c) {
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int cantidad = 0;

		String Consulta = "select count(*) as Cantidad from cursos where "
				+ "IdMateria = "+c.getIdMateria()+" and "
				+ "Semestre = "+c.getSemestre()+" and "
				+ "Anio = "+c.getAnio()+" and "
				+ "IdDocente = "+c.getIdDocente();

		try {
			st = conexion.prepareStatement(Consulta);
			rs = st.executeQuery();
			while (rs.next()) {
				cantidad = rs.getInt("Cantidad");
			}
			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cantidad;
	}
	
	public int Agregar(Curso c)
	{
		int estado = 0;
		
		CallableStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			statement = conexion.prepareCall("insert into tpintegrador.cursos (IdMateria, "
					+ "Semestre, Anio, IdDocente) values("
					+ c.getIdMateria() + ", "
					+ c.getSemestre() + ", "
					+ c.getAnio() + ", "
					+ c.getIdDocente()
					+ ")");
			
			statement.execute();
			
			estado = 1;
			
		}
		catch (SQLException e) 
		{											
			estado = -1;
		}
		return estado;
	}
	
	public int BuscarID() {
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		int ID = 0;

		String Consulta = "select ID from cursos order by ID desc limit 1";

		try {
			st = conexion.prepareStatement(Consulta);
			rs = st.executeQuery();
			while (rs.next()) {
				ID = rs.getInt("ID");
			}
			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ID;
	}
	
	public int AgregarAlumnosCurso(int IdAlumno, int IdCurso)
	{
		int estado = 0;
		
		CallableStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			statement = conexion.prepareCall("insert into tpintegrador.alumnosxcurso(IdCurso, "
					+ "IdAlumno) values("
					+ IdCurso + ", "
					+ IdAlumno + ")");
			
			statement.execute();
			
			estado = 1;
			
		}
		catch (SQLException e) 
		{											
			estado = -1;
		}
		return estado;
	}
	
	public ArrayList<Curso> Listar() {
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<Curso> Lista = new ArrayList<Curso>();
		
		String Consulta = "select * from `vw-cursos` order by ID asc";

		try {
			st = conexion.prepareStatement(Consulta);
			rs = st.executeQuery();
			while (rs.next()) {
				Curso c = new Curso();
				
				c.setID(rs.getInt("ID"));
				c.setMateria(rs.getString("Materia"));
				c.setSemestre(rs.getInt("Semestre"));
				c.setAnio(rs.getInt("Anio"));
				c.setDocente(rs.getString("Docente"));
				
				Lista.add(c);
			}
			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Lista;
	}
	
	public ArrayList<AlumnoPorCurso> ListarAlumnosPorCurso(int IdCurso) {
		
		PreparedStatement st;
		ResultSet rs;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		ArrayList<AlumnoPorCurso> Lista = new ArrayList<AlumnoPorCurso>();
		
		String Consulta = "select * from `vw-alumnosxcurso` where IdCurso = " + IdCurso +" order by ID asc";

		try {
			st = conexion.prepareStatement(Consulta);
			rs = st.executeQuery();
			while (rs.next()) {
				AlumnoPorCurso aPc = new AlumnoPorCurso();
				
				aPc.setID(rs.getInt("ID"));
				aPc.setIdCurso(rs.getInt("IdCurso"));
				aPc.setLegajo(rs.getString("Legajo"));
				aPc.setDni(rs.getString("Dni"));
				aPc.setNombre(rs.getString("Nombre"));
				aPc.setApellido(rs.getString("Apellido"));
				aPc.setIdAlumno(rs.getInt("IdAlumno"));
				aPc.setNota1(rs.getInt("Nota1"));
				aPc.setNota2(rs.getInt("Nota2"));
				aPc.setNota3(rs.getInt("Nota3"));
				aPc.setNota4(rs.getInt("Nota4"));
				aPc.setEstado(rs.getInt("Estado"));
				
				Lista.add(aPc);
			}
			//conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Lista;
	}
	
}
