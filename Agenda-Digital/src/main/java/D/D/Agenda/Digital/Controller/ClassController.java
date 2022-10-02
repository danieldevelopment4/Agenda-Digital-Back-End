package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import D.D.Agenda.Digital.Models.ClassModel;
import D.D.Agenda.Digital.Models.HoraryModel;
import D.D.Agenda.Digital.Services.ClassService;
import D.D.Agenda.Digital.Services.HoraryService;

@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	ClassService classService;
	@Autowired
	HoraryService horaryService;

	@PostMapping("/create")
	public void create(@RequestBody ClassModel clas) {
		HoraryModel horaryDB = horaryService.getHorary(clas.getHorary());
		if(horaryDB==null) {
			horaryDB = horaryService.create(clas.getHorary());
		}
		clas.setHorary(horaryDB);
		classService.create(clas);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody ClassModel clas) {
		HoraryModel horaryDB = horaryService.getHorary(clas.getHorary());
		if(horaryDB==null) {
			horaryDB = horaryService.create(clas.getHorary());
		}
		clas.setHorary(horaryDB);
		classService.update(clas);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody ClassModel clas) {
		classService.delete(clas);
	}
	
	@PostMapping(value="/showoptions", produces = MediaType.APPLICATION_JSON_VALUE)
	public String showOptions() {
		return horaryService.show();
	}
	
	
}
