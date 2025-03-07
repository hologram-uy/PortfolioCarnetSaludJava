package logica;

import java.util.Calendar;

public class Control extends Registro {

	private double peso;
	private double altura;

	/*
	 * Constructor
	 *
	 */
	public Control(Calendar fecha, String coment, double peso, double altura) {
		super(fecha, coment);
		this.peso = peso;
		this.altura = altura;
	}

	/*
	 * Métodos
	 * 
	 */
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String mostrarRegistro() {

		String info;

		info = "Fecha: " + mostrarFechaRegistro() + " Comentarios: " + getComent() + " Peso: " + getPeso() + " Altura: "
				+ getAltura();

		return info;
	}
}
