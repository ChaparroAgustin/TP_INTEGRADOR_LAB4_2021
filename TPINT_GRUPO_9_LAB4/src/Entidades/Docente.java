package Entidades;
import Entidades.Nacionalidad;

public class Docente {

	private int Codigo;
	private String Legajo;
	private int Dni;	
	private String Nombre;
	private String Apellido;
	private String FechaNac;
	private String Direccion;
	private String Localidad;
	private Nacionalidad nacionalidad;
	private String Email;
	private String Telefono;
	
	public Docente() {
		
	}

	public Docente(int codigo, String legajo, int dni, String nombre, String apellido, String fechaNac,
			String direccion, String localidad, Nacionalidad nacionalidad, String email, String telefono) {
		super();
		Codigo = codigo;
		Legajo = legajo;
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
		FechaNac = fechaNac;
		Direccion = direccion;
		Localidad = localidad;
		this.nacionalidad = nacionalidad;
		Email = email;
		Telefono = telefono;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getLegajo() {
		return Legajo;
	}

	public void setLegajo(String legajo) {
		Legajo = legajo;
	}

	public int getDni() {
		return Dni;
	}

	public void setDni(int dni) {
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

	public String getFechaNac() {
		return FechaNac;
	}

	public void setFechaNac(String fechaNac) {
		FechaNac = fechaNac;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	@Override
	public String toString() {
		return "Docente [Codigo=" + Codigo + ", Legajo=" + Legajo + ", Dni=" + Dni + ", Nombre=" + Nombre
				+ ", Apellido=" + Apellido + ", FechaNac=" + FechaNac + ", Direccion=" + Direccion + ", Localidad="
				+ Localidad + ", Nacionalidad=" + nacionalidad + ", Email=" + Email + ", Telefono=" + Telefono + "]";
	}
	
	
}
