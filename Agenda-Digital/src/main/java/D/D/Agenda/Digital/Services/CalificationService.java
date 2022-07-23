package D.D.Agenda.Digital.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.CalificationsModel;
import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Repository.CalificationsRepository;
import D.D.Agenda.Digital.Repository.StudentRepository;

@Service
public class CalificationService {
	
	@Autowired
	CalificationsRepository calificationsRepository;
	@Autowired
	StudentRepository studentRepository;

	public void newCalification(CalificationsModel calification) {
		StudentModel strudentDb = studentRepository.findById(calification.getIdStudent().getId()).get();
		calification.setIdStudent(strudentDb);
		calificationsRepository.save(calification);
	}
	
	public ArrayList<CalificationsModel> showCalifications(){
		return (ArrayList<CalificationsModel>) calificationsRepository.findAll();
	}
	
	public String getStatus() {
		ArrayList<CalificationsModel> califications = (ArrayList<CalificationsModel>) calificationsRepository.findAll();
		float total = 0;
		for (int i = 0; i < califications.size(); i++) {
			total += califications.get(i).getCalification();
		}
		total = (calificationsRepository.count()==0)?0:total/calificationsRepository.count();
		return "\"noCalifications\": \""+calificationsRepository.count()+"\",\n"
			 + "\"calification\": \""+total+"\"\n";
	}
	
}
