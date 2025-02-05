package entidades;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Matriculas")
public class MatriculaEntity implements Serializable { // ¿Obligatorio Serializable?

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMatricula")
	private long idMatricula;

	@ManyToOne
	@JoinColumn(name = "idProfesor", foreignKey = @ForeignKey(name = "FK_Profesores"))
	private ProfesorEntity profesor;

	@ManyToOne
	@JoinColumn(name = "idAlumno", foreignKey = @ForeignKey(name = "FK_Alumnos"))
	private AlumnoEntity alumno;

	@Column(name = "asignatura")
	private String asignatura;

	@Column(name = "curso")
	private int curso;


	// CONSTRUCTORES
	
	public MatriculaEntity() {

	}
	
	public MatriculaEntity(ProfesorEntity profesor, AlumnoEntity alumno, String asignatura, int curso) {
		this.profesor = profesor;
		this.alumno = alumno;
		this.asignatura = asignatura;
		this.curso = curso;
	}

	
	// GETTERS Y SETTERS
	
	public long getIdMatricula() {
		return idMatricula;
	}


	public ProfesorEntity getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorEntity profesor) {
		this.profesor = profesor;
	}

	public AlumnoEntity getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnoEntity alumno) {
		this.alumno = alumno;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}
	
	
}
