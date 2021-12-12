package Entidades;
import Entidades.Nacionalidad;

public class Docente {

	private int ID;
	private String Legajo;
	private String Dni;	
	private String Nombre;
	private String Apellido;
	private String FechaNac;
	private String Direccion;
	private Localidad Localidad;
	private Nacionalidad nacionalidad;
	private String Email;
	private String Telefono;
	
	public Docente() {
		
	}

	public Docente(int id, String legajo, String dni, String nombre, String apellido, String fechaNac,
			String direccion, Localidad localidad, Nacionalidad nacionalidad, String email, String telefono) {
		super();
		ID = id;
		Legajo = legajo;
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
		FechaNac = fechaNac;
		Direccion = direccion;
		this.Localidad = localidad;
		this.nacionalidad = nacionalidad;
		Email = email;
		Telefono = telefono;
	}

	public int getId() {
		return ID;
	}
	
	public void setId(int id) {
		ID = id;
	}
	
	public String getLegajo() {
		return Legajo;
	}

	public void setLegajo(String legajo) {
		Legajo = legajo;
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

	public Localidad getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.Localidad = localidad;
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
		return "Docente [ID=" + ID + ", Legajo=" + Legajo + ", Dni=" + Dni + ", Nombre=" + Nombre
				+ ", Apellido=" + Apellido + ", FechaNac=" + FechaNac + ", Direccion=" + Direccion + ", Localidad="
				+ Localidad + ", Nacionalidad=" + nacionalidad + ", Email=" + Email + ", Telefono=" + Telefono + "]";
	}
	
	
}
