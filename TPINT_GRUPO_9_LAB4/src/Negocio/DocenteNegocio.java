package Negocio;

import java.util.ArrayList;

import Dominio.DocenteDao;
import Entidades.Alumno;
import Entidades.Docente;

public class DocenteNegocio {

	DocenteDao dDao = new DocenteDao();
	
	public ArrayList<Docente> listarDocentes() {
		
		return (ArrayList<Docente>) dDao.listarDocentes();
		
	}
	public ArrayList<Docente> listaFiltroDocentes(String text){
		
		ArrayList<Docente> Lista = null;
		
		Lista = dDao.listaFiltroDocentes(text);
		
		return Lista;
	}
}
