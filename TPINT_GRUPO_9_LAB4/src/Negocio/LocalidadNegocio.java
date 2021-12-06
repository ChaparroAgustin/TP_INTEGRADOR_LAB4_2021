package Negocio;

import java.util.ArrayList;

import Dominio.LocalidadDao;
import Entidades.Localidad;

public class LocalidadNegocio {

	LocalidadDao Ldao = new LocalidadDao();
	
	public ArrayList<Localidad> ListarLocalidades(){
		
		ArrayList<Localidad> Lista = null;
		
		Lista = Ldao.listarLocalidades();
		
		return Lista;
	}
	
}
