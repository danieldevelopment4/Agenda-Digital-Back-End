package D.D.Agenda.Digital.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import D.D.Agenda.Digital.Models.TeacherModel;
import D.D.Agenda.Digital.Repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository; 
	
	public void create(TeacherModel teacher) {
		teacherRepository.save(teacher);
	}
	
	public void update(TeacherModel teacher) {
		TeacherModel teacherDB = teacherRepository.findById(teacher.getId()).get();
		teacherDB.setName(teacher.getName());
		teacherDB.setLastName(teacher.getLastName());
		teacherDB.setEmail(teacher.getEmail());
		teacherDB.setCellphone(teacher.getCellphone());
		teacherRepository.save(teacherDB);
	}
	
	public void delete(TeacherModel activity) {
		teacherRepository.deleteById(activity.getId());
	}
	
	public TeacherModel show(TeacherModel teacher) {
		Optional<TeacherModel> teacherDB = teacherRepository.findById(teacher.getId());
		if(teacherDB.isPresent()) {
			return teacherDB.get();
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID no encontrado");
		}
	}
	
}
