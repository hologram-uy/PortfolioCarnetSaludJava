package logica;

import java.util.Calendar;

public class Vacuna extends Registro {

	private String nombre;
	private int dosis;
	private boolean obligatoria;

	/*
	 * Constructor
	 */
	public Vacuna(Calendar fecha, String coment, String nombre, int dosis, boolean obligatoria) {
		super(fecha, coment);
		this.nombre = nombre;
		this.dosis = dosis;
		this.obligatoria = obligatoria;
	}

	/*
	 * Métodos
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	public boolean getObligatoria() {
		return obligatoria;
	}

	public void setObligatoria(boolean obligatoria) {
		this.obligatoria = obligatoria;
	}

	/*
	 * Método abstracto para mostrar registros vacuna
	 * 
	 */
	public String mostrarRegistro() {

		String info = "";

		info = "Fecha: " + mostrarFechaRegistro() + " Comentarios: " + getComent() + " Nombre vacuna: " + getNombre() + " Dosis: "
				+ getDosis() + " Es obligatoria: " + getObligatoria();

		return info;
	}
}
