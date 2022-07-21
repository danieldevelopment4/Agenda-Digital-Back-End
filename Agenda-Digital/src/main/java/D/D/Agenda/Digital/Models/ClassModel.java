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
@Table(name = "clase")
public class ClassModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private MatterModel idMatter;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private HoraryModel idHorary;

	public ClassModel(Long id, MatterModel idMatter, HoraryModel idHorary) {
		super();
		this.id = id;
		this.idMatter = idMatter;
		this.idHorary = idHorary;
	}

	public ClassModel() {
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

	public HoraryModel getIdHorary() {
		return idHorary;
	}

	public void setIdHorary(HoraryModel idHorary) {
		this.idHorary = idHorary;
	}
	
}
