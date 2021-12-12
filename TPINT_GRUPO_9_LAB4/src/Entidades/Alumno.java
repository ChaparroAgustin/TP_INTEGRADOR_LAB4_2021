package Entidades;

import java.util.*;

public class Alumno {
	
	private int ID;
	private String Legajo;
	private String DNI;
	private String Nombre;
	private String Apellido;
	private String FechaNac;
	private int DiaNac;
	private int MesNac;
	private int AnioNac;
	private String Direccion;
	private Nacionalidad Nacionalidad;
	private Provincia Provincia;
	private String Email;
	private String Telefono;
	
	public Alumno() {
		
	}

	public Alumno(int id, String legajo, String dNI, String nombre, String apellido, String fechaNac, int diaNac,
			int mesNac, int anioNac, String direccion, Entidades.Nacionalidad nacionalidad,
			Entidades.Provincia provincia, String email, String telefono) {
		super();
		ID = id;
		Legajo = legajo;
		DNI = dNI;
		Nombre = nombre;
		Apellido = apellido;
		FechaNac = fechaNac;
		DiaNac = diaNac;
		MesNac = mesNac;
		AnioNac = anioNac;
		Direccion = direccion;
		Nacionalidad = nacionalidad;
		Provincia = provincia;
		Email = email;
		Telefono = telefono;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int id) {
		ID = id;
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

	public void setDNI(String dNI) {
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

	public int getDiaNac() {
		return DiaNac;
	}

	public void setDiaNac(int diaNac) {
		DiaNac = diaNac;
	}

	public int getMesNac() {
		return MesNac;
	}

	public void setMesNac(int mesNac) {
		MesNac = mesNac;
	}

	public int getAnioNac() {
		return AnioNac;
	}

	public void setAnioNac(int anioNac) {
		AnioNac = anioNac;
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
		Nacionalidad = nacionalidad;
	}

	public Provincia getProvincia() {
		return Provincia;
	}

	public void setProvincia(Provincia provincia) {
		Provincia = provincia;
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
		return "Alumno [ID=" + ID + ", Legajo=" + Legajo + ", DNI=" + DNI + ", Nombre=" + Nombre + ", Apellido=" + Apellido
				+ ", FechaNac=" + FechaNac + ", DiaNac=" + DiaNac + ", MesNac=" + MesNac + ", AnioNac=" + AnioNac
				+ ", Direccion=" + Direccion + ", Nacionalidad=" + Nacionalidad + ", Provincia=" + Provincia
				+ ", Email=" + Email + ", Telefono=" + Telefono + "]";
	}

	
}
