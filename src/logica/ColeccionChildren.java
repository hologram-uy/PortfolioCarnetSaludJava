package logica;

import java.util.Calendar;


public class ColeccionChildren {

	private Child[] children;
	private int tope;
	@SuppressWarnings("unused")
	private int maximoChildren;
	private int maximoRegistros;

	/*
	 * Constructor Inicializa arreglo en null y tope en 0.
	 * 
	 */
	public ColeccionChildren() {
		children = null;
		tope = 0;
		maximoChildren = 0;
		maximoRegistros = 0;
	}

	public void configurar(int maximoChildren, int maximoRegistros) {

		if (!estaConfigurado()) {
			if (maximoChildren > 0 && maximoRegistros > 0) {

				this.maximoChildren = maximoChildren;
				this.maximoRegistros = maximoRegistros;
				children = new Child[maximoChildren];
			} else {
				System.out.println("Valores deben ser mayor que 0.");
			}
		} else {
			System.out.println("La colecci\u00f3n ya est\u00e1 configurada.");
		}
	}

	public void altaChild(Child n) {

		if (!existeChild(n.getDocumento())) {
			if (hayLugar()) {
				Registro[] reg = new Registro[maximoRegistros];
				n.setRegistros(reg);
				children[tope] = n;
				tope++;
			} else {
				System.out.println("No parece haber m\u00e1s lugar en el arreglo.");
			}
		} else {
			System.out.println("El ni\u00f1o con documento " + n.mostrarDocumento() + " ya se encuentra registrado.");
		}
	}

	public String listarChildren() {

		String info = "";

		for (int i = 0; i < tope; i++) {
			info += children[i].mostrarDatos().toString() + "\n";
		}

		return info;
	}

	public void altaRegistro(Registro r, int cedulaChild) {

		int i = 0;
		boolean ingresado = false;

		while (i < tope && hayLugar() && !ingresado) {
			if (existeChild(cedulaChild) && children[i].getDocumento() == cedulaChild) {
				children[i].nuevoRegistro(r);
				ingresado = true;
			}
			i++;
		}
	}

	public void getDatosChild(int ci) {

		// reescribir con while
		if (existeChild(ci)) {
			for (int i = 0; i < tope; i++) {
				if (children[i].getDocumento() == ci) {
					System.out.println(children[i].mostrarDatos());
					System.out.println(children[i].mostrarRegistros());
				}
			}
		} else {
			System.out.println("El documento no figura en la base.");
		}
	}

	// to do
	public int cuantasConsultasAntesDe(Calendar fecha) {

		int cantidadConsultas = 0;

		for (int i = 0; i < tope; i++) {

		}

		return cantidadConsultas;
	}

	/*
	 * Otros m\u00e9todos para controles
	 * 
	 */
	public boolean hayLugar() {

		boolean lugarOk = false;

		if (tope < children.length) {
			lugarOk = true;
		}

		return lugarOk;
	}

	public boolean existeChild(int ci) {

		boolean existe = false;
		int i = 0;

		while (!existe && i < tope) {
			if (children[i].getDocumento() == ci) {
				existe = true;
			} else {
				existe = false;
			}
			i++;
		}

		return existe;
	}

	public boolean estaConfigurado() {
		@SuppressWarnings("unused")
		boolean configurado;

		if (children == null) {
			return configurado = false;
		} else {
			return configurado = true;
		}
	}

	public boolean fechaAnterior(Calendar fch, Calendar fch2) {

		// Calendar fecha = dateChooser.getCalendar();

		boolean esAnterior = false;

		@SuppressWarnings("unused")
		Calendar hoy = Calendar.getInstance();
		if (fch.before(fch2)) {
			esAnterior = true;
		}

		return esAnterior;
	}
}
