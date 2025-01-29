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
		System.out.println("-----------------------------");
		System.out.println("idProfesor: " + profesor.getIdProfesor());
		System.out.println("nombre: " + profesor.getNombre());
		System.out.println("apellidos: " + profesor.getApellidos());
		// Para que se vea en ese formato
		System.out.println(
				"fechaNacimiento: " + profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
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
				System.out.println("-----------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento: "
						+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor");
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
				System.out.println("-----------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento: "
						+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con idProfesor = " + idProfesor);
		}

		instancia.cerrar();

	}

	static void leerPornombre(String nombre, String filtro) throws Exception {
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
				System.out.println("-----------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento: "
						+ profesor.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con el nombre " + filtro + " " + nombre);
		}

		instancia.cerrar();

	}

}
