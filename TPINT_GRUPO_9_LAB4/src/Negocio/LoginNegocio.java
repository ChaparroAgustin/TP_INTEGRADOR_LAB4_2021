package Negocio;

import Dominio.LoginDao;

public class LoginNegocio {

	LoginDao ldao = new LoginDao();
	
	public int comprobarLogin(String user, String pass)
	{
		int resultado = 0;
		
		resultado = ldao.buscarLogin(user, pass);
		
		return resultado;
	}
}
