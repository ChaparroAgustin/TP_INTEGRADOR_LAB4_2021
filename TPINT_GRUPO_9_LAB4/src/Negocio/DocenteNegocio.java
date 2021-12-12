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
	public int AgregarDocente(Docente d)
	{
		int estado = 0;
		
		estado = dDao.AgregarDocente(d);
		
		return estado;
	}
	public Docente Buscar(String filtroTexto)
	{
		Docente docente = new Docente();
		
		docente = dDao.Buscar(filtroTexto);
		
		return docente;
	}
	public int Contar(String filtroTexto)
	{
		int coincidencia = 0;
		
		coincidencia = dDao.Contar(filtroTexto);
		
		return coincidencia;
	}
	public int Modificar(Docente docente)
	{
		int confirmacion = 0;
		
		confirmacion = dDao.Modificar(docente);
		
		return confirmacion;
	}
	public int ContarModificar(String DniLegajo, int Id)
	{
		int coincidencia = 0;
		
		coincidencia = dDao.ContarModificar(DniLegajo, Id);
		
		return coincidencia;
	}
}
