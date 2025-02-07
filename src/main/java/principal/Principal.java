package principal;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.Column;

import colores.ColorMio;
import entidades.ProfesorEntity;
import funciones.FuncionesProfesores;

public class Principal {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// sc.useLocale(Locale.US);

		int opcionMenu = -1;
		int opcionSubmenuA = -1;
		int opcionSubmenuB = -1;
		int opcionSubmenuC = -1;
		int opcionSubmenuD = -1;
		int opcionSubmenuE = -1;

		ProfesorEntity profesor;
		long idProfesor;
		String nombre = "";
		String apellidos = "";
		String fechaNacimiento = "";
		int antiguedad = -1;

		int fechaDia = 0;
		int fechaMes = 0;
		int fechaAnnio = 0;

		do {
			Menu.menuPrincipal();
			opcionMenu = leeInt(sc);
			System.out.println();

			switch (opcionMenu) {
			case 1:
				do {
					Menu.subMenuInsertarDatos();
					opcionSubmenuA = leeInt(sc);
					System.out.println();

					switch (opcionSubmenuA) {
					case 1:
						while (nombre == null || nombre.equals("")) {
							System.out.print("Escriba el Nombre del Profesor: ");
							nombre = sc.nextLine();
						}
						while (apellidos == null || apellidos.equals("")) {
							System.out.print("Escriba los Apellidos del Profesor: ");
							apellidos = sc.nextLine();
						}
						while (fechaNacimiento == null || fechaNacimiento.equals("")) {
							while (fechaDia < 1 || fechaDia > 31) {
								System.out.print("Introduzca el día de FechaNacimiento del Profesor (entre 1 y 31): ");
								fechaDia = leeInt(sc);
							}
							while (fechaMes < 1 || fechaMes > 12) {
								System.out.print("Introduzca el mes de FechaNacimiento del Profesor (entre 1 y 12): ");
								fechaMes = leeInt(sc);
							}

							while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear()) {
								System.out.print(
										"Introduzca el año de FechaNacimiento del Profesor (mayor o igual que 1000 y menor o igual que el año actual): ");
								fechaAnnio = leeInt(sc);
							}
							fechaNacimiento = String.format("%d-%02d-%02d", fechaAnnio, fechaMes, fechaDia);
						}
						while (antiguedad < 0) {
							System.out.print("Escriba la Antiguedad del Profesor (mayor o igual que 0): ");
							antiguedad = leeInt(sc);
						}
						try {
							profesor = new ProfesorEntity(nombre, apellidos, LocalDate.parse(fechaNacimiento),
									antiguedad);

							FuncionesProfesores.guardar(profesor);
						} catch (DateTimeException e) {
							System.out.println();
							System.out.print(ColorMio.getRojo());
							System.out.println(
									"Fecha de nacimiento '" + fechaNacimiento + "' incorrecta:" + ColorMio.getReset());
							System.out.println();
						} finally {
							opcionSubmenuA = 0;

							nombre = "";
							apellidos = "";
							fechaNacimiento = "";
							antiguedad = -1;

							fechaDia = 0;
							fechaMes = 0;
							fechaAnnio = 0;
							
							profesor = null;
						}

						break;
					case 2:

						break;
					case 3:

						break;
					case 0:
						break;

					default:
						System.out.print(ColorMio.getRojo());
						System.out.println("Opción no disponible:" + ColorMio.getReset() + " Elija del 0 al 3");
						System.out.println();
						break;
					}// FIN switch (opcionSubmenuA)

				} while (opcionSubmenuA != 0);

				opcionMenu = -1;

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 0:
				break;

			default:
				System.out.print(ColorMio.getRojo());
				System.out.println("Opción no disponible:" + ColorMio.getReset() + " Elija del 0 al 4");
				System.out.println();
				break;
			} // FIN switch (opcionMenu)

		} while (opcionMenu != 0);

		System.out.println("Saliendo del programa...");
	}

	/**
	 * Funcion que devuelve el numero escrito por teclado
	 * 
	 * @param sc Objeto de tipo Scanner que leera
	 * @return Valor del numero escrito
	 */
	private static long leeLong(Scanner sc) {
		// Numero decimal que devolverá la funcion, inicializado en -1
		long longDevuelto = -1;

		try {
			// Le asignamos el int escrito por teclado
			longDevuelto = sc.nextLong();

			// Si se produce un InputMismatchException
		} catch (InputMismatchException e) {
			// Mostrará este mensaje
			System.out.println(ColorMio.getRojo() + "El valor introducido no es un número" + ColorMio.getReset());
		} finally {
			// Siempre limpiamos el buffer
			sc.nextLine();
		}

		// Devolverá el valor escrito por teclado, o -1 si no es del tipo correcto
		return longDevuelto;
	}

	/**
	 * Funcion que devuelve el numero entero escrito por teclado
	 * 
	 * @param sc Objeto de tipo Scanner que leera
	 * @return Valor del numero entero escrito
	 */
	private static int leeInt(Scanner sc) {
		// Numero decimal que devolverá la funcion, inicializado en -1
		int intDevuelto = -1;

		try {
			// Le asignamos el int escrito por teclado
			intDevuelto = sc.nextInt();

			// Si se produce un InputMismatchException
		} catch (InputMismatchException e) {
			// Mostrará este mensaje
			System.out
					.println(ColorMio.getRojo() + "El valor introducido no es un número entero" + ColorMio.getReset());
		} finally {
			// Siempre limpiamos el buffer
			sc.nextLine();
		}

		// Devolverá el valor escrito por teclado, o -1 si no es del tipo correcto
		return intDevuelto;
	}

	/**
	 * Funcion que devuelve un numero decimal escrito por teclado. Si se introduce
	 * un valor no valido, muestra un mensaje de error y devuelve -1.
	 * 
	 * @param sc Objeto de tipo Scanner que leere la entrada del usuario.
	 * @return El numero decimal introducido por el usuario, o -1 si ocurre un
	 *         error.
	 */
	private static double leeDouble(Scanner sc) {
		// Número decimal que devolverá la función, inicializado en -1.
		double doubleDevuelto = -1;

		try {
			// Le asignamos el número decimal escrito por teclado.
			doubleDevuelto = sc.nextDouble();

			// Si se produce un InputMismatchException.
		} catch (InputMismatchException e) {
			// Mostrará este mensaje en caso de error.
			System.out.println(ColorMio.getRojo()
					+ "El valor introducido no es un número o no ha usado punto \".\" como separador decimal."
					+ ColorMio.getReset());
		} finally {
			// Siempre limpiamos el buffer del Scanner.
			sc.nextLine();
		}

		// Devolverá el valor escrito por teclado, o -1 si no es del tipo correcto.
		return doubleDevuelto;
	}

}
