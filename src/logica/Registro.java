package logica;

import java.util.Calendar;

public abstract class Registro {

	private Calendar fecha;
	private String coment;

	/*
	 * Constructor
	 */
	public Registro(Calendar fecha, String coment) {
		super();
		this.fecha = fecha;
		this.coment = coment;
	}

	/*
	 * Métodos
	 */
	public Calendar getFecha() {
		return fecha;
	}

	public String mostrarFechaRegistro() {

		String miFecha;

		int year = fecha.get(Calendar.YEAR);
		int month = fecha.get(Calendar.MONTH);
		int day = fecha.get(Calendar.DAY_OF_MONTH);

		miFecha = "" + year + "-" + (month + 1) + "-" + day;

		return miFecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	/*
	 * Otros métodos
	 * 
	 */
	public abstract String mostrarRegistro();

}
