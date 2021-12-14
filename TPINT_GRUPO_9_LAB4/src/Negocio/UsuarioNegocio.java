package Negocio;

import java.util.ArrayList;

import Dominio.UsuarioDao;
import Entidades.Usuario;

public class UsuarioNegocio {

	UsuarioDao uDao = new UsuarioDao();
	
	public int asignarClave(Usuario u)
	{
		int estado = 0;
		
		estado = uDao.asignarClave(u);
		
		return estado;
	}
	
	public int actualizarClave(String user, String pass)
	{
		int estado = 0;
		
		estado = uDao.actualizarClave(user, pass);
		
		return estado;
	}
	
	public ArrayList<Usuario> listarUsuarios()
	{
		ArrayList<Usuario> lista = new ArrayList();
		
		lista = uDao.listarUsuarios();
		
		return lista;
	}
	
}
