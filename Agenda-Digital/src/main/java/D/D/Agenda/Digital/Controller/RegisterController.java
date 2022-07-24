package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import D.D.Agenda.Digital.Models.MatterModel;
import D.D.Agenda.Digital.Models.RegisterModel;
import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Services.MatterService;
import D.D.Agenda.Digital.Services.RegisterService;
import D.D.Agenda.Digital.Services.StudentService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	MatterService matterService;
	@Autowired
	StudentService studentService;
	@Autowired
	RegisterService registerService;
	
	@PostMapping("/register")
	public void register(@RequestBody RegisterModel register) {
		MatterModel matterDB = matterService.getMatter(register.getIdMatter().getId());
		StudentModel studentDB = studentService.getStudentMattterRegister(register.getIdStudent().getId());
		register.setIdMatter(matterDB);
		register.setIdStudent(studentDB);
		register.setRequest(true);
		registerService.register(register);
	}
	
	@PostMapping("/aprobeRegister")
	public void aprobeRegister(@RequestBody RegisterModel register) {
		registerService.aprobeRegister(register);
	}
	
	@PostMapping("/unregister")
	public void unregister(@RequestBody RegisterModel register) {
		registerService.unregister(register);
	}
}
