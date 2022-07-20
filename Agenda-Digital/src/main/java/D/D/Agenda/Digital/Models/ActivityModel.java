package D.D.Agenda.Digital.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "actividades")
public class ActivityModel {
	
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String name;
	private String description;
	private double percent;
	
	private String noDaysRecordatories;
	private String cuts;
	public ActivityModel(Long id, String name, String description, double percent, String noDaysRecordatories,
			String cuts) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.percent = percent;
		this.noDaysRecordatories = noDaysRecordatories;
		this.cuts = cuts;
	}
	public ActivityModel() {
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public String getNoDaysRecordatories() {
		return noDaysRecordatories;
	}
	public void setNoDaysRecordatories(String noDaysRecordatories) {
		this.noDaysRecordatories = noDaysRecordatories;
	}
	public String getCuts() {
		return cuts;
	}
	public void setCuts(String cuts) {
		this.cuts = cuts;
	}
	
	
}
