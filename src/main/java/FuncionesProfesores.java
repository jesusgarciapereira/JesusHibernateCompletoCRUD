import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FuncionesProfesores {
	static Accesobd instancia = new Accesobd();

	static void guardar(Object cosa) throws Exception {

		ProfesorEntity profesor = (ProfesorEntity) cosa;

		instancia.abrir();

		instancia.guardar(cosa); // Guarda el objeto en la base de datos

		System.out.println("----------------");
		System.out.println("Profesor guardado");
		System.out.println("-----------------------------------------");
		System.out.println("idProfesor: " + profesor.getIdProfesor());
		System.out.println("nombre: " + profesor.getNombre());
		System.out.println("apellidos: " + profesor.getApellidos());
		// Para que se vea en ese formato
		System.out.println("fechaNacimiento (dd-MM-aaaa): "
				+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		System.out.println("antiguedad: " + profesor.getAntiguedad());

		instancia.cerrar();
	}

	static void leerTodos() throws Exception {
		String consultaSQL = "SELECT * FROM Profesores";

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (dd-MM-aaaa): "
						+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún elemento en la tabla Profesor");
		}

		instancia.cerrar();
	}

	static void leerPorId(long idProfesor, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Profesores WHERE idProfesor " + filtro + " " + idProfesor;

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (dd-MM-aaaa): "
						+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con idProfesor " + filtro + " " + idProfesor);
		}

		instancia.cerrar();

	}

	static void leerPorNombre(String nombre, String filtro) throws Exception {
		String consultaSQL;

		// Construye la consulta SQL según el filtro
		if (filtro.equals("=")) {
			consultaSQL = "SELECT * FROM Profesores WHERE nombre " + filtro + " '" + nombre + "'";
		} else {
			consultaSQL = "SELECT * FROM Profesores WHERE nombre " + filtro + " '%" + nombre + "%'";
		}

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (dd-MM-aaaa): "
						+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con el nombre " + filtro + " " + nombre);
		}

		instancia.cerrar();

	}

	static void leerPorApellidos(String apellidos, String filtro) throws Exception {

		String consultaSQL;

		// Construye la consulta SQL según el filtro
		if (filtro.equals("=")) {
			consultaSQL = "SELECT * FROM Profesores WHERE apellidos " + filtro + " '" + apellidos + "'";
		} else {
			consultaSQL = "SELECT * FROM Profesores WHERE apellidos " + filtro + " '%" + apellidos + "%'";
		}

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (dd-MM-aaaa): "
						+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con apellidos " + filtro + " " + apellidos);
		}

		instancia.cerrar();

	}

	static void leerPorFechaNacimiento(LocalDate fechaNacimiento, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Profesores WHERE fechaNacimiento " + filtro + " '" + fechaNacimiento + "'";

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (dd-MM-aaaa): "
						+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con fechaNacimiento " + filtro + " " + fechaNacimiento);
		}

		instancia.cerrar();

	}
	
	static void leerPorAntiguedad(int antiguedad, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Profesores WHERE antiguedad " + filtro + " " + antiguedad;

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (dd-MM-aaaa): "
						+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con antigüedad " + filtro + " " + antiguedad);
		}

		instancia.cerrar();

	}
	
//	static void actualizar(long id, String nombre, double saldo) throws Exception {
//		instancia.abrir();
//
//		// Busca la persona por su ID
//		EntidadPersona persona = instancia.getSesion().get(EntidadPersona.class, id);
//
//		if (persona != null) {
//			// Actualiza los datos de la persona
//			persona.setNombre(nombre);
//			persona.setSaldo(saldo);
//			instancia.getSesion().update(persona); // Actualiza la persona en la base de datos
//		} else {
//			System.out.println("No existe ninguna Persona con el id = " + id);
//		}
//
//		instancia.cerrar();
//	}

}
