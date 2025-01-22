import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
	private static Accesobd instancia;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		sc.useLocale(Locale.US);
		instancia = new Accesobd();

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

				guardar(persona);

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
						leer(id);

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
								leer(nombre, filtro);
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
								leer(saldo, filtro);
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
				muestraTodo();
				System.out.println(
						"Indique el ID de la Persona que desea actualizar (o escriba 0 para ir al menú anterior)");
				id = leeInt(sc);

				if (id != 0) {
					System.out.println("Indique el nombre de la Persona");
					nombre = sc.nextLine();
					System.out.println("Indique el saldo de la Persona (si tiene decimales, use punto \".\")");
					saldo = leeDouble(sc);
					actualizar(id, nombre, saldo);
				}
				break;
			case 4:
				muestraTodo();
				System.out
						.println("Indique el ID de la Persona que desea borrar (o escriba 0 para ir al menú anterior)");
				id = leeInt(sc);
				if (id != 0) {
					borrar(id);
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
	 * Guarda un objeto en la base de datos, validando que el saldo sea mayor o
	 * igual a 0.
	 * 
	 * @param cosa El objeto a guardar, debe ser de tipo EntidadPersona.
	 * @throws Exception Si ocurre un error al guardar o acceder a la base de datos.
	 */
	private static void guardar(Object cosa) throws Exception {
		
		EntidadPersona persona =  (EntidadPersona) cosa;
	
		instancia.abrir();

		// Verifica que el saldo sea mayor o igual a 0 antes de guardar
		if (persona.getSaldo() >= 0) {
			instancia.guardar(cosa); // Guarda el objeto en la base de datos

			System.out.println("----------------");
			System.out.println("Persona guardada");
			System.out.println("-----------------------------");
			System.out.println("idPersona: " + persona.getIdPersona());
			System.out.println("nombre: " + persona.getNombre());
			System.out.println("saldo: " + persona.getSaldo());

		} else {
			System.out.println("Saldo incorrecto, no se ha podido guardar");
		}

		instancia.cerrar(); // Cierra la conexión con la base de datos
	}

	/**
	 * Lee una persona de la base de datos por su ID y muestra sus detalles.
	 * 
	 * @param id ID de la persona a buscar.
	 * @throws Exception Si ocurre un error al acceder a la base de datos.
	 */
	private static void leer(long id) throws Exception {
		instancia.abrir();

		// Busca la persona por su ID
		EntidadPersona persona = instancia.getSesion().get(EntidadPersona.class, id);

		// Si se encuentra la persona, muestra sus detalles
		if (persona != null) {
			System.out.println("-----------------------------");
			System.out.println("idPersona: " + persona.getIdPersona());
			System.out.println("nombre: " + persona.getNombre());
			System.out.println("saldo: " + persona.getSaldo());
		} else {
			System.out.println("No existe ninguna Persona con el id = " + id);
		}

		instancia.cerrar();
	}

	/**
	 * Busca personas en la base de datos por nombre utilizando un filtro.
	 * 
	 * @param nombre Nombre a buscar.
	 * @param filtro Tipo de filtro (por ejemplo, "=" o "LIKE").
	 * @throws Exception Si ocurre un error al acceder a la base de datos.
	 */
	private static void leer(String nombre, String filtro) throws Exception {
		String consultaSQL;

		// Construye la consulta SQL según el filtro
		if (filtro.equals("=")) {
			consultaSQL = "SELECT * FROM Personas WHERE nombre " + filtro + " '" + nombre + "'";
		} else {
			consultaSQL = "SELECT * FROM Personas WHERE nombre " + filtro + " '%" + nombre + "%'";
		}

		instancia.abrir();

		// Ejecuta la consulta y obtiene los resultados
		List<EntidadPersona> personas = instancia.getSesion().createNativeQuery(consultaSQL, EntidadPersona.class)
				.getResultList();

		// Muestra los resultados si se encuentran personas
		if (!personas.isEmpty()) {
			for (EntidadPersona persona : personas) {
				System.out.println("-----------------------------");
				System.out.println("idPersona: " + persona.getIdPersona());
				System.out.println("nombre: " + persona.getNombre());
				System.out.println("saldo: " + persona.getSaldo());
			}
		} else {
			System.out.println("No existe ninguna Persona con el nombre " + filtro + " " + nombre);
		}

		instancia.cerrar();
	}

	/**
	 * Busca personas en la base de datos por saldo utilizando un filtro.
	 * 
	 * @param saldo  Saldo a buscar.
	 * @param filtro Tipo de filtro (por ejemplo, ">", "<", "=").
	 * @throws Exception Si ocurre un error al acceder a la base de datos.
	 */
	private static void leer(double saldo, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Personas WHERE saldo " + filtro + " " + saldo;

		instancia.abrir();

		// Ejecuta la consulta y obtiene los resultados
		List<EntidadPersona> personas = instancia.getSesion().createNativeQuery(consultaSQL, EntidadPersona.class)
				.getResultList();

		// Muestra los resultados si se encuentran personas
		if (!personas.isEmpty()) {
			for (EntidadPersona persona : personas) {
				System.out.println("-----------------------------");
				System.out.println("idPersona: " + persona.getIdPersona());
				System.out.println("nombre: " + persona.getNombre());
				System.out.println("saldo: " + persona.getSaldo());
			}
		} else {
			System.out.println("No existe ninguna Persona con el saldo = " + saldo);
		}

		instancia.cerrar();
	}

	/**
	 * Actualiza los datos de una persona en la base de datos.
	 * 
	 * @param id     ID de la persona a actualizar.
	 * @param nombre Nuevo nombre de la persona.
	 * @param saldo  Nuevo saldo de la persona.
	 * @throws Exception Si ocurre un error al acceder a la base de datos.
	 */
	private static void actualizar(long id, String nombre, double saldo) throws Exception {
		instancia.abrir();

		// Busca la persona por su ID
		EntidadPersona persona = instancia.getSesion().get(EntidadPersona.class, id);

		if (persona != null) {
			// Actualiza los datos de la persona
			persona.setNombre(nombre);
			persona.setSaldo(saldo);
			instancia.getSesion().update(persona); // Actualiza la persona en la base de datos
		} else {
			System.out.println("No existe ninguna Persona con el id = " + id);
		}

		instancia.cerrar();
	}

	/**
	 * Elimina una persona de la base de datos por su ID.
	 * 
	 * @param id ID de la persona a eliminar.
	 * @throws Exception Si ocurre un error al acceder a la base de datos.
	 */
	private static void borrar(long id) throws Exception {
		instancia.abrir();

		// Busca la persona por su ID
		EntidadPersona persona = instancia.getSesion().get(EntidadPersona.class, id);

		if (persona != null) {
			instancia.getSesion().delete(persona); // Elimina la persona de la base de datos
		} else {
			System.out.println("No existe ninguna Persona con el id = " + id);
		}

		instancia.cerrar();
	}

	/**
	 * Muestra todas las personas registradas en la base de datos.
	 * 
	 * @throws Exception Si ocurre un error al acceder a la base de datos.
	 */
	private static void muestraTodo() throws Exception {
		String consultaSQL = "SELECT * FROM Personas";

		instancia.abrir();

		// Ejecuta la consulta y obtiene todos los registros
		List<EntidadPersona> personas = instancia.getSesion().createNativeQuery(consultaSQL, EntidadPersona.class)
				.getResultList();

		if (!personas.isEmpty()) {
			for (EntidadPersona persona : personas) {
				System.out.println("-----------------------------");
				System.out.println("idPersona: " + persona.getIdPersona());
				System.out.println("nombre: " + persona.getNombre());
				System.out.println("saldo: " + persona.getSaldo());
			}
		} else {
			System.out.println("No existe ningún elemento en la tabla Persona");
		}

		instancia.cerrar();
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
