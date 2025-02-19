package entidades;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Profesores")
public class ProfesorEntity implements Serializable{ // ¿Obligatorio Serializable?

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProfesor")
	private long idProfesor;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "fechaNacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name="antiguedad")
	private int antiguedad;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProfesor")
	private List<MatriculaEntity> matriculasProfesor;

	// CONSTRUCTORES
	
	public ProfesorEntity() {
	}
	
	public ProfesorEntity(String nombre, String apellidos, LocalDate fechaNacimiento, int antiguedad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.antiguedad = antiguedad;
	}

	
	// GETTERS Y SETTERS
	
	public long getIdProfesor() {
		return idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	
	
	
}
