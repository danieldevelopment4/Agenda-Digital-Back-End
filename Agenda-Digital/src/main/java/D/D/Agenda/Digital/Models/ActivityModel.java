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
@Table(name = "actividades")
public class ActivityModel {
	
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String name;
	private String description;
	private int percent;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MatterModel matter;
	
	private String noDaysRecordatories;
	@CreationTimestamp
	private Date submissionDate;
	private String term;
	
	public ActivityModel(Long id, String name, String description, int percent, String noDaysRecordatories,
			String term) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.percent = percent;
		this.noDaysRecordatories = noDaysRecordatories;
		this.term = term;
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
	
	public int getPercent() {
		return percent;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	public MatterModel getMatter() {
		return matter;
	}
	
	public void setMatter(MatterModel matter) {
		this.matter = matter;
	}
	
	public String getNoDaysRecordatories() {
		return noDaysRecordatories;
	}
	
	public void setNoDaysRecordatories(String noDaysRecordatories) {
		this.noDaysRecordatories = noDaysRecordatories;
	}
	
	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getTerm() {
		return term;
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	public String toString(SubmitModel submit) {
		String data = "";
		data += "\t\t\t\t{\n";
		data += "\t\t\t\t\t\"id\":"+id+",\n";
		data += "\t\t\t\t\t\"name\":\""+name+"\",\n";
		data += "\t\t\t\t\t\"description\":"+((description==null)?description:"\""+description+"\"")+",\n";
		data += "\t\t\t\t\t\"percent\":"+percent+",\n";
		data += "\t\t\t\t\t\"noDaysRecordatories\":"+noDaysRecordatories+",\n";
		data += "\t\t\t\t\t\"submissionDate\":\""+submissionDate+"\",\n";
		data += "\t\t\t\t\t\"term\":"+term+",\n";
		data += "\t\t\t\t\t\"submit\":"+((submit!=null)?submit.toString():null)+"\n";
		data += "\t\t\t\t}";
		return data;
	}
		
}
