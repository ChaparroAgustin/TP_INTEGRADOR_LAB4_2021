package Entidades;

public class AlumnoPorCurso {

	private int ID;
	private int IdCurso;
	private String Legajo;
	private String Dni;
	private String Nombre;
	private String Apellido;
	private int IdAlumno;
	private int Nota1;
	private int Nota2;
	private int Nota3;
	private int Nota4;
	private int Estado;
	
	public AlumnoPorCurso() {
		
	}

	public AlumnoPorCurso(int iD, int idCurso, String legajo, String dni, String nombre, String apellido, int idAlumno,
			int nota1, int nota2, int nota3, int nota4, int estado) {
		super();
		ID = iD;
		IdCurso = idCurso;
		Legajo = legajo;
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
		IdAlumno = idAlumno;
		Nota1 = nota1;
		Nota2 = nota2;
		Nota3 = nota3;
		Nota4 = nota4;
		Estado = estado;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getIdCurso() {
		return IdCurso;
	}

	public void setIdCurso(int idCurso) {
		IdCurso = idCurso;
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

	public int getIdAlumno() {
		return IdAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		IdAlumno = idAlumno;
	}

	public int getNota1() {
		return Nota1;
	}

	public void setNota1(int nota1) {
		Nota1 = nota1;
	}

	public int getNota2() {
		return Nota2;
	}

	public void setNota2(int nota2) {
		Nota2 = nota2;
	}

	public int getNota3() {
		return Nota3;
	}

	public void setNota3(int nota3) {
		Nota3 = nota3;
	}

	public int getNota4() {
		return Nota4;
	}

	public void setNota4(int nota4) {
		Nota4 = nota4;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "AlumnoPorCurso [ID=" + ID + ", IdCurso=" + IdCurso + ", Legajo=" + Legajo + ", Dni=" + Dni + ", Nombre="
				+ Nombre + ", Apellido=" + Apellido + ", IdAlumno=" + IdAlumno + ", Nota1=" + Nota1 + ", Nota2=" + Nota2
				+ ", Nota3=" + Nota3 + ", Nota4=" + Nota4 + ", Estado=" + Estado + "]";
	}
}
