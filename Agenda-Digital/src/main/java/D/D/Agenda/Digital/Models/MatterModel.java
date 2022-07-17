package D.D.Agenda.Digital.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class MatterModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private TeacherModel idTeacher;
	
	public MatterModel() {
		// TODO Auto-generated constructor stub
	}
	
	public MatterModel(String name, TeacherModel idTeacher) {
		super();
		this.name = name;
		this.idTeacher = idTeacher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeacherModel getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(TeacherModel idTeacher) {
		this.idTeacher = idTeacher;
	}
}
