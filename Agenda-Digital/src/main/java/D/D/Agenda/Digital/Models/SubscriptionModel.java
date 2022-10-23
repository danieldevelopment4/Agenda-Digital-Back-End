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
@Table(name = "Suscripcion")
public class SubscriptionModel {
	
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MatterModel matter;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private StudentModel student;
	
	private boolean request=true;
	
	public SubscriptionModel(MatterModel matter, StudentModel student) {
		super();
		this.matter = matter;
		this.student = student;
	}
	
	public SubscriptionModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MatterModel getMatter() {
		return matter;
	}

	public void setMatter(MatterModel matter) {
		this.matter = matter;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}

	public boolean isRequest() {
		return request;
	}

	public void setRequest(boolean request) {
		this.request = request;
	}
	
	public String toString(String matter) {
		String data = "";
		data += "\t{\n";
		data += "\t\t\"id\":"+this.id+",\n";
		data += "\t\t\"matter\":"+matter+",\n";
		data += "\t\t\"request\":"+request+"\n";
		data += "\t}";
		return data;
	}
	
}
