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

		// BORRAR POR OTROS DATOS (NO ID)
		List<Long> idsProfesores = new ArrayList<>();
		Long idDeBorrado;

		// SI NO HAY NADIE
//		String nombreColumna = "fechaNacimiento";
//		String dato = "1988-01-01";

		// SI SOLO HAY UNO
//		String nombreColumna = "nombre";
//		String dato = "Ana";

		// SI HAY MAS DE UNO
		String nombreColumna = "fechaNacimiento";
		String dato = "1980-05-15";

		try {
			System.out.println(
					"¿Está seguro de que quiere borrar al Profesor con " + nombreColumna + " = " + dato + "? (s/n)");

			if (sc.nextLine().equals("s")) {
				idsProfesores = FuncionesProfesores.buscaIDsPorColumna(nombreColumna, dato);

				if (idsProfesores.size() > 1) {

					switch (nombreColumna) {
					case "nombre":
						FuncionesProfesores.leerPorNombre(dato, "=");
						break;

					case "apellidos":
						FuncionesProfesores.leerPorApellidos(dato, "=");
						break;

					case "fechaNacimiento":
						FuncionesProfesores.leerPorFechaNacimiento(LocalDate.parse(dato), "=");
						;
						break;
					case "antiguedad":
						FuncionesProfesores.leerPorAntiguedad(Integer.parseInt(dato), "=");
						;
						break;

					default:
						break;
					}

					System.out.println("Hay varios Profesores con " + nombreColumna + " = " + dato);
					System.out.println(
							"Escriba el id del Profesor que desea borrar, o si lo prefiere, \"0\" para borrar a todos estos:");
					idDeBorrado = sc.nextLong();
					sc.nextLine(); // Con la funcion pideLong() no hara falta

					if (idDeBorrado != 0) {
						System.out.println(
								"¿Está seguro de que quiere borrar al Profesor con ID = " + idDeBorrado + "? (s/n)");
						if (sc.nextLine().equals("s")) {
							if (FuncionesProfesores.borrarPorId(idDeBorrado)) {
								System.out.println("Profesor con ID = " + idDeBorrado + " borrado");
							} else {
								System.out.println("No existe ningún Profesor con ID = " + idDeBorrado);
							}
						}

					} else {
						System.out.println(
								"¿Está seguro de que quiere borrar a todos estos Profesores con " + nombreColumna + " = " + dato + "? (s/n)");
						if (sc.nextLine().equals("s")) {
							for (Long id : idsProfesores) {
								FuncionesProfesores.borrarPorId(id);					
							}
							System.out.println("Todos los profesores con " + nombreColumna + " = " + dato + " han sido borrados");
						}
						
					}
					
					
				} else if (idsProfesores.size() == 1) {
					idDeBorrado = idsProfesores.get(0);

					FuncionesProfesores.borrarPorId(idDeBorrado);
					System.out.println("Profesor con " + nombreColumna + " = " + dato + " borrado");
				} else {
					System.out.println("No existe ningún Profesor con " + nombreColumna + " = " + dato);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se puede mostrar");
		}

		// BORRAR POR ID
//		Long idDeBorrado = 1L;
//
//		try {
//			System.out.println("¿Está seguro de que quiere borrar al Profesor con ID = " + idDeBorrado + "? (s/n)");
//			if (sc.nextLine().equals("s")) {
//
//				if (FuncionesProfesores.borrarPorId(idDeBorrado)) {
//
//					System.out.println("Profesor con ID = " + idDeBorrado + " ha sido borrado");
//				} else {
//					System.out.println("No existe ningún Profesor con ID = " + idDeBorrado);
//
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// BORRAR TODOS
//		List<Long> idsProfesores = new ArrayList<>();
//		try {			
//			System.out.println("¿Está seguro de que quiere borrar a todos los Profesores? (s/n)");
//			if (sc.nextLine().equals("s")) {
//				idsProfesores = FuncionesProfesores.buscaIDsDeTodos();
//				for (Long id : idsProfesores) {
//					FuncionesProfesores.borrarPorId(id);					
//				}
//				System.out.println("Todos los profesores han sido borrados");
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// ACTUALIZAR POR OTROS DATOS (NO ID)
//		List<Long> idsProfesores = new ArrayList<>();
//		Long idDeCambio;

		// SI NO HAY NADIE
//		String nombreColumna = "fechaNacimiento";
//		String dato = "1988-01-01";
//		String columnaCambiada = "apellidos";
//		String datoCambiado = "Cerezo";

		// SI SOLO HAY UNO
//		String nombreColumna = "nombre";
//		String dato = "Ana";
//		String columnaCambiada = "antiguedad";
//		String datoCambiado = "5";

		// SI HAY MAS DE UNO
//		String nombreColumna = "fechaNacimiento";
//		String dato = "1980-05-15";
//		String columnaCambiada = "nombre";
//		String datoCambiado = "Agapito";
//
//		try {
//			idsProfesores = FuncionesProfesores.buscaIDsPorColumna(nombreColumna, dato);
//
//			if (idsProfesores.size() > 1) {
//
//				switch (nombreColumna) {
//				case "nombre":
//					FuncionesProfesores.leerPorNombre(dato, "=");
//					break;
//
//				case "apellidos":
//					FuncionesProfesores.leerPorApellidos(dato, "=");
//					break;
//
//				case "fechaNacimiento":
//					FuncionesProfesores.leerPorFechaNacimiento(LocalDate.parse(dato), "=");
//					;
//					break;
//				case "antiguedad":
//					FuncionesProfesores.leerPorAntiguedad(Integer.parseInt(dato), "=");
//					;
//					break;
//
//				default:
//					break;
//				}
//
//				System.out.println("Hay varios Profesores con " + nombreColumna + " = " + dato);
//				System.out.println("Escriba el id del Profesor que desea modificar:");
//				idDeCambio = sc.nextLong();
//
//				if (FuncionesProfesores.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
//					System.out.println("Profesor con ID = " + idDeCambio + " tiene ahora " + columnaCambiada + " = "
//							+ datoCambiado);
//				} else {
//					System.out.println("No existe ningún Profesor con ID = " + idDeCambio);
//				}
//			} else if (idsProfesores.size() == 1) {
//				idDeCambio = idsProfesores.get(0);
//
//				FuncionesProfesores.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado);
//				System.out.println("Profesor con " + nombreColumna + " = " + dato + " tiene ahora " + columnaCambiada
//						+ " = " + datoCambiado);
//			} else {
//				System.out.println("No existe ningún Profesor con " + nombreColumna + " = " + dato);
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		}

		// ACTUALIZAR POR ID
//		Long idDeCambio = 3L;
//		String columnaCambiada = "fechaNacimiento";
//		String datoCambiado = "1990-07-21";
//		try {
//			if (FuncionesProfesores.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
//				System.out.println(
//						"Profesor con ID = " + idDeCambio + " tiene ahora " + columnaCambiada + " = " + datoCambiado);
//			} else {
//				System.out.println("No existe ningún Profesor con ID = " + idDeCambio);
//				
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
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

	}
}
