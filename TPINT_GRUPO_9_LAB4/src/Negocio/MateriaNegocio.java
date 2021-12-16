package Negocio;

import java.util.ArrayList;

import Dominio.MateriaDao;
import Entidades.Materia;

public class MateriaNegocio {

MateriaDao mDao = new MateriaDao();
	
	public ArrayList<Materia> listarMaterias() {
		return (ArrayList<Materia>) mDao.listarMaterias();
	}
	
}
