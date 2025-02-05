package principal;

import entidades.AlumnoEntity;
import entidades.MatriculaEntity;
import entidades.ProfesorEntity;
import funciones.FuncionesAlumnos;
import funciones.FuncionesMatriculas;
import funciones.FuncionesProfesores;

public class ProbandoMatriculas {

	public static void main(String[] args) {
		
		// MOSTRAR MATRICULAS POR ASIGNATURA
//		try {
//			FuncionesMatriculas.leerTodos();
//			FuncionesMatriculas.leerPorAsignatura("fía", "LIKE");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 
		
		// MOSTRAR MATRICULAS POR ALUMNO
		try {
			FuncionesMatriculas.leerTodos();
			AlumnoEntity alumno = FuncionesAlumnos.getAlumnoPorId(4); 
			FuncionesMatriculas.leerPorAlumno(alumno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se puede mostrar");
		} 
		
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
