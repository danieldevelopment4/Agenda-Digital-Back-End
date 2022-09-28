package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import D.D.Agenda.Digital.Models.ActivityModel;
import D.D.Agenda.Digital.Services.ActivityServices;

@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	ActivityServices activityServices;
	
	@PostMapping("/create")
	public void create(@RequestBody ActivityModel activity) {
		activityServices.create(activity);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody ActivityModel activity) {
		activityServices.update(activity);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody ActivityModel activity) {
		activityServices.delete(activity);
	}
	
}
