package Negocio;

import java.util.ArrayList;

import Dominio.NacionalidadDao;
import Entidades.Nacionalidad;

public class NacionalidadNegocio {

	NacionalidadDao Ndao = new NacionalidadDao();
	
	public ArrayList<Nacionalidad> ListarNacionalidades(){
		
		ArrayList<Nacionalidad> Lista = null;
		
		Lista = Ndao.listarNacionalidades();
		
		return Lista;
	}
}
