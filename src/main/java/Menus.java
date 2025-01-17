/**
 * Clase que gestiona los menus y submenus.
 */
public class Menus {
	
	/**
	 * Menu principal del programa que muestra las diferentes opciones
	 */
	static void menuPrincipal() {
		System.out.println("Menú Principal:");
		System.out.println("===============");
		System.out.println("1. Guardar Persona.");
		System.out.println("2. Obtener Persona.");
		System.out.println("3. Actualizar Persona.");
		System.out.println("4. Borrar Persona.");
		System.out.println("0. Salir del Programa");
		System.out.println();
		System.out.println("Escriba una opción: ");
	}
	
	static void submenuObtener() {
		System.out.println("Obtener Persona:");
		System.out.println("===============");
		System.out.println("1. Por ID.");
		System.out.println("2. Por nombre.");
		System.out.println("3. Por saldo.");
		System.out.println("0. Volver al Menú anterior.");
		System.out.println();
		System.out.println("Escriba una opción: ");
	}
	

}
