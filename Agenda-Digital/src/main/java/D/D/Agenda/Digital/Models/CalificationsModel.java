package D.D.Agenda.Digital.Models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "calificaciones")
public class CalificationsModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	private float calification;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date date= new Date();
	private String comentary;
	
	@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private StudentModel idStudent;
	
	public CalificationsModel(Long id, float calification, Date date, String comentary, StudentModel idStudent) {
		super();
		this.id = id;
		this.calification = calification;
		this.date = date;
		this.comentary = comentary;
		this.idStudent = idStudent;
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

	public float getCalification() {
		return calification;
	}

	public void setCalification(float calification) {
		this.calification = calification;
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

	public StudentModel getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(StudentModel idStudent) {
		this.idStudent = idStudent;
	}
		
}
