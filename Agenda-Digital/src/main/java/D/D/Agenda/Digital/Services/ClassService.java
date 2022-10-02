package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import D.D.Agenda.Digital.Models.ClassModel;
import D.D.Agenda.Digital.Models.MatterModel;
import D.D.Agenda.Digital.Repository.ClassRepository;
import D.D.Agenda.Digital.Repository.MatterRepository;

@Service
public class ClassService {

	@Autowired
	ClassRepository classRepository;
	@Autowired
	MatterRepository matterRepository;
	
	public void create(@RequestBody ClassModel clas) {
		MatterModel matterDB = matterRepository.findById(clas.getMatter().getId()).get();
		clas.setMatter(matterDB);
		classRepository.save(clas);
	}
	
	public void update(@RequestBody ClassModel clas) {
		ClassModel classDB = classRepository.findById(clas.getId()).get();
		classDB.setHorary(clas.getHorary());
		classRepository.save(classDB);
	}
	
	public void delete(@RequestBody ClassModel clas) {
		clas.setHorary(null);
		clas.setMatter(null);
		classRepository.delete(clas);
	}
	
}
