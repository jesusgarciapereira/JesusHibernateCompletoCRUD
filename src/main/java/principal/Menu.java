package principal;

import colores.ColorMio;

public class Menu {

	static void menuPrincipal() {
		System.out.println("Menú Principal:");
		System.out.println("===============");
		System.out.println("1. Guardar Datos.");
		System.out.println("2. Obtener Datos.");
		System.out.println("3. Actualizar Datos.");
		System.out.println("4. Borrar Datos.");
		System.out.println("0. Salir del Programa");
		System.out.println();
		
		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}
	
	static void subMenuObtenerAlumnos() {
		System.out.println("Obtener Alumnos:");
		System.out.println("================");
		System.out.println("1. Todos.");
		System.out.println("2. Por idAlumno.");
		System.out.println("3. Por nombre.");
		System.out.println("4. Por apellidos.");
		System.out.println("5. Por fechaNacimiento.");
		System.out.println("0. Volver al Menú anterior.");
		System.out.println();

		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}
	
	static void subMenuObtenerProfesores() {
		System.out.println("Obtener Profesores:");
		System.out.println("===================");
		System.out.println("1. Todos.");
		System.out.println("2. Por idProfesor.");
		System.out.println("3. Por nombre.");
		System.out.println("4. Por apellidos.");
		System.out.println("5. Por fechaNacimiento.");
		System.out.println("6. Por antiguedad.");
		System.out.println("0. Volver al Menú anterior.");
		System.out.println();

		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}
	
	static void subMenuObtenerDatos() {
		System.out.println("Obtener Datos:");
		System.out.println("==============");
		System.out.println("1. Todos.");
		System.out.println("2. Profesores.");
		System.out.println("3. Alumnos.");
		System.out.println("4. Matriculas.");
		System.out.println("0. Volver al Menú anterior.");
		System.out.println();
		
		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}

	static void subMenuGuardarDatos() {
		System.out.println("Guardar Datos:");
		System.out.println("==============");
		System.out.println("1. Profesores.");
		System.out.println("2. Alumnos.");
		System.out.println("3. Matriculas.");
		System.out.println("0. Volver al Menú anterior.");
		System.out.println();
		
		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}

	static void subMenuInsertarProfesor() {
		System.out.println("Insertar Profesor en la Matricula:");
		System.out.println("==================================");
		System.out.println("1. Por idProfesor.");
		System.out.println("2. Por nombre.");
		System.out.println("3. Por apellidos.");
		System.out.println("4. Por fechaNacimiento.");
		System.out.println("5. Por antiguedad.");
		System.out.println("0. Volver al Menú anterior.");
		System.out.println();
		
		System.out.print(ColorMio.getAmarillo());
		System.out.print("Consejo: ");
		System.out.print(ColorMio.getReset());
		System.out.println("Antes de Insertar un Profesor asegúrese de que conoce alguno de sus campos");
		System.out.println("Si lo necesita, vuelva al Menú Principal y seleccione la opción 2. Obtener Datos ");
		
		System.out.println();

		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}
	
	static void subMenuInsertarAlumno() {
		System.out.println("Insertar Alumno en la Matricula:");
		System.out.println("================================");
		System.out.println("1. Por idAlumno.");
		System.out.println("2. Por nombre.");
		System.out.println("3. Por apellidos.");
		System.out.println("4. Por fechaNacimiento.");
		System.out.println("0. Volver al Menú anterior.");
		System.out.println();
		
		System.out.print(ColorMio.getAmarillo());
		System.out.print("Consejo: ");
		System.out.print(ColorMio.getReset());
		System.out.println("Antes de Insertar un Alumno asegúrese de que conoce alguno de sus campos");
		System.out.println("Si lo necesita, vuelva al Menú Principal y seleccione la opción 2. Obtener Datos ");
		
		System.out.println();

		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}
	
	/**
	 * Submenu que permite seleccionar opciones de filtro para columnas de tipo VARCHAR.
	 */
	static void submenuOpcionFiltroVARCHAR() {
		System.out.println("Opción filtro:");
		System.out.println("==============");
		System.out.println("1. =");
		System.out.println("2. LIKE");
		System.out.println("0. Volver al Menú anterior.");
		
		System.out.println();

		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}

	/**
	 * Submenu que permite seleccionar opciones de filtro para columnas de tipo INT.
	 */
	static void submenuOpcionFiltroNUMBER() {
		System.out.println("Opción filtro:");
		System.out.println("==============");
		System.out.println("1. =");
		System.out.println("2. >");
		System.out.println("3. <");
		System.out.println("4. >=");
		System.out.println("5. <=");
		System.out.println("0. Volver al Menú anterior.");

		System.out.println();

		System.out.print(ColorMio.getAzul());
		System.out.print("Escriba una opción: ");
		System.out.print(ColorMio.getReset());
	}

}
