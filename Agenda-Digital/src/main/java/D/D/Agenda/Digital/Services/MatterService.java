package D.D.Agenda.Digital.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import D.D.Agenda.Digital.Models.MatterModel;
import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Models.TeacherModel;
import D.D.Agenda.Digital.Repository.MatterRepository;
import D.D.Agenda.Digital.Repository.StudentRepository;
import D.D.Agenda.Digital.Repository.TeacherRepository;

@Service
public class MatterService {
	
	@Autowired
	MatterRepository matterRepository;
	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	StudentRepository studentRepository;
	
	public MatterModel create(MatterModel matter) {
		if(matter.getTeacher()!=null) {
			TeacherModel teacherDB = teacherRepository.findById(matter.getTeacher().getId()).get();
			matter.setTeacher(teacherDB);
		}
		StudentModel studentDB = studentRepository.findById(matter.getStudent().getId()).get();
		matter.setStudent(studentDB);
		return matterRepository.save(matter);
	}
	
	public void update(MatterModel matter) {
		MatterModel matterDB = matterRepository.findById(matter.getId()).get();
		matterDB.setName(matter.getName());
		TeacherModel teacherDB = teacherRepository.findById(matter.getTeacher().getId()).get();
		matterDB.setTeacher(teacherDB);
		
		matterRepository.save(matterDB);
	}
	
	public void delete(MatterModel matter) {
		MatterModel matterDB = matterRepository.findById(matter.getId()).get();
		matterDB.setTeacher(null);
		matterRepository.delete(matterDB);
		//Error eliminar de la tabla docente viola las clausulas de foreign key de la tabla materias...
		//estamos en la tabla materias por lo que no se que tiene que verlos docentes
		//matterRepository.deleteById(matter.getId());
	}
	
	public MatterModel getMatter(Long id) {
		return matterRepository.findById(id).get();
	}
	
}
