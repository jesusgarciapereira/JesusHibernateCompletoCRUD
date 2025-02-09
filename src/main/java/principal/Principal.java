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
		String asignatura = "";
		int curso = -1;

		int fechaDia = 0;
		int fechaMes = 0;
		int fechaAnnio = 0;

		String filtro = "";

		List<Long> idsProfesores = new ArrayList<>();
		List<Long> idsAlumnos = new ArrayList<>();

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
