package accesodb;
import java.util.logging.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Clase que gestiona la conexion con la base de datos utilizando Hibernate.
 * Proporciona metodos para abrir y cerrar sesiones, manejar transacciones y realizar operaciones de guardado.
 */
public class Accesobd {

	/**
	 * Factoria de sesiones para gestionar la conexión con la base de datos
	 */
	private SessionFactory sf;

	/**
	 * Sesion activa de Hibernate
	 */
    private Session sesion;

    /**
     * Transaccion activa de Hibernate
     */
    private Transaction transaction;

    /**
     * Obtiene la sesion actual.
     * 
     * @return La sesion de Hibernate activa.
     */
    public Session getSesion() {
        return sesion;
    }

    /**
     * Configura la fabrica de sesiones utilizando el archivo de configuración
     * hibernate.cfg.xml. Este metodo se debe llamar antes de abrir la sesión.
     */
    protected void setUp() {
    	
    	// java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);// Modificar a tu gusto
    	
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // Carga la configuración de hibernate.cfg.xml por defecto
                .build();
        try {
            // Crea la fábrica de sesiones
            sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // En caso de error, destruye el registro
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    /**
     * Abre una nueva sesion y comienza una transaccion.
     * 
     * @throws Exception si ocurre un error al configurar o abrir la sesión.
     */
    public void abrir() throws Exception {
        setUp(); // Configura la fábrica de sesiones
        sesion = sf.openSession(); // Abre una nueva sesión
        transaction = sesion.beginTransaction(); // Inicia una transacción
    }

    /**
     * Cierra la transaccion activa y la fabrica de sesiones.
     * Si la transacción falla, realiza un rollback.
     */
    public void cerrar() {
        try {
            transaction.commit(); // Confirma la transacción
        } catch (Exception e) {
            transaction.rollback(); // Revierte la transacción en caso de error
        } finally {
            // Cierra la fábrica de sesiones, independientemente de lo que ocurra
            sf.close();
        }

    }

    /**
     * Guarda un objeto en la base de datos.
     * 
     * @param cosa el objeto a guardar.
     * @return el identificador generado para el objeto guardado.
     */
    public Object guardar(Object cosa) {
        return sesion.save(cosa); // Guarda el objeto y devuelve su ID
    }
}

    
    

