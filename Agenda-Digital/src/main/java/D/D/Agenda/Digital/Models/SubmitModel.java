package D.D.Agenda.Digital.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "submit")
public class SubmitModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String note;
	
	@Enumerated(EnumType.STRING)
	private SubmitStateEnum state; 
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ActivityModel activity;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private SubscriptionModel subscription ;

	public SubmitModel(Long id, String note, SubmitStateEnum state ) {
		super();
		this.id = id;
		this.note = note;
		this.state = state;
	}

	public SubmitModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public SubmitStateEnum getState() {
		return state;
	}

	public void setState(SubmitStateEnum state) {
		this.state = state;
	}

	public ActivityModel getActivity() {
		return activity;
	}

	public void setActivity(ActivityModel activity) {
		this.activity = activity;
	}

	public SubscriptionModel getSubscription() {
		return subscription;
	}

	public void setSubscription(SubscriptionModel subscription) {
		this.subscription = subscription;
	}
	
	@Override
	public String toString() {
		String data = "{\n";
		data += "\t\t\t\t\t\t\"id\":"+id+"\n";
		data += "\t\t\t\t\t\t\"note\":"+note+",\n";
		data += "\t\t\t\t\t\t\"state\":"+state.name()+"\n";
		data += "\t\t\t\t\t}";
		return data;
	}

}
