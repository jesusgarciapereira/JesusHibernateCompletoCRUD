package funciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import accesodb.Accesobd;
import entidades.ProfesorEntity;

public class FuncionesProfesores {
	static Accesobd instancia = new Accesobd();

	// GUARDAR
	public static void guardar(Object cosa) throws Exception {

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
		System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
		System.out.println("antiguedad: " + profesor.getAntiguedad());

		instancia.cerrar();
	}

	// LEER
	public static void leerTodos() throws Exception {
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
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún elemento en la tabla Profesor");
		}

		instancia.cerrar();
	}

	public static void leerPorId(long idProfesor, String filtro) throws Exception {
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
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con idProfesor " + filtro + " " + idProfesor);
		}

		instancia.cerrar();

	}

	public static void leerPorNombre(String nombre, String filtro) throws Exception {
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
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con nombre " + filtro + " " + nombre);
		}

		instancia.cerrar();

	}

	public static void leerPorApellidos(String apellidos, String filtro) throws Exception {

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
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con apellidos " + filtro + " " + apellidos);
		}

		instancia.cerrar();

	}

	public static void leerPorFechaNacimiento(LocalDate fechaNacimiento, String filtro) throws Exception {
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
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con fechaNacimiento " + filtro + " " + fechaNacimiento);
		}

		instancia.cerrar();

	}

	public static void leerPorAntiguedad(int antiguedad, String filtro) throws Exception {
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
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
		} else {
			System.out.println("No existe ningún Profesor con antigüedad " + filtro + " " + antiguedad);
		}

		instancia.cerrar();

	}

	// BUSQUEDAS ESPECIFICAS
	public static List<Long> buscaIDsDeTodos() throws Exception {
		String hql = "SELECT p.id FROM ProfesorEntity p";

		instancia.abrir();
		List<Long> idsProfesores = instancia.getSesion().createQuery(hql, Long.class).getResultList();
		instancia.cerrar();

		return idsProfesores;
	}

	public static List<Long> buscaIDsPorColumna(String nombreColumna, String dato) throws Exception {

		String hql = "";
		instancia.abrir();

		List<Long> idsProfesores = new ArrayList<>();

		switch (nombreColumna) {
		case "nombre":
			hql = "SELECT p.id FROM ProfesorEntity p WHERE p.nombre = :nombre";
			idsProfesores = instancia.getSesion().createQuery(hql, Long.class).setParameter("nombre", dato)
					.getResultList();
			break;
		case "apellidos":
			hql = "SELECT p.id FROM ProfesorEntity p WHERE p.apellidos = :apellidos";
			idsProfesores = instancia.getSesion().createQuery(hql, Long.class).setParameter("apellidos", dato)
					.getResultList();
			break;
		case "fechaNacimiento":
			hql = "SELECT p.id FROM ProfesorEntity p WHERE p.fechaNacimiento = :fechaNacimiento";
			idsProfesores = instancia.getSesion().createQuery(hql, Long.class)
					.setParameter("fechaNacimiento", LocalDate.parse(dato)).getResultList();
			break;
		case "antiguedad":
			hql = "SELECT p.id FROM ProfesorEntity p WHERE p.antiguedad = :antiguedad";
			idsProfesores = instancia.getSesion().createQuery(hql, Long.class)
					.setParameter("antiguedad", Integer.valueOf(dato)).getResultList();
			break;

		default:
			break;
		}

		instancia.cerrar();

		return idsProfesores;
	}

	// ACTUALIZAR
	public static boolean actualizarPorId(long id, String columnaCambiada, String datoCambiado) throws Exception {
		boolean hecho = false;

		instancia.abrir();

		// Busca el Profesor por su id
		ProfesorEntity profesor = instancia.getSesion().get(ProfesorEntity.class, id);

		if (profesor != null) {
			// Actualiza el dato elegido
			switch (columnaCambiada) {
			case "nombre":
				profesor.setNombre(datoCambiado);
				break;
			case "apellidos":
				profesor.setApellidos(datoCambiado);
				break;
			case "fechaNacimiento":
				profesor.setFechaNacimiento(LocalDate.parse(datoCambiado));
				break;
			case "antiguedad":
				profesor.setAntiguedad(Integer.valueOf(datoCambiado));
				break;

			default:
				break;
			}

			instancia.getSesion().update(profesor); // Actualiza el profesor en la base de datos
			hecho = true;
		}

		instancia.cerrar();

		return hecho;
	}

	// BORRAR
	public static boolean borrarPorId(long id) throws Exception {
		boolean hecho = false;

		instancia.abrir();

		// Busca el Profesor por su ID
		ProfesorEntity profesor = instancia.getSesion().get(ProfesorEntity.class, id);

		if (profesor != null) {
			instancia.getSesion().delete(profesor); // Elimina el profesor de la base de datos
			hecho = true;
		}

		instancia.cerrar();

		return hecho;
	}

	// QUE TE DEVUELVA EL OBJETO
	public static ProfesorEntity getProfesorPorId(long id) throws Exception {
		instancia.abrir();
		// Busca el Profesor por su ID
		ProfesorEntity profesor = instancia.getSesion().get(ProfesorEntity.class, id);

		instancia.cerrar();
		return profesor;

	}

}
