package Entidades;

public class Provincia {
	
	private int ID;
	private String Descripcion;
	
	public Provincia() {
		
	}
	
	public Provincia(int iD, String descripcion) {
		super();
		ID = iD;
		Descripcion = descripcion;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Provincia [ID=" + ID + ", Descripcion=" + Descripcion + "]";
	}
}
