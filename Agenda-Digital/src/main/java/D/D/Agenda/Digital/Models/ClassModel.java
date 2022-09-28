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
	private MatterModel matter;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private HoraryModel horary;

	public ClassModel(Long id, MatterModel matter, HoraryModel horary) {
		super();
		this.id = id;
		this.matter = matter;
		this.horary = horary;
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

	public MatterModel getMatter() {
		return matter;
	}

	public void setMatter(MatterModel matter) {
		this.matter = matter;
	}

	public HoraryModel getHorary() {
		return horary;
	}

	public void setHorary(HoraryModel horary) {
		this.horary = horary;
	}
	
}
