import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {


	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		sc.useLocale(Locale.US);
		

		int id;
		String nombre = "";
		double saldo;
		String filtro = "";

		EntidadPersona persona;

		int opcion;
		int opcionSubmenuA;
		int opcionSubmenuB;

		do {
			// Creo que estos cuatro no harán falta
			id = 0;
			nombre = "";
			saldo = 0.0;
			filtro = "";

			Menus.menuPrincipal();
			opcion = leeInt(sc);
			System.out.println();

			switch (opcion) {
			case 1:
				System.out.println("Indique el nombre de la Persona");
				nombre = sc.nextLine();
				System.out.println("Indique el saldo de la Persona (si tiene decimales, use punto \".\")");
				saldo = leeDouble(sc);

				persona = new EntidadPersona(nombre, saldo);

				Funciones.guardar(persona);

				break;

			case 2:

				do {
					Menus.submenuObtener();
					opcionSubmenuA = leeInt(sc);
					System.out.println();

					switch (opcionSubmenuA) {
					case 1:
						System.out.println("Indique el ID de la Persona");
						id = leeInt(sc);
						Funciones.leer(id);

						opcionSubmenuA = 0;
						break;
					case 2:
						do {
							Menus.submenuObtenerPersonaPorNombre();
							opcionSubmenuB = leeInt(sc);
							System.out.println();

							switch (opcionSubmenuB) {
							case 1:
								filtro = "=";
								break;
							case 2:
								filtro = "LIKE";
								break;
							case 0:
								break;
							default:
								System.out.println("Opción no disponible, elija del 0 al 2");
								System.out.println();
								break;
							}

							if (opcionSubmenuB >= 1 && opcionSubmenuB <= 2) {
								System.out.println("Indique el nombre de la Persona");
								nombre = sc.nextLine();
								Funciones.leer(nombre, filtro);
								opcionSubmenuB = 0;
								opcionSubmenuA = 0;
							}

						} while (opcionSubmenuB != 0);

						break;

					case 3:
						do {
							Menus.submenuObtenerPersonaPorSaldo();
							opcionSubmenuB = leeInt(sc);
							System.out.println();

							switch (opcionSubmenuB) {
							case 1:
								filtro = "=";
								break;
							case 2:
								filtro = ">";
								break;
							case 3:
								filtro = "<";
								break;
							case 4:
								filtro = ">=";
								break;
							case 5:
								filtro = "<=";
								break;
							case 0:
								break;

							default:
								System.out.println("Opción no disponible, elija del 0 al 5");
								System.out.println();
								break;
							}

							if (opcionSubmenuB >= 1 && opcionSubmenuB <= 5) {
								System.out.println(
										"Indique el saldo de la Persona (si tiene decimales, use punto \".\")");
								saldo = leeDouble(sc);
								Funciones.leer(saldo, filtro);
								opcionSubmenuB = 0;
								opcionSubmenuA = 0;
							}

						} while (opcionSubmenuB != 0);

						break;
					case 0:
						break;
					default:
						System.out.println("Opción no disponible, elija del 0 al 3");
						System.out.println();
						break;
					}

				} while (opcionSubmenuA != 0);
				break;
			case 3:
				Funciones.muestraTodo();
				System.out.println(
						"Indique el ID de la Persona que desea actualizar (o escriba 0 para ir al menú anterior)");
				id = leeInt(sc);

				if (id != 0) {
					System.out.println("Indique el nombre de la Persona");
					nombre = sc.nextLine();
					System.out.println("Indique el saldo de la Persona (si tiene decimales, use punto \".\")");
					saldo = leeDouble(sc);
					Funciones.actualizar(id, nombre, saldo);
				}
				break;
			case 4:
				Funciones.muestraTodo();
				System.out
						.println("Indique el ID de la Persona que desea borrar (o escriba 0 para ir al menú anterior)");
				id = leeInt(sc);
				if (id != 0) {
					Funciones.borrar(id);
				}
				break;

			case 0:
				break;

			default:
				System.out.println("Opción no disponible, elija del 0 al 4");
				System.out.println();
				break;
			}

		} while (opcion != 0);

		System.out.println("Saliendo del programa...");

		sc.close();

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
			System.out.println("El valor introducido no es un número entero");
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
			System.out
					.println("El valor introducido no es un número o no ha usado punto \".\" como separador decimal.");
		} finally {
			// Siempre limpiamos el buffer del Scanner.
			sc.nextLine();
		}

		// Devolverá el valor escrito por teclado, o -1 si no es del tipo correcto.
		return doubleDevuelto;
	}

}
