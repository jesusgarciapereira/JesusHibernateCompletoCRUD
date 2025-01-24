import java.util.List;

public class Funciones {

	  static Accesobd instancia = new Accesobd();
	
	/**
	 * Guarda un objeto en la base de datos, validando que el saldo sea mayor o
	 * igual a 0.
	 * 
	 * @param cosa El objeto a guardar, debe ser de tipo EntidadPersona.
	 * @throws Exception Si ocurre un error al guardar o acceder a la base de datos.
	 */
	 static void guardar(Object cosa) throws Exception {
		
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
	 static void leer(long id) throws Exception {
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
	 static void leer(String nombre, String filtro) throws Exception {
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
	 static void leer(double saldo, String filtro) throws Exception {
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
	 static void actualizar(long id, String nombre, double saldo) throws Exception {
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
	 static void borrar(long id) throws Exception {
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
	 static void muestraTodo() throws Exception {
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
}
