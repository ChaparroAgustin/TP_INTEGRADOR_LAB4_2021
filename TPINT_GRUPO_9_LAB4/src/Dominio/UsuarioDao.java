package Dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidades.Usuario;

public class UsuarioDao {

	public ArrayList<Usuario> listarUsuarios() {
		PreparedStatement st;
		ResultSet rs;
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conexion = Conexion.getConexion().getSQLConexion();		
		
		try {
			st = conexion.prepareStatement("SELECT * FROM `vw-usuarios` where tipo <> 'Administrador' ORDER BY ID;");
			rs = st.executeQuery();
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setID(rs.getInt("ID"));
				u.setUser(rs.getString("usuario"));
				u.setPass(rs.getString("pass"));
				u.setIdTipo(rs.getInt("idTipo"));
				u.setTipo(rs.getString("tipo"));
				u.setDni(rs.getString("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				
				usuarios.add(u);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public int asignarClave(Usuario u) {
		
		int estado = 0;
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			statement = conexion.prepareStatement("insert into tpintegrador.usuarios (usuario, pass, idTipo, "
					+ "nombre, apellido, dni)"
					+ "values('"
					+ u.getUser() + "', '"
					+ u.getPass() + "', "
					+ "(select ID from tiposusuario where Tipo = '" + u.getTipo() + "'), '"
					+ u.getNombre() + "', '"
					+ u.getApellido() + "', '"
					+ u.getDni() + "')");
			
			
			statement.execute();
			
			estado = 1;
			
		}
		catch (SQLException e) 
		{											
			estado = -1;
		}
		
		return estado;
		
	}
	
public int actualizarClave(String user, String pass) {
		
		int estado = 0;
		
		CallableStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			statement = conexion.prepareCall("update tpintegrador.usuarios set "
					+ "pass = '"+pass+"' where usuario = '"+user+"'");
			
			statement.execute();
			
			estado = 1;
			
		}
		catch (SQLException e) 
		{											
			estado = -1;
		}
		
		return estado;
	}
	
}
