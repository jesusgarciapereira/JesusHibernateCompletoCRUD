import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProbandoProfesores {

	public static void main(String[] args) {

		
		try {
			FuncionesProfesores.leerPornombre("ese", "LIKE");;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se puede mostrar");
		} 
		
		
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
//		ProfesorEntity profesor = new ProfesorEntity("Jesús", "García Pereira", LocalDate.parse("1900-05-20"), 1);
//
//		
//		try {
//			FuncionesProfesores.guardar(profesor);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("No se ha podido guardar");
//		}

	}

}
