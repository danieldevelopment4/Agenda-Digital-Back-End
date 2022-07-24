package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.submitModel;
import D.D.Agenda.Digital.Repository.SubmitRepository;

@Service
public class SubmitService {
	
	@Autowired
	SubmitRepository submitRepository;
	
	public void create(submitModel submit) {
		submitRepository.save(submit);
	}
	
	public void update(submitModel submit) {
		submitModel teacherDB = submitRepository.findById(submit.getId()).get();
		
		submitRepository.save(teacherDB);
	}
	
	public void delete(submitModel submit) {
		submitRepository.deleteById(submit.getId());
	}
	
}
