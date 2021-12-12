package Entidades;

import java.util.*;

public class Alumno {
	private String Legajo;
	private String DNI;
	private String Nombre;
	private String Apellido;
	private String FechaNac;
	private String Direccion;
	private Nacionalidad Nacionalidad;
	private Provincia Provincia;
	private String Email;
	private String Telefono;
	
	public Alumno() {
		
	}

	public Alumno(String legajo, String dni, String nombre, String apellido, String fechaNac, String direccion,
			Nacionalidad nacionalidad, Provincia provincia, String email, String telefono) {
		super();
		Legajo = legajo;
		DNI = dni;
		Nombre = nombre;
		Apellido = apellido;
		FechaNac = fechaNac;
		Direccion = direccion;
		this.Nacionalidad = nacionalidad;
		this.Provincia = provincia;
		Email = email;
		Telefono = telefono;
	}

	public String getLegajo() {
		return Legajo;
	}

	public void setLegajo(String legajo) {
		Legajo = legajo;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dni) {
		DNI = dni;
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

	public Nacionalidad getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.Nacionalidad = nacionalidad;
	}

	public Provincia getProvincia() {
		return Provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.Provincia = provincia;
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
		return "Alumno [Legajo=" + Legajo + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido
				+ ", FechaNac=" + FechaNac + ", Direccion=" + Direccion + ", Nacionalidad=" + Nacionalidad
				+ ", Provincia=" + Provincia + ", Email=" + Email + ", Telefono=" + Telefono + "]";
	}
	
	
	
	
}
