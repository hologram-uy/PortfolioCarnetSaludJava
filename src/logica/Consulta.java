package logica;

import java.util.Calendar;

public class Consulta extends Registro {

	private String medico;
	private String diagnostico;
	private String recomendaciones;

	/*
	 * Constructor
	 * 
	 */
	public Consulta(Calendar fecha, String coment, String medico, String diagnostico, String recomendaciones) {
		super(fecha, coment);
		this.medico = medico;
		this.diagnostico = diagnostico;
		this.recomendaciones = recomendaciones;
	}

	/*
	 * M�todos
	 * 
	 */
	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	/*
	 * Otros m�todos
	 * 
	 */

	public String mostrarRegistro() {

		String info;

		info = "Fecha: " + mostrarFechaRegistro() + " Comentarios: " + getComent() + " Nombre m�dico: " + getMedico()
				+ " Diagn\u00f3stico: " + getDiagnostico() + " Recomendaciones: " + getRecomendaciones();

		return info;
	}
}
