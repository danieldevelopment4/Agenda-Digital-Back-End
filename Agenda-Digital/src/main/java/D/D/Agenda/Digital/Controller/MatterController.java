package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import D.D.Agenda.Digital.Models.MatterModel;
import D.D.Agenda.Digital.Models.SubscriptionModel;
import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Services.MatterService;
import D.D.Agenda.Digital.Services.SubscriptionService;

@RestController
@RequestMapping("/matter")
public class MatterController {

	@Autowired
	MatterService matterService;
	@Autowired
	SubscriptionService subscriptionService;
	
	
	@PostMapping("/create")
	public void create(@RequestBody MatterModel matter) {
		if(!subscriptionService.validateSubscriptionByMatterName(matter)) {
			MatterModel matterBD = matterService.create(matter);
			SubscriptionModel subscriptionDB = subscriptionService.subscribe(new SubscriptionModel(matterBD, matterBD.getStudent()));
			subscriptionService.aprobeSubscription(subscriptionDB);
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya estas registrado en una materia con el mismo nombre");
		}
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
