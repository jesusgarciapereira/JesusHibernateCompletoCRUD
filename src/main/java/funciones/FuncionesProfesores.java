package funciones;

import java.awt.image.ColorModel;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import accesodb.Accesobd;
import colores.ColorMio;
import entidades.ProfesorEntity;

public class FuncionesProfesores {
	static Accesobd instancia = new Accesobd();

	// GUARDAR
	public static void guardar(Object cosa) throws Exception {

		ProfesorEntity profesor = (ProfesorEntity) cosa;

		instancia.abrir();

		instancia.guardar(cosa); // Guarda el objeto en la base de datos

		System.out.println();
		System.out.print(ColorMio.getFondoVerde());
		System.out.print("Profesor guardado");
		System.out.print(ColorMio.getReset());
		System.out.println(ColorMio.getVerde());
		System.out.println("-----------------------------------------");
		System.out.println("idProfesor: " + profesor.getIdProfesor());
		System.out.println("nombre: " + profesor.getNombre());
		System.out.println("apellidos: " + profesor.getApellidos());
		// Para que se vea en ese formato
		System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
		System.out.println("antiguedad: " + profesor.getAntiguedad());
		System.out.print("-----------------------------------------");
		System.out.println(ColorMio.getReset());
		System.out.println();

		instancia.cerrar();
	}

	// LEER
	public static void leerTodos() throws Exception {
		String consultaSQL = "SELECT * FROM Profesores";

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("\t\t\tPROFESORES\t\t ");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.print(ColorMio.getRojo());
			System.out.print("No existe ningún elemento en la tabla Profesores");
			System.out.println(ColorMio.getReset());
		}

		instancia.cerrar();
	}

	public static void leerPorId(long idProfesor, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Profesores WHERE idProfesor " + filtro + " " + idProfesor;

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("\t    Profesor(es) con idProfesor " + filtro + " " + idProfesor + "\t ");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			System.out.print("No existe ningún Profesor con idProfesor " + filtro + " " + idProfesor);
			System.out.println(ColorMio.getReset());
		}
		System.out.println();
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
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			if (filtro.equals("=")) {
				System.out.print("\t   Profesor(es) con nombre " + filtro + " '" + nombre + "'\t ");
			} else {
				System.out.print("\t   Profesor(es) con nombre " + filtro + " '%" + nombre + "%'\t ");
			}
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (ProfesorEntity profesor : profesores) {

				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			
			if (filtro.equals("=")) {
				System.out.print("No existe ningún Profesor con nombre " + filtro + " '" + nombre + "'");
			} else {
				System.out.print("No existe ningún Profesor con nombre " + filtro + " '%" + nombre + "%'");
			}
			System.out.println(ColorMio.getReset());

		}
		System.out.println();

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
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			if (filtro.equals("=")) {
				System.out.print("\t   Profesor(es) con apellidos " + filtro + " '" + apellidos + "'\t ");
			} else {
				System.out.print("\t   Profesor(es) con apellidos " + filtro + " '%" + apellidos + "%'\t ");
			}
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			if (filtro.equals("=")) {
				System.out.print("No existe ningún Profesor con apellidos " + filtro + " '" + apellidos + "'");
			} else {
				System.out.print("No existe ningún Profesor con apellidos " + filtro + " '%" + apellidos + "%'");
			}
			System.out.println(ColorMio.getReset());

		}
		System.out.println();
		instancia.cerrar();

	}

	public static void leerPorFechaNacimiento(LocalDate fechaNacimiento, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Profesores WHERE fechaNacimiento " + filtro + " '" + fechaNacimiento + "'";

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("Profesor(es) con fechaNacimiento " + filtro + " '" + fechaNacimiento + "'");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			System.out.print("No existe ningún Profesor con fechaNacimiento " + filtro + " '" + fechaNacimiento + "'");
			System.out.println(ColorMio.getReset());

		}

		System.out.println();
		instancia.cerrar();

	}

	public static void leerPorAntiguedad(int antiguedad, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Profesores WHERE antiguedad " + filtro + " " + antiguedad;

		instancia.abrir();

		List<ProfesorEntity> profesores = instancia.getSesion().createNativeQuery(consultaSQL, ProfesorEntity.class)
				.getResultList();

		if (!profesores.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("\t    Profesor(es) con antiguedad " + filtro + " " + antiguedad + "\t ");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (ProfesorEntity profesor : profesores) {
				System.out.println("-----------------------------------------");
				System.out.println("idProfesor: " + profesor.getIdProfesor());
				System.out.println("nombre: " + profesor.getNombre());
				System.out.println("apellidos: " + profesor.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + profesor.getFechaNacimiento());
				System.out.println("antiguedad: " + profesor.getAntiguedad());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			System.out.print("No existe ningún Profesor con antigüedad " + filtro + " " + antiguedad);
			System.out.println(ColorMio.getReset());

		}
		System.out.println();
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
			try {
				idsProfesores = instancia.getSesion().createQuery(hql, Long.class)
						.setParameter("fechaNacimiento", LocalDate.parse(dato)).getResultList();
			} catch (DateTimeException e) {
				System.out.print(ColorMio.getRojo());
				System.out.print("Fecha '" + dato + "' incorrecta");
				System.out.println(ColorMio.getReset());
			}
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
