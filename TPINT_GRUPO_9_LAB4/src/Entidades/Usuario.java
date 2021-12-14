package Entidades;

public class Usuario {

	private int ID;
	private String user;
	private String pass;
	private int idTipo;
	private String tipo;
	private String Dni;
	private String Nombre;
	private String Apellido;
	
	public Usuario() {
		
	}

	public Usuario(int iD, String user, String pass, int idTipo, String tipo, String dni, String nombre, String apellido) {
		super();
		ID = iD;
		this.user = user;
		this.pass = pass;
		this.idTipo = idTipo;
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String Tipo) {
		this.tipo = Tipo;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	@Override
	public String toString() {
		return "Usuario [ID=" + ID + ", user=" + user + ", pass=" + pass + ", idTipo=" + idTipo + ", tipo=" + tipo + ", "
				+ "Dni=" + Dni
				+ ", Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
	}
}
