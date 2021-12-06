package Entidades;

import java.util.*;

public class Alumno {
	private int Legajo;
	private int DNI;
	private String Nombre;
	private String Apellido;
	private String FechaNac;
	private String Direccion;
	private String Nacionalidad;
	private String Provincia;
	private String Email;
	private int Telefono;
	
	public Alumno() {
		
	}

	public Alumno(int legajo, int dNI, String nombre, String apellido, String fechaNac, String direccion,
			String nacionalidad, String provincia, String email, int telefono) {
		super();
		Legajo = legajo;
		DNI = dNI;
		Nombre = nombre;
		Apellido = apellido;
		FechaNac = fechaNac;
		Direccion = direccion;
		Nacionalidad = nacionalidad;
		Provincia = provincia;
		Email = email;
		Telefono = telefono;
	}

	public int getLegajo() {
		return Legajo;
	}

	public void setLegajo(int legajo) {
		Legajo = legajo;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
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

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	@Override
	public String toString() {
		return "Alumno [Legajo=" + Legajo + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido
				+ ", FechaNac=" + FechaNac + ", Direccion=" + Direccion + ", Nacionalidad=" + Nacionalidad
				+ ", Provincia=" + Provincia + ", Email=" + Email + ", Telefono=" + Telefono + "]";
	}
	
	
	
	
}