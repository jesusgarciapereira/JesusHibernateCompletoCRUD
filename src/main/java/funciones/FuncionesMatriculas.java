package funciones;

import accesodb.Accesobd;
import entidades.AlumnoEntity;
import entidades.MatriculaEntity;

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
}
