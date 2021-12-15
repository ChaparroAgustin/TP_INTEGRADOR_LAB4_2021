package Entidades;

public class Materia {
	
	private int ID;
	private String Descripcion;
	
	public Materia() {
		
	}

	public Materia(int ID, String descripcion) {
		super();
		this.ID = ID;
		Descripcion = descripcion;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Materia [ID=" + ID + ", Descripcion=" + Descripcion + "]";
	}
	
	
}
