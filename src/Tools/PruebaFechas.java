package Tools;

import java.util.Calendar;

import logica.Child;
import logica.ColeccionChildren;
import logica.Consulta;
import logica.Control;
import logica.Vacuna;

public class PruebaFechas {

	public static void main(String[] args) {

		
		// Edad de los children
		Calendar fechaNac1 = Calendar.getInstance();
		fechaNac1.set(2015, 8, 28);
		Calendar fechaNac2 = Calendar.getInstance();
		fechaNac2.set(2019, 11, 15);
		
		// Fechas para vacunas
		Calendar fechaVac1 = Calendar.getInstance();
		fechaNac2.set(2011, 5, 1);
		Calendar fechaVac2 = Calendar.getInstance();
		fechaNac2.set(2014, 1, 8);
		
		// Otras fechas
		Calendar fechaCons1 = Calendar.getInstance();
		fechaCons1.set(2013, 6, 3);
		Calendar fechaCont1 = Calendar.getInstance();
		fechaCont1.set(2012, 11, 24);

		// Vacunas
		Vacuna vac1 = new Vacuna(fechaVac1, "com1", "SaramPH", 1, true);
		@SuppressWarnings("unused")
		Vacuna vac2 = new Vacuna(fechaVac2, "com2", "VaricPH", 2, true);
		
		// Consultas
		Consulta con1 = new Consulta(fechaCons1, "com3", "Pepe Grillo", "Flema", "Juguito");
		
		// Controles
		Control cont1 = new Control(fechaCont1, "com3", 24.50, 1.16);
		@SuppressWarnings("unused")
		Control cont2 = new Control(fechaCont1, "com3", 4.9, 0.96);
		
		Child c1 = new Child("Juan Fanta", 42342345, fechaNac1, "ServiMec", "Antonio Padila", true);
		//System.out.println(c1.mostrarDatos());
		Child c2 = new Child("Maria Pomelo", 51234567, fechaNac2, "UCM", "Rosa Clemente", false);
		//System.out.println(c2.mostrarDatos());
		
		
				
		// Creo arreglo para children
		ColeccionChildren cc1 = new ColeccionChildren();
		// Configuro tamaño arreglo
		cc1.configurar(3, 3);
		
		// Configuro tamaño del arreglo de Registro
		c1.setRegistros(10);
		c2.setRegistros(10);
		
		// Alta de 2 children
		cc1.altaChild(c1);
		cc1.altaChild(c2);
		

				
		// Muestro cantidad de registros que tiene child 1
		System.out.println("Child 1 tiene: " + c1.getCantRegistrosIngresados() + " registros.");
		
		// Muestro cantidad de registros que tiene child 2
		System.out.println("Child 2 tiene: " + c2.getCantRegistrosIngresados() + " registros.");
		
		cc1.altaRegistro(cont1, 51234567);
		cc1.altaRegistro(con1, 51234567);
		cc1.altaRegistro(vac1, 42342345);
		System.out.println("Child 1 tiene: " + c1.getCantRegistrosIngresados() + " registros.");
		System.out.println("Child 2 tiene: " + c2.getCantRegistrosIngresados() + " registros.");
		
		cc1.getDatosChild(51234567);
		
		//c1.getRegistros();
		
		System.out.println(cc1.cuantasConsultasAntesDe(Calendar.getInstance()));
	}
}
