package funciones;

import java.util.List;

import accesodb.Accesobd;
import entidades.AlumnoEntity;
import entidades.MatriculaEntity;
import entidades.ProfesorEntity;

public class FuncionesMatriculas {
	static Accesobd instancia = new Accesobd();

	public static void guardar(Object cosa) throws Exception {

		MatriculaEntity matricula = (MatriculaEntity) cosa;

		instancia.abrir();

		instancia.guardar(cosa); // Guarda el objeto en la base de datos

		System.out.println("------------------");
		System.out.println("Matrícula guardada");
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

		instancia.cerrar();
	}

	// LEER
	public static void leerTodos() throws Exception {
		String consultaSQL = "SELECT * FROM Matriculas";

		instancia.abrir();

		List<MatriculaEntity> matriculas = instancia.getSesion().createNativeQuery(consultaSQL, MatriculaEntity.class)
				.getResultList();

		if (!matriculas.isEmpty()) {
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
		} else {
			System.out.println("No existe ninguna Matricula con idMatricula " + filtro + " " + idMatricula);
		}

		instancia.cerrar();

	}

	public static void leerPorProfesor(ProfesorEntity profesor) throws Exception {

		String consultaSQL = "SELECT * FROM Matriculas WHERE idProfesor = " + profesor.getIdProfesor();

		instancia.abrir();

		List<MatriculaEntity> matriculas = instancia.getSesion().createNativeQuery(consultaSQL, MatriculaEntity.class)
				.getResultList();

		if (!matriculas.isEmpty()) {
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
		} else {
			System.out.println("No existe ninguna Matricula correspondiente con el Profesor con id?rofesor = " + profesor.getIdProfesor());
			
		}

		instancia.cerrar();

	}
	
	public static void leerPorAlumno(AlumnoEntity alumno) throws Exception {

		String consultaSQL = "SELECT * FROM Matriculas WHERE idAlumno = " + alumno.getIdAlumno();

		instancia.abrir();

		List<MatriculaEntity> matriculas = instancia.getSesion().createNativeQuery(consultaSQL, MatriculaEntity.class)
				.getResultList();

		if (!matriculas.isEmpty()) {
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
		} else {
			System.out.println("No existe ninguna Matricula correspondiente con el Alumno con idAlumno = " + alumno.getIdAlumno());
			
		}

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
		} else {
			System.out.println("No existe ninguna Matricula con asignatura " + filtro + " " + asignatura);
		}

		instancia.cerrar();

	}
}
