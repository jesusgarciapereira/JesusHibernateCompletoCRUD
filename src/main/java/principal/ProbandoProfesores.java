package principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entidades.ProfesorEntity;
import funciones.FuncionesProfesores;

public class ProbandoProfesores {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

//		try {
//			FuncionesProfesores.leerTodos();
//		} catch (Exception e) {
//			System.out.println("No se puede mostrar");
//			e.printStackTrace();
//		}

		// ACTUALIZAR
		List<Long> idsProfesores = new ArrayList<>();
		// SI NO HAY NADIE
//		String nombreColumna = "fechaNacimiento";
//		String dato = "1988-01-01";
		// SI SOLO HAY UNO
//		String nombreColumna = "nombre";
//		String dato = "Ana";
//		String columnaCambiada = "antiguedad";
//		String datoCambiado = "15";

		// SI HAY MAS DE UNO
		String nombreColumna = "apellidos";
		String dato = "Martínez";
		String columnaCambiada = "apellidos";
		String datoCambiado = "Cerezo";
		Long idDeCambio;

		try {
			idsProfesores = FuncionesProfesores.buscaIDsPorColumna(nombreColumna, dato);
			if (idsProfesores.size() >= 1) {
				idDeCambio = idsProfesores.get(0);
				
				if (idsProfesores.size() > 1) {
					
					switch (nombreColumna) {
					case "nombre":
						FuncionesProfesores.leerPorNombre(dato, "=");	
						break;
						
					case "apellidos":
						FuncionesProfesores.leerPorApellidos(dato, "=");	
						break;

					default:
						break;
					}
					
					System.out.println("Hay varios Profesores con " + nombreColumna + " = " + dato);
					System.out.println("Escriba el id del Profesor que desea modificar:");
					idDeCambio = sc.nextLong();
				}
				
				FuncionesProfesores.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado);
				System.out.println("Profesor con " + nombreColumna + " = " + dato + " tiene ahora "
						+ columnaCambiada + " = " + datoCambiado);
			}else {
				System.out.println("No existe ningún Profesor con " + nombreColumna + " = " + dato);
			}

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se puede mostrar");
		}

		// ACTUALIZAR SI SOLO HAY UNO
//		List<Long> idsProfesores = new ArrayList<>(); 
//		
//		try {
//			idsProfesores = FuncionesProfesores.buscaIDsPorColumna("nombre", "Ana");
//			System.out.println(idsProfesores.get(0));
//			FuncionesProfesores.actualizarPorId(idsProfesores.get(0), "antiguedad", "15");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		}

		// MOSTRAR PROFESORES POR ANTIGUEDAD
//		try {
//			FuncionesProfesores.leerTodos();
//			FuncionesProfesores.leerPorAntiguedad(140, ">");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 

		// MOSTRAR PROFESORES POR FECHANACIMIENTO
//		try {
//			FuncionesProfesores.leerTodos();
//			FuncionesProfesores.leerPorFechaNacimiento(LocalDate.parse("1970-03-27"), "=");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 

		// MOSTRAR PROFESORES POR NOMBRE O APELLIDOS
//		try {
//			FuncionesProfesores.leerTodos();
//			FuncionesProfesores.leerPorApellidos("Hernández", "=");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 

		// MOSTRAR PROFESORES POR ID
//		try {
//			FuncionesProfesores.leerPorId(2, "<");
//			;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		}

		// MOSTRAR TODOS LOS PROFESORES
//		try {
//			FuncionesProfesores.leerTodos();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 

		// GUARDAR PROFESOR
//		// RECUERDA, en el objeto debes ponerlo asi

//		List<ProfesorEntity> profesores = Arrays.asList(
//				new ProfesorEntity("Jesús", "García Pereira", LocalDate.parse("1900-05-20"), 1),
//			    new ProfesorEntity("Juan", "Pérez", LocalDate.parse("1980-05-15"), 10),
//			    new ProfesorEntity("Ana", "García", LocalDate.parse("1975-09-22"), 15),
//			    new ProfesorEntity("Luis", "Martínez", LocalDate.parse("1988-12-03"), 5),
//			    new ProfesorEntity("Juan", "Márquez", LocalDate.parse("1970-03-27"), 20),
//			    new ProfesorEntity("Clara", "Sánchez", LocalDate.parse("1985-11-15"), 8),
//			    new ProfesorEntity("Roberto", "Gómez", LocalDate.parse("1978-04-19"), 12),
//			    new ProfesorEntity("Elena", "Torres", LocalDate.parse("1990-07-09"), 6),
//			    new ProfesorEntity("Miguel", "Álvarez", LocalDate.parse("1983-02-01"), 18),
//			    new ProfesorEntity("Laura", "Hernández", LocalDate.parse("1992-11-23"), 7)
//			);
//		
//		try {
//			for (ProfesorEntity profesor : profesores) {
//				FuncionesProfesores.guardar(profesor);
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se ha podido guardar");
//		}
//
//	}
	}
}
