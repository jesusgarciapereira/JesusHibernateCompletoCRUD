package funciones;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import accesodb.Accesobd;
import colores.ColorMio;
import entidades.AlumnoEntity;
import entidades.ProfesorEntity;

public class FuncionesAlumnos {

	static Accesobd instancia = new Accesobd();

	// GUARDAR
	public static void guardar(Object cosa) throws Exception {

		AlumnoEntity alumno = (AlumnoEntity) cosa;

		instancia.abrir();

		instancia.guardar(cosa); // Guarda el objeto en la base de datos

		System.out.println();
		System.out.print(ColorMio.getFondoVerde());
		System.out.print("Alumno guardado");
		System.out.print(ColorMio.getReset());
		System.out.println(ColorMio.getVerde());
		System.out.println("-----------------------------------------");
		System.out.println("idAlumno: " + alumno.getIdAlumno());
		System.out.println("nombre: " + alumno.getNombre());
		System.out.println("apellidos: " + alumno.getApellidos());
		// Para que se vea en ese formato
		System.out.println("fechaNacimiento (aaaa-mm-dd): " + alumno.getFechaNacimiento());
		System.out.print("-----------------------------------------");
		System.out.println(ColorMio.getReset());
		System.out.println();

		instancia.cerrar();
	}

	// LEER
	public static void leerTodos() throws Exception {
		String consultaSQL = "SELECT * FROM Alumnos";

		instancia.abrir();

		List<AlumnoEntity> alumnos = instancia.getSesion().createNativeQuery(consultaSQL, AlumnoEntity.class)
				.getResultList();

		if (!alumnos.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("\t\t\tALUMNOS\t\t\t ");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (AlumnoEntity alumno : alumnos) {
				System.out.println("-----------------------------------------");
				System.out.println("idAlumno: " + alumno.getIdAlumno());
				System.out.println("nombre: " + alumno.getNombre());
				System.out.println("apellidos: " + alumno.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + alumno.getFechaNacimiento());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println("No existe ningún elemento en la tabla Alumno");
		}

		instancia.cerrar();
	}

	public static void leerPorId(long idAlumno, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Alumnos WHERE idAlumno " + filtro + " " + idAlumno;

		instancia.abrir();

		List<AlumnoEntity> alumnos = instancia.getSesion().createNativeQuery(consultaSQL, AlumnoEntity.class)
				.getResultList();

		if (!alumnos.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("\t       Alumno(s) con idAlumno " + filtro + " " + idAlumno + "\t ");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (AlumnoEntity alumno : alumnos) {
				System.out.println("-----------------------------------------");
				System.out.println("idAlumno: " + alumno.getIdAlumno());
				System.out.println("nombre: " + alumno.getNombre());
				System.out.println("apellidos: " + alumno.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + alumno.getFechaNacimiento());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			System.out.print("No existe ningún Alumno con idAlumno " + filtro + " " + idAlumno);
			System.out.println(ColorMio.getReset());

		}
		System.out.println();
		instancia.cerrar();

	}

	public static void leerPorNombre(String nombre, String filtro) throws Exception {
		String consultaSQL;

		// Construye la consulta SQL según el filtro
		if (filtro.equals("=")) {
			consultaSQL = "SELECT * FROM Alumnos WHERE nombre " + filtro + " '" + nombre + "'";
		} else {
			consultaSQL = "SELECT * FROM Alumnos WHERE nombre " + filtro + " '%" + nombre + "%'";
		}

		instancia.abrir();

		List<AlumnoEntity> alumnos = instancia.getSesion().createNativeQuery(consultaSQL, AlumnoEntity.class)
				.getResultList();

		if (!alumnos.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			if (filtro.equals("=")) {
				System.out.print("\t     Alumno(s) con nombre " + filtro + " '" + nombre + "'\t ");
			} else {
				System.out.print("\t     Alumno(s) con nombre " + filtro + " '%" + nombre + "%'\t ");
			}
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (AlumnoEntity alumno : alumnos) {
				System.out.println("-----------------------------------------");
				System.out.println("idAlumno: " + alumno.getIdAlumno());
				System.out.println("nombre: " + alumno.getNombre());
				System.out.println("apellidos: " + alumno.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + alumno.getFechaNacimiento());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			if (filtro.equals("=")) {
				System.out.print("No existe ningún Alumno con nombre " + filtro + " '" + nombre + "'");
			} else {
				System.out.print("No existe ningún Alumno con nombre " + filtro + " '%" + nombre + "%'");
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
			consultaSQL = "SELECT * FROM Alumnos WHERE apellidos " + filtro + " '" + apellidos + "'";
		} else {
			consultaSQL = "SELECT * FROM Alumnos WHERE apellidos " + filtro + " '%" + apellidos + "%'";
		}

		instancia.abrir();

		List<AlumnoEntity> alumnos = instancia.getSesion().createNativeQuery(consultaSQL, AlumnoEntity.class)
				.getResultList();

		if (!alumnos.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			if (filtro.equals("=")) {
				System.out.print("\t   Alumno(s) con apellidos " + filtro + " '" + apellidos + "'\t ");
			} else {
				System.out.print("\t   Alumno(s) con apellidos " + filtro + " '%" + apellidos + "%'\t ");
			}
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (AlumnoEntity alumno : alumnos) {
				System.out.println("-----------------------------------------");
				System.out.println("idAlumno: " + alumno.getIdAlumno());
				System.out.println("nombre: " + alumno.getNombre());
				System.out.println("apellidos: " + alumno.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + alumno.getFechaNacimiento());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			if (filtro.equals("=")) {
				System.out.print("No existe ningún Alumno con apellidos " + filtro + " '" + apellidos + "'");
			} else {
				System.out.print("No existe ningún Alumno con apellidos " + filtro + " '%" + apellidos + "%'");
			}
			System.out.println(ColorMio.getReset());

		}
		System.out.println();
		instancia.cerrar();

	}

	public static void leerPorFechaNacimiento(LocalDate fechaNacimiento, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Alumnos WHERE fechaNacimiento " + filtro + " '" + fechaNacimiento + "'";

		instancia.abrir();

		List<AlumnoEntity> alumnos = instancia.getSesion().createNativeQuery(consultaSQL, AlumnoEntity.class)
				.getResultList();

		if (!alumnos.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("Alumnos(s) con fechaNacimiento " + filtro + " '" + fechaNacimiento + "'");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (AlumnoEntity alumno : alumnos) {
				System.out.println("-----------------------------------------");
				System.out.println("idAlumno: " + alumno.getIdAlumno());
				System.out.println("nombre: " + alumno.getNombre());
				System.out.println("apellidos: " + alumno.getApellidos());
				// Para que se vea en ese formato
				System.out.println("fechaNacimiento (aaaa-mm-dd): " + alumno.getFechaNacimiento());
			}
			System.out.print("-----------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			System.out.print("No existe ningún Alumno con fechaNacimiento " + filtro + " '" + fechaNacimiento + "'");
			System.out.println(ColorMio.getReset());

		}

		System.out.println();
		instancia.cerrar();

	}

	// BUSQUEDAS ESPECIFICAS
	public static List<Long> buscaIDsDeTodos() throws Exception {
		String hql = "SELECT p.id FROM AlumnoEntity p";

		instancia.abrir();
		List<Long> idsAlumnos = instancia.getSesion().createQuery(hql, Long.class).getResultList();
		instancia.cerrar();

		return idsAlumnos;
	}

	public static List<Long> buscaIDsPorColumna(String nombreColumna, String dato) throws Exception {

		String hql = "";
		instancia.abrir();

		List<Long> idsAlumnos = new ArrayList<>();

		switch (nombreColumna) {
		case "nombre":
			hql = "SELECT p.id FROM AlumnoEntity p WHERE p.nombre = :nombre";
			idsAlumnos = instancia.getSesion().createQuery(hql, Long.class).setParameter("nombre", dato)
					.getResultList();
			break;
		case "apellidos":
			hql = "SELECT p.id FROM AlumnoEntity p WHERE p.apellidos = :apellidos";
			idsAlumnos = instancia.getSesion().createQuery(hql, Long.class).setParameter("apellidos", dato)
					.getResultList();
			break;
		case "fechaNacimiento":
			hql = "SELECT p.id FROM AlumnoEntity p WHERE p.fechaNacimiento = :fechaNacimiento";
			try {
				idsAlumnos = instancia.getSesion().createQuery(hql, Long.class)
						.setParameter("fechaNacimiento", LocalDate.parse(dato)).getResultList();
			} catch (DateTimeException e) {
				System.out.print(ColorMio.getRojo());
				System.out.print("Fecha '" + dato + "' incorrecta");
				System.out.println(ColorMio.getReset());
			}
			break;

		default:
			break;
		}

		instancia.cerrar();

		return idsAlumnos;
	}

	// ACTUALIZAR
	public static boolean actualizarPorId(long id, String columnaCambiada, String datoCambiado) throws Exception {
		boolean hecho = false;

		instancia.abrir();

		// Busca el Alumno por su id
		AlumnoEntity alumno = instancia.getSesion().get(AlumnoEntity.class, id);

		if (alumno != null) {
			// Actualiza el dato elegido
			switch (columnaCambiada) {
			case "nombre":
				alumno.setNombre(datoCambiado);
				break;
			case "apellidos":
				alumno.setApellidos(datoCambiado);
				break;
			case "fechaNacimiento":
				alumno.setFechaNacimiento(LocalDate.parse(datoCambiado));
				break;

			default:
				break;
			}

			instancia.getSesion().update(alumno); // Actualiza el alumno en la base de datos
			hecho = true;
		}

		instancia.cerrar();

		return hecho;
	}

	// BORRAR
	public static boolean borrarPorId(long id) throws Exception {
		boolean hecho = false;

		instancia.abrir();

		// Busca la persona por su ID
		AlumnoEntity alumno = instancia.getSesion().get(AlumnoEntity.class, id);

		if (alumno != null) {
			instancia.getSesion().delete(alumno); // Elimina el alumno de la base de datos
			hecho = true;
		}

		instancia.cerrar();

		return hecho;
	}

	// QUE TE DEVUELVA EL OBJETO
	public static AlumnoEntity getAlumnoPorId(long id) throws Exception {
		instancia.abrir();
		// Busca el Profesor por su ID
		AlumnoEntity alumno = instancia.getSesion().get(AlumnoEntity.class, id);

		instancia.cerrar();
		return alumno;

	}

}
