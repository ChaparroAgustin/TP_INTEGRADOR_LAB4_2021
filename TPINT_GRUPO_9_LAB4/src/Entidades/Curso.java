package Entidades;

public class Curso {

	private int ID;
	private int IdMateria;
	private String Materia;
	private int Semestre;
	private int Anio;
	private int IdDocente;
	private String Docente;
	
	public Curso() {
		
	}

	public Curso(int iD, int idMateria, String materia, int semestre, int anio, int idDocente, String docente) {
		super();
		ID = iD;
		IdMateria = idMateria;
		Materia = materia;
		Semestre = semestre;
		Anio = anio;
		IdDocente = idDocente;
		Docente = docente;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getIdMateria() {
		return IdMateria;
	}

	public void setIdMateria(int idMateria) {
		IdMateria = idMateria;
	}

	public String getMateria() {
		return Materia;
	}

	public void setMateria(String materia) {
		Materia = materia;
	}

	public int getSemestre() {
		return Semestre;
	}

	public void setSemestre(int semestre) {
		Semestre = semestre;
	}

	public int getAnio() {
		return Anio;
	}

	public void setAnio(int anio) {
		Anio = anio;
	}

	public int getIdDocente() {
		return IdDocente;
	}

	public void setIdDocente(int idDocente) {
		IdDocente = idDocente;
	}

	public String getDocente() {
		return Docente;
	}

	public void setDocente(String docente) {
		Docente = docente;
	}

	@Override
	public String toString() {
		return "Curso [ID=" + ID + ", IdMateria=" + IdMateria + ", Materia=" + Materia + ", Semestre=" + Semestre
				+ ", Anio=" + Anio + ", IdDocente=" + IdDocente + ", Docente=" + Docente + "]";
	}

	
}
