package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import funciones.FuncionesAlumnos;
import funciones.FuncionesMatriculas;
import funciones.FuncionesProfesores;

public class ProbandoMatriculas {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		// ACTUALIZAR POR OTROS DATOS (NO ID)
		List<Long> idsMatriculas = new ArrayList<>();
		Long idDeCambio;

		// SI NO HAY NADIE
//		String nombreColumna = "idAlumno";
//		String dato = "2";
//		String columnaCambiada = "curso";
//		String datoCambiado = "2006";

		// SI SOLO HAY UNO
//		String nombreColumna = "idAlumno";
//		String dato = "3";
//		String columnaCambiada = "idProfesor";
//		String datoCambiado = "3";

		// SI HAY MAS DE UNO
		String nombreColumna = "asignatura";
		String dato = "Matemáticas";
		String columnaCambiada = "curso";
		String datoCambiado = "1996";

		try {
			idsMatriculas = FuncionesMatriculas.buscaIDsPorColumna(nombreColumna, dato);

			if (idsMatriculas.size() > 1) {

				switch (nombreColumna) {
				case "idProfesor":
					FuncionesMatriculas.leerPorProfesor(FuncionesProfesores.getProfesorPorId(Long.valueOf(dato)));
					break;
					
				case "idAlumno":
					FuncionesMatriculas.leerPorAlumno(FuncionesAlumnos.getAlumnoPorId(Long.valueOf(dato)));
					break;
				
				case "asignatura":
					FuncionesMatriculas.leerPorAsignatura(dato, "=");
					break;

				case "curso":
					FuncionesMatriculas.leerPorCurso(Integer.valueOf(dato), "=");
					break;


				default:
					break;
				}

				System.out.println("Hay varias Matriculas con " + nombreColumna + " = " + dato);
				System.out.println(
						"Escriba el idMatricula de la Matricula que desea modificar, o si lo prefiere, \"0\" para modificar a todas estas:");
				idDeCambio = sc.nextLong();

				if (idDeCambio != 0) {
					if (idsMatriculas.contains(idDeCambio) && FuncionesMatriculas.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
						System.out.println("Matricula con ID = " + idDeCambio + " tiene ahora " + columnaCambiada + " = "
								+ datoCambiado);
					} else {
						System.out.println("No existe ninguna Matricula con ID = " + idDeCambio + " en la lista anteriormente mostrada");
					}
				} else {
					for (Long id : idsMatriculas) {
						FuncionesMatriculas.actualizarPorId(id, columnaCambiada, datoCambiado);
					}
					System.out.println(
							"Todas las Matriculas con " + nombreColumna + " = " + dato + " tienen ahora " + columnaCambiada + " = "
									+ datoCambiado);
				}

			} else if (idsMatriculas.size() == 1) {
				idDeCambio = idsMatriculas.get(0);

				if (FuncionesMatriculas.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
					System.out.println("Matricula con " + nombreColumna + " = " + dato + " tiene ahora " + columnaCambiada
							+ " = " + datoCambiado);
				} else {
					if (columnaCambiada.equals("idProfesor")) {
						System.out.println("No existe ningún Profesor con idProfesor = " + datoCambiado);
					} else if (columnaCambiada.equals("idAlumno")) {
						System.out.println("No existe ningún Alumno con idAlumno = " + datoCambiado);
					}
				}
				
			} else {
				System.out.println("No existe ninguna Matricula con " + nombreColumna + " = " + dato);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se puede mostrar");
		}

		// ACTUALIZAR POR ID
//		Long idDeCambio = 3L;
//		String columnaCambiada = "idProfesor";
//		String datoCambiado = "20";
//		try {
//			if (FuncionesMatriculas.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
//				System.out.println(
//						"Matricula con ID = " + idDeCambio + " tiene ahora " + columnaCambiada + " = " + datoCambiado);
//			} else {
//				if (columnaCambiada.equals("idProfesor")) {
//					System.out.println("No existe ningún Profesor con ID = " + datoCambiado);
//				} else if (columnaCambiada.equals("idAlumno")) {
//					System.out.println("No existe ningún Alumno con ID = " + datoCambiado);
//				} else {
//					System.out.println("No existe ninguna Matricula con ID = " + idDeCambio);
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// MOSTRAR MATRICULAS POR ASIGNATURA
//		try {
//			FuncionesMatriculas.leerTodos();
//			FuncionesMatriculas.leerPorAsignatura("fía", "LIKE");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 

		// MOSTRAR MATRICULAS POR CURSO
//		try {
//			FuncionesMatriculas.leerTodos();
//
//			FuncionesMatriculas.leerPorCurso(2022, ">=");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 

		// MOSTRAR MATRICULAS POR ALUMNO
//		try {
//			FuncionesMatriculas.leerTodos();
//			AlumnoEntity alumno = FuncionesAlumnos.getAlumnoPorId(4); 
//			FuncionesMatriculas.leerPorAlumno(alumno);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 

		// MOSTRAR MATRICULAS POR PROFESOR
//		try {
//			FuncionesMatriculas.leerTodos();
//			ProfesorEntity profesor = FuncionesProfesores.getProfesorPorId(4);
//			FuncionesMatriculas.leerPorProfesor(profesor);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 

		// MOSTRAR MATRICULAS POR ID
//		try {
//			FuncionesMatriculas.leerPorId(5, "=");
//			;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		}

		// MOSTRAR TODAS LAS MATRICULAS
//		try {
//			FuncionesMatriculas.leerTodos();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 

		// GUARDAR MATRICULA
//		try {
//			ProfesorEntity profesor = FuncionesProfesores.getProfesorPorId(2);
//			AlumnoEntity alumno = FuncionesAlumnos.getAlumnoPorId(4);
//			
//			if (profesor != null && alumno != null) {
//				MatriculaEntity matricula = new MatriculaEntity(profesor, alumno, "Geografía", 2020);
//				FuncionesMatriculas.guardar(matricula);
//			} else {
//				System.out.println("No se puede guardar la Matricula, Profesor y/o alumno insertado(s) no existe(n) en la Base de Datos");
//			}
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}

//		try {
//			ProfesorEntity profesor1 = FuncionesProfesores.getProfesorPorId(1L);
//			ProfesorEntity profesor2 = FuncionesProfesores.getProfesorPorId(2L);
//			ProfesorEntity profesor3 = FuncionesProfesores.getProfesorPorId(3L);
//
//			// Recuperamos los alumnos por su ID
//			AlumnoEntity alumno1 = FuncionesAlumnos.getAlumnoPorId(1L);
//			AlumnoEntity alumno2 = FuncionesAlumnos.getAlumnoPorId(2L);
//			AlumnoEntity alumno3 = FuncionesAlumnos.getAlumnoPorId(3L);
//
//			// Validamos que los objetos no sean null
//			if (profesor1 == null || profesor2 == null || profesor3 == null) {
//				throw new RuntimeException("Error: Uno o más profesores no existen en la base de datos.");
//			}
//			if (alumno1 == null || alumno2 == null || alumno3 == null) {
//				throw new RuntimeException("Error: Uno o más alumnos no existen en la base de datos.");
//			}
//
//			// Lista de matrículas a registrar
//			List<MatriculaEntity> matriculas = Arrays.asList(
//					new MatriculaEntity(profesor1, alumno1, "Matemáticas", 2023),
//					new MatriculaEntity(profesor1, alumno2, "Ciencias", 2023),
//					new MatriculaEntity(profesor2, alumno2, "Historia", 2024),
//					new MatriculaEntity(profesor2, alumno3, "Física", 2024),
//					new MatriculaEntity(profesor3, alumno1, "Lengua Española", 2023),
//					new MatriculaEntity(profesor3, alumno3, "Biología", 2024));
//
//			for (MatriculaEntity matricula : matriculas) {
//				FuncionesMatriculas.guardar(matricula);
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
