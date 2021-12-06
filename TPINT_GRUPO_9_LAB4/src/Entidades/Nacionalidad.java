package Entidades;

public class Nacionalidad {
	
	private int ID;
	private String Descripcion;
	
	public Nacionalidad() {
		
	}
	
	public Nacionalidad(int id, String descripcion) {
		this.ID = id;
		this.Descripcion = descripcion;
	}

	public int getID() {
		return ID;
	}

	public void setID(int id) {
		ID = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Nacionalidad [ID=" + ID + ", Descripcion=" + Descripcion + "]";
	}
}
