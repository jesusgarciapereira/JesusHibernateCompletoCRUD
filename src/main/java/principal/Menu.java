package principal;

import colores.ColorMio;

public class Menu {

	static void menuPrincipal() {
		System.out.println("Menú Principal:");
		System.out.println("===============");
		System.out.println("1. Guardar Datos.");
		System.out.println("2. Obtener datos.");
		System.out.println("3. Actualizar Datos.");
		System.out.println("4. Borrar Datos.");
		System.out.println("0. Salir del Programa");
		System.out.println();
		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}
	
	static void subMenuInsertarDatos() {
		System.out.println("Guardar Datos:");
		System.out.println("==============");
		System.out.println("1. Profesores.");
		System.out.println("2. Alumnos.");
		System.out.println("3. Matriculas.");
		System.out.println("0. Volver al Menú anterior.");
		System.out.println();
		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}
	
}
