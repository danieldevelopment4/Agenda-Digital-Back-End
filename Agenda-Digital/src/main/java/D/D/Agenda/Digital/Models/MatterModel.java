package D.D.Agenda.Digital.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materia")
public class MatterModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)          
	private TeacherModel teacher;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private StudentModel student;
	
	public MatterModel(String name, TeacherModel teacher , StudentModel student) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.student = student;
	}
	
	public MatterModel() {
		super();
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

	public TeacherModel getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherModel teacher) {
		this.teacher = teacher;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}

}
