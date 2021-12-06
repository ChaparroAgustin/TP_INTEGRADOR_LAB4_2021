package Negocio;

import Dominio.AlumnosDao;
import Entidades.Alumno;
import java.util.*;

public class AlumnoNegocio {

	AlumnosDao Adao = new AlumnosDao();
	
	public ArrayList<Alumno> ListarAlumnos(){
		
		ArrayList<Alumno> Lista = null;
		
		Lista = Adao.obtenerAlumnos();
		
		return Lista;
	}
	public ArrayList<Alumno> FiltrarAlumnos(String text){
		
		ArrayList<Alumno> Lista = null;
		
		Lista = Adao.filtrarAlumnos(text);
		
		return Lista;
	}
}
