package Entidades;

public class Materia {
	
	private String Codigo;
	private String Descripcion;
	
	public Materia() {
		
	}

	public Materia(String codigo, String descripcion) {
		super();
		Codigo = codigo;
		Descripcion = descripcion;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Materia [Codigo=" + Codigo + ", Descripcion=" + Descripcion + "]";
	}
	
	
}
