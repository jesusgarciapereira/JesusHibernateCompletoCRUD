import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Principal {
	private static Accesobd instancia;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		instancia = new Accesobd();

		sc.useLocale(Locale.US);

		// ejemploGuardar1Persona();
		// ejemploLeer1PersonaPorId();
		ejemploLeer1PersonaPorNombre();
		ejemploLeer1PersonaPorSaldo();
	}

	private static void ejemploGuardar1Persona() throws Exception {
		EntidadPersona persona = new EntidadPersona("Anselmo", 567);
		guardar(persona);

	}

	private static void ejemploLeer1PersonaPorId() throws Exception {
		leer(4);

	}

	private static void ejemploLeer1PersonaPorNombre() throws Exception {
		leer("e", "LIKE");

	}
	
	private static void ejemploLeer1PersonaPorSaldo() throws Exception {
		leer(1, ">=");

	}

	private static void guardar(Object cosa) throws Exception {
		instancia.abrir();
		long id = (long) instancia.guardar(cosa);
		System.out.println(id);
		instancia.cerrar();
	}

	private static void leer(long id) throws Exception {
		instancia.abrir();
		EntidadPersona persona = instancia.getSesion().get(EntidadPersona.class, id);

		// Esta línea también funcionaría como la anterior pero es mejor la otra
		// EntidadPersona persona = instancia.getSesion().load(EntidadPersona.class,
		// id);

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

	private static void leer(String nombre, String filtro) throws Exception {
		String consultaSQL = "";
		
		if (filtro.equals("=")) {
			consultaSQL += "SELECT * FROM Personas WHERE nombre " + filtro + " '" + nombre + "'";
		} else {
			consultaSQL += "SELECT * FROM Personas WHERE nombre " + filtro + " '%" + nombre + "%'";
		}
		
		
		instancia.abrir();
		List<EntidadPersona> personas = instancia.getSesion().createNativeQuery(consultaSQL, EntidadPersona.class)
				.getResultList();

		if (personas.size() > 0) {
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

	private static void leer(double saldo, String filtro) throws Exception {

		String consultaSQL = "SELECT * FROM Personas WHERE saldo " + filtro + " " +  saldo;

		instancia.abrir();
		List<EntidadPersona> personas = instancia.getSesion().createNativeQuery(consultaSQL, EntidadPersona.class)
				.getResultList();

		if (personas.size() > 0) {
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
			System.out.print("\u001B[91mError: \u001B[0m"); // Color personalizado para el "error".
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
