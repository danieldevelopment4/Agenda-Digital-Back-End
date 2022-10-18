package D.D.Agenda.Digital.Models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

@Entity
@Table(name = "materia")
public class MatterModel {
	@Id//la BD no sabe que esto es un ID y debemos de indicarselo a spring para que asi este le informe a la BD como actuar
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID autogenerado, consecutivo automaticamente
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)          
	private TeacherModel teacher;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private StudentModel student;
	
	public MatterModel(String name, TeacherModel teacher , StudentModel student) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.student = student;
	}
	
	public MatterModel() {
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

	public TeacherModel getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherModel teacher) {
		this.teacher = teacher;
	}

	public StudentModel getStudent() {
		return student;
	}

	public void setStudent(StudentModel student) {
		this.student = student;
	}
	
	public String toString(boolean request, TeacherModel teacher, ArrayList<ActivityModel> activitiesList, ArrayList<SubmitModel> submitList, boolean admin) {
		String data = "{\n";
		data += "\t\t\t\"id\":"+id+",\n";
		data += "\t\t\t\"name\":"+name+",\n";
		if(!request) {
			data += "\t\t\t\"teacher\":"+((teacher!=null)?teacher.toString():null)+",\n";
			data += "\t\t\t\"activities\":[\n";
			int aux = -1;
			for (int i = 0; i < activitiesList.size(); i++) {
				aux=-1;
				for (int j = 0; j < submitList.size(); j++) {
					if(activitiesList.get(i).getId()==submitList.get(j).getActivity().getId()) {
						aux = j;
					}
				}
				data += activitiesList.get(i).toString(((aux!=-1)?submitList.get(aux):null));
				data += ((i<activitiesList.size()-1)?",\n":"\n");
			}
			data += "\t\t\t],\n";
			data += "\t\t\t\"admin\":"+admin+"\n";
		}
		data += "\t\t}";
		return data;
	}

}
