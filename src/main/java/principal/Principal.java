package principal;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import colores.ColorMio;
import entidades.AlumnoEntity;
import entidades.MatriculaEntity;
import entidades.ProfesorEntity;
import funciones.FuncionesAlumnos;
import funciones.FuncionesMatriculas;
import funciones.FuncionesProfesores;

public class Principal {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// sc.useLocale(Locale.US);

		int opcionMenu = -1;
		int opcionSubmenuA = -1;
		int opcionSubmenuB = -1;
		int opcionSubmenuC = -1;
		int opcionSubmenuD = -1;
		int opcionSubmenuE = -1;

		ProfesorEntity profesor = null;
		AlumnoEntity alumno = null;
		MatriculaEntity matricula;

		long idProfesor = 0;
		String nombre = "";
		String apellidos = "";
		String fechaNacimiento = "";
		int antiguedad = -1;
		long idAlumno = 0;
		String asignatura = "";
		int curso = -1;

		int fechaDia = 0;
		int fechaMes = 0;
		int fechaAnnio = 0;

		do {
			Menu.menuPrincipal();
			opcionMenu = leeInt(sc);
			System.out.println();

			switch (opcionMenu) {

			case 1: // 1. Guardar Datos.
				do {
					Menu.subMenuGuardarDatos();
					opcionSubmenuA = leeInt(sc);
					System.out.println();

					switch (opcionSubmenuA) {

					case 1: // 1. Profesores.
						do {
							System.out.print("Escriba el Nombre del Profesor: ");
							nombre = sc.nextLine();
						} while (nombre == null || nombre.equals(""));

						do {
							System.out.print("Escriba los Apellidos del Profesor: ");
							apellidos = sc.nextLine();
						} while (apellidos == null || apellidos.equals(""));

						do {
							do {
								System.out.print("Introduzca el día de FechaNacimiento del Profesor (entre 1 y 31): ");
								fechaDia = leeInt(sc);
							} while (fechaDia < 1 || fechaDia > 31);

							do {
								System.out.print("Introduzca el mes de FechaNacimiento del Profesor (entre 1 y 12): ");
								fechaMes = leeInt(sc);
							} while (fechaMes < 1 || fechaMes > 12);

							do {
								System.out.print(
										"Introduzca el año de FechaNacimiento del Profesor (>= 1000 y <= año actual): ");
								fechaAnnio = leeInt(sc);
							} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

							fechaNacimiento = String.format("%d-%02d-%02d", fechaAnnio, fechaMes, fechaDia);
						} while (fechaNacimiento == null || fechaNacimiento.equals(""));

						do {
							System.out.print("Escriba la Antiguedad del Profesor (>= 0): ");
							antiguedad = leeInt(sc);
						} while (antiguedad < 0);

						try {
							profesor = new ProfesorEntity(nombre, apellidos, LocalDate.parse(fechaNacimiento),
									antiguedad);

							FuncionesProfesores.guardar(profesor);
						} catch (DateTimeException e) {
							System.out.println();
							System.out.print(ColorMio.getRojo());
							System.out.print("Fecha de nacimiento '" + fechaNacimiento + "' incorrecta:");
							System.out.println(ColorMio.getReset());
							System.out.println();
//						} catch (Exception e) {
//							System.out.println();
//							System.out.print(ColorMio.getRojo());
//							System.out.print("Ha ocurrido un error");
//							System.out.println(ColorMio.getReset());
//							System.out.println();
						} finally {
							opcionSubmenuA = 0;

							nombre = "";
							apellidos = "";
							fechaNacimiento = "";
							antiguedad = -1;

							fechaDia = 0;
							fechaMes = 0;
							fechaAnnio = 0;

							profesor = null;
						}

						break; // FIN 1. Profesores.
					case 2: // 2. Alumnos.
						do {
							System.out.print("Escriba el Nombre del Alumno: ");
							nombre = sc.nextLine();
						} while (nombre == null || nombre.equals(""));

						do {
							System.out.print("Escriba los Apellidos del Alumno: ");
							apellidos = sc.nextLine();
						} while (apellidos == null || apellidos.equals(""));

						do {
							do {
								System.out.print("Introduzca el día de FechaNacimiento del Alumno (entre 1 y 31): ");
								fechaDia = leeInt(sc);
							} while (fechaDia < 1 || fechaDia > 31);

							do {
								System.out.print("Introduzca el mes de FechaNacimiento del Alumno (entre 1 y 12): ");
								fechaMes = leeInt(sc);
							} while (fechaMes < 1 || fechaMes > 12);

							do {
								System.out.print(
										"Introduzca el año de FechaNacimiento del Alumno (>= 1000 y <= año actual): ");
								fechaAnnio = leeInt(sc);
							} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

							fechaNacimiento = String.format("%d-%02d-%02d", fechaAnnio, fechaMes, fechaDia);
						} while (fechaNacimiento == null || fechaNacimiento.equals(""));

						try {
							alumno = new AlumnoEntity(nombre, apellidos, LocalDate.parse(fechaNacimiento));

							FuncionesAlumnos.guardar(alumno);
						} catch (DateTimeException e) {
							System.out.println();
							System.out.print(ColorMio.getRojo());
							System.out.print("Fecha de nacimiento '" + fechaNacimiento + "' incorrecta");
							System.out.println(ColorMio.getReset());
							System.out.println();
//						} catch (Exception e) {
//							System.out.println();
//							System.out.print(ColorMio.getRojo());
//							System.out.print("Ha ocurrido un error");
//							System.out.println(ColorMio.getReset());
//							System.out.println();
						} finally {
							opcionSubmenuA = 0;

							nombre = "";
							apellidos = "";
							fechaNacimiento = "";

							fechaDia = 0;
							fechaMes = 0;
							fechaAnnio = 0;

							alumno = null;
						}

						break; // FIN 2. Alumnos.
					case 3: // 3. Matriculas.
						if (FuncionesProfesores.buscaIDsDeTodos().isEmpty()
								|| FuncionesAlumnos.buscaIDsDeTodos().isEmpty()) {
							System.out.print(ColorMio.getRojo());
							System.out.print("No existe ningún elemento en la(s) tabla(s) Profesores y/o Alumnos: ");
							System.out.print(ColorMio.getReset());
							System.out
									.println("Guarde al menos un Profesor y un Alumno antes de guardar una Matricula");
							System.out.println();
						} else {
							do {
								Menu.subMenuInsertarProfesor();
								opcionSubmenuB = leeInt(sc);
								System.out.println();

								switch (opcionSubmenuB) {
								case 1: // 1. Por idProfesor.
									do {
										System.out.print(
												"Escriba el idProfesor de la Matricula, o si lo prefiere, \"0\" para volver al Menú anterior: ");
										idProfesor = leeLong(sc);

										if (idProfesor != 0) {
											profesor = FuncionesProfesores.getProfesorPorId(idProfesor);

											if (profesor == null) {
												System.out.print(ColorMio.getRojo());
												System.out.println(
														"No existe ningún Profesor con idProfesor = " + idProfesor);
												System.out.print(ColorMio.getReset());
											}
										} else {
											System.out.println();
										}

									} while (idProfesor != 0 && profesor == null);

									break; // FIN 1. Por idProfesor.
								case 2: // 2. Por nombre.

									break; // FIN 2. Por nombre.
								case 3: // 3. Por apellidos.

									break; // FIN 3. Por apellidos.
								case 4: // 4. Por fechaNacimiento.

									break; // FIN 4. Por fechaNacimiento.
								case 5: // 5. Por antiguedad.

									break; // FIN 5. Por antiguedad.
								case 0: // 0. Volver al Menú Principal.
									break; // FIN 0. Volver al Menú Principal.

								default:
									System.out.print(ColorMio.getRojo());
									System.out.print("Opción no disponible: ");
									System.out.print(ColorMio.getReset());
									System.out.println("Elija del 0 al 5");
									System.out.println();
									break;
								}

								if (profesor != null)  {

									// Aqui iria el menu de alumno

									if (profesor != null && alumno != null) {
										matricula = new MatriculaEntity(profesor, alumno, "Geografía", 2020);
										FuncionesMatriculas.guardar(matricula);

									} else {
										System.out.println(
												"No se puede guardar la Matricula, Profesor y/o Alumno insertado(s) no existe(n) en la Base de Datos");
									}

									opcionSubmenuB = 0;
									opcionSubmenuA = 0;

									idProfesor = 0;

									nombre = "";
									apellidos = "";
									fechaNacimiento = "";

									fechaDia = 0;
									fechaMes = 0;
									fechaAnnio = 0;

									profesor = null;
									alumno = null;
									matricula = null;
								}
							} while (opcionSubmenuB != 0);

						}
						break; // FIN 3. Matriculas.
					case 0: // 0. Volver al Menú anterior.
						break; // FIN 0. Volver al Menú anterior.

					default:
						System.out.print(ColorMio.getRojo());
						System.out.print("Opción no disponible: ");
						System.out.print(ColorMio.getReset());
						System.out.println("Elija del 0 al 3");
						System.out.println();
						break;
					}// FIN switch (opcionSubmenuA)

				} while (opcionSubmenuA != 0);

				opcionMenu = -1;

				break; // FIN 1. Guardar Datos.
			case 2: // 2. Obtener datos.

				break; // FIN 2. Obtener datos.
			case 3: // 3. Actualizar Datos.

				break;// FIN 3. Actualizar Datos.
			case 4: // 4. Borrar Datos.

				break; // FIN 4. Borrar Datos.
			case 0: // 0. Salir del Programa
				break; // FIN 0. Salir del Programa

			default:
				System.out.print(ColorMio.getRojo());
				System.out.print("Opción no disponible: ");
				System.out.print(ColorMio.getReset());
				System.out.println("Elija del 0 al 4");
				System.out.println();
				break;
			} // FIN switch (opcionMenu)

		} while (opcionMenu != 0);

		System.out.println("Saliendo del programa...");
	}

	/**
	 * Funcion que devuelve el numero escrito por teclado
	 * 
	 * @param sc Objeto de tipo Scanner que leera
	 * @return Valor del numero escrito
	 */
	private static long leeLong(Scanner sc) {
		// Numero decimal que devolverá la funcion, inicializado en -1
		long longDevuelto = 0;

		try {
			// Le asignamos el int escrito por teclado
			longDevuelto = sc.nextLong();

			// Si se produce un InputMismatchException
		} catch (InputMismatchException e) {
			// Mostrará este mensaje
			System.out.println(ColorMio.getRojo() + "El valor introducido no es un número" + ColorMio.getReset());
		} finally {
			// Siempre limpiamos el buffer
			sc.nextLine();
		}

		// Devolverá el valor escrito por teclado, o -1 si no es del tipo correcto
		return longDevuelto;
	}

	/**
	 * Funcion que devuelve el numero entero escrito por teclado
	 * 
	 * @param sc Objeto de tipo Scanner que leera
	 * @return Valor del numero entero escrito
	 */
	private static int leeInt(Scanner sc) {
		// Numero decimal que devolverá la funcion, inicializado en -1
		int intDevuelto = -1;

		try {
			// Le asignamos el int escrito por teclado
			intDevuelto = sc.nextInt();

			// Si se produce un InputMismatchException
		} catch (InputMismatchException e) {
			// Mostrará este mensaje
			System.out
					.println(ColorMio.getRojo() + "El valor introducido no es un número entero" + ColorMio.getReset());
		} finally {
			// Siempre limpiamos el buffer
			sc.nextLine();
		}

		// Devolverá el valor escrito por teclado, o -1 si no es del tipo correcto
		return intDevuelto;
	}

	/**
	 * Funcion que devuelve un numero decimal escrito por teclado. Si se introduce
	 * un valor no valido, muestra un mensaje de error y devuelve -1.
	 * 
	 * @param sc Objeto de tipo Scanner que leere la entrada del usuario.
	 * @return El numero decimal introducido por el usuario, o -1 si ocurre un
	 *         error.
	 */
	private static double leeDouble(Scanner sc) {
		// Número decimal que devolverá la función, inicializado en -1.
		double doubleDevuelto = -1;

		try {
			// Le asignamos el número decimal escrito por teclado.
			doubleDevuelto = sc.nextDouble();

			// Si se produce un InputMismatchException.
		} catch (InputMismatchException e) {
			// Mostrará este mensaje en caso de error.
			System.out.println(ColorMio.getRojo()
					+ "El valor introducido no es un número o no ha usado punto \".\" como separador decimal."
					+ ColorMio.getReset());
		} finally {
			// Siempre limpiamos el buffer del Scanner.
			sc.nextLine();
		}

		// Devolverá el valor escrito por teclado, o -1 si no es del tipo correcto.
		return doubleDevuelto;
	}

}
