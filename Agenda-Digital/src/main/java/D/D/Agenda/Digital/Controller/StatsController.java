package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import D.D.Agenda.Digital.Services.CalificationService;
import D.D.Agenda.Digital.Services.DownloadService;
import D.D.Agenda.Digital.Services.StudentService;

@RestController
@RequestMapping("/stats")
public class StatsController {
	
	@Autowired
	StudentService studentService;
	@Autowired
	DownloadService downloadService;
	@Autowired
	CalificationService calificationService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String stats() {
		
		return "{\n"
			 + studentService.getStats()
			 + downloadService.getStats()
			 + calificationService.getStatus()
			 + "}";
	}
	
	
}
