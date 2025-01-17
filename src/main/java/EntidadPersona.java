import javax.persistence.*;
import java.io.Serializable;


/**
 * Entidad que representa la tabla "Personas" en la base de datos.
 * Cada instancia de esta clase corresponde a un registro en la tabla.
 */
@Entity
@Table(name = "Personas") // Especifica el nombre de la tabla en la base de datos
public class EntidadPersona implements Serializable {

    // ATRIBUTOS
    
    /**
     * Identificador unico de la persona.
     * Mapeado a la columna "idPersona" en la tabla.
     * Generado automaticamente utilizando la estrategia IDENTITY, 
     * comunmente utilizada con bases de datos como MySQL.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática del ID
    @Column(name = "idPersona") // Nombre de la columna en la tabla
    private long idPersona;

    /**
     * Nombre de la persona.
     * Mapeado a la columna "nombre" en la tabla.
     */
    @Column(name = "nombre") // Nombre de la columna en la tabla
    private String nombre;

    /**
     * Saldo asociado a la persona.
     * Mapeado a la columna "saldo" en la tabla.
     */
    @Column(name = "saldo") // Nombre de la columna en la tabla
    private double saldo;
	
	
	// CONSTRUCTORES
	
	public EntidadPersona() {

	}

	public EntidadPersona(String nombre, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}

	
	// GETTERS Y SETTERS

	public long getIdPersona() {
		return idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
