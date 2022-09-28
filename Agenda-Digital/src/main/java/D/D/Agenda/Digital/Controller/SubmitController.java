package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import D.D.Agenda.Digital.Models.SubmitModel;
import D.D.Agenda.Digital.Services.SubmitService;

@RestController
@RequestMapping("/submit")
public class SubmitController {

	@Autowired
	SubmitService submitService;
	
	
	@PostMapping("/create")
	public void create(@RequestBody SubmitModel submit) {
		submitService.create(submit);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody SubmitModel submit) {
		submitService.update(submit);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody SubmitModel submit) {
		submitService.delete(submit);
	}
	
	
}
