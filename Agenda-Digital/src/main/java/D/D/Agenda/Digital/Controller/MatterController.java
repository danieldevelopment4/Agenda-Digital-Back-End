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
@RequestMapping("/matter")
public class MatterController {

	@Autowired
	MatterService matterService;
	
	
	@PostMapping("/create")
	public void create(@RequestBody MatterModel matter) {
		matterService.create(matter);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody MatterModel matter) {
		matterService.update(matter);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody MatterModel matter) {
		matterService.delete(matter);
	}
	
	
}
