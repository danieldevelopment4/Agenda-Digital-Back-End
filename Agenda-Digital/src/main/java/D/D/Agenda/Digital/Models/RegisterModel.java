package D.D.Agenda.Digital.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class RegisterModel {
	
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	private MatterModel idMatter;
	
	@Column(nullable = false)
	private StudentModel idStudent;
	
	private String request;
	
	public RegisterModel() {
		// TODO Auto-generated constructor stub
	}

	public RegisterModel(MatterModel idMatter, StudentModel idStudent, String request) {
		super();
		this.idMatter = idMatter;
		this.idStudent = idStudent;
		this.request = request;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MatterModel getIdMatter() {
		return idMatter;
	}

	public void setIdMatter(MatterModel idMatter) {
		this.idMatter = idMatter;
	}

	public StudentModel getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(StudentModel idStudent) {
		this.idStudent = idStudent;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	
}
