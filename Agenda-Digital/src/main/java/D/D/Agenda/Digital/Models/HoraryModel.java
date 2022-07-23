package D.D.Agenda.Digital.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Horario")
public class HoraryModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private HoraryDayEnum day;
	
	@Enumerated(EnumType.STRING)
	private HoraryHourEnum hour;
	
	private int duration;

	public HoraryModel(Long id, HoraryDayEnum day, HoraryHourEnum hour, int duration) {
		super();
		this.id = id;
		this.day = day;
		this.hour = hour;
		this.duration = duration;
	}

	public HoraryModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public HoraryDayEnum getDay() {
		return day;
	}

	public void setDay(HoraryDayEnum day) {
		this.day = day;
	}

	public HoraryHourEnum getHour() {
		return hour;
	}

	public void setHour(HoraryHourEnum hour) {
		this.hour = hour;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
