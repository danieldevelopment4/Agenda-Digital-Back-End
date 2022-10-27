package D.D.Agenda.Digital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import D.D.Agenda.Digital.Models.MatterModel;
import D.D.Agenda.Digital.Models.SubscriptionModel;
import D.D.Agenda.Digital.Models.StudentModel;
import D.D.Agenda.Digital.Services.MatterService;
import D.D.Agenda.Digital.Services.SubscriptionService;
import D.D.Agenda.Digital.Services.StudentService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	
	@Autowired
	MatterService matterService;
	@Autowired
	StudentService studentService;
	@Autowired
	SubscriptionService subscriptionService;
	
	@PostMapping("/subscribe")
	public void subscribe(@RequestBody SubscriptionModel subscription) {
		MatterModel matterDB = matterService.getMatter(subscription.getMatter().getId());
		StudentModel studentDB = studentService.getStudentMattterRegister(subscription.getStudent().getId());
		subscription.setMatter(matterDB);
		subscription.setStudent(studentDB);
		subscriptionService.subscribe(subscription);
	}
	
	@PostMapping("/aprobe")
	public void aprobeSubscription(@RequestBody SubscriptionModel subscription) {
		MatterModel matterDB = matterService.getMatter(subscription.getMatter().getId());
		StudentModel studentDB = studentService.getStudentMattterRegister(subscription.getStudent().getId());
		subscription.setMatter(matterDB);
		subscription.setStudent(studentDB);
		subscriptionService.aprobeSubscription(subscription);
	}
	
	@PostMapping("/denied")
	public void deniedSubscription(@RequestBody SubscriptionModel subscription) {
		MatterModel matterDB = matterService.getMatter(subscription.getMatter().getId());
		StudentModel studentDB = studentService.getStudentMattterRegister(subscription.getStudent().getId());
		subscription.setMatter(matterDB);
		subscription.setStudent(studentDB);
		subscriptionService.deniedSubscription(subscription);
	}
	
	@PostMapping(value="/show", produces = MediaType.APPLICATION_JSON_VALUE)
	public String showSubscriptions(@RequestBody SubscriptionModel subscription){
		return subscriptionService.show(subscription);
	}
}
