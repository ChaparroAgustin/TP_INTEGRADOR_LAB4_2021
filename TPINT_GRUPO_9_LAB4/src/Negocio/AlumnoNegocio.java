package Negocio;

import Dominio.AlumnosDao;
import Entidades.Alumno;

import java.text.ParseException;
import java.util.*;

public class AlumnoNegocio {

	AlumnosDao aDao = new AlumnosDao();
	
	public ArrayList<Alumno> ListarAlumnos(){
		
		ArrayList<Alumno> Lista = null;
		
		Lista = aDao.obtenerAlumnos();
		
		return Lista;
	}
	public ArrayList<Alumno> FiltrarAlumnos(String text){
		
		ArrayList<Alumno> Lista = null;
		
		Lista = aDao.filtrarAlumnos(text);
		
		return Lista;
	}
	public int AgregarAlumno(Alumno a)
	{
		int estado = 0;
		
		estado = aDao.AgregarAlumno(a);
		
		return estado;
	}
	public Alumno Buscar(String filtroTexto)
	{
		Alumno alumno = new Alumno();
		
		alumno = aDao.Buscar(filtroTexto);
		
		return alumno;
	}
	public int Contar(String filtroTexto)
	{
		int coincidencia = 0;
		
		coincidencia = aDao.Contar(filtroTexto);
		
		return coincidencia;
	}
	public int Modificar(Alumno alumno)
	{
		int confirmacion = 0;
		
		confirmacion = aDao.Modificar(alumno);
		
		return confirmacion;
	}
	public int ContarModificar(String DniLegajo, int Id)
	{
		int coincidencia = 0;
		
		coincidencia = aDao.ContarModificar(DniLegajo, Id);
		
		return coincidencia;
	}
}
