package logica;

import java.util.Calendar;

public class Child {

	private String nombre;
	private int documento;
	private Calendar fechaNacimiento;
	private String servicioMedico;
	private String medicoCabecera;
	private boolean tieneFonasa;
	private Registro[] registros;
	private int cantRegistrosIngresados;

	/*
	 * Constructor con todos los parámetros
	 * 
	 */
	public Child(String nombre, int documento, Calendar fechaNacimiento, String servicioMedico, String medicoCabecera,
			boolean tieneFonasa, Registro[] registros, int cantRegistrosIngresados) {
		this.nombre = nombre;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.servicioMedico = servicioMedico;
		this.medicoCabecera = medicoCabecera;
		this.tieneFonasa = tieneFonasa;
		this.registros = registros;
		this.cantRegistrosIngresados = cantRegistrosIngresados;
	}

	/*
	 * Constructor que recibe los primeros 6 atributos como parámetro Inicializa
	 * arreglo Registros en null y cantRegistrosIngresados en 0
	 * 
	 */
	public Child(String nombre, int documento, Calendar fechaNacimiento, String servicioMedico, String medicoCabecera,
			boolean tieneFonasa) {
		this.nombre = nombre;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.servicioMedico = servicioMedico;
		this.medicoCabecera = medicoCabecera;
		this.tieneFonasa = tieneFonasa;
		registros = null;
		cantRegistrosIngresados = 0;
	}

	/*
	 * Métodos
	 *
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String mostrarDocumento() {

		String doc = String.valueOf(documento);

		doc = doc.charAt(0) + "." + doc.substring(1, 4) + "." + doc.substring(4, 7) + "-" + doc.charAt(7);

		return doc;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	/*
	 * Método extra para mostrar fecha nacimiento en formato amigable
	 * 
	 */
	public String mostrarFechaNacimiento() {

		String miFecha;

		int year = fechaNacimiento.get(Calendar.YEAR);
		int month = fechaNacimiento.get(Calendar.MONTH);
		int day = fechaNacimiento.get(Calendar.DAY_OF_MONTH);

		miFecha = "" + year + "-" + (month+1) + "-" + day;
		
		//miFecha = fechaNacimiento.toString();

		return miFecha;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		// to do
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getServicioMedico() {
		return servicioMedico;
	}

	public void setServicioMedico(String servicioMedico) {
		this.servicioMedico = servicioMedico;
	}

	public String getMedicoCabecera() {
		return medicoCabecera;
	}

	public void setMedicoCabecera(String medicoCabecera) {
		this.medicoCabecera = medicoCabecera;
	}

	public boolean getTieneFonasa() {
		return tieneFonasa;
	}

	public void setTieneFonasa(boolean tieneFonasa) {
		this.tieneFonasa = tieneFonasa;
	}
	
	public Registro[] getRegistros() {
		return registros;
	}

	public void setRegistros(Registro[] registros) {
		this.registros = registros;
	}

	public String mostrarRegistros() {
		// to do
		String regInfo = "";

		for (int i = 0; i < cantRegistrosIngresados; i++) {
			if (registros[i] != null) {
				regInfo += "" + registros[i].mostrarRegistro() + "\n";
			} else {
				return regInfo = "nada";
			}
		}
		return regInfo;

	}

	public void setRegistros(int maxRegistros) {
		// to do
		registros = new Registro[maxRegistros];
	}

	public int getCantRegistrosIngresados() {
		return cantRegistrosIngresados;
	}
	
	/*
	 *	creo un metodo cuantasConsultasAntesDe devuelve int (recibe fecha, devuelve int)
	 *	 
	 * 
	 */
	

	/*
	 * Método para calcular edad del child
	 * 
	 */
	public int getEdad() {

		int edad = 0;

		// Fecha de hoy
		Calendar hoy = Calendar.getInstance();
		
		// Fecha nacimiento child
		Calendar fch1 = (Calendar) fechaNacimiento.clone();		
		

		fch1.add(Calendar.YEAR, 1);
		while (fch1.before(hoy)) {
			edad++;
			fch1.add(Calendar.YEAR, 1);
		}

		return edad;
	}

	public void nuevoRegistro(Registro r) {

		registros[cantRegistrosIngresados] = r;
		cantRegistrosIngresados++;

	}

	/*
	 * Método para devolver datos del objeto child
	 * 
	 */
	public String mostrarDatos() {

		String info;
		info = "Nombre: " + getNombre() + " Documento: " + mostrarDocumento() + " Fecha nacimiento: "
				+ mostrarFechaNacimiento() + " Edad: " + getEdad() + " Servicio M\u00e9dico: " + getServicioMedico()
				+ " Fonasa: " + getTieneFonasa();

		return info;
	}
}
