package principal;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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

		long idProfesor = -1;
		String nombre = "";
		String apellidos = "";
		String fechaNacimiento = "";
		int antiguedad = -1;
		long idAlumno = -1;
		long idMatricula = -1;
		String asignatura = "";
		int curso = -1;

		int fechaDia = 0;
		int fechaMes = 0;
		int fechaAnnio = 0;

		String filtro = "";
		String cabecera = "";

		String columnaCambiada = "";
		String datoCambiado = "";
		long idDeCambio = -1;
		String datoDeCambio = "";
		long idDeBorrado = -1;
		String datoDeBorrado = "";

		List<Long> idsProfesores = new ArrayList<>();
		List<Long> idsAlumnos = new ArrayList<>();
		List<Long> idsMatriculas = new ArrayList<>();

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
							System.out.print("Introduzca el Nombre del Profesor: ");
							nombre = sc.nextLine();
						} while (nombre == null || nombre.equals(""));

						do {
							System.out.print("Introduzca los Apellidos del Profesor: ");
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
							System.out.print("Introduzca la Antiguedad del Profesor (>= 0): ");
							antiguedad = leeInt(sc);
						} while (antiguedad < 0);

						try {
							profesor = new ProfesorEntity(nombre, apellidos, LocalDate.parse(fechaNacimiento),
									antiguedad);

							FuncionesProfesores.guardar(profesor);
						} catch (DateTimeException e) {
							System.out.println();
							System.out.print(ColorMio.getRojo());
							System.out.print("Fecha '" + fechaNacimiento + "' incorrecta:");
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
							System.out.print("Introduzca el Nombre del Alumno: ");
							nombre = sc.nextLine();
						} while (nombre == null || nombre.equals(""));

						do {
							System.out.print("Introduzca los Apellidos del Alumno: ");
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

								idsProfesores.clear();
								profesor = null;
								Menu.subMenuInsertarProfesor();
								opcionSubmenuB = leeInt(sc);
								System.out.println();

								switch (opcionSubmenuB) {
								case 1: // 1. Por idProfesor.
									do {
										System.out.print(
												"Introduzca el ID del Profesor correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
										idProfesor = leeLong(sc);

										if (idProfesor != 0) {
											profesor = FuncionesProfesores.getProfesorPorId(idProfesor);

											if (profesor == null) {
												System.out.print(ColorMio.getRojo());
												System.out.println(
														"No existe ningún Profesor con idProfesor = " + idProfesor);
												System.out.print(ColorMio.getReset());
											}
										}

									} while (idProfesor != 0 && profesor == null);
									System.out.println();
									break; // FIN 1. Por idProfesor.
								case 2: // 2. Por nombre.
									do {
										do {
											System.out.print(
													"Introduzca el Nombre del Profesor correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
											nombre = sc.nextLine();
										} while (nombre == null || nombre.equals(""));
										if (!nombre.equals("0")) {
											idsProfesores = FuncionesProfesores.buscaIDsPorColumna("nombre", nombre);

											if (idsProfesores.size() > 1) {

												FuncionesProfesores.leerPorNombre(nombre, "=");

												System.out.print(ColorMio.getAmarillo());
												System.out.println("Hay varios Profesores con nombre = " + nombre);
												System.out.print(ColorMio.getReset());

												System.out.print(
														"Introduzca el idProfesor correspondiente, o si lo prefiere, \"0\" para introducir otro Nombre: ");
												idProfesor = leeLong(sc);

												if (idProfesor != 0) {

													if (!idsProfesores.contains(idProfesor)) {
														System.out.print(ColorMio.getRojo());
														System.out.println("No existe ningún Profesor con idProfesor = "
																+ idProfesor + " en la lista anteriormente mostrada");
														System.out.print(ColorMio.getReset());
														nombre = "";
													} else {
														profesor = FuncionesProfesores.getProfesorPorId(idProfesor);
													}
												} else {

													System.out.println();
												}
											}

											else if (idsProfesores.size() == 0) {
												System.out.print(ColorMio.getRojo());
												System.out.println("No existe ningún Profesor con nombre = " + nombre);
												System.out.print(ColorMio.getReset());
											} else {
												profesor = FuncionesProfesores.getProfesorPorId(idsProfesores.get(0));

											}

										}

									} while (!nombre.equals("0") && !nombre.equals("") && profesor == null
											&& !idsProfesores.contains(idProfesor));
									System.out.println();
									break; // FIN 2. Por nombre.
								case 3: // 3. Por apellidos.
									do {
										do {
											System.out.print(
													"Introduzca el Apellido del Profesor correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
											apellidos = sc.nextLine();
										} while (apellidos == null || apellidos.equals(""));

										if (!apellidos.equals("0")) {
											idsProfesores = FuncionesProfesores.buscaIDsPorColumna("apellidos",
													apellidos);

											if (idsProfesores.size() > 1) {

												FuncionesProfesores.leerPorApellidos(apellidos, "=");

												System.out.print(ColorMio.getAmarillo());
												System.out
														.println("Hay varios Profesores con apellidos = " + apellidos);
												System.out.print(ColorMio.getReset());

												System.out.print(
														"Introduzca el idProfesor de la Matricula, o si lo prefiere, \"0\" para introducir otros Apellidos: ");
												idProfesor = leeLong(sc);

												if (idProfesor != 0) {

													if (!idsProfesores.contains(idProfesor)) {
														System.out.print(ColorMio.getRojo());
														System.out.println("No existe ningún Profesor con idProfesor = "
																+ idProfesor + " en la lista anteriormente mostrada");
														System.out.print(ColorMio.getReset());
														apellidos = "";
													} else {
														profesor = FuncionesProfesores.getProfesorPorId(idProfesor);
													}
												} else {
													System.out.println();
												}
											}

											else if (idsProfesores.size() == 0) {
												System.out.print(ColorMio.getRojo());
												System.out.println(
														"No existe ningún Profesor con apellidos = " + apellidos);
												System.out.print(ColorMio.getReset());
											} else {
												profesor = FuncionesProfesores.getProfesorPorId(idsProfesores.get(0));

											}

										}

									} while (!apellidos.equals("0") && !apellidos.equals("") && profesor == null
											&& !idsProfesores.contains(idProfesor));
									System.out.println();
									break; // FIN 3. Por apellidos.
								case 4: // 4. Por fechaNacimiento.
									do {
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Profesor correspondiente (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Profesor correspondiente (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Profesor correspondiente (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											fechaNacimiento = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);

										} while (fechaNacimiento == null || fechaNacimiento.equals(""));

										idsProfesores = FuncionesProfesores.buscaIDsPorColumna("fechaNacimiento",
												fechaNacimiento);

										if (idsProfesores.size() > 1) {

											FuncionesProfesores.leerPorFechaNacimiento(LocalDate.parse(fechaNacimiento),
													"=");

											System.out.print(ColorMio.getAmarillo());
											System.out.println(
													"Hay varios Profesores con fechaNacimiento = " + fechaNacimiento);
											System.out.print(ColorMio.getReset());

											System.out.print(
													"Introduzca el idProfesor de la Matricula, o si lo prefiere, \"0\" para introducir otra FechaNacimiento: ");
											idProfesor = leeLong(sc);

											if (idProfesor != 0) {

												if (!idsProfesores.contains(idProfesor)) {
													System.out.print(ColorMio.getRojo());
													System.out.println("No existe ningún Profesor con idProfesor = "
															+ idProfesor + " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
												} else {
													profesor = FuncionesProfesores.getProfesorPorId(idProfesor);
												}
											} else {
												System.out.println();
											}
										}

										else if (idsProfesores.size() == 0) {
											System.out.print(ColorMio.getRojo());
											System.out.println("No existe ningún Profesor con fechaNacimiento = "
													+ fechaNacimiento);
											System.out.print(ColorMio.getReset());
											System.out
													.println("¿Quiere introducir una FechaNacimiento de nuevo? (s/n)");
											if (sc.nextLine().equals("s")) {
												fechaNacimiento = "";

											}

										} else {
											profesor = FuncionesProfesores.getProfesorPorId(idsProfesores.get(0));

										}

									} while (fechaNacimiento.equals("")
											&& (profesor == null && !idsProfesores.contains(idProfesor)));
									System.out.println();

									break; // FIN 4. Por fechaNacimiento.
								case 5: // 5. Por antiguedad.
									do {
										do {
											System.out.print(
													"Introduzca la Antiguedad del Profesor correspondiente (>= 0), o si lo prefiere, \"-1\" para volver al Menú anterior: ");
											antiguedad = leeInt(sc);
										} while (antiguedad < 0 && antiguedad != -1);

										if (antiguedad != -1) {
											idsProfesores = FuncionesProfesores.buscaIDsPorColumna("antiguedad",
													String.valueOf(antiguedad));

											if (idsProfesores.size() > 1) {

												FuncionesProfesores.leerPorAntiguedad(antiguedad, "=");

												System.out.print(ColorMio.getAmarillo());
												System.out.println(
														"Hay varios Profesores con antiguedad = " + antiguedad);
												System.out.print(ColorMio.getReset());

												System.out.print(
														"Introduzca el idProfesor de la Matricula, o si lo prefiere, \"0\" para introducir otra Antiguedad: ");
												idProfesor = leeLong(sc);

												if (idProfesor != 0) {

													if (!idsProfesores.contains(idProfesor)) {
														System.out.print(ColorMio.getRojo());
														System.out.println("No existe ningún Profesor con idProfesor = "
																+ idProfesor + " en la lista anteriormente mostrada");
														System.out.print(ColorMio.getReset());
														antiguedad = -1;
													} else {
														profesor = FuncionesProfesores.getProfesorPorId(idProfesor);
													}
												} else {
													System.out.println();
												}
											}

											else if (idsProfesores.size() == 0) {
												System.out.print(ColorMio.getRojo());
												System.out.println(
														"No existe ningún Profesor con antiguedad = " + antiguedad);
												System.out.print(ColorMio.getReset());
											} else {
												profesor = FuncionesProfesores.getProfesorPorId(idsProfesores.get(0));

											}

										}

									} while (antiguedad != -1 && profesor == null
											&& !idsProfesores.contains(idProfesor));
									System.out.println();
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

								nombre = "";
								apellidos = "";
								fechaNacimiento = "";

								fechaDia = 0;
								fechaMes = 0;
								fechaAnnio = 0;

								if (profesor != null) {

									do {
										idsAlumnos.clear();
										alumno = null;
										Menu.subMenuInsertarAlumno();
										opcionSubmenuC = leeInt(sc);
										System.out.println();

										switch (opcionSubmenuC) {
										case 1: // 1. Por idAlumno.
											do {
												System.out.print(
														"Introduzca el ID del Alumno correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
												idAlumno = leeLong(sc);

												if (idAlumno != 0) {
													alumno = FuncionesAlumnos.getAlumnoPorId(idAlumno);

													if (alumno == null) {
														System.out.print(ColorMio.getRojo());
														System.out.println(
																"No existe ningún Alumno con idAlumno = " + idAlumno);
														System.out.print(ColorMio.getReset());
													}
												}

											} while (idAlumno != 0 && alumno == null);
											System.out.println();
											break; // FIN 1. Por idAlumno.
										case 2: // 2. Por nombre.
											do {
												do {
													System.out.print(
															"Introduzca el Nombre del Alumno correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
													nombre = sc.nextLine();
												} while (nombre == null || nombre.equals(""));
												if (!nombre.equals("0")) {
													idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna("nombre", nombre);

													if (idsAlumnos.size() > 1) {

														FuncionesAlumnos.leerPorNombre(nombre, "=");

														System.out.print(ColorMio.getAmarillo());
														System.out.println("Hay varios Alumnos con nombre = " + nombre);
														System.out.print(ColorMio.getReset());

														System.out.print(
																"Introduzca el idAlumno correspondiente, o si lo prefiere, \"0\" para introducir otro Nombre: ");
														idAlumno = leeLong(sc);

														if (idAlumno != 0) {

															if (!idsAlumnos.contains(idAlumno)) {
																System.out.print(ColorMio.getRojo());
																System.out.println(
																		"No existe ningún Alumno con idAlumno = "
																				+ idAlumno
																				+ " en la lista anteriormente mostrada");
																System.out.print(ColorMio.getReset());
																nombre = "";
															} else {
																alumno = FuncionesAlumnos.getAlumnoPorId(idAlumno);

															}
														} else {

															System.out.println();
														}
													}

													else if (idsAlumnos.size() == 0) {
														System.out.print(ColorMio.getRojo());
														System.out.println(
																"No existe ningún Alumno con nombre = " + nombre);
														System.out.print(ColorMio.getReset());
													} else {
														alumno = FuncionesAlumnos.getAlumnoPorId(idsProfesores.get(0));

													}

												}

											} while (!nombre.equals("0") && !nombre.equals("") && alumno == null
													&& !idsAlumnos.contains(idAlumno));
											System.out.println();
											break; // FIN 2. Por nombre.
										case 3: // 3. Por apellidos.
											do {
												do {
													System.out.print(
															"Introduzca el Apellido del Alumno correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
													apellidos = sc.nextLine();
												} while (apellidos == null || apellidos.equals(""));

												if (!apellidos.equals("0")) {
													idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna("apellidos",
															apellidos);

													if (idsAlumnos.size() > 1) {

														FuncionesAlumnos.leerPorApellidos(apellidos, "=");

														System.out.print(ColorMio.getAmarillo());
														System.out.println(
																"Hay varios Alumnos con apellidos = " + apellidos);
														System.out.print(ColorMio.getReset());

														System.out.print(
																"Introduzca el idAlumno de la Matricula, o si lo prefiere, \"0\" para introducir otros Apellidos: ");
														idAlumno = leeLong(sc);

														if (idAlumno != 0) {

															if (!idsAlumnos.contains(idAlumno)) {
																System.out.print(ColorMio.getRojo());
																System.out.println(
																		"No existe ningún Alumno con idAlumno = "
																				+ idAlumno
																				+ " en la lista anteriormente mostrada");
																System.out.print(ColorMio.getReset());
																apellidos = "";
															} else {
																alumno = FuncionesAlumnos.getAlumnoPorId(idAlumno);

															}
														} else {
															System.out.println();
														}
													}

													else if (idsAlumnos.size() == 0) {
														System.out.print(ColorMio.getRojo());
														System.out.println(
																"No existe ningún Alumno con apellidos = " + apellidos);
														System.out.print(ColorMio.getReset());
													} else {
														alumno = FuncionesAlumnos.getAlumnoPorId(idsAlumnos.get(0));

													}

												}

											} while (!apellidos.equals("0") && !apellidos.equals("") && alumno == null
													&& !idsAlumnos.contains(idAlumno));
											System.out.println();
											break; // FIN 3. Por apellidos.
										case 4: // 4. Por fechaNacimiento.
											do {
												do {
													do {
														System.out.print(
																"Introduzca el día de FechaNacimiento del Alumno correspondiente (entre 1 y 31): ");
														fechaDia = leeInt(sc);
													} while (fechaDia < 1 || fechaDia > 31);

													do {
														System.out.print(
																"Introduzca el mes de FechaNacimiento del Alumno correspondiente (entre 1 y 12): ");
														fechaMes = leeInt(sc);
													} while (fechaMes < 1 || fechaMes > 12);

													do {
														System.out.print(
																"Introduzca el año de FechaNacimiento del Alumno correspondiente (>= 1000 y <= año actual): ");
														fechaAnnio = leeInt(sc);
													} while (fechaAnnio <= 1000
															|| fechaAnnio > LocalDate.now().getYear());

													fechaNacimiento = String.format("%d-%02d-%02d", fechaAnnio,
															fechaMes, fechaDia);

												} while (fechaNacimiento == null || fechaNacimiento.equals(""));

												idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna("fechaNacimiento",
														fechaNacimiento);

												if (idsAlumnos.size() > 1) {
													FuncionesAlumnos.leerPorFechaNacimiento(
															LocalDate.parse(fechaNacimiento), "=");

													System.out.print(ColorMio.getAmarillo());
													System.out.println("Hay varios Alumnos con fechaNacimiento = "
															+ fechaNacimiento);
													System.out.print(ColorMio.getReset());

													System.out.print(
															"Introduzca el idAlumno de la Matricula, o si lo prefiere, \"0\" para introducir otra FechaNacimiento: ");
													idAlumno = leeLong(sc);

													if (idAlumno != 0) {

														if (!idsAlumnos.contains(idAlumno)) {
															System.out.print(ColorMio.getRojo());
															System.out.println("No existe ningún Alumno con idAlumno = "
																	+ idAlumno + " en la lista anteriormente mostrada");
															System.out.print(ColorMio.getReset());

														} else {
															alumno = FuncionesAlumnos.getAlumnoPorId(idAlumno);
														}
													} else {
														System.out.println();
													}
												}

												else if (idsAlumnos.size() == 0) {
													System.out.print(ColorMio.getRojo());
													System.out.println("No existe ningún Alumno con fechaNacimiento = "
															+ fechaNacimiento);
													System.out.print(ColorMio.getReset());
													System.out.println(
															"¿Quiere introducir una FechaNacimiento de nuevo? (s/n)");
													if (sc.nextLine().equals("s")) {
														fechaNacimiento = "";
													}

												} else {
													alumno = FuncionesAlumnos.getAlumnoPorId(idsProfesores.get(0));

												}

											} while (fechaNacimiento.equals("") && alumno == null
													&& !idsProfesores.contains(idAlumno));
											System.out.println();

											break; // FIN 4. Por fechaNacimiento.
										case 0: // 0. Volver al Menú Principal.
											break; // FIN 0. Volver al Menú Principal.

										default:
											System.out.print(ColorMio.getRojo());
											System.out.print("Opción no disponible: ");
											System.out.print(ColorMio.getReset());
											System.out.println("Elija del 0 al 4");
											System.out.println();
											break;
										}

										if (alumno != null) {

											// Aqui irian los otros dos

											do {
												System.out.print("Introduzca la Asignatura de la Matricula: ");
												asignatura = sc.nextLine();
											} while (asignatura == null || asignatura.equals(""));

											do {
												System.out.print("Introduzca el Curso de la Matricula (>= 0): ");
												curso = leeInt(sc);
											} while (curso < 0);

											matricula = new MatriculaEntity(profesor, alumno, asignatura, curso);
											FuncionesMatriculas.guardar(matricula);

											opcionSubmenuC = 0;
											opcionSubmenuB = 0;
											opcionSubmenuA = 0;

											idProfesor = -1;
											idAlumno = -1;

											nombre = "";
											apellidos = "";
											fechaNacimiento = "";
											antiguedad = -1;

											fechaDia = 0;
											fechaMes = 0;
											fechaAnnio = 0;

											asignatura = "";
											curso = -1;

											profesor = null;
											alumno = null;
											matricula = null;

											idsProfesores.clear();
											idsAlumnos.clear();
										}
									} while (opcionSubmenuC != 0);

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
				do {
					Menu.subMenuObtenerDatos();
					opcionSubmenuA = leeInt(sc);
					System.out.println();

					switch (opcionSubmenuA) {
					case 1: // 1. Todos.

						FuncionesProfesores.leerTodos();
						FuncionesAlumnos.leerTodos();
						FuncionesMatriculas.leerTodos();
						System.out.println();

						opcionSubmenuA = 0;

						break; // FIN 1. Todos.

					case 2: // 2. Profesores.
						do {
							Menu.subMenuObtenerProfesores();
							opcionSubmenuB = leeInt(sc);
							System.out.println();

							switch (opcionSubmenuB) {
							case 1: // 1. Todos.
								FuncionesProfesores.leerTodos();
								System.out.println();

								opcionSubmenuB = 0;
								opcionSubmenuA = 0;

								break; // FIN 1. Todos.
							case 2: // 2. Por idProfesor.

								do {
									Menu.submenuOpcionFiltroNUMBER();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = ">";
										break;
									case 3:
										filtro = "<";
										break;
									case 4:
										filtro = ">=";
										break;
									case 5:
										filtro = "<=";
										break;
									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 5");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 5) {
										do {
											System.out.print("Introduzca el ID del Profesor (> 0): ");
											idProfesor = leeLong(sc);

										} while (idProfesor <= 0);

										FuncionesProfesores.leerPorId(idProfesor, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idProfesor = -1;
										filtro = "";
									}
								} while (opcionSubmenuC != 0);

								break; // FIN 2. Por idProfesor.
							case 3: // 3. Por nombre.
								do {
									Menu.submenuOpcionFiltroVARCHAR();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = "LIKE";
										break;

									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 2");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 2) {
										do {
											System.out.print("Introduzca el Nombre del Profesor: ");
											nombre = sc.nextLine();

										} while (nombre == "" | nombre == null);

										FuncionesProfesores.leerPorNombre(nombre, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										nombre = "";
										filtro = "";
									}
								} while (opcionSubmenuC != 0);
								break; // FIN 3. Por nombre.
							case 4: // 4. Por apellidos.
								do {
									Menu.submenuOpcionFiltroVARCHAR();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = "LIKE";
										break;

									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 2");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 2) {
										do {
											System.out.print("Introduzca los Apellidos del Profesor: ");
											apellidos = sc.nextLine();

										} while (apellidos == "" | apellidos == null);

										FuncionesProfesores.leerPorApellidos(apellidos, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										apellidos = "";
										filtro = "";
									}
								} while (opcionSubmenuC != 0);
								break; // FIN 4. Por apellidos.
							case 5: // 5. Por fechaNacimiento.
								do {
									Menu.submenuOpcionFiltroNUMBER();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = ">";
										break;
									case 3:
										filtro = "<";
										break;
									case 4:
										filtro = ">=";
										break;
									case 5:
										filtro = "<=";
										break;
									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 5");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 5) {
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Profesor (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Profesor (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Profesor (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											fechaNacimiento = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (fechaNacimiento == null || fechaNacimiento.equals(""));

										try {
											FuncionesProfesores.leerPorFechaNacimiento(LocalDate.parse(fechaNacimiento),
													filtro);
										} catch (DateTimeException e) {
											System.out.println();
											System.out.print(ColorMio.getRojo());
											System.out
													.print("Fecha de nacimiento '" + fechaNacimiento + "' incorrecta");
											System.out.println(ColorMio.getReset());
											System.out.println();
										} finally {
											opcionSubmenuC = 0;
											opcionSubmenuB = 0;
											opcionSubmenuA = 0;

											fechaDia = 0;
											fechaMes = 0;
											fechaAnnio = 0;

											fechaNacimiento = "";
											filtro = "";
										}
									}
								} while (opcionSubmenuC != 0);
								break; // FIN 5. Por fechaNacimiento.
							case 6: // 6. Por antiguedad.
								do {
									Menu.submenuOpcionFiltroNUMBER();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = ">";
										break;
									case 3:
										filtro = "<";
										break;
									case 4:
										filtro = ">=";
										break;
									case 5:
										filtro = "<=";
										break;
									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 5");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)

									if (opcionSubmenuC > 0 && opcionSubmenuC <= 5) {
										do {
											System.out.print("Introduzca la antiguedad del Profesor (>= 0): ");
											antiguedad = leeInt(sc);

										} while (antiguedad < 0);

										FuncionesProfesores.leerPorAntiguedad(antiguedad, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										antiguedad = -1;
										filtro = "";

									}
								} while (opcionSubmenuC != 0);
								break; // FIN 6. Por antiguedad.
							case 0: // 0. Volver al Menú anterior.

								break; // FIN 0. Volver al Menú anterior.

							default:
								System.out.print(ColorMio.getRojo());
								System.out.print("Opción no disponible: ");
								System.out.print(ColorMio.getReset());
								System.out.println("Elija del 0 al 6");
								System.out.println();
								break;
							}// FIN switch (opcionSubmenuB)
						} while (opcionSubmenuB != 0);

						break; // FIN 2. Profesores.
					case 3: // 3. Alumnos.
						do {
							Menu.subMenuObtenerAlumnos();
							opcionSubmenuB = leeInt(sc);
							System.out.println();

							switch (opcionSubmenuB) {
							case 1: // 1. Todos.
								FuncionesAlumnos.leerTodos();
								System.out.println();

								opcionSubmenuB = 0;
								opcionSubmenuA = 0;

								break; // FIN 1. Todos.
							case 2: // 2. Por idAlumno.

								do {
									Menu.submenuOpcionFiltroNUMBER();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = ">";
										break;
									case 3:
										filtro = "<";
										break;
									case 4:
										filtro = ">=";
										break;
									case 5:
										filtro = "<=";
										break;
									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 5");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 5) {
										do {
											System.out.print("Introduzca el ID del Alumno (> 0): ");
											idAlumno = leeLong(sc);

										} while (idAlumno <= 0);

										FuncionesAlumnos.leerPorId(idAlumno, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idAlumno = -1;
										filtro = "";
									}
								} while (opcionSubmenuC != 0);

								break; // FIN 2. Por idAlumno.
							case 3: // 3. Por nombre.
								do {
									Menu.submenuOpcionFiltroVARCHAR();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = "LIKE";
										break;

									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 2");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 2) {
										do {
											System.out.print("Introduzca el Nombre del Alumno: ");
											nombre = sc.nextLine();

										} while (nombre == "" | nombre == null);

										FuncionesAlumnos.leerPorNombre(nombre, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										nombre = "";
										filtro = "";
									}
								} while (opcionSubmenuC != 0);
								break; // FIN 3. Por nombre.
							case 4: // 4. Por apellidos.
								do {
									Menu.submenuOpcionFiltroVARCHAR();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = "LIKE";
										break;

									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 2");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 2) {
										do {
											System.out.print("Introduzca los Apellidos del Alumno: ");
											apellidos = sc.nextLine();

										} while (apellidos == "" | apellidos == null);

										FuncionesAlumnos.leerPorApellidos(apellidos, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										apellidos = "";
										filtro = "";
									}
								} while (opcionSubmenuC != 0);
								break; // FIN 4. Por apellidos.
							case 5: // 5. Por fechaNacimiento.
								do {
									Menu.submenuOpcionFiltroNUMBER();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = ">";
										break;
									case 3:
										filtro = "<";
										break;
									case 4:
										filtro = ">=";
										break;
									case 5:
										filtro = "<=";
										break;
									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 5");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 5) {
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Alumno (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Alumno (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Alumno (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											fechaNacimiento = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (fechaNacimiento == null || fechaNacimiento.equals(""));

										try {
											FuncionesAlumnos.leerPorFechaNacimiento(LocalDate.parse(fechaNacimiento),
													filtro);
										} catch (DateTimeException e) {
											System.out.println();
											System.out.print(ColorMio.getRojo());
											System.out
													.print("Fecha de nacimiento '" + fechaNacimiento + "' incorrecta");
											System.out.println(ColorMio.getReset());
											System.out.println();
										} finally {
											opcionSubmenuC = 0;
											opcionSubmenuB = 0;
											opcionSubmenuA = 0;

											fechaDia = 0;
											fechaMes = 0;
											fechaAnnio = 0;

											fechaNacimiento = "";
											filtro = "";
										}
									}
								} while (opcionSubmenuC != 0);
								break; // FIN 5. Por fechaNacimiento.

							case 0: // 0. Volver al Menú anterior.

								break; // FIN 0. Volver al Menú anterior.

							default:
								System.out.print(ColorMio.getRojo());
								System.out.print("Opción no disponible: ");
								System.out.print(ColorMio.getReset());
								System.out.println("Elija del 0 al 5");
								System.out.println();
								break;
							}// FIN switch (opcionSubmenuB)
						} while (opcionSubmenuB != 0);
						break; // FIN 3. Alumnos.

					case 4: // 4. Matriculas.
						do {
							Menu.subMenuObtenerMatriculas();
							opcionSubmenuB = leeInt(sc);
							System.out.println();

							switch (opcionSubmenuB) {
							case 1: // 1. Todas.
								FuncionesMatriculas.leerTodos();
								System.out.println();

								opcionSubmenuB = 0;
								opcionSubmenuA = 0;

								break; // FIN 1. Todas.
							case 2: // 2. Por idMatricula.
								do {
									Menu.submenuOpcionFiltroNUMBER();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = ">";
										break;
									case 3:
										filtro = "<";
										break;
									case 4:
										filtro = ">=";
										break;
									case 5:
										filtro = "<=";
										break;
									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 5");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 5) {
										do {
											System.out.print("Introduzca el ID de la Matricula (> 0): ");
											idMatricula = leeLong(sc);

										} while (idMatricula <= 0);

										FuncionesMatriculas.leerPorId(idMatricula, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idMatricula = -1;
										filtro = "";
									}
								} while (opcionSubmenuC != 0);

								break; // FIN 2. Por idMatricula.
							case 3: // 3. Por Profesor.
								do {
									idsProfesores.clear();
									profesor = null;
									Menu.subMenuObtenerMatriculasPorProfesor();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. Por idProfesor.
										do {
											System.out.print(
													"Introduzca el ID del Profesor correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
											idProfesor = leeLong(sc);

											if (idProfesor != 0) {
												profesor = FuncionesProfesores.getProfesorPorId(idProfesor);

												if (profesor == null) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Profesor con idProfesor = " + idProfesor);
													System.out.print(ColorMio.getReset());
												} else {
													cabecera = " Matricula(s) con Profesor con idProfesor = "
															+ idProfesor + "\t";

													FuncionesMatriculas.leerPorProfesor(profesor, cabecera);

													opcionSubmenuC = 0;
													opcionSubmenuB = 0;
													opcionSubmenuA = 0;

													idProfesor = 0;
													profesor = null;
													cabecera = "";

												}
											} else {
												System.out.println();
											}

										} while (idProfesor != 0 && profesor == null);

										break; // FIN 1. Por idProfesor.
									case 2: // 2. Por nombre.
										do {
											do {
												System.out.print(
														"Introduzca el Nombre del Profesor correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
												nombre = sc.nextLine();
											} while (nombre == null || nombre.equals(""));
											if (!nombre.equals("0")) {
												idsProfesores = FuncionesProfesores.buscaIDsPorColumna("nombre",
														nombre);

												if (idsProfesores.size() > 1) {

													FuncionesProfesores.leerPorNombre(nombre, "=");

													System.out.print(ColorMio.getAmarillo());
													System.out.println("Hay varios Profesores con nombre = " + nombre);
													System.out.print(ColorMio.getReset());

													System.out.print(
															"Introduzca el idProfesor correspondiente, o si lo prefiere, \"0\" para introducir otro Nombre: ");
													idProfesor = leeLong(sc);

													if (idProfesor != 0) {

														if (!idsProfesores.contains(idProfesor)) {
															System.out.print(ColorMio.getRojo());
															System.out.println(
																	"No existe ningún Profesor con idProfesor = "
																			+ idProfesor
																			+ " en la lista anteriormente mostrada");
															System.out.println(ColorMio.getReset());
															nombre = "";
														} else {
															cabecera = " Matricula(s) con Profesor con idProfesor = "
																	+ idProfesor + "\t";
															profesor = FuncionesProfesores.getProfesorPorId(idProfesor);
															FuncionesMatriculas.leerPorProfesor(profesor, cabecera);

															opcionSubmenuC = 0;
															opcionSubmenuB = 0;
															opcionSubmenuA = 0;

															nombre = "";
															idProfesor = 0;
															profesor = null;
															cabecera = "";
														}
													} else {

														System.out.println();
													}
												}

												else if (idsProfesores.size() == 0) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Profesor con nombre = " + nombre);
													System.out.print(ColorMio.getReset());
												} else {
													cabecera = " Matricula(s) con Profesor con nombre = '" + nombre
															+ "'\t";
													profesor = FuncionesProfesores
															.getProfesorPorId(idsProfesores.get(0));
													FuncionesMatriculas.leerPorProfesor(profesor, cabecera);

													opcionSubmenuC = 0;
													opcionSubmenuB = 0;
													opcionSubmenuA = 0;

													nombre = "";
													idProfesor = 0;
													profesor = null;
													cabecera = "";
												}

											}

										} while (!nombre.equals("0") && !nombre.equals("") && profesor == null
												&& !idsProfesores.contains(idProfesor));
										System.out.println();
										break; // FIN 2. Por nombre.
									case 3: // 3. Por apellidos.
										do {
											do {
												System.out.print(
														"Introduzca los Apellidos del Profesor correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
												apellidos = sc.nextLine();
											} while (apellidos == null || apellidos.equals(""));
											if (!apellidos.equals("0")) {
												idsProfesores = FuncionesProfesores.buscaIDsPorColumna("apellidos",
														apellidos);

												if (idsProfesores.size() > 1) {

													FuncionesProfesores.leerPorApellidos(apellidos, "=");

													System.out.print(ColorMio.getAmarillo());
													System.out.println(
															"Hay varios Profesores con apellidos = " + apellidos);
													System.out.print(ColorMio.getReset());

													System.out.print(
															"Introduzca el idProfesor correspondiente, o si lo prefiere, \"0\" para introducir otros Apellidos: ");
													idProfesor = leeLong(sc);

													if (idProfesor != 0) {

														if (!idsProfesores.contains(idProfesor)) {
															System.out.print(ColorMio.getRojo());
															System.out.println(
																	"No existe ningún Profesor con idProfesor = "
																			+ idProfesor
																			+ " en la lista anteriormente mostrada");
															System.out.println(ColorMio.getReset());
															apellidos = "";
														} else {
															cabecera = " Matricula(s) con Profesor con idProfesor = "
																	+ idProfesor + "\t";
															profesor = FuncionesProfesores.getProfesorPorId(idProfesor);
															FuncionesMatriculas.leerPorProfesor(profesor, cabecera);

															opcionSubmenuC = 0;
															opcionSubmenuB = 0;
															opcionSubmenuA = 0;

															apellidos = "";
															idProfesor = 0;
															profesor = null;
															cabecera = "";
														}
													} else {

														System.out.println();
													}
												}

												else if (idsProfesores.size() == 0) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Profesor con apellidos = " + apellidos);
													System.out.print(ColorMio.getReset());
												} else {
													cabecera = " Matricula(s) con Profesor con apellidos = '"
															+ apellidos + "'\t";
													profesor = FuncionesProfesores
															.getProfesorPorId(idsProfesores.get(0));
													FuncionesMatriculas.leerPorProfesor(profesor, cabecera);

													opcionSubmenuC = 0;
													opcionSubmenuB = 0;
													opcionSubmenuA = 0;

													apellidos = "";
													idProfesor = 0;
													profesor = null;
													cabecera = "";
												}

											}

										} while (!apellidos.equals("0") && !apellidos.equals("") && profesor == null
												&& !idsProfesores.contains(idProfesor));
										System.out.println();
										break; // FIN 3. Por apellidos.
									case 4: // 4. Por fechaNacimiento.
										do {
											do {
												do {
													System.out.print(
															"Introduzca el día de FechaNacimiento del Profesor correspondiente (entre 1 y 31): ");
													fechaDia = leeInt(sc);
												} while (fechaDia < 1 || fechaDia > 31);

												do {
													System.out.print(
															"Introduzca el mes de FechaNacimiento del Profesor correspondiente (entre 1 y 12): ");
													fechaMes = leeInt(sc);
												} while (fechaMes < 1 || fechaMes > 12);

												do {
													System.out.print(
															"Introduzca el año de FechaNacimiento del Profesor correspondiente (>= 1000 y <= año actual): ");
													fechaAnnio = leeInt(sc);
												} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

												fechaNacimiento = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
														fechaDia);

											} while (fechaNacimiento == null || fechaNacimiento.equals(""));

											idsProfesores = FuncionesProfesores.buscaIDsPorColumna("fechaNacimiento",
													fechaNacimiento);

											if (idsProfesores.size() > 1) {

												FuncionesProfesores
														.leerPorFechaNacimiento(LocalDate.parse(fechaNacimiento), "=");

												System.out.print(ColorMio.getAmarillo());
												System.out.println("Hay varios Profesores con fechaNacimiento = "
														+ fechaNacimiento);
												System.out.print(ColorMio.getReset());

												System.out.print(
														"Introduzca el idProfesor de la Matricula, o si lo prefiere, \"0\" para introducir otra FechaNacimiento: ");
												idProfesor = leeLong(sc);

												if (idProfesor != 0) {

													if (!idsProfesores.contains(idProfesor)) {
														System.out.print(ColorMio.getRojo());
														System.out.println("No existe ningún Profesor con idProfesor = "
																+ idProfesor + " en la lista anteriormente mostrada");
														System.out.print(ColorMio.getReset());
														// fechaNacimiento = "";
													} else {
														cabecera = " Matricula(s) con Profesor con idProfesor = "
																+ idProfesor + "\t";
														profesor = FuncionesProfesores.getProfesorPorId(idProfesor);
														FuncionesMatriculas.leerPorProfesor(profesor, cabecera);

														opcionSubmenuC = 0;
														opcionSubmenuB = 0;
														opcionSubmenuA = 0;

														// fechaNacimiento = "";
														idProfesor = 0;
														profesor = null;
														cabecera = "";

													}
												} else {
													fechaNacimiento = "";
													System.out.println();
												}
											}

											else if (idsProfesores.size() == 0) {
												System.out.print(ColorMio.getRojo());
												System.out.println("No existe ningún Profesor con fechaNacimiento = "
														+ fechaNacimiento);
												System.out.print(ColorMio.getReset());
												System.out.println(
														"¿Quiere introducir una FechaNacimiento de nuevo? (s/n)");
												if (sc.nextLine().equals("s")) {
													fechaNacimiento = "";

												}

											} else {
												cabecera = " Matricula(s) con Profesor con fechaNacimiento = '"
														+ fechaNacimiento + "'\t";
												profesor = FuncionesProfesores.getProfesorPorId(idsProfesores.get(0));
												FuncionesMatriculas.leerPorProfesor(profesor, cabecera);

												opcionSubmenuC = 0;
												opcionSubmenuB = 0;
												opcionSubmenuA = 0;

												// fechaNacimiento = "";
												idProfesor = -1;
												profesor = null;
												cabecera = "";

											}

										} while (fechaNacimiento.equals("")
												&& (profesor == null && !idsProfesores.contains(idProfesor)));
										System.out.println();
										break; // FIN 4. Por fechaNacimiento.
									case 5: // 5. Por antiguedad.
										do {
											do {
												System.out.print(
														"Introduzca la Antiguedad del Profesor correspondiente (>= 0), o si lo prefiere, \"-1\" para volver al Menú anterior: ");
												antiguedad = leeInt(sc);
											} while (antiguedad < 0 && antiguedad != -1);

											if (antiguedad != -1) {
												idsProfesores = FuncionesProfesores.buscaIDsPorColumna("antiguedad",
														String.valueOf(antiguedad));

												if (idsProfesores.size() > 1) {

													FuncionesProfesores.leerPorAntiguedad(antiguedad, "=");

													System.out.print(ColorMio.getAmarillo());
													System.out.println(
															"Hay varios Profesores con antiguedad = " + antiguedad);
													System.out.print(ColorMio.getReset());

													System.out.print(
															"Introduzca el idProfesor de la Matricula, o si lo prefiere, \"0\" para introducir otra Antiguedad: ");
													idProfesor = leeLong(sc);

													if (idProfesor != 0) {

														if (!idsProfesores.contains(idProfesor)) {
															System.out.print(ColorMio.getRojo());
															System.out.println(
																	"No existe ningún Profesor con idProfesor = "
																			+ idProfesor
																			+ " en la lista anteriormente mostrada");
															System.out.print(ColorMio.getReset());
															antiguedad = -1;
														} else {
															cabecera = " Matricula(s) con Profesor con idProfesor = "
																	+ idProfesor + "\t";
															profesor = FuncionesProfesores.getProfesorPorId(idProfesor);
															FuncionesMatriculas.leerPorProfesor(profesor, cabecera);

															opcionSubmenuC = 0;
															opcionSubmenuB = 0;
															opcionSubmenuA = 0;

															antiguedad = -1;
															idProfesor = -1;
															profesor = null;
															cabecera = "";

														}
													} else {
														System.out.println();
													}
												}

												else if (idsProfesores.size() == 0) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Profesor con antiguedad = " + antiguedad);
													System.out.print(ColorMio.getReset());
												} else {
													cabecera = " Matricula(s) con Profesor con antiguedad = '"
															+ antiguedad + "'\t";
													profesor = FuncionesProfesores
															.getProfesorPorId(idsProfesores.get(0));
													FuncionesMatriculas.leerPorProfesor(profesor, cabecera);

													opcionSubmenuC = 0;
													opcionSubmenuB = 0;
													opcionSubmenuA = 0;

													antiguedad = -1;
													idProfesor = -1;
													profesor = null;
													cabecera = "";

												}

											}

										} while (antiguedad != -1 && profesor == null
												&& !idsProfesores.contains(idProfesor));
										System.out.println();
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
								} while (opcionSubmenuC != 0);

								break; // FIN 3. Por Profesor.
							case 4: // 4. Por Alumno.
								do {
									idsAlumnos.clear();
									alumno = null;
									Menu.subMenuObtenerMatriculasPorAlumno();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. Por idAlumno.
										do {
											System.out.print(
													"Introduzca el ID del Alumno correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
											idAlumno = leeLong(sc);

											if (idAlumno != 0) {
												alumno = FuncionesAlumnos.getAlumnoPorId(idAlumno);

												if (alumno == null) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Alumno con idAlumno = " + idAlumno);
													System.out.print(ColorMio.getReset());
												} else {
													cabecera = " Matricula(s) con Alumno con idAlumno = " + idAlumno
															+ "\t";

													FuncionesMatriculas.leerPorAlumno(alumno, cabecera);

													opcionSubmenuC = 0;
													opcionSubmenuB = 0;
													opcionSubmenuA = 0;

													idAlumno = 0;
													alumno = null;
													cabecera = "";

												}
											} else {
												System.out.println();
											}

										} while (idAlumno != 0 && alumno == null);

										break; // FIN 1. Por idAlumno.
									case 2: // 2. Por nombre.
										do {
											do {
												System.out.print(
														"Introduzca el Nombre del Alumno correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
												nombre = sc.nextLine();
											} while (nombre == null || nombre.equals(""));
											if (!nombre.equals("0")) {
												idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna("nombre", nombre);

												if (idsAlumnos.size() > 1) {

													FuncionesAlumnos.leerPorNombre(nombre, "=");

													System.out.print(ColorMio.getAmarillo());
													System.out.println("Hay varios Alumnos con nombre = " + nombre);
													System.out.print(ColorMio.getReset());

													System.out.print(
															"Introduzca el idAlumno correspondiente, o si lo prefiere, \"0\" para introducir otro Nombre: ");
													idAlumno = leeLong(sc);

													if (idAlumno != 0) {

														if (!idsAlumnos.contains(idAlumno)) {
															System.out.print(ColorMio.getRojo());
															System.out.println("No existe ningún Alumno con idAlumno = "
																	+ idAlumno + " en la lista anteriormente mostrada");
															System.out.println(ColorMio.getReset());
															nombre = "";
														} else {
															cabecera = " Matricula(s) con Alumno con idAlumno = "
																	+ idAlumno + "\t";
															alumno = FuncionesAlumnos.getAlumnoPorId(idAlumno);
															FuncionesMatriculas.leerPorAlumno(alumno, cabecera);

															opcionSubmenuC = 0;
															opcionSubmenuB = 0;
															opcionSubmenuA = 0;

															nombre = "";
															idAlumno = -1;
															alumno = null;
															cabecera = "";
														}
													} else {

														System.out.println();
													}
												}

												else if (idsAlumnos.size() == 0) {
													System.out.print(ColorMio.getRojo());
													System.out
															.println("No existe ningún Alumno con nombre = " + nombre);
													System.out.print(ColorMio.getReset());
												} else {
													cabecera = " Matricula(s) con Alumno con nombre = '" + nombre
															+ "'\t";
													alumno = FuncionesAlumnos.getAlumnoPorId(idsAlumnos.get(0));
													FuncionesMatriculas.leerPorAlumno(alumno, cabecera);

													opcionSubmenuC = 0;
													opcionSubmenuB = 0;
													opcionSubmenuA = 0;

													nombre = "";
													idAlumno = -1;
													alumno = null;
													cabecera = "";
												}

											}

										} while (!nombre.equals("0") && !nombre.equals("") && alumno == null
												&& !idsAlumnos.contains(idAlumno));
										System.out.println();
										break; // FIN 2. Por nombre.
									case 3: // 3. Por apellidos.
										do {
											do {
												System.out.print(
														"Introduzca los Apellidos del Alumno correspondiente, o si lo prefiere, \"0\" para volver al Menú anterior: ");
												apellidos = sc.nextLine();
											} while (apellidos == null || apellidos.equals(""));
											if (!apellidos.equals("0")) {
												idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna("apellidos",
														apellidos);

												if (idsAlumnos.size() > 1) {

													FuncionesAlumnos.leerPorApellidos(apellidos, "=");

													System.out.print(ColorMio.getAmarillo());
													System.out
															.println("Hay varios Alumnos con apellidos = " + apellidos);
													System.out.print(ColorMio.getReset());

													System.out.print(
															"Introduzca el idAlumno correspondiente, o si lo prefiere, \"0\" para introducir otros Apellidos: ");
													idAlumno = leeLong(sc);

													if (idAlumno != 0) {

														if (!idsAlumnos.contains(idAlumno)) {
															System.out.print(ColorMio.getRojo());
															System.out.println("No existe ningún Alumno con idAlumno = "
																	+ idAlumno + " en la lista anteriormente mostrada");
															System.out.println(ColorMio.getReset());
															apellidos = "";
														} else {
															cabecera = " Matricula(s) con Alumno con idAlumno = "
																	+ idAlumno + "\t";
															alumno = FuncionesAlumnos.getAlumnoPorId(idAlumno);
															FuncionesMatriculas.leerPorAlumno(alumno, cabecera);

															opcionSubmenuC = 0;
															opcionSubmenuB = 0;
															opcionSubmenuA = 0;

															apellidos = "";
															idAlumno = -1;
															alumno = null;
															cabecera = "";
														}
													} else {

														System.out.println();
													}
												}

												else if (idsAlumnos.size() == 0) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Alumno con apellidos = " + apellidos);
													System.out.print(ColorMio.getReset());
												} else {
													cabecera = " Matricula(s) con Alumno con apellidos = '" + apellidos
															+ "'\t";
													alumno = FuncionesAlumnos.getAlumnoPorId(idsAlumnos.get(0));
													FuncionesMatriculas.leerPorAlumno(alumno, cabecera);

													opcionSubmenuC = 0;
													opcionSubmenuB = 0;
													opcionSubmenuA = 0;

													apellidos = "";
													idAlumno = -1;
													alumno = null;
													cabecera = "";
												}

											}

										} while (!apellidos.equals("0") && !apellidos.equals("") && alumno == null
												&& !idsAlumnos.contains(idAlumno));
										System.out.println();
										break; // FIN 3. Por apellidos.
									case 4: // 4. Por fechaNacimiento.
										do {
											do {
												do {
													System.out.print(
															"Introduzca el día de FechaNacimiento del Alumno correspondiente (entre 1 y 31): ");
													fechaDia = leeInt(sc);
												} while (fechaDia < 1 || fechaDia > 31);

												do {
													System.out.print(
															"Introduzca el mes de FechaNacimiento del Alumno correspondiente (entre 1 y 12): ");
													fechaMes = leeInt(sc);
												} while (fechaMes < 1 || fechaMes > 12);

												do {
													System.out.print(
															"Introduzca el año de FechaNacimiento del Alumno correspondiente (>= 1000 y <= año actual): ");
													fechaAnnio = leeInt(sc);
												} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

												fechaNacimiento = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
														fechaDia);

											} while (fechaNacimiento == null || fechaNacimiento.equals(""));

											idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna("fechaNacimiento",
													fechaNacimiento);

											if (idsAlumnos.size() > 1) {

												FuncionesAlumnos
														.leerPorFechaNacimiento(LocalDate.parse(fechaNacimiento), "=");

												System.out.print(ColorMio.getAmarillo());
												System.out.println(
														"Hay varios Alumnos con fechaNacimiento = " + fechaNacimiento);
												System.out.print(ColorMio.getReset());

												System.out.print(
														"Introduzca el idAlumno de la Matricula, o si lo prefiere, \"0\" para introducir otra FechaNacimiento: ");
												idAlumno = leeLong(sc);

												if (idAlumno != 0) {

													if (!idsAlumnos.contains(idAlumno)) {
														System.out.print(ColorMio.getRojo());
														System.out.println("No existe ningún Alumno con idAlumno = "
																+ idAlumno + " en la lista anteriormente mostrada");
														System.out.print(ColorMio.getReset());
														// fechaNacimiento = "";
													} else {
														cabecera = " Matricula(s) con Alumno con idAlumno = " + idAlumno
																+ "\t";
														alumno = FuncionesAlumnos.getAlumnoPorId(idAlumno);
														FuncionesMatriculas.leerPorAlumno(alumno, cabecera);

														opcionSubmenuC = 0;
														opcionSubmenuB = 0;
														opcionSubmenuA = 0;

														// fechaNacimiento = "";
														idAlumno = -1;
														alumno = null;
														cabecera = "";

													}
												} else {
													fechaNacimiento = "";
													System.out.println();
												}
											}

											else if (idsAlumnos.size() == 0) {
												System.out.print(ColorMio.getRojo());
												System.out.println("No existe ningún Alumno con fechaNacimiento = "
														+ fechaNacimiento);
												System.out.print(ColorMio.getReset());
												System.out.println(
														"¿Quiere introducir una FechaNacimiento de nuevo? (s/n)");
												if (sc.nextLine().equals("s")) {
													fechaNacimiento = "";

												}

											} else {
												cabecera = " Matricula(s) con Alumno con fechaNacimiento = '"
														+ fechaNacimiento + "'\t";
												alumno = FuncionesAlumnos.getAlumnoPorId(idsAlumnos.get(0));
												FuncionesMatriculas.leerPorAlumno(alumno, cabecera);

												opcionSubmenuC = 0;
												opcionSubmenuB = 0;
												opcionSubmenuA = 0;

												// fechaNacimiento = "";
												idAlumno = -1;
												alumno = null;
												cabecera = "";

											}

										} while (fechaNacimiento.equals("")
												&& (alumno == null && !idsAlumnos.contains(idAlumno)));
										System.out.println();
										break; // FIN 4. Por fechaNacimiento.

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
								} while (opcionSubmenuC != 0);
								break; // FIN 4. Por Alumno.
							case 5: // 5. Por asignatura.
								do {
									Menu.submenuOpcionFiltroVARCHAR();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = "LIKE";
										break;

									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 2");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 2) {
										do {
											System.out.print("Introduzca la Asignatura de la Matricula: ");
											asignatura = sc.nextLine();

										} while (asignatura == "" | asignatura == null);

										FuncionesMatriculas.leerPorAsignatura(asignatura, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										asignatura = "";
										filtro = "";
									}
								} while (opcionSubmenuC != 0);
								break; // FIN 5. Por asignatura.
							case 6: // 6. Por curso.
								do {
									Menu.submenuOpcionFiltroNUMBER();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1:
										filtro = "=";
										break;
									case 2:
										filtro = ">";
										break;
									case 3:
										filtro = "<";
										break;
									case 4:
										filtro = ">=";
										break;
									case 5:
										filtro = "<=";
										break;
									case 0:

										break;

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 5");
										System.out.println();
										break;
									}// FIN switch (opcionSubmenuC)
									if (opcionSubmenuC > 0 && opcionSubmenuC <= 5) {
										do {
											System.out.print("Introduzca el curso de la Matricula (>= 0): ");
											curso = leeInt(sc);

										} while (curso < 0);

										FuncionesMatriculas.leerPorCurso(curso, filtro);

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										curso = -1;
										filtro = "";
									}
								} while (opcionSubmenuC != 0);
								break; // FIN 6. Por curso.
							case 0: // 0. Volver al Menú anterior.
								break; // FIN 0. Volver al Menú anterior.
							default:
								System.out.print(ColorMio.getRojo());
								System.out.print("Opción no disponible: ");
								System.out.print(ColorMio.getReset());
								System.out.println("Elija del 0 al 6");
								System.out.println();
								break;
							}// FIN switch (opcionSubmenuB)

						} while (opcionSubmenuB != 0);

						break; // FIN 4. Matriculas.

					case 0: // 0. Volver al Menú anterior.

						break; // FIN 0. Volver al Menú anterior.

					default:
						System.out.print(ColorMio.getRojo());
						System.out.print("Opción no disponible: ");
						System.out.print(ColorMio.getReset());
						System.out.println("Elija del 0 al 4");
						System.out.println();
						break;
					}// FIN switch (opcionSubmenuA)

				} while (opcionSubmenuA != 0);
				// opcionMenu = -1;
				break; // FIN 2. Obtener datos.
			case 3: // 3. Actualizar Datos.
				do {
					Menu.subMenuActualizarDatos();
					opcionSubmenuA = leeInt(sc);
					System.out.println();

					switch (opcionSubmenuA) {
					case 1: // 1. Profesores.
						do {
							Menu.subMenuElegirProfesorActualizar();
							opcionSubmenuB = leeInt(sc);
							System.out.println();

							switch (opcionSubmenuB) {
							case 1: // 1. Por idProfesor.

								do {
									System.out.print("Introduzca el ID del Profesor que quiera Actualizar (> 0): ");
									idDeCambio = leeLong(sc);
								} while (idDeCambio <= 0);

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarProfesor();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. nombre.
										columnaCambiada = "nombre";
										do {
											System.out.print("Introduzca el nuevo Nombre del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. nombre.
									case 2: // 2. apellidos.
										columnaCambiada = "apellidos";
										do {
											System.out.print("Introduzca los nuevos Apellidos del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 2. apellidos.
									case 3: // 3. fechaNacimiento.
										columnaCambiada = "fechaNacimiento";
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Profesor (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Profesor (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Profesor (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											datoCambiado = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // fechaNacimiento.
									case 4: // 4. antiguedad.
										columnaCambiada = "antiguedad";
										do {
											System.out.print("Introduzca la nueva Antiguedad del Profesor (>= 0): ");
											antiguedad = leeInt(sc);
											if (antiguedad >= 0) {
												datoCambiado = String.valueOf(antiguedad);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. antiguedad.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();

									if (opcionSubmenuC != 0) {
										try {
											if (FuncionesProfesores.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado)) {
												System.out.print(ColorMio.getVerde());
												System.out.print("Profesor con ID = " + idDeCambio + " tiene ahora "
														+ columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();
											} else {
												System.out.print(ColorMio.getRojo());
												System.out.print("No existe ningún Profesor con ID = " + idDeCambio);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}
										} catch (DateTimeException e) {
											System.out.print(ColorMio.getRojo());
											System.out.print("Fecha '" + datoCambiado + "' incorrecta");
											System.out.println(ColorMio.getReset());
										}

										System.out.println();
									}

									opcionSubmenuC = 0;
									opcionSubmenuB = 0;
									opcionSubmenuA = 0;

									idDeCambio = -1;

									antiguedad = -1;

									columnaCambiada = "";
									datoCambiado = "";

									fechaDia = 0;
									fechaMes = 0;
									fechaAnnio = 0;

								} while (opcionSubmenuC != 0);

								break; // FIN 1. Por idProfesor.
							case 2: // 2. Por nombre.
								do {
									System.out.print("Introduzca el Nombre del Profesor que quiera Actualizar: ");
									datoDeCambio = sc.nextLine();
								} while (datoDeCambio == "" || datoDeCambio == null);

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarProfesor();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. nombre.
										columnaCambiada = "nombre";
										do {
											System.out.print("Introduzca el nuevo Nombre del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. nombre.
									case 2: // 2. apellidos.
										columnaCambiada = "apellidos";
										do {
											System.out.print("Introduzca los nuevos Apellidos del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 2. apellidos.
									case 3: // 3. fechaNacimiento.
										columnaCambiada = "fechaNacimiento";
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Profesor (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Profesor (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Profesor (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											datoCambiado = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // fechaNacimiento.
									case 4: // 4. antiguedad.
										columnaCambiada = "antiguedad";
										do {
											System.out.print("Introduzca la nueva Antiguedad del Profesor (>= 0): ");
											antiguedad = leeInt(sc);
											if (antiguedad >= 0) {
												datoCambiado = String.valueOf(antiguedad);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. antiguedad.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();

									idsProfesores.clear();

									if (opcionSubmenuC != 0) {
										idsProfesores = FuncionesProfesores.buscaIDsPorColumna("nombre", datoDeCambio);

										if (idsProfesores.size() > 1) {

											FuncionesProfesores.leerPorNombre(datoDeCambio, "=");

											System.out.print(ColorMio.getAmarillo());
											System.out.println(

													"Hay varios Profesores con nombre = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println(
													"Escriba el idProfesor del Profesor que desea modificar, o si lo prefiere, \"0\" para modificar a todos estos:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {

												if (idsProfesores.contains(idDeCambio) && FuncionesProfesores
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
													System.out.print(ColorMio.getVerde());
													System.out.print("Profesor con ID = " + idDeCambio + " tiene ahora "
															+ columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Profesor con ID = " + idDeCambio
															+ " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();

												}
											} else {
												for (Long id : idsProfesores) {
													FuncionesProfesores.actualizarPorId(id, columnaCambiada,
															datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todos los Profesores con nombre = " + datoDeCambio
														+ " tienen ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsProfesores.size() == 1) {
											idDeCambio = idsProfesores.get(0);

											FuncionesProfesores.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado);

											System.out.print(ColorMio.getVerde());
											System.out.print("Profesor con nombre = " + datoDeCambio + " tiene ahora "
													+ columnaCambiada + " = " + datoCambiado);
											System.out.print(ColorMio.getReset());
											System.out.println();

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print("No existe ningún Profesor con nombre = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsProfesores.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;

										antiguedad = -1;

										columnaCambiada = "";
										datoCambiado = "";

										fechaDia = 0;
										fechaMes = 0;
										fechaAnnio = 0;
									}
									System.out.println();
								} while (opcionSubmenuC != 0);
								break; // FIN 2. Por nombre.
							case 3: // 3. Por apellidos.
								do {
									System.out.print("Introduzca los Apellidos del Profesor que quiera Actualizar: ");
									datoDeCambio = sc.nextLine();
								} while (datoDeCambio == "" || datoDeCambio == null);

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarProfesor();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. nombre.
										columnaCambiada = "nombre";
										do {
											System.out.print("Introduzca el nuevo Nombre del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. nombre.
									case 2: // 2. apellidos.
										columnaCambiada = "apellidos";
										do {
											System.out.print("Introduzca los nuevos Apellidos del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 2. apellidos.
									case 3: // 3. fechaNacimiento.
										columnaCambiada = "fechaNacimiento";
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Profesor (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Profesor (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Profesor (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											datoCambiado = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // fechaNacimiento.
									case 4: // 4. antiguedad.
										columnaCambiada = "antiguedad";
										do {
											System.out.print("Introduzca la nueva Antiguedad del Profesor (>= 0): ");
											antiguedad = leeInt(sc);
											if (antiguedad >= 0) {
												datoCambiado = String.valueOf(antiguedad);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. antiguedad.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();

									idsProfesores.clear();

									if (opcionSubmenuC != 0) {
										idsProfesores = FuncionesProfesores.buscaIDsPorColumna("apellidos",
												datoDeCambio);

										if (idsProfesores.size() > 1) {

											FuncionesProfesores.leerPorApellidos(datoDeCambio, "=");

											System.out.print(ColorMio.getAmarillo());
											System.out.println(

													"Hay varios Profesores con apellidos = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println(
													"Escriba el idProfesor del Profesor que desea modificar, o si lo prefiere, \"0\" para modificar a todos estos:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {

												if (idsProfesores.contains(idDeCambio) && FuncionesProfesores
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
													System.out.print(ColorMio.getVerde());
													System.out.print("Profesor con ID = " + idDeCambio + " tiene ahora "
															+ columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Profesor con ID = " + idDeCambio
															+ " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();

												}
											} else {
												for (Long id : idsProfesores) {
													FuncionesProfesores.actualizarPorId(id, columnaCambiada,
															datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todos los Profesores con apellidos = " + datoDeCambio
														+ " tienen ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsProfesores.size() == 1) {
											idDeCambio = idsProfesores.get(0);

											FuncionesProfesores.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado);

											System.out.print(ColorMio.getVerde());
											System.out.print("Profesor con apellidos = " + datoDeCambio
													+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
											System.out.print(ColorMio.getReset());
											System.out.println();

										} else {
											System.out.print(ColorMio.getRojo());
											System.out
													.print("No existe ningún Profesor con apellidos = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsProfesores.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;

										antiguedad = -1;

										columnaCambiada = "";
										datoCambiado = "";

										fechaDia = 0;
										fechaMes = 0;
										fechaAnnio = 0;
									}
									System.out.println();
								} while (opcionSubmenuC != 0);
								break; // FIN 3. Por apellidos.
							case 4: // 4. Por fechaNacimiento.
								do {
									do {
										System.out.print(
												"Introduzca el día de FechaNacimiento del Profesor que quiera Actualizar (entre 1 y 31): ");
										fechaDia = leeInt(sc);
									} while (fechaDia < 1 || fechaDia > 31);

									do {
										System.out.print(
												"Introduzca el mes de FechaNacimiento del Profesor que quiera Actualizar (entre 1 y 12): ");
										fechaMes = leeInt(sc);
									} while (fechaMes < 1 || fechaMes > 12);

									do {
										System.out.print(
												"Introduzca el año de FechaNacimiento del Profesor que quiera Actualizar (>= 1000 y <= año actual): ");
										fechaAnnio = leeInt(sc);
									} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

									datoDeCambio = String.format("%d-%02d-%02d", fechaAnnio, fechaMes, fechaDia);
								} while (datoDeCambio == null || datoDeCambio.equals(""));

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarProfesor();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. nombre.
										columnaCambiada = "nombre";
										do {
											System.out.print("Introduzca el nuevo Nombre del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. nombre.
									case 2: // 2. apellidos.
										columnaCambiada = "apellidos";
										do {
											System.out.print("Introduzca los nuevos Apellidos del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 2. apellidos.
									case 3: // 3. fechaNacimiento.
										columnaCambiada = "fechaNacimiento";
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Profesor (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Profesor (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Profesor (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											datoCambiado = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // fechaNacimiento.
									case 4: // 4. antiguedad.
										columnaCambiada = "antiguedad";
										do {
											System.out.print("Introduzca la nueva Antiguedad del Profesor (>= 0): ");
											antiguedad = leeInt(sc);
											if (antiguedad >= 0) {
												datoCambiado = String.valueOf(antiguedad);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. antiguedad.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();

									idsProfesores.clear();

									if (opcionSubmenuC != 0) {
										idsProfesores = FuncionesProfesores.buscaIDsPorColumna("fechaNacimiento",
												datoDeCambio);

										if (idsProfesores.size() > 1) {

											FuncionesProfesores.leerPorFechaNacimiento(LocalDate.parse(datoDeCambio),
													"=");

//												case "apellidos":
//													FuncionesProfesores.leerPorApellidos(datoDeCambio, "=");
//													break;
//								
//												case "fechaNacimiento":
//													FuncionesProfesores.leerPorFechaNacimiento(LocalDate.parse(datoDeCambio), "=");
//													;
//													break;
//												case "antiguedad":
//													FuncionesProfesores.leerPorAntiguedad(Integer.parseInt(datoDeCambio), "=");
//													;
//													break;
//								
//												default:
//													break;
//												}
											System.out.print(ColorMio.getAmarillo());
											System.out.println(

													"Hay varios Profesores con fechaNacimiento = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println(
													"Escriba el idProfesor del Profesor que desea modificar, o si lo prefiere, \"0\" para modificar a todos estos:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {

												if (idsProfesores.contains(idDeCambio) && FuncionesProfesores
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
													System.out.print(ColorMio.getVerde());
													System.out.print("Profesor con ID = " + idDeCambio + " tiene ahora "
															+ columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Profesor con ID = " + idDeCambio
															+ " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();

												}
											} else {
												for (Long id : idsProfesores) {
													FuncionesProfesores.actualizarPorId(id, columnaCambiada,
															datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todos los Profesores con fechaNacimiento = "
														+ datoDeCambio + " tienen ahora " + columnaCambiada + " = "
														+ datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsProfesores.size() == 1) {
											idDeCambio = idsProfesores.get(0);

											FuncionesProfesores.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado);

											System.out.print(ColorMio.getVerde());
											System.out.print("Profesor con fechaNacimiento = " + datoDeCambio
													+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
											System.out.print(ColorMio.getReset());
											System.out.println();

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print(
													"No existe ningún Profesor con fechaNacimiento = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsProfesores.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;

										antiguedad = -1;

										columnaCambiada = "";
										datoCambiado = "";

										fechaDia = 0;
										fechaMes = 0;
										fechaAnnio = 0;
									}
									System.out.println();
								} while (opcionSubmenuC != 0);
								break; // FIN 4. Por fechaNacimiento.
							case 5: // 5. Por antiguedad.

								do {
									System.out.print(
											"Introduzca la antiguedad del Profesor que quiera Actualizar (>=0): ");
									antiguedad = leeInt(sc);
									if (antiguedad >= 0) {
										datoDeCambio = String.valueOf(antiguedad);
									}
								} while (datoDeCambio == null || datoDeCambio.equals(""));

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarProfesor();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. nombre.
										columnaCambiada = "nombre";
										do {
											System.out.print("Introduzca el nuevo Nombre del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. nombre.
									case 2: // 2. apellidos.
										columnaCambiada = "apellidos";
										do {
											System.out.print("Introduzca los nuevos Apellidos del Profesor: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 2. apellidos.
									case 3: // 3. fechaNacimiento.
										columnaCambiada = "fechaNacimiento";
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Profesor (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Profesor (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Profesor (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											datoCambiado = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // fechaNacimiento.
									case 4: // 4. antiguedad.
										columnaCambiada = "antiguedad";
										do {
											System.out.print("Introduzca la nueva Antiguedad del Profesor (>= 0): ");
											antiguedad = leeInt(sc);
											if (antiguedad >= 0) {
												datoCambiado = String.valueOf(antiguedad);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. antiguedad.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();

									idsProfesores.clear();

									if (opcionSubmenuC != 0) {
										idsProfesores = FuncionesProfesores.buscaIDsPorColumna("antiguedad",
												datoDeCambio);

										if (idsProfesores.size() > 1) {

											FuncionesProfesores.leerPorAntiguedad(Integer.parseInt(datoDeCambio), "=");

											System.out.print(ColorMio.getAmarillo());
											System.out.println(

													"Hay varios Profesores con antiguedad = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println(
													"Escriba el idProfesor del Profesor que desea modificar, o si lo prefiere, \"0\" para modificar a todos estos:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {

												if (idsProfesores.contains(idDeCambio) && FuncionesProfesores
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
													System.out.print(ColorMio.getVerde());
													System.out.print("Profesor con ID = " + idDeCambio + " tiene ahora "
															+ columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Profesor con ID = " + idDeCambio
															+ " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();

												}
											} else {
												for (Long id : idsProfesores) {
													FuncionesProfesores.actualizarPorId(id, columnaCambiada,
															datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todos los Profesores con antiguedad = " + datoDeCambio
														+ " tienen ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsProfesores.size() == 1) {
											idDeCambio = idsProfesores.get(0);

											FuncionesProfesores.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado);

											System.out.print(ColorMio.getVerde());
											System.out.print("Profesor con antiguedad = " + datoDeCambio
													+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
											System.out.print(ColorMio.getReset());
											System.out.println();

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print(
													"No existe ningún Profesor con antiguedad = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsProfesores.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;

										antiguedad = -1;

										columnaCambiada = "";
										datoCambiado = "";

										fechaDia = 0;
										fechaMes = 0;
										fechaAnnio = 0;
									}
									System.out.println();
								} while (opcionSubmenuC != 0);
								break; // FIN 5. Por antiguedad.
							case 0: // 0. Volver al Menú anterior.

								break; // FIN 0. Volver al Menú anterior.

							default:
								System.out.print(ColorMio.getRojo());
								System.out.print("Opción no disponible: ");
								System.out.print(ColorMio.getReset());
								System.out.println("Elija del 0 al 5");
								System.out.println();
								break;
							}
						} while (opcionSubmenuB != 0);

						break; // FIN 1. Profesores.
					case 2: // 2. Alumnos.
						do {
							Menu.subMenuElegirAlumnoActualizar();
							opcionSubmenuB = leeInt(sc);
							System.out.println();

							switch (opcionSubmenuB) {
							case 1: // 1. Por idAlumno.

								do {
									System.out.print("Introduzca el ID del Alumno que quiera Actualizar (> 0): ");
									idDeCambio = leeLong(sc);
								} while (idDeCambio <= 0);

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarAlumno();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. nombre.
										columnaCambiada = "nombre";
										do {
											System.out.print("Introduzca el nuevo Nombre del Alumno: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. nombre.
									case 2: // 2. apellidos.
										columnaCambiada = "apellidos";
										do {
											System.out.print("Introduzca los nuevos Apellidos del Alumno: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 2. apellidos.
									case 3: // 3. fechaNacimiento.
										columnaCambiada = "fechaNacimiento";
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Alumno (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Alumno (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Alumno (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											datoCambiado = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // fechaNacimiento.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 3");
										System.out.println();
										break;
									}

									System.out.println();

									if (opcionSubmenuC != 0) {
										try {
											if (FuncionesAlumnos.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado)) {
												System.out.print(ColorMio.getVerde());
												System.out.print("Alumno con ID = " + idDeCambio + " tiene ahora "
														+ columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();
											} else {
												System.out.print(ColorMio.getRojo());
												System.out.print("No existe ningún Alumno con ID = " + idDeCambio);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}
										} catch (DateTimeException e) {
											System.out.print(ColorMio.getRojo());
											System.out.print("Fecha '" + datoCambiado + "' incorrecta");
											System.out.println(ColorMio.getReset());
										}

										System.out.println();
									}

									opcionSubmenuC = 0;
									opcionSubmenuB = 0;
									opcionSubmenuA = 0;

									idDeCambio = -1;

									columnaCambiada = "";
									datoCambiado = "";

									fechaDia = 0;
									fechaMes = 0;
									fechaAnnio = 0;

								} while (opcionSubmenuC != 0);

								break; // FIN 1. Por idAlumno.
							case 2: // 2. Por nombre.
								do {
									System.out.print("Introduzca el Nombre del Alumno que quiera Actualizar: ");
									datoDeCambio = sc.nextLine();
								} while (datoDeCambio == "" || datoDeCambio == null);

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarAlumno();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. nombre.
										columnaCambiada = "nombre";
										do {
											System.out.print("Introduzca el nuevo Nombre del Alumno: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. nombre.
									case 2: // 2. apellidos.
										columnaCambiada = "apellidos";
										do {
											System.out.print("Introduzca los nuevos Apellidos del Alumno: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 2. apellidos.
									case 3: // 3. fechaNacimiento.
										columnaCambiada = "fechaNacimiento";
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Alumno (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Alumno (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Alumno (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											datoCambiado = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // fechaNacimiento.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 3");
										System.out.println();
										break;
									}

									System.out.println();

									idsAlumnos.clear();

									if (opcionSubmenuC != 0) {
										idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna("nombre", datoDeCambio);

										if (idsAlumnos.size() > 1) {

											FuncionesAlumnos.leerPorNombre(datoDeCambio, "=");

											System.out.print(ColorMio.getAmarillo());
											System.out.println("Hay varios Alumnos con nombre = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println(
													"Escriba el idAlumno del Alumno que desea modificar, o si lo prefiere, \"0\" para modificar a todos estos:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {

												if (idsAlumnos.contains(idDeCambio) && FuncionesAlumnos
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
													System.out.print(ColorMio.getVerde());
													System.out.print("Alumno con ID = " + idDeCambio + " tiene ahora "
															+ columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Alumno con ID = " + idDeCambio
															+ " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();

												}
											} else {
												for (Long id : idsAlumnos) {
													FuncionesAlumnos.actualizarPorId(id, columnaCambiada, datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todos los Alumnos con nombre = " + datoDeCambio
														+ " tienen ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsAlumnos.size() == 1) {
											idDeCambio = idsAlumnos.get(0);

											FuncionesAlumnos.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado);

											System.out.print(ColorMio.getVerde());
											System.out.print("Alumno con nombre = " + datoDeCambio + " tiene ahora "
													+ columnaCambiada + " = " + datoCambiado);
											System.out.print(ColorMio.getReset());
											System.out.println();

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print("No existe ningún Alumno con nombre = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsAlumnos.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;

										antiguedad = -1;

										columnaCambiada = "";
										datoCambiado = "";

										fechaDia = 0;
										fechaMes = 0;
										fechaAnnio = 0;
									}
									System.out.println();
								} while (opcionSubmenuC != 0);
								break; // FIN 2. Por nombre.
							case 3: // 3. Por apellidos.
								do {
									System.out.print("Introduzca los Apellidos del Alumno que quiera Actualizar: ");
									datoDeCambio = sc.nextLine();
								} while (datoDeCambio == "" || datoDeCambio == null);

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarAlumno();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. nombre.
										columnaCambiada = "nombre";
										do {
											System.out.print("Introduzca el nuevo Nombre del Alumno: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. nombre.
									case 2: // 2. apellidos.
										columnaCambiada = "apellidos";
										do {
											System.out.print("Introduzca los nuevos Apellidos del Alumno: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 2. apellidos.
									case 3: // 3. fechaNacimiento.
										columnaCambiada = "fechaNacimiento";
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Alumno (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Alumno (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Alumno (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											datoCambiado = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // fechaNacimiento.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 3");
										System.out.println();
										break;
									}

									System.out.println();

									idsAlumnos.clear();

									if (opcionSubmenuC != 0) {
										idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna("apellidos", datoDeCambio);

										if (idsAlumnos.size() > 1) {

											FuncionesAlumnos.leerPorApellidos(datoDeCambio, "=");

											System.out.print(ColorMio.getAmarillo());
											System.out.println("Hay varios Alumnos con apellidos = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println(
													"Escriba el idProfesor del Alumno que desea modificar, o si lo prefiere, \"0\" para modificar a todos estos:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {

												if (idsAlumnos.contains(idDeCambio) && FuncionesAlumnos
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
													System.out.print(ColorMio.getVerde());
													System.out.print("Alumno con ID = " + idDeCambio + " tiene ahora "
															+ columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Alumno con ID = " + idDeCambio
															+ " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();

												}
											} else {
												for (Long id : idsAlumnos) {
													FuncionesAlumnos.actualizarPorId(id, columnaCambiada, datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todos los Alumnos con apellidos = " + datoDeCambio
														+ " tienen ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsAlumnos.size() == 1) {
											idDeCambio = idsAlumnos.get(0);

											FuncionesAlumnos.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado);

											System.out.print(ColorMio.getVerde());
											System.out.print("Alumno con apellidos = " + datoDeCambio + " tiene ahora "
													+ columnaCambiada + " = " + datoCambiado);
											System.out.print(ColorMio.getReset());
											System.out.println();

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print("No existe ningún Alumno con apellidos = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsAlumnos.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;

										antiguedad = -1;

										columnaCambiada = "";
										datoCambiado = "";

										fechaDia = 0;
										fechaMes = 0;
										fechaAnnio = 0;
									}
									System.out.println();
								} while (opcionSubmenuC != 0);
								break; // FIN 3. Por apellidos.
							case 4: // 4. Por fechaNacimiento.
								do {
									do {
										System.out.print(
												"Introduzca el día de FechaNacimiento del Alumno que quiera Actualizar (entre 1 y 31): ");
										fechaDia = leeInt(sc);
									} while (fechaDia < 1 || fechaDia > 31);

									do {
										System.out.print(
												"Introduzca el mes de FechaNacimiento del Alumno que quiera Actualizar (entre 1 y 12): ");
										fechaMes = leeInt(sc);
									} while (fechaMes < 1 || fechaMes > 12);

									do {
										System.out.print(
												"Introduzca el año de FechaNacimiento del Alumno que quiera Actualizar (>= 1000 y <= año actual): ");
										fechaAnnio = leeInt(sc);
									} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

									datoDeCambio = String.format("%d-%02d-%02d", fechaAnnio, fechaMes, fechaDia);
								} while (datoDeCambio == null || datoDeCambio.equals(""));

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarAlumno();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. nombre.
										columnaCambiada = "nombre";
										do {
											System.out.print("Introduzca el nuevo Nombre del Alumno: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. nombre.
									case 2: // 2. apellidos.
										columnaCambiada = "apellidos";
										do {
											System.out.print("Introduzca los nuevos Apellidos del Alumno: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 2. apellidos.
									case 3: // 3. fechaNacimiento.
										columnaCambiada = "fechaNacimiento";
										do {
											do {
												System.out.print(
														"Introduzca el día de FechaNacimiento del Alumno (entre 1 y 31): ");
												fechaDia = leeInt(sc);
											} while (fechaDia < 1 || fechaDia > 31);

											do {
												System.out.print(
														"Introduzca el mes de FechaNacimiento del Alumno (entre 1 y 12): ");
												fechaMes = leeInt(sc);
											} while (fechaMes < 1 || fechaMes > 12);

											do {
												System.out.print(
														"Introduzca el año de FechaNacimiento del Alumno (>= 1000 y <= año actual): ");
												fechaAnnio = leeInt(sc);
											} while (fechaAnnio <= 1000 || fechaAnnio > LocalDate.now().getYear());

											datoCambiado = String.format("%d-%02d-%02d", fechaAnnio, fechaMes,
													fechaDia);
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // fechaNacimiento.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 3");
										System.out.println();
										break;
									}

									System.out.println();

									idsAlumnos.clear();

									if (opcionSubmenuC != 0) {
										idsAlumnos = FuncionesAlumnos.buscaIDsPorColumna("fechaNacimiento",
												datoDeCambio);

										if (idsAlumnos.size() > 1) {

											FuncionesAlumnos.leerPorFechaNacimiento(LocalDate.parse(datoDeCambio), "=");

											System.out.print(ColorMio.getAmarillo());
											System.out.println(
													"Hay varios Alumnos con fechaNacimiento = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println(
													"Escriba el idAlumno del Alumnos que desea modificar, o si lo prefiere, \"0\" para modificar a todos estos:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {

												if (idsAlumnos.contains(idDeCambio) && FuncionesAlumnos
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {
													System.out.print(ColorMio.getVerde());
													System.out.print("Alumno con ID = " + idDeCambio + " tiene ahora "
															+ columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Alumno con ID = " + idDeCambio
															+ " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();

												}
											} else {
												for (Long id : idsAlumnos) {
													FuncionesAlumnos.actualizarPorId(id, columnaCambiada, datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todos los Alumnos con fechaNacimiento = "
														+ datoDeCambio + " tienen ahora " + columnaCambiada + " = "
														+ datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsAlumnos.size() == 1) {
											idDeCambio = idsAlumnos.get(0);

											FuncionesAlumnos.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado);

											System.out.print(ColorMio.getVerde());
											System.out.print("Alumno con fechaNacimiento = " + datoDeCambio
													+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
											System.out.print(ColorMio.getReset());
											System.out.println();

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print(
													"No existe ningún Alumno con fechaNacimiento = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsAlumnos.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;

										antiguedad = -1;

										columnaCambiada = "";
										datoCambiado = "";

										fechaDia = 0;
										fechaMes = 0;
										fechaAnnio = 0;
									}
									System.out.println();
								} while (opcionSubmenuC != 0);
								break; // FIN 4. Por fechaNacimiento.
							case 0: // 0. Volver al Menú anterior.

								break; // FIN 0. Volver al Menú anterior.

							default:
								System.out.print(ColorMio.getRojo());
								System.out.print("Opción no disponible: ");
								System.out.print(ColorMio.getReset());
								System.out.println("Elija del 0 al 4");
								System.out.println();
								break;
							}
						} while (opcionSubmenuB != 0);

						break; // FIN 2. Alumnos.
					case 3: // 3. Matriculas.
						do {
							Menu.subMenuElegirMatriculaActualizar();
							opcionSubmenuB = leeInt(sc);
							System.out.println();

							switch (opcionSubmenuB) {
							case 1: // 1. Por idMatricula.

								do {
									System.out.print("Introduzca el ID de la Matricula que quiera Actualizar (> 0): ");
									idDeCambio = leeLong(sc);
								} while (idDeCambio <= 0);

								System.out.println();

								do {
									Menu.subMenuElegirColumnaModificarMatricula();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. idProfesor.
										columnaCambiada = "idProfesor";
										do {
											System.out.print("Introduzca el nuevo idProfesor de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. idProfesor.
									case 2: // 2. idAlumno.
										columnaCambiada = "idAlumno";
										do {
											System.out.print("Introduzca el nuevo idAlumno de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 2. idAlumno.
									case 3: // 3. asignatura.
										columnaCambiada = "asignatura";
										do {
											System.out.print("Introduzca la nueva Asignatura de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 3. asignatura.
									case 4: // 4. curso.
										columnaCambiada = "curso";
										do {
											System.out.print("Introduzca el nuevo Curso de la Matricula: ");
											curso = leeInt(sc);
											if (curso >= 0) {
												datoCambiado = String.valueOf(curso);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. curso.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();

									if (opcionSubmenuC != 0) {

										if (!FuncionesMatriculas.buscaIDsDeTodos().contains(idDeCambio)) {
											System.out.print(ColorMio.getRojo());
											System.out.print("No existe ninguna Matricula con ID = " + idDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();
										} else {
											if (columnaCambiada.equals("idProfesor") && !FuncionesProfesores
													.buscaIDsDeTodos().contains(Long.valueOf(datoCambiado))) {
												System.out.print(ColorMio.getRojo());
												System.out.print("No existe ningún Profesor con ID = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();
											} else if (columnaCambiada.equals("idAlumno") && !FuncionesAlumnos
													.buscaIDsDeTodos().contains(Long.valueOf(datoCambiado))) {
												System.out.print(ColorMio.getRojo());
												System.out.print("No existe ningún Alumno con ID = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();
											} else {
												FuncionesMatriculas.actualizarPorId(idDeCambio, columnaCambiada,
														datoCambiado);
												System.out.print(ColorMio.getVerde());
												System.out.print("Matricula con ID = " + idDeCambio + " tiene ahora "
														+ columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();
											}
										}
										System.out.println();
									}

									opcionSubmenuC = 0;
									opcionSubmenuB = 0;
									opcionSubmenuA = 0;

									idDeCambio = -1;

									columnaCambiada = "";
									datoCambiado = "";
									curso = -1;

								} while (opcionSubmenuC != 0);
								break; // FIN 1. Por idMatricula.
							case 2: // 2. Por idProfesor.
								do {
									System.out.print(
											"Introduzca el idProfesor de la Matricula que quiera Actualizar (> 0): ");
									idProfesor = leeLong(sc);
								} while (idProfesor <= 0);

								System.out.println();

								datoDeCambio = String.valueOf(idProfesor);

								do {
									idsMatriculas.clear();

									Menu.subMenuElegirColumnaModificarMatricula();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. idProfesor.
										columnaCambiada = "idProfesor";
										do {
											System.out.print("Introduzca el nuevo idProfesor de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. idProfesor.
									case 2: // 2. idAlumno.
										columnaCambiada = "idAlumno";
										do {
											System.out.print("Introduzca el nuevo idAlumno de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 2. idAlumno.
									case 3: // 3. asignatura.
										columnaCambiada = "asignatura";
										do {
											System.out.print("Introduzca la nueva Asignatura de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 3. asignatura.
									case 4: // 4. curso.
										columnaCambiada = "curso";
										do {
											System.out.print("Introduzca el nuevo Curso de la Matricula: ");
											curso = leeInt(sc);
											if (curso >= 0) {
												datoCambiado = String.valueOf(curso);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. curso.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();
									if (opcionSubmenuC != 0) {

										idsMatriculas = FuncionesMatriculas.buscaIDsPorColumna("idProfesor",
												datoDeCambio);

										if (idsMatriculas.size() > 1) {
											cabecera = " Matricula(s) con Profesor con idProfesor = " + idProfesor
													+ "\t";

											FuncionesMatriculas.leerPorProfesor(
													FuncionesProfesores.getProfesorPorId(Long.valueOf(datoDeCambio)),
													cabecera);

											System.out.print(ColorMio.getAmarillo());
											System.out.print("Hay varias Matriculas con idProfesor = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println();

											System.out.println(
													"Escriba el idMatricula de la Matricula que desea modificar, o si lo prefiere, \"0\" para modificar a todas estas:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {
												if (idsMatriculas.contains(idDeCambio) && FuncionesMatriculas
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {

													System.out.print(ColorMio.getVerde());
													System.out.print("Matricula con ID = " + idDeCambio
															+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();
												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ninguna Matricula con ID = "
															+ idDeCambio + " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();
												}
											} else {
												for (Long id : idsMatriculas) {
													FuncionesMatriculas.actualizarPorId(id, columnaCambiada,
															datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todas las Matriculas con idProfesor = " + datoDeCambio
														+ " tienen ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsMatriculas.size() == 1) {
											idDeCambio = idsMatriculas.get(0);

											if (FuncionesMatriculas.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado)) {
												System.out.print(ColorMio.getVerde());
												System.out.print("Matricula con idProfesor = " + datoDeCambio
														+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											} else {
												if (columnaCambiada.equals("idProfesor")) {

													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Profesor con idProfesor = "
															+ datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else if (columnaCambiada.equals("idAlumno")) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Alumno con idAlumno = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();
												}
											}

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print(
													"No existe ninguna Matricula con idProfesor = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsMatriculas.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;
										idProfesor = -1;

										columnaCambiada = "";
										datoCambiado = "";
										curso = -1;
									}

									System.out.println();

								} while (opcionSubmenuC != 0);
								break; // FIN 2. Por idProfesor.
							case 3: // 3. Por idAlumno.
								do {
									System.out.print(
											"Introduzca el idAlumno de la Matricula que quiera Actualizar (> 0): ");
									idAlumno = leeLong(sc);
								} while (idAlumno <= 0);

								System.out.println();

								datoDeCambio = String.valueOf(idAlumno);

								do {
									idsMatriculas.clear();

									Menu.subMenuElegirColumnaModificarMatricula();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. idProfesor.
										columnaCambiada = "idProfesor";
										do {
											System.out.print("Introduzca el nuevo idProfesor de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. idProfesor.
									case 2: // 2. idAlumno.
										columnaCambiada = "idAlumno";
										do {
											System.out.print("Introduzca el nuevo idAlumno de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 2. idAlumno.
									case 3: // 3. asignatura.
										columnaCambiada = "asignatura";
										do {
											System.out.print("Introduzca la nueva Asignatura de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 3. asignatura.
									case 4: // 4. curso.
										columnaCambiada = "curso";
										do {
											System.out.print("Introduzca el nuevo Curso de la Matricula: ");
											curso = leeInt(sc);
											if (curso >= 0) {
												datoCambiado = String.valueOf(curso);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. curso.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();
									if (opcionSubmenuC != 0) {

										idsMatriculas = FuncionesMatriculas.buscaIDsPorColumna("idAlumno",
												datoDeCambio);

										if (idsMatriculas.size() > 1) {
											cabecera = " Matricula(s) con Alumno con idAlumno = " + idAlumno + "\t";

											FuncionesMatriculas.leerPorAlumno(
													FuncionesAlumnos.getAlumnoPorId(Long.valueOf(datoDeCambio)),
													cabecera);

											System.out.print(ColorMio.getAmarillo());
											System.out.print("Hay varias Matriculas con idAlumno = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println();

											System.out.println(
													"Escriba el idMatricula de la Matricula que desea modificar, o si lo prefiere, \"0\" para modificar a todas estas:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {
												if (idsMatriculas.contains(idDeCambio) && FuncionesMatriculas
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {

													System.out.print(ColorMio.getVerde());
													System.out.print("Matricula con ID = " + idDeCambio
															+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();
												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ninguna Matricula con ID = "
															+ idDeCambio + " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();
												}
											} else {
												for (Long id : idsMatriculas) {
													FuncionesMatriculas.actualizarPorId(id, columnaCambiada,
															datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todas las Matriculas con idAlumno = " + datoDeCambio
														+ " tienen ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsMatriculas.size() == 1) {
											idDeCambio = idsMatriculas.get(0);

											if (FuncionesMatriculas.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado)) {
												System.out.print(ColorMio.getVerde());
												System.out.print("Matricula con idAlumno = " + datoDeCambio
														+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											} else {
												if (columnaCambiada.equals("idProfesor")) {

													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Profesor con idProfesor = "
															+ datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else if (columnaCambiada.equals("idAlumno")) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Alumno con idAlumno = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();
												}
											}

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print(
													"No existe ninguna Matricula con idAlumno = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsMatriculas.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;
										idAlumno = -1;

										columnaCambiada = "";
										datoCambiado = "";
										curso = -1;
									}

									System.out.println();

								} while (opcionSubmenuC != 0);
								break; // FIN 3. Por Alumno.
							case 4: // 4. Por asignatura.
								do {
									System.out
											.print("Introduzca la asignatura de la Matricula que quiera Actualizar: ");
									asignatura = sc.nextLine();
								} while (asignatura == "" || asignatura == null);

								System.out.println();

								datoDeCambio = asignatura;

								do {
									idsMatriculas.clear();

									Menu.subMenuElegirColumnaModificarMatricula();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. idProfesor.
										columnaCambiada = "idProfesor";
										do {
											System.out.print("Introduzca el nuevo idProfesor de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. idProfesor.
									case 2: // 2. idAlumno.
										columnaCambiada = "idAlumno";
										do {
											System.out.print("Introduzca el nuevo idAlumno de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 2. idAlumno.
									case 3: // 3. asignatura.
										columnaCambiada = "asignatura";
										do {
											System.out.print("Introduzca la nueva Asignatura de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 3. asignatura.
									case 4: // 4. curso.
										columnaCambiada = "curso";
										do {
											System.out.print("Introduzca el nuevo Curso de la Matricula: ");
											curso = leeInt(sc);
											if (curso >= 0) {
												datoCambiado = String.valueOf(curso);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. curso.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();
									if (opcionSubmenuC != 0) {

										idsMatriculas = FuncionesMatriculas.buscaIDsPorColumna("asignatura",
												datoDeCambio);

										if (idsMatriculas.size() > 1) {

											FuncionesMatriculas.leerPorAsignatura(asignatura, "=");

											System.out.print(ColorMio.getAmarillo());
											System.out.print("Hay varias Matriculas con asignatura = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println();

											System.out.println(
													"Escriba el idMatricula de la Matricula que desea modificar, o si lo prefiere, \"0\" para modificar a todas estas:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {
												if (idsMatriculas.contains(idDeCambio) && FuncionesMatriculas
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {

													System.out.print(ColorMio.getVerde());
													System.out.print("Matricula con ID = " + idDeCambio
															+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();
												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ninguna Matricula con ID = "
															+ idDeCambio + " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();
												}
											} else {
												for (Long id : idsMatriculas) {
													FuncionesMatriculas.actualizarPorId(id, columnaCambiada,
															datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todas las Matriculas con asignatura = " + datoDeCambio
														+ " tienen ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsMatriculas.size() == 1) {
											idDeCambio = idsMatriculas.get(0);

											if (FuncionesMatriculas.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado)) {
												System.out.print(ColorMio.getVerde());
												System.out.print("Matricula con asignatura = " + datoDeCambio
														+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											} else {
												if (columnaCambiada.equals("idProfesor")) {

													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Profesor con idProfesor = "
															+ datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else if (columnaCambiada.equals("idAlumno")) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Alumno con idAlumno = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();
												}
											}

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print(
													"No existe ninguna Matricula con asignatura = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsMatriculas.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;
										asignatura = "";

										columnaCambiada = "";
										datoCambiado = "";
										curso = -1;
									}

									System.out.println();

								} while (opcionSubmenuC != 0);
								break; // FIN 4. Por asignatura.
							case 5: // 5. Por curso.
								do {
									System.out
											.print("Introduzca el curso de la Matricula que quiera Actualizar (>0): ");
									curso = leeInt(sc);
								} while (curso <= 0);

								System.out.println();

								String.valueOf(idAlumno);

								datoDeCambio = String.valueOf(curso);

								do {
									idsMatriculas.clear();

									Menu.subMenuElegirColumnaModificarMatricula();
									opcionSubmenuC = leeInt(sc);
									System.out.println();

									switch (opcionSubmenuC) {
									case 1: // 1. idProfesor.
										columnaCambiada = "idProfesor";
										do {
											System.out.print("Introduzca el nuevo idProfesor de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));

										break; // FIN 1. idProfesor.
									case 2: // 2. idAlumno.
										columnaCambiada = "idAlumno";
										do {
											System.out.print("Introduzca el nuevo idAlumno de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 2. idAlumno.
									case 3: // 3. asignatura.
										columnaCambiada = "asignatura";
										do {
											System.out.print("Introduzca la nueva Asignatura de la Matricula: ");
											datoCambiado = sc.nextLine();
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 3. asignatura.
									case 4: // 4. curso.
										columnaCambiada = "curso";
										do {
											System.out.print("Introduzca el nuevo Curso de la Matricula: ");
											curso = leeInt(sc);
											if (curso >= 0) {
												datoCambiado = String.valueOf(curso);
											}
										} while (datoCambiado == null || datoCambiado.equals(""));
										break; // FIN 4. curso.

									case 0: // 0. Volver al Menú anterior.

										break; // FIN 0. Volver al Menú anterior.

									default:
										System.out.print(ColorMio.getRojo());
										System.out.print("Opción no disponible: ");
										System.out.print(ColorMio.getReset());
										System.out.println("Elija del 0 al 4");
										System.out.println();
										break;
									}

									System.out.println();
									if (opcionSubmenuC != 0) {

										idsMatriculas = FuncionesMatriculas.buscaIDsPorColumna("curso", datoDeCambio);

										if (idsMatriculas.size() > 1) {
											FuncionesMatriculas.leerPorCurso(curso, "=");

											System.out.print(ColorMio.getAmarillo());
											System.out.print("Hay varias Matriculas con curso = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

											System.out.println();

											System.out.println(
													"Escriba el idMatricula de la Matricula que desea modificar, o si lo prefiere, \"0\" para modificar a todas estas:");
											idDeCambio = sc.nextLong();

											System.out.println();

											if (idDeCambio != 0) {
												if (idsMatriculas.contains(idDeCambio) && FuncionesMatriculas
														.actualizarPorId(idDeCambio, columnaCambiada, datoCambiado)) {

													System.out.print(ColorMio.getVerde());
													System.out.print("Matricula con ID = " + idDeCambio
															+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();
												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ninguna Matricula con ID = "
															+ idDeCambio + " en la lista anteriormente mostrada");
													System.out.print(ColorMio.getReset());
													System.out.println();
												}
											} else {
												for (Long id : idsMatriculas) {
													FuncionesMatriculas.actualizarPorId(id, columnaCambiada,
															datoCambiado);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todas las Matriculas con curso = " + datoDeCambio
														+ " tienen ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											}

										} else if (idsMatriculas.size() == 1) {
											idDeCambio = idsMatriculas.get(0);

											if (FuncionesMatriculas.actualizarPorId(idDeCambio, columnaCambiada,
													datoCambiado)) {
												System.out.print(ColorMio.getVerde());
												System.out.print("Matricula con curso = " + datoDeCambio
														+ " tiene ahora " + columnaCambiada + " = " + datoCambiado);
												System.out.print(ColorMio.getReset());
												System.out.println();

											} else {
												if (columnaCambiada.equals("idProfesor")) {

													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Profesor con idProfesor = "
															+ datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();

												} else if (columnaCambiada.equals("idAlumno")) {
													System.out.print(ColorMio.getRojo());
													System.out.println(
															"No existe ningún Alumno con idAlumno = " + datoCambiado);
													System.out.print(ColorMio.getReset());
													System.out.println();
												}
											}

										} else {
											System.out.print(ColorMio.getRojo());
											System.out.print("No existe ninguna Matricula con curso = " + datoDeCambio);
											System.out.print(ColorMio.getReset());
											System.out.println();

										}

										idsMatriculas.clear();

										opcionSubmenuC = 0;
										opcionSubmenuB = 0;
										opcionSubmenuA = 0;

										idDeCambio = -1;

										columnaCambiada = "";
										datoCambiado = "";
										curso = -1;
									}

									System.out.println();

								} while (opcionSubmenuC != 0);
								break; // FIN 5. Por curso.
							case 0: // 0. Volver al Menú anterior.

								break; // FIN 0. Volver al Menú anterior.

							default:
								System.out.print(ColorMio.getRojo());
								System.out.print("Opción no disponible: ");
								System.out.print(ColorMio.getReset());
								System.out.println("Elija del 0 al 5");
								System.out.println();
								break;
							}
						} while (opcionSubmenuB != 0);
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
					}
				} while (opcionSubmenuA != 0);

				break;// FIN 3. Actualizar Datos.
			case 4: // 4. Borrar Datos.
				do {
					Menu.subMenuBorrarDatos();
					opcionSubmenuA = leeInt(sc);
					System.out.println();

					switch (opcionSubmenuA) {
					case 1: // 1. Todos

						break; // FIN 1. Todos
					case 2: // 2. Profesores.
						do {
							Menu.subMenuElegirProfesorBorrar();
							opcionSubmenuB = leeInt(sc);
							System.out.println();

							switch (opcionSubmenuB) {
							case 1: // 1. Todos

								break; // FIN 1. Todos
							case 2: // 2. Por idProfesor.
								do {
									System.out.print("Introduzca el ID del Profesor que quiera Borrar (> 0): ");
									idDeBorrado = leeLong(sc);
								} while (idDeBorrado <= 0);

								System.out.println();

								System.out.println("¿Está seguro de que quiere borrar al Profesor con ID = "
										+ idDeBorrado + "? (s/n)");
								System.out.print(ColorMio.getAmarillo());
								System.out.print(
										"ADVERTENCIA: Se borrarán también las Matriculas asociadas a dicho Profesor");
								System.out.println(ColorMio.getReset());

								if (sc.nextLine().equals("s")) {

									System.out.println();

									if (FuncionesProfesores.borrarPorId(idDeBorrado)) {
										System.out.print(ColorMio.getVerde());
										System.out.print("Profesor con ID = " + idDeBorrado + " ha sido borrado");
										System.out.println(ColorMio.getReset());
									} else {
										System.out.print(ColorMio.getRojo());
										System.out.print("No existe ningún Profesor con ID = " + idDeBorrado);
										System.out.println(ColorMio.getReset());

									}
								}

								System.out.println();

								opcionSubmenuB = 0;
								opcionSubmenuA = 0;

								idDeBorrado = -1;

								break; // FIN 2. Por idProfesor.

							case 3: // 3. Por nombre.
								idsProfesores.clear();

								do {
									System.out.print("Introduzca el Nombre del Profesor que quiera Borrar: ");
									datoDeBorrado = sc.nextLine();
								} while (datoDeBorrado == "" || datoDeBorrado == null);

								System.out.println();

								System.out.println("¿Está seguro de que quiere borrar al Profesor con nombre = '"
										+ datoDeBorrado + "'? (s/n)");
								System.out.print(ColorMio.getAmarillo());
								System.out.print(
										"ADVERTENCIA: Se borrarán también las Matriculas asociadas a dicho Profesor");
								System.out.println(ColorMio.getReset());

								if (sc.nextLine().equals("s")) {
									System.out.println();

									idsProfesores = FuncionesProfesores.buscaIDsPorColumna("nombre", datoDeBorrado);

									if (idsProfesores.size() > 1) {

										FuncionesProfesores.leerPorNombre(datoDeBorrado, "=");

										System.out.print(ColorMio.getAmarillo());
										System.out.print("Hay varios Profesores con nombre = " + datoDeBorrado);
										System.out.println(ColorMio.getReset());

										System.out.println(
												"Escriba el id del Profesor que desea borrar, o si lo prefiere, \"0\" para borrar a todos estos:");
										idDeBorrado = leeLong(sc);

										System.out.println();

										if (idDeBorrado != 0) {
											System.out.println("¿Está seguro de que quiere borrar al Profesor con ID = "
													+ idDeBorrado + "? (s/n)");
											System.out.print(ColorMio.getAmarillo());
											System.out.print(
													"ADVERTENCIA: Se borrarán también las Matriculas asociadas a dicho Profesor");
											System.out.println(ColorMio.getReset());
											if (sc.nextLine().equals("s")) {
												System.out.println();
												if (idsProfesores.contains(idDeBorrado)
														&& FuncionesProfesores.borrarPorId(idDeBorrado)) {

													System.out.print(ColorMio.getVerde());
													System.out.print("Profesor con ID = " + idDeBorrado + " borrado");
													System.out.println(ColorMio.getReset());
												} else {
													System.out.print(ColorMio.getRojo());
													System.out.print("No existe ningún Profesor con ID = " + idDeBorrado
															+ " en la lista anteriormente mostrada");
													System.out.println(ColorMio.getReset());
												}
											}

										} else {
											System.out.println(
													"¿Está seguro de que quiere borrar a todos estos Profesores con nombre = '"
															+ datoDeBorrado + "'? (s/n)");

											System.out.print(ColorMio.getAmarillo());
											System.out.print(
													"ADVERTENCIA: Se borrarán también las Matriculas asociadas a dichos Profesores");
											System.out.println(ColorMio.getReset());

											if (sc.nextLine().equals("s")) {
												
												System.out.println();
												
												for (Long id : idsProfesores) {
													FuncionesProfesores.borrarPorId(id);
												}
												System.out.print(ColorMio.getVerde());
												System.out.print("Todos los Profesores con nombre = '" + datoDeBorrado
														+ "' han sido borrados");
												System.out.println(ColorMio.getReset());
											}

										}

									} else if (idsProfesores.size() == 1) {
										idDeBorrado = idsProfesores.get(0);

										FuncionesProfesores.borrarPorId(idDeBorrado);

										System.out.print(ColorMio.getVerde());
										System.out.print("Profesor con nombre = '" + datoDeBorrado + "' borrado");
										System.out.println(ColorMio.getReset());
									} else {
										System.out.print(ColorMio.getRojo());
										System.out.print(
												"No existe ningún Profesor con nombre = '" + datoDeBorrado + "'");
										System.out.println(ColorMio.getReset());
									}
								}

								System.out.println();

								opcionSubmenuB = 0;
								opcionSubmenuA = 0;

								idDeBorrado = -1;
								datoDeBorrado = "";
								idsProfesores.clear();

								break; // FIN 3. Por nombre.

							case 4: // 4. Por apellidos.

								break; // FIN 4. Por apellidos.

							case 5: // 5. Por fechaNacimiento.

								break; // 5. FIN Por fechaNacimiento.

							case 6: // 6. Por antiguedad.

								break; // FIN 6. Por antiguedad.

							case 0: // 0. Volver al Menú anterior.
								break; // FIN 0. Volver al Menú anterior.

							default:
								System.out.print(ColorMio.getRojo());
								System.out.print("Opción no disponible: ");
								System.out.print(ColorMio.getReset());
								System.out.println("Elija del 0 al 6");
								System.out.println();
								break;
							}

						} while (opcionSubmenuB != 0);
						break; // FIN 2. Profesores.
					case 3: // 3. Alumnos.

						break; // FIN 3. Alumnos.
					case 4: // 4. Matriculas.

						break; // FIN 4. Matriculas.
					case 0: // 0. Volver al Menú anterior.

						break; // FIN 0. Volver al Menú anterior.

					default:
						System.out.print(ColorMio.getRojo());
						System.out.print("Opción no disponible: ");
						System.out.print(ColorMio.getReset());
						System.out.println("Elija del 0 al 4");
						System.out.println();
						break;
					}

				} while (opcionSubmenuA != 0);

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
