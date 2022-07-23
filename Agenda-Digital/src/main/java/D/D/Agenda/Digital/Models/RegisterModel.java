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
@Table(name = "Registro")
public class RegisterModel {
	
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MatterModel idMatter;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private StudentModel idStudent;
	
	private boolean request;
	
	public RegisterModel(MatterModel idMatter, StudentModel idStudent, boolean request) {
		super();
		this.idMatter = idMatter;
		this.idStudent = idStudent;
		this.request = request;
	}
	
	public RegisterModel() {
		super();
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

	public boolean isRequest() {
		return request;
	}

	public void setRequest(boolean request) {
		this.request = request;
	}
	
}
