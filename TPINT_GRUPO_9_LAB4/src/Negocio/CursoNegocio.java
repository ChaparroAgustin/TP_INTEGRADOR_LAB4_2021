package Negocio;

import java.util.ArrayList;

import Dominio.CursoDao;
import Entidades.AlumnoPorCurso;
import Entidades.Curso;

public class CursoNegocio {

	CursoDao cDao = new CursoDao();
	
	public int Contar(Curso c)
	{
		int cantidad = 0;
		
		cantidad = cDao.Contar(c);
		
		return cantidad;
	}
	
	public int Agregar(Curso c)
	{
		int estado = 0;
		
		estado = cDao.Agregar(c);
		
		return estado;
	}
	
	public int BuscarID()
	{
		int ID = 0;
		
		ID = cDao.BuscarID();
		
		return ID;
	}
	
	public int AgregarAlumnosCurso(int IdAlumno, int IdCurso)
	{
		int estado = 0;
		
		estado = cDao.AgregarAlumnosCurso(IdAlumno, IdCurso);
		
		return estado;
	}
	
	public ArrayList<Curso> Listar()
	{
		ArrayList<Curso> Lista = new ArrayList<Curso>();
		
		Lista = cDao.Listar();
		
		return Lista;
	}
	
	public ArrayList<AlumnoPorCurso> ListarAlumnosPorCurso(int IdCurso)
	{
		ArrayList<AlumnoPorCurso> Lista = new ArrayList<AlumnoPorCurso>();
		
		Lista = cDao.ListarAlumnosPorCurso(IdCurso);
		
		return Lista;
	}
}
