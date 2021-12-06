package Negocio;

import java.util.ArrayList;

import Dominio.ProvinciaDao;
import Entidades.Provincia;

public class ProvinciaNegocio {

	ProvinciaDao Ndao = new ProvinciaDao();
	
	public ArrayList<Provincia> ListarProvincias(){
		
		ArrayList<Provincia> Lista = null;
		
		Lista = Ndao.listarProvincias();
		
		return Lista;
	}
}
