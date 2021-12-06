package Negocio;

import java.util.ArrayList;

import Dominio.DocenteDao;
import Entidades.Docente;

public class DocenteNegocio {

	DocenteDao dDao = new DocenteDao();
	
	public ArrayList<Docente> listarDocentes() {
		return (ArrayList<Docente>) dDao.listarDocentes();
	}
}
