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
	
}
