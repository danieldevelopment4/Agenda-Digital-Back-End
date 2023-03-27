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
	
	public String toString(boolean request, TeacherModel teacher, ArrayList<ActivityModel> activitiesList, ArrayList<SubmitModel> submitList, boolean admin, ArrayList<StudentModel> aprobedStudentsList, ArrayList<StudentModel> waitingStudentsList) {
		String data = "{\n";
		data += "\t\t\t\"id\":"+id+",\n";
		data += "\t\t\t\"name\":\""+name+"\"";
		if(!request) {
			data += ",\n";
			data += "\t\t\t\"studentsCount\":"+aprobedStudentsList.size()+",\n";
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
			data += "\t\t\t\"admin\":"+admin+",\n";
			data += "\t\t\t\"aprobedStudentsList\":[\n";
			for (int i = 0; i < aprobedStudentsList.size(); i++) {
				data+=aprobedStudentsList.get(i).toString();
				data+=((i<aprobedStudentsList.size()-1)?",\n":"\n");
			}
			data += "\t\t\t],\n";
			if(admin) {
				data += "\t\t\t\"waitingStudentsList\":[\n";
				for (int i = 0; i < waitingStudentsList.size(); i++) {
					data+=waitingStudentsList.get(i).toString();
					data+=((i<waitingStudentsList.size()-1)?",\n":"\n");
				}
				data += "\t\t\t]\n";
			}else {
				data += "\t\t\t\"waitingStudentsList\":[ ]\n";
			}
		}
		data += "\t\t}";
		return data;
	}

}
