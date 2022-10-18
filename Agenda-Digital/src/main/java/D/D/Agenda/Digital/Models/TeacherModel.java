package D.D.Agenda.Digital.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "docente")
public class TeacherModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String lastName;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String cellphone;
	
	public TeacherModel() {
		super();
	}
	
	public TeacherModel(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String toString() {
		String data = "{";
		data += "\t\t\t\t\"id\":"+id+",\n";
		data += "\t\t\t\t\"name\":"+name+",\n";
		data += "\t\t\t\t\"lastName\":"+lastName+",\n";
		data += "\t\t\t\t\"email\":"+email+",\n";
		data += "\t\t\t\t\"cellphone\":"+cellphone+"\n";
		data += "\t\t\t}";
		return data;
	}
}
