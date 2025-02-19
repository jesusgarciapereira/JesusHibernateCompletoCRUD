package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Alumnos")
public class AlumnoEntity implements Serializable { // ¿Obligatorio Serializable?

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAlumno")
	private long idAlumno;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "fechaNacimiento")
	private LocalDate fechaNacimiento;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAlumno")
	private List<MatriculaEntity> matriculasAlumno;

	// CONSTRUCTORES

	public AlumnoEntity() {
	}

	public AlumnoEntity(String nombre, String apellidos, LocalDate fechaNacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}
	

	// GETTERS Y SETTERS

	public long getIdAlumno() {
		return idAlumno;
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

}
