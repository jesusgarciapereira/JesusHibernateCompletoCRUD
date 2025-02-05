package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import funciones.FuncionesAlumnos;
import funciones.FuncionesProfesores;

public class ProbandoAlumnos {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		// BORRAR POR OTROS DATOS (NO ID)
		List<Long> idsAlumnos = new ArrayList<>();
		Long idDeBorrado;

		// SI NO HAY NADIE
//		String nombreColumna = "fechaNacimiento";
//		String dato = "1988-01-01";

		// SI SOLO HAY UNO
//		String nombreColumna = "nombre";
//		String dato = "Sandra";

		// SI HAY MAS DE UNO
		String nombreColumna = "fechaNacimiento";
		String dato = "2005-07-12";

		try {
			System.out.println(
					"¿Está seguro de que quiere borrar al Alumno con " + nombreColumna + " = " + dato + "? (s/n)");

			if (sc.nextLine().equals("s")) {
				idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna(nombreColumna, dato);

				if (idsAlumnos.size() > 1) {

					switch (nombreColumna) {
					case "nombre":
						FuncionesAlumnos.leerPorNombre(dato, "=");
						break;

					case "apellidos":
						FuncionesAlumnos.leerPorApellidos(dato, "=");
						break;

					case "fechaNacimiento":
						FuncionesAlumnos.leerPorFechaNacimiento(LocalDate.parse(dato), "=");
						
						break;

					default:
						break;
					}

					System.out.println("Hay varios Alumnos con " + nombreColumna + " = " + dato);
					System.out.println(
							"Escriba el id del Alumno que desea borrar, o si lo prefiere, \"0\" para borrar a todos estos:");
					idDeBorrado = sc.nextLong();
					sc.nextLine(); // Con la funcion pideLong() no hara falta

					if (idDeBorrado != 0) {
						System.out.println(
								"¿Está seguro de que quiere borrar al Alumno con ID = " + idDeBorrado + "? (s/n)");
						if (sc.nextLine().equals("s")) {
							if (idsAlumnos.contains(idDeBorrado) && FuncionesAlumnos.borrarPorId(idDeBorrado)) {
								System.out.println("Alumno con ID = " + idDeBorrado + " borrado");
							} else {
								System.out.println("No existe ningún Alumno con ID = " + idDeBorrado + " en la lista anteriormente mostrada");
							}
						}

					} else {
						System.out.println("¿Está seguro de que quiere borrar a todos estos Alumnos con "
								+ nombreColumna + " = " + dato + "? (s/n)");
						if (sc.nextLine().equals("s")) {
							for (Long id : idsAlumnos) {
								FuncionesAlumnos.borrarPorId(id);
							}
							System.out.println(
									"Todos los Alumnos con " + nombreColumna + " = " + dato + " han sido borrados");
						}

					}

				} else if (idsAlumnos.size() == 1) {
					idDeBorrado = idsAlumnos.get(0);

					FuncionesAlumnos.borrarPorId(idDeBorrado);
					System.out.println("Alumno con " + nombreColumna + " = " + dato + " borrado");
				} else {
					System.out.println("No existe ningún Alumno con " + nombreColumna + " = " + dato);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se puede mostrar");
		}
		
		// BORRAR POR ID
//		Long idDeBorrado = 10L;
//
//		try {
//			System.out.println("¿Está seguro de que quiere borrar al Alumno con ID = " + idDeBorrado + "? (s/n)");
//			if (sc.nextLine().equals("s")) {
//
//				if (FuncionesAlumnos.borrarPorId(idDeBorrado)) {
//
//					System.out.println("Alumno con ID = " + idDeBorrado + " ha sido borrado");
//				} else {
//					System.out.println("No existe ningún Alumno con ID = " + idDeBorrado);
//
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// BORRAR TODOS
//		List<Long> idsAlumnos = new ArrayList<>();
//		try {			
//			System.out.println("¿Está seguro de que quiere borrar a todos los Alumnos? (s/n)");
//			if (sc.nextLine().equals("s")) {
//				idsAlumnos = FuncionesAlumnos.buscaIDsDeTodos();
//				for (Long id : idsAlumnos) {
//					FuncionesAlumnos.borrarPorId(id);					
//				}
//				System.out.println("Todos los Alumnos han sido borrados");
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// ACTUALIZAR POR OTROS DATOS (NO ID)
//		List<Long> idsAlumnos = new ArrayList<>();
//		Long idDeCambio;

		// SI NO HAY NADIE
//		String nombreColumna = "fechaNacimiento";
//		String dato = "1988-01-01";
//		String columnaCambiada = "apellidos";
//		String datoCambiado = "Cerezo";

		// SI SOLO HAY UNO
//		String nombreColumna = "nombre";
//		String dato = "David";
//		String columnaCambiada = "apellidos";
//		String datoCambiado = "Ortega";

		// SI HAY MAS DE UNO
//		String nombreColumna = "nombre";
//		String dato = "Olegario";
//		String columnaCambiada = "nombre";
//		String datoCambiado = "Agapito";

//		try {
//			idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna(nombreColumna, dato);
//
//			if (idsAlumnos.size() > 1) {
//
//				switch (nombreColumna) {
//				case "nombre":
//					FuncionesAlumnos.leerPorNombre(dato, "=");
//					break;
//
//				case "apellidos":
//					FuncionesAlumnos.leerPorApellidos(dato, "=");
//					break;
//
//				case "fechaNacimiento":
//					FuncionesAlumnos.leerPorFechaNacimiento(LocalDate.parse(dato), "=");
//					break;
//
//				default:
//					break;
//				}
//
//				System.out.println("Hay varios Alumnos con " + nombreColumna + " = " + dato);
//				System.out.println(
//						"Escriba el id del Alumno que desea modificar, o si lo prefiere, \"0\" para modificar a todos estos:");
//				idDeCambio = sc.nextLong();
//
//				if (idDeCambio != 0) {
//					if (idsAlumnos.contains(idDeCambio) && FuncionesAlumnos.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
//						System.out.println("Alumno con ID = " + idDeCambio + " tiene ahora " + columnaCambiada + " = "
//								+ datoCambiado);
//					} else {
//						System.out.println("No existe ningún Alumno con ID = " + idDeCambio + " en la lista anteriormente mostrada");
//					}
//				} else {
//					for (Long id : idsAlumnos) {
//						FuncionesAlumnos.actualizarPorId(id, columnaCambiada, datoCambiado);
//					}
//					System.out.println(
//							"Todos los Alumnos con " + nombreColumna + " = " + dato + " tienen ahora " + columnaCambiada + " = "
//									+ datoCambiado);
//				}
//
//			} else if (idsAlumnos.size() == 1) {
//				idDeCambio = idsAlumnos.get(0);
//
//				FuncionesAlumnos.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado);
//				System.out.println("Alumno con " + nombreColumna + " = " + dato + " tiene ahora " + columnaCambiada
//						+ " = " + datoCambiado);
//			} else {
//				System.out.println("No existe ningún Alumno con " + nombreColumna + " = " + dato);
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
//			if (FuncionesAlumnos.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
//				System.out.println(
//						"Alumno con ID = " + idDeCambio + " tiene ahora " + columnaCambiada + " = " + datoCambiado);
//			} else {
//				System.out.println("No existe ningún Alumno con ID = " + idDeCambio);
//				
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// MOSTRAR ALUMNOS POR FECHANACIMIENTO
//		try {
//			FuncionesAlumnos.leerTodos();
//			FuncionesAlumnos.leerPorFechaNacimiento(LocalDate.parse("2000-10-14"), "=");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 
		
		// MOSTRAR ALUMNOS POR NOMBRE O APELLIDOS
//		try {
//			FuncionesAlumnos.leerTodos();
//			FuncionesAlumnos.leerPorApellidos("ez", "LIKE");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 
		
		// MOSTRAR ALUMNOS POR ID
//		try {
//			FuncionesAlumnos.leerPorId(2, "<");
//			;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		}
		
		// MOSTRAR TODOS LOS ALUMNOS
//		try {
//			FuncionesAlumnos.leerTodos();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se puede mostrar");
//		} 
		
		// GUARDAR ALUMNO
//		// RECUERDA, en el objeto debes ponerlo asi
		
//		List<AlumnoEntity> alumnos = Arrays.asList(
//			    new AlumnoEntity("Carlos", "López", LocalDate.parse("2005-07-12")),
//			    new AlumnoEntity("María", "Fernández", LocalDate.parse("2006-01-25")),
//			    new AlumnoEntity("Lucía", "Rodríguez", LocalDate.parse("2004-03-18")),
//			    new AlumnoEntity("Carlos", "Martín", LocalDate.parse("2006-03-17")),
//			    new AlumnoEntity("David", "Ramírez", LocalDate.parse("2005-11-10")),
//			    new AlumnoEntity("Sandra", "Ortiz", LocalDate.parse("2006-04-02")),
//			    new AlumnoEntity("Pablo", "Serrano", LocalDate.parse("2004-10-14")),
//			    new AlumnoEntity("Andrea", "Vega", LocalDate.parse("2003-09-05")),
//			    new AlumnoEntity("Javier", "Mendoza", LocalDate.parse("2005-06-20"))
//			);
//
//			try {
//			    for (AlumnoEntity alumno : alumnos) {
//			         FuncionesAlumnos.guardar(alumno);
//			    }
//			} catch (Exception e) {
//			    e.printStackTrace();
//			    System.out.println("No se ha podido guardar los alumnos");
//			}

	}

}
