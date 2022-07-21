package D.D.Agenda.Digital.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calificaciones")
public class CalificationsModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String califications;
	private Date date;
	private String comentary;
	public CalificationsModel(Long id, String califications, Date date, String comentary) {
		super();
		this.id = id;
		this.califications = califications;
		this.date = date;
		this.comentary = comentary;
	}
	
	public CalificationsModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalifications() {
		return califications;
	}

	public void setCalifications(String califications) {
		this.califications = califications;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComentary() {
		return comentary;
	}

	public void setComentary(String comentary) {
		this.comentary = comentary;
	}
		
}
