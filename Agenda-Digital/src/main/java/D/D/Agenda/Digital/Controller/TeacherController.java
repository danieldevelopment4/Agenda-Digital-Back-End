package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import D.D.Agenda.Digital.Models.TeacherModel;
import D.D.Agenda.Digital.Services.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	
	@PostMapping("/create")
	public void create(@RequestBody TeacherModel teacher) {
		teacherService.create(teacher);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody TeacherModel teacher) {
		teacherService.update(teacher);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody TeacherModel teacher) {
		teacherService.delete(teacher);
	}
	
	@PostMapping("/show")
	public TeacherModel show(@RequestBody TeacherModel teacher) {
		return teacherService.show(teacher);
	}
	
}
