package principal;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import entidades.AlumnoEntity;

public class ProbandoAlumnos {

	public static void main(String[] args) {
		List<AlumnoEntity> alumnos = Arrays.asList(
			    new AlumnoEntity("Carlos", "López", LocalDate.parse("2005-07-12")),
			    new AlumnoEntity("María", "Fernández", LocalDate.parse("2006-01-25")),
			    new AlumnoEntity("Lucía", "Rodríguez", LocalDate.parse("2004-03-18")),
			    new AlumnoEntity("Carlos", "Martín", LocalDate.parse("2006-03-17")),
			    new AlumnoEntity("David", "Ramírez", LocalDate.parse("2005-11-10")),
			    new AlumnoEntity("Sandra", "Ortiz", LocalDate.parse("2006-04-02")),
			    new AlumnoEntity("Pablo", "Serrano", LocalDate.parse("2004-10-14")),
			    new AlumnoEntity("Andrea", "Vega", LocalDate.parse("2003-09-05")),
			    new AlumnoEntity("Javier", "Mendoza", LocalDate.parse("2005-06-20"))
			);

			try {
			    for (AlumnoEntity alumno : alumnos) {
			        // FuncionesAlumnos.guardar(alumno);
			    }
			} catch (Exception e) {
			    e.printStackTrace();
			    System.out.println("No se ha podido guardar los alumnos");
			}

	}

}
