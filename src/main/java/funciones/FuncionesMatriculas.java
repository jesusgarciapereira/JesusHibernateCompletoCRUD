package funciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import accesodb.Accesobd;
import colores.ColorMio;
import entidades.AlumnoEntity;
import entidades.MatriculaEntity;
import entidades.ProfesorEntity;

public class FuncionesMatriculas {
	static Accesobd instancia = new Accesobd();

	public static void guardar(Object cosa) throws Exception {

		MatriculaEntity matricula = (MatriculaEntity) cosa;

		instancia.abrir();

		instancia.guardar(cosa); // Guarda el objeto en la base de datos

		System.out.println();
		System.out.print(ColorMio.getFondoVerde());
		System.out.print("Matrícula guardado");
		System.out.print(ColorMio.getReset());
		System.out.println(ColorMio.getVerde());
		System.out.println("------------------------------------------------");
		System.out.println("idMatricula: " + matricula.getIdMatricula());
		System.out.println("--------");
		System.out.println("PROFESOR");
		System.out.println("--------");
		System.out.println("\tidProfesor: " + matricula.getProfesor().getIdProfesor());
		System.out.println("\tnombre: " + matricula.getProfesor().getNombre());
		System.out.println("\tapellidos: " + matricula.getProfesor().getApellidos());
		// Para que se vea en ese formato
		System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getProfesor().getFechaNacimiento());
		System.out.println("\tantiguedad: " + matricula.getProfesor().getAntiguedad());
		System.out.println("------");
		System.out.println("ALUMNO");
		System.out.println("------");
		System.out.println("\tidAlumno: " + matricula.getAlumno().getIdAlumno());
		System.out.println("\tnombre: " + matricula.getAlumno().getNombre());
		System.out.println("\tapellidos: " + matricula.getAlumno().getApellidos());
		// Para que se vea en ese formato
		System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getAlumno().getFechaNacimiento());
		System.out.println("asignatura: " + matricula.getAsignatura());
		System.out.println("curso: " + matricula.getCurso());
		System.out.print("------------------------------------------------");
		System.out.println(ColorMio.getReset());
		System.out.println();

		instancia.cerrar();
	}

	// LEER
	public static void leerTodos() throws Exception {
		String consultaSQL = "SELECT * FROM Matriculas";

		instancia.abrir();

		List<MatriculaEntity> matriculas = instancia.getSesion().createNativeQuery(consultaSQL, MatriculaEntity.class)
				.getResultList();

		if (!matriculas.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("\t\t\t    MATRICULAS\t\t\t");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (MatriculaEntity matricula : matriculas) {
				System.out.println("------------------------------------------------");
				System.out.println("idMatricula: " + matricula.getIdMatricula());
				System.out.println("--------");
				System.out.println("PROFESOR");
				System.out.println("--------");
				System.out.println("\tidProfesor: " + matricula.getProfesor().getIdProfesor());
				System.out.println("\tnombre: " + matricula.getProfesor().getNombre());
				System.out.println("\tapellidos: " + matricula.getProfesor().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getProfesor().getFechaNacimiento());
				System.out.println("\tantiguedad: " + matricula.getProfesor().getAntiguedad());
				System.out.println("------");
				System.out.println("ALUMNO");
				System.out.println("------");
				System.out.println("\tidAlumno: " + matricula.getAlumno().getIdAlumno());
				System.out.println("\tnombre: " + matricula.getAlumno().getNombre());
				System.out.println("\tapellidos: " + matricula.getAlumno().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getAlumno().getFechaNacimiento());
				System.out.println("asignatura: " + matricula.getAsignatura());
				System.out.println("curso: " + matricula.getCurso());
			}
			System.out.print("------------------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println("No existe ningún elemento en la tabla Alumno");
		}

		instancia.cerrar();
	}

	public static void leerPorId(long idMatricula, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Matriculas WHERE idMatricula  " + filtro + " " + idMatricula;

		instancia.abrir();

		List<MatriculaEntity> matriculas = instancia.getSesion().createNativeQuery(consultaSQL, MatriculaEntity.class)
				.getResultList();

		if (!matriculas.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("\t       Matricula(s) con idMatricula " + filtro + " " + idMatricula + "\t");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (MatriculaEntity matricula : matriculas) {
				System.out.println("------------------------------------------------");
				System.out.println("idMatricula: " + matricula.getIdMatricula());
				System.out.println("--------");
				System.out.println("PROFESOR");
				System.out.println("--------");
				System.out.println("\tidProfesor: " + matricula.getProfesor().getIdProfesor());
				System.out.println("\tnombre: " + matricula.getProfesor().getNombre());
				System.out.println("\tapellidos: " + matricula.getProfesor().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getProfesor().getFechaNacimiento());
				System.out.println("\tantiguedad: " + matricula.getProfesor().getAntiguedad());
				System.out.println("------");
				System.out.println("ALUMNO");
				System.out.println("------");
				System.out.println("\tidAlumno: " + matricula.getAlumno().getIdAlumno());
				System.out.println("\tnombre: " + matricula.getAlumno().getNombre());
				System.out.println("\tapellidos: " + matricula.getAlumno().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getAlumno().getFechaNacimiento());
				System.out.println("asignatura: " + matricula.getAsignatura());
				System.out.println("curso: " + matricula.getCurso());
			}
			System.out.print("------------------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			System.out.print("No existe ninguna Matricula con idMatricula " + filtro + " " + idMatricula);
			System.out.println(ColorMio.getReset());
			
		}
		System.out.println();
		instancia.cerrar();

	}

	public static void leerPorProfesor(ProfesorEntity profesor) throws Exception {

		String consultaSQL = "SELECT * FROM Matriculas WHERE idProfesor = " + profesor.getIdProfesor();

		instancia.abrir();

		List<MatriculaEntity> matriculas = instancia.getSesion().createNativeQuery(consultaSQL, MatriculaEntity.class)
				.getResultList();

		if (!matriculas.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getAzul());
			for (MatriculaEntity matricula : matriculas) {
				System.out.println("------------------------------------------------");
				System.out.println("idMatricula: " + matricula.getIdMatricula());
				System.out.println("--------");
				System.out.println("PROFESOR");
				System.out.println("--------");
				System.out.println("\tidProfesor: " + matricula.getProfesor().getIdProfesor());
				System.out.println("\tnombre: " + matricula.getProfesor().getNombre());
				System.out.println("\tapellidos: " + matricula.getProfesor().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getProfesor().getFechaNacimiento());
				System.out.println("\tantiguedad: " + matricula.getProfesor().getAntiguedad());
				System.out.println("------");
				System.out.println("ALUMNO");
				System.out.println("------");
				System.out.println("\tidAlumno: " + matricula.getAlumno().getIdAlumno());
				System.out.println("\tnombre: " + matricula.getAlumno().getNombre());
				System.out.println("\tapellidos: " + matricula.getAlumno().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getAlumno().getFechaNacimiento());
				System.out.println("asignatura: " + matricula.getAsignatura());
				System.out.println("curso: " + matricula.getCurso());
			}
			System.out.print("------------------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			System.out.print("No existe ninguna Matricula correspondiente con el Profesor con idProfesor = "
					+ profesor.getIdProfesor());
			System.out.println(ColorMio.getReset());
			

		}
		System.out.println();
		instancia.cerrar();

	}

	public static void leerPorAlumno(AlumnoEntity alumno) throws Exception {

		String consultaSQL = "SELECT * FROM Matriculas WHERE idAlumno = " + alumno.getIdAlumno();

		instancia.abrir();

		List<MatriculaEntity> matriculas = instancia.getSesion().createNativeQuery(consultaSQL, MatriculaEntity.class)
				.getResultList();

		if (!matriculas.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getAzul());
			for (MatriculaEntity matricula : matriculas) {
				System.out.println("------------------------------------------------");
				System.out.println("idMatricula: " + matricula.getIdMatricula());
				System.out.println("--------");
				System.out.println("PROFESOR");
				System.out.println("--------");
				System.out.println("\tidProfesor: " + matricula.getProfesor().getIdProfesor());
				System.out.println("\tnombre: " + matricula.getProfesor().getNombre());
				System.out.println("\tapellidos: " + matricula.getProfesor().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getProfesor().getFechaNacimiento());
				System.out.println("\tantiguedad: " + matricula.getProfesor().getAntiguedad());
				System.out.println("------");
				System.out.println("ALUMNO");
				System.out.println("------");
				System.out.println("\tidAlumno: " + matricula.getAlumno().getIdAlumno());
				System.out.println("\tnombre: " + matricula.getAlumno().getNombre());
				System.out.println("\tapellidos: " + matricula.getAlumno().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getAlumno().getFechaNacimiento());
				System.out.println("asignatura: " + matricula.getAsignatura());
				System.out.println("curso: " + matricula.getCurso());
			}
			System.out.print("------------------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			System.out.print(
					"No existe ninguna Matricula correspondiente con el Alumno con idAlumno = " + alumno.getIdAlumno());
			System.out.println(ColorMio.getReset());
			

		}
		System.out.println();
		instancia.cerrar();

	}

	public static void leerPorAsignatura(String asignatura, String filtro) throws Exception {
		String consultaSQL;

		// Construye la consulta SQL según el filtro
		if (filtro.equals("=")) {
			consultaSQL = "SELECT * FROM Matriculas WHERE asignatura " + filtro + " '" + asignatura + "'";
		} else {
			consultaSQL = "SELECT * FROM Matriculas WHERE asignatura " + filtro + " '%" + asignatura + "%'";
		}

		instancia.abrir();

		List<MatriculaEntity> matriculas = instancia.getSesion().createNativeQuery(consultaSQL, MatriculaEntity.class)
				.getResultList();

		if (!matriculas.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			if (filtro.equals("=")) {
				System.out.print("\t  Matricula(s) con asignatura " + filtro + " '" + asignatura + "'\t");
			} else {
				System.out.print("\t  Matricula(s) con asignatura " + filtro + " '%" + asignatura + "%'\t");
			}
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (MatriculaEntity matricula : matriculas) {
				System.out.println("------------------------------------------------");
				System.out.println("idMatricula: " + matricula.getIdMatricula());
				System.out.println("--------");
				System.out.println("PROFESOR");
				System.out.println("--------");
				System.out.println("\tidProfesor: " + matricula.getProfesor().getIdProfesor());
				System.out.println("\tnombre: " + matricula.getProfesor().getNombre());
				System.out.println("\tapellidos: " + matricula.getProfesor().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getProfesor().getFechaNacimiento());
				System.out.println("\tantiguedad: " + matricula.getProfesor().getAntiguedad());
				System.out.println("------");
				System.out.println("ALUMNO");
				System.out.println("------");
				System.out.println("\tidAlumno: " + matricula.getAlumno().getIdAlumno());
				System.out.println("\tnombre: " + matricula.getAlumno().getNombre());
				System.out.println("\tapellidos: " + matricula.getAlumno().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getAlumno().getFechaNacimiento());
				System.out.println("asignatura: " + matricula.getAsignatura());
				System.out.println("curso: " + matricula.getCurso());
			}
			System.out.print("------------------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			if (filtro.equals("=")) {
				System.out.print("No existe ninguna Matricula con asignatura " + filtro + " '" + asignatura + "'");
			} else {
				System.out.print("No existe ninguna Matricula con asignatura " + filtro + " '%" + asignatura + "%'");
			}
			System.out.println(ColorMio.getReset());
			
		}
		System.out.println();
		instancia.cerrar();

	}

	public static void leerPorCurso(int curso, String filtro) throws Exception {
		String consultaSQL = "SELECT * FROM Matriculas WHERE curso  " + filtro + " " + curso;

		instancia.abrir();

		List<MatriculaEntity> matriculas = instancia.getSesion().createNativeQuery(consultaSQL, MatriculaEntity.class)
				.getResultList();

		if (!matriculas.isEmpty()) {
			System.out.println();
			System.out.print(ColorMio.getFondoAzul());
			System.out.print("\t\t  Matricula(s) con curso " + filtro + " " + curso + "\t");
			System.out.println(ColorMio.getReset());
			System.out.print(ColorMio.getAzul());
			for (MatriculaEntity matricula : matriculas) {
				System.out.println("------------------------------------------------");
				System.out.println("idMatricula: " + matricula.getIdMatricula());
				System.out.println("--------");
				System.out.println("PROFESOR");
				System.out.println("--------");
				System.out.println("\tidProfesor: " + matricula.getProfesor().getIdProfesor());
				System.out.println("\tnombre: " + matricula.getProfesor().getNombre());
				System.out.println("\tapellidos: " + matricula.getProfesor().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getProfesor().getFechaNacimiento());
				System.out.println("\tantiguedad: " + matricula.getProfesor().getAntiguedad());
				System.out.println("------");
				System.out.println("ALUMNO");
				System.out.println("------");
				System.out.println("\tidAlumno: " + matricula.getAlumno().getIdAlumno());
				System.out.println("\tnombre: " + matricula.getAlumno().getNombre());
				System.out.println("\tapellidos: " + matricula.getAlumno().getApellidos());
				// Para que se vea en ese formato
				System.out.println("\tfechaNacimiento (aaaa-mm-dd): " + matricula.getAlumno().getFechaNacimiento());
				System.out.println("asignatura: " + matricula.getAsignatura());
				System.out.println("curso: " + matricula.getCurso());
			}
			System.out.print("------------------------------------------------");
			System.out.println(ColorMio.getReset());
		} else {
			System.out.println();
			System.out.print(ColorMio.getRojo());
			System.out.print("No existe ninguna Matricula con curso " + filtro + " " + curso);
			System.out.println(ColorMio.getReset());
			
		}
		
		System.out.println();
		instancia.cerrar();

	}

	// BUSQUEDAS ESPECIFICAS
	public static List<Long> buscaIDsDeTodos() throws Exception {
		String hql = "SELECT p.id FROM MatriculaEntity p";

		instancia.abrir();
		List<Long> idsMatriculas = instancia.getSesion().createQuery(hql, Long.class).getResultList();
		instancia.cerrar();

		return idsMatriculas;
	}

	public static List<Long> buscaIDsPorColumna(String nombreColumna, String dato) throws Exception {

		String hql = "";
		instancia.abrir();

		List<Long> idsMatriculas = new ArrayList<>();

		switch (nombreColumna) {
		case "idProfesor":
			hql = "SELECT p.id FROM MatriculaEntity p WHERE p.profesor.idProfesor = :idProfesor";
			idsMatriculas = instancia.getSesion().createQuery(hql, Long.class).setParameter("idProfesor", Long.valueOf(dato))
					.getResultList();
			break;
		case "idAlumno":
			hql = "SELECT p.id FROM MatriculaEntity p WHERE p.alumno.idAlumno = :idAlumno";
			idsMatriculas = instancia.getSesion().createQuery(hql, Long.class).setParameter("idAlumno", Long.valueOf(dato))
					.getResultList();
			break;
		case "asignatura":
			hql = "SELECT p.id FROM MatriculaEntity p WHERE p.asignatura = :asignatura";
			idsMatriculas = instancia.getSesion().createQuery(hql, Long.class)
					.setParameter("asignatura", dato).getResultList();
			break;
		case "curso":
			hql = "SELECT p.id FROM MatriculaEntity p WHERE p.curso = :curso";
			idsMatriculas = instancia.getSesion().createQuery(hql, Long.class)
					.setParameter("curso", Integer.valueOf(dato)).getResultList();
			break;

		default:
			break;
		}

		instancia.cerrar();

		return idsMatriculas;
	}

	// ACTUALIZAR
	public static boolean actualizarPorId(long id, String columnaCambiada, String datoCambiado) throws Exception {
		ProfesorEntity profesor = null;
		AlumnoEntity alumno = null;
		boolean hecho = false;

		instancia.abrir();

		// Busca el Matricula por su id
		MatriculaEntity matricula = instancia.getSesion().get(MatriculaEntity.class, id);

		if (matricula != null) {
			// Actualiza el dato elegido
			switch (columnaCambiada) {
			case "idProfesor":
				profesor = FuncionesProfesores.getProfesorPorId(Long.valueOf(datoCambiado));
				matricula.setProfesor(profesor);
				break;
			case "idAlumno":
				alumno = FuncionesAlumnos.getAlumnoPorId(Long.valueOf(datoCambiado));
				matricula.setAlumno(alumno);
				break;
			case "asignatura":
				matricula.setAsignatura(datoCambiado);
				;
				break;
			case "curso":
				matricula.setCurso(Integer.valueOf(datoCambiado));
				break;

			default:
				break;
			}

			if (columnaCambiada.equals("asignatura") || columnaCambiada.equals("curso")
					|| columnaCambiada.equals("idProfesor") && profesor != null
					|| columnaCambiada.equals("idAlumno") && alumno != null) {
				
				instancia.getSesion().update(matricula); // Actualiza la matricula en la base de datos
				hecho = true;
			}

		}

		instancia.cerrar();

		return hecho;
	}
	
	// BORRAR
		public static boolean borrarPorId(long id) throws Exception {
			boolean hecho = false;

			instancia.abrir();

			// Busca la matricula por su ID
			MatriculaEntity matricula = instancia.getSesion().get(MatriculaEntity.class, id);

			if (matricula != null) {
				instancia.getSesion().delete(matricula); // Elimina el alumno de la base de datos
				hecho = true;
			}

			instancia.cerrar();

			return hecho;
		}
}
