package D.D.Agenda.Digital.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import D.D.Agenda.Digital.Models.CalificationsModel;
import D.D.Agenda.Digital.Services.CalificationService;

@RestController
@RequestMapping("/calification")
public class CalificationController {

	@Autowired
	CalificationService calificationService;
	
	@PostMapping("/create")
	public void newCalification(@RequestBody CalificationsModel calification) {
		calificationService.newCalification(calification);
	}
	
	@PostMapping("/view")
	public ArrayList<CalificationsModel> showCalifications() {
		return calificationService.showCalifications();
	}
}
